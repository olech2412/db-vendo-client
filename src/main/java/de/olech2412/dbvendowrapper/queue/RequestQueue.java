package de.olech2412.dbvendowrapper.queue;

import de.olech2412.dbvendowrapper.config.QueueConfig;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * Queue for API requests with rate limiting and optional spreading.
 *
 * Requests are scheduled according to the {@link QueueConfig} so that the API is not overloaded.
 * Users can inspect the planned execution times and the current queue.
 *
 * */
public class RequestQueue {

    /**
     * Represents a scheduled request in the queue.
     * @param <T> Return type of the request
     */
    public static class ScheduledRequest<T> {
        private final Supplier<T> supplier;
        private final ZonedDateTime scheduledTime;
        private final CompletableFuture<T> future;

        /**
         * Create a scheduled request.
         * @param supplier The supplier to execute
         * @param scheduledTime The planned execution time (Europe/Berlin)
         */
        public ScheduledRequest(Supplier<T> supplier, ZonedDateTime scheduledTime) {
            this.supplier = supplier;
            this.scheduledTime = scheduledTime;
            this.future = new CompletableFuture<>();
        }

        /** @return the planned execution time (Europe/Berlin) */
        public ZonedDateTime getScheduledTime() {
            return scheduledTime;
        }

        /** @return the future to retrieve the result */
        public CompletableFuture<T> getFuture() {
            return future;
        }
    }

    private final QueueConfig config;
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final List<ScheduledRequest<?>> queue = Collections.synchronizedList(new ArrayList<>());
    private final Object lock = new Object();
    private final Map<Long, AtomicInteger> intervalReservations = new ConcurrentHashMap<>();

    /**
     * Create a new RequestQueue with the given configuration.
     * @param config QueueConfig
     */
    public RequestQueue(QueueConfig config) {
        this.config = config;
    }

    /**
     * Submit a new request to the queue and schedule its execution.
     *
     * @param supplier Supplier that executes the request
     * @param <T> Return type
     * @return Future with the result
     */
    public <T> CompletableFuture<T> submit(Supplier<T> supplier) {
        return submitWithTime(supplier, ZonedDateTime.now(ZoneId.of("Europe/Berlin")));
    }

    /**
     * Submit a new request with a specific reference time for calculation.
     * This is used internally to ensure consistent time calculations for batch operations.
     */
    private <T> CompletableFuture<T> submitWithTime(Supplier<T> supplier, ZonedDateTime referenceTime) {
        ScheduledRequest<T> scheduledRequest;
        synchronized (lock) {
            ZonedDateTime scheduledTime = calculateNextAvailableTime(referenceTime);
            scheduledRequest = new ScheduledRequest<>(supplier, scheduledTime);

            // Reserve a slot for the interval
            long intervalStart = getIntervalStartMillis(scheduledTime.toInstant());
            intervalReservations.computeIfAbsent(intervalStart, k -> new AtomicInteger(0)).incrementAndGet();

            // Release slot after interval expires
            long intervalDuration = config.getInterval().toMillis();
            long releaseDelay = intervalStart + intervalDuration - System.currentTimeMillis();
            if (releaseDelay > 0) {
                executor.schedule(() -> {
                    intervalReservations.computeIfPresent(intervalStart, (k, v) -> {
                        v.decrementAndGet();
                        return v.get() <= 0 ? null : v;
                    });
                }, releaseDelay, TimeUnit.MILLISECONDS);
            }

            queue.add(scheduledRequest);
            scheduleExecution(scheduledRequest, referenceTime);
        }
        return scheduledRequest.getFuture();
    }

