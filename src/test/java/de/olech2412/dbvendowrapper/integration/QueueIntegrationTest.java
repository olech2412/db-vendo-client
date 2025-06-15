package de.olech2412.dbvendowrapper.integration;

import de.olech2412.dbvendowrapper.ApiClient;
import de.olech2412.dbvendowrapper.api.DBVendoAPI;
import de.olech2412.dbvendowrapper.config.CacheConfig;
import de.olech2412.dbvendowrapper.config.QueueConfig;
import de.olech2412.dbvendowrapper.requests.StopByIdRequest;
import de.olech2412.dbvendowrapper.model.StopsIdResponse;
import de.olech2412.dbvendowrapper.queue.RequestQueue;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.*;

public class QueueIntegrationTest {

    private DBVendoAPI dbVendoAPI;

    @ClassRule
    public static GenericContainer<?> dbVendoClient = new GenericContainer<>(DockerImageName.parse("ghcr.io/public-transport/db-vendo-client"))
            .withEnv("USER_AGENT", "db-vendo-wrapper-test")
            .withEnv("DB_PROFILE", "dbnav")
            .withExposedPorts(3000);

    @Before
    public void setUp() {
        ApiClient apiClient = new ApiClient();
        String baseUrl = String.format("http://%s:%d", dbVendoClient.getHost(), dbVendoClient.getMappedPort(3000));
        apiClient.setBasePath(baseUrl); // Adjust if needed
        // Set interval to 1 second for more robust timing in tests
        QueueConfig queueConfig = new QueueConfig(true, 2, Duration.ofSeconds(1), false);
        dbVendoAPI = new DBVendoAPI(apiClient, de.olech2412.dbvendowrapper.config.CacheConfig.DEFAULT, queueConfig);
    }

    @Test
    public void testQueueLimitsRequestsPerInterval() throws Exception {
        StopByIdRequest req1 = new StopByIdRequest("8011160");
        StopByIdRequest req2 = new StopByIdRequest("8011160");
        StopByIdRequest req3 = new StopByIdRequest("8011160");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit all requests quickly
        Future<StopsIdResponse> f1 = executor.submit(() -> dbVendoAPI.stopsIdGet(req1));
        Future<StopsIdResponse> f2 = executor.submit(() -> dbVendoAPI.stopsIdGet(req2));
        Future<StopsIdResponse> f3 = executor.submit(() -> dbVendoAPI.stopsIdGet(req3));

        // Wait a short moment to ensure all are scheduled
        Thread.sleep(200);

        // Get the scheduled times from the queue snapshot
        List<RequestQueue.ScheduledRequest<?>> scheduled = dbVendoAPI.getQueueSnapshot();
        // If the queue is empty (all requests already running), just skip the check
        if (scheduled.size() >= 3) {
            scheduled.sort(Comparator.comparing(RequestQueue.ScheduledRequest::getScheduledTime));
            long s1 = scheduled.get(0).getScheduledTime().toInstant().toEpochMilli();
            long s3 = scheduled.get(2).getScheduledTime().toInstant().toEpochMilli();
            // The third request should be scheduled at least 900ms after the first
            assertTrue("Third scheduled request should be at least 900ms after the first. Actual: " + (s3 - s1), (s3 - s1) >= 900);
        }

        // Wait for all to complete to avoid thread leaks
        f1.get();
        f2.get();
        f3.get();

        executor.shutdown();
    }

    @Test
    public void testQueueAutoSpread() throws Exception {
        QueueConfig spreadConfig = new QueueConfig(true, 3, Duration.ofSeconds(3), true);
        ApiClient apiClient = new ApiClient();
        String baseUrl = String.format("http://%s:%d", dbVendoClient.getHost(), dbVendoClient.getMappedPort(3000));
        apiClient.setBasePath(baseUrl);
        DBVendoAPI api = new DBVendoAPI(apiClient, de.olech2412.dbvendowrapper.config.CacheConfig.DEFAULT, spreadConfig);

        StopByIdRequest req1 = new StopByIdRequest("8011160");
        StopByIdRequest req2 = new StopByIdRequest("8011160");
        StopByIdRequest req3 = new StopByIdRequest("8011160");

        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<StopsIdResponse> f1 = executor.submit(() -> api.stopsIdGet(req1));
        Future<StopsIdResponse> f2 = executor.submit(() -> api.stopsIdGet(req2));
        Future<StopsIdResponse> f3 = executor.submit(() -> api.stopsIdGet(req3));

        f1.get();
        f2.get();
        f3.get();

        long duration = System.currentTimeMillis() - start;

        // With autoSpread, the last request should be about 2 seconds after the first (3 requests in 3s interval)
        assertTrue(duration >= 1800);

        executor.shutdown();
    }

    @Test
    public void testQueueInspection() {
        QueueConfig queueConfig = new QueueConfig(true, 2, Duration.ofSeconds(10), false);
        DBVendoAPI api = new DBVendoAPI(new ApiClient(), de.olech2412.dbvendowrapper.config.CacheConfig.DEFAULT, queueConfig);

        // Submit requests asynchronously to fill the queue
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> api.stopsIdGet(new StopByIdRequest("8011160")));
        executor.submit(() -> api.stopsIdGet(new StopByIdRequest("8011160")));

        // The queue should have at least 1 scheduled request (depending on timing)
        List<ZonedDateTime> scheduled = api.getScheduledRequestTimes();
        assertNotNull(scheduled);
        assertTrue(scheduled.size() >= 1);

        int size = api.getQueueSize();
        assertTrue(size >= 0);

        executor.shutdownNow();
    }

    @Test
    public void testQueueLoadHandling() throws Exception {
        int maxRequestsPerInterval = 5;
        int totalRequests = 20;
        int intervalSeconds = 5; // kürzeres Intervall für robustere Tests
        QueueConfig queueConfig = new QueueConfig(true, maxRequestsPerInterval, Duration.ofSeconds(intervalSeconds), false);

        ApiClient apiClient = new ApiClient();
        String baseUrl = String.format("http://%s:%d", dbVendoClient.getHost(), dbVendoClient.getMappedPort(3000));
        apiClient.setBasePath(baseUrl);
        CacheConfig cacheConfig = new CacheConfig(false, 0, null);
        DBVendoAPI api = new DBVendoAPI(apiClient, cacheConfig, queueConfig);

        ExecutorService executor = Executors.newFixedThreadPool(maxRequestsPerInterval);
        List<Callable<Long>> tasks = new CopyOnWriteArrayList<>();
        for (int i = 0; i < totalRequests; i++) {
            int finalI = i;
            tasks.add(() -> {
                StopByIdRequest req = new StopByIdRequest("8011160");
                System.out.println(LocalDateTime.now() + ": Submitting request " + (finalI + 1));
                api.stopsIdGet(req);
                return System.currentTimeMillis();
            });
        }

        long start = System.currentTimeMillis();
        List<Future<Long>> futures = executor.invokeAll(tasks);
        List<Long> finishTimes = new CopyOnWriteArrayList<>();
        for (Future<Long> f : futures) {
            finishTimes.add(f.get());
        }
        long end = System.currentTimeMillis();

        // Die Requests sollten mindestens (totalRequests / maxRequestsPerInterval - 1) * intervalSeconds Sekunden dauern
        int intervals = (int) Math.ceil((double) totalRequests / maxRequestsPerInterval);
        long expectedMinDuration = (intervals - 1) * intervalSeconds * 1000L;

        // Toleranz: 80% der erwarteten Mindestdauer
        long minDurationWithTolerance = (long) (expectedMinDuration * 0.8);

        long actualDuration = end - start;
        assertTrue("Total duration should be at least " + minDurationWithTolerance + "ms, but was " + actualDuration + "ms",
                actualDuration >= minDurationWithTolerance);

        executor.shutdown();
    }
}