    /**
     * Fügt eine Liste von Suppliern (Requests) zur Queue hinzu und gibt die zugehörigen Futures zurück.
     * Die Ausführung erfolgt nach den Regeln der QueueConfig.
     * Alle Requests in der Liste verwenden denselben Referenzzeitpunkt für konsistente Berechnung.
     */
    public <T> List<CompletableFuture<T>> enqueueRequests(List<Supplier<T>> suppliers) {
        List<CompletableFuture<T>> futures = new ArrayList<>();
        if (suppliers == null || suppliers.isEmpty()) {
            return futures;
        }
        // Jeder Request bekommt seinen eigenen Referenzzeitpunkt
        for (Supplier<T> supplier : suppliers) {
            futures.add(submitWithTime(supplier, ZonedDateTime.now(ZoneId.of("Europe/Berlin"))));
        }
        return futures;
    }

    private <T> void scheduleExecution(ScheduledRequest<T> req, ZonedDateTime now) {
        long delay = Duration.between(now, req.getScheduledTime()).toMillis();

        executor.schedule(() -> {
            try {
                T result = req.supplier.get();
                req.future.complete(result);
            } catch (Exception e) {
                req.future.completeExceptionally(e);
                e.printStackTrace();
            } finally {
                synchronized (lock) {
                    queue.remove(req);
                }
            }
        }, Math.max(0, delay), TimeUnit.MILLISECONDS);
    }

    /**
     * Calculate the next available time for a new request according to the configuration.
     */
    private ZonedDateTime calculateNextAvailableTime(ZonedDateTime now) {
        Duration interval = config.getInterval();
        int maxRequests = config.getMaxRequestsPerInterval();
        boolean spread = config.isAutoSpread();

        // Start with the current interval using the corrected calculation
        long intervalStartMillis = getIntervalStartMillis(now.toInstant());
        ZonedDateTime candidateIntervalStart = ZonedDateTime.ofInstant(
                Instant.ofEpochMilli(intervalStartMillis),
                ZoneId.of("Europe/Berlin")
        );

        while (true) {
            long currentIntervalStartMillis = getIntervalStartMillis(candidateIntervalStart.toInstant());
            int reserved = intervalReservations.getOrDefault(currentIntervalStartMillis, new AtomicInteger(0)).get();

            long countInInterval;
            synchronized (lock) {
                ZonedDateTime finalCandidateIntervalStart = candidateIntervalStart;
                countInInterval = queue.stream()
                        .filter(r -> !r.getScheduledTime().isBefore(finalCandidateIntervalStart) &&
                                r.getScheduledTime().isBefore(finalCandidateIntervalStart.plus(interval)))
                        .count();
            }

            long total = reserved + countInInterval;
            if (total < maxRequests) {
                if (!spread) {
                    // Minimal spread for fairness - add small offset based on position
                    return candidateIntervalStart.plusNanos(total * 1_000_000);
                } else {
                    // Evenly spread requests across the interval
                    long slotMillis = interval.toMillis() / maxRequests;
                    return candidateIntervalStart.plus(total * slotMillis, TimeUnit.MILLISECONDS.toChronoUnit());
                }
            }

            // Move to next interval
            candidateIntervalStart = candidateIntervalStart.plus(interval);
        }
    }

    /**
     * Calculate the start time of the interval containing the given instant.
     */
    private long getIntervalStartMillis(Instant instant) {
        long intervalMillis = config.getInterval().toMillis();
        long time = instant.toEpochMilli();
        return time - (time % intervalMillis);
    }

    /**
     * @return the planned execution times of all requests in the queue
     */
    public List<ZonedDateTime> getScheduledTimes() {
        synchronized (lock) {
            List<ZonedDateTime> times = new ArrayList<>();
            for (ScheduledRequest<?> r : queue) {
                times.add(r.getScheduledTime());
            }
            return Collections.unmodifiableList(times);
        }
    }

    /**
     * @return the current size of the queue
     */
    public int getQueueSize() {
        return queue.size();
    }

    /**
     * @return a snapshot of the current queue (read-only)
     */
    public List<ScheduledRequest<?>> getQueueSnapshot() {
        synchronized (lock) {
            return new ArrayList<>(queue);
        }
    }

    /**
     * Shutdown the queue and stop all scheduled executions.
     */
    public void shutdown() {
        executor.shutdownNow();
    }
}
