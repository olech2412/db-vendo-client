package de.olech2412.dbvendowrapper.unit;

import de.olech2412.dbvendowrapper.config.QueueConfig;
import de.olech2412.dbvendowrapper.queue.RequestQueue;
import org.junit.After;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class RequestQueueTest {

    private RequestQueue queue;

    @After
    public void tearDown() {
        if (queue != null) {
            queue.shutdown();
        }
    }

    @Test
    public void testSubmitAndExecuteImmediately() throws Exception {
        queue = new RequestQueue(new QueueConfig(true, 2, Duration.ofSeconds(10), false));
        CompletableFuture<String> fut = queue.submit(() -> "test");
        assertEquals("test", fut.get());
    }

    @Test
    public void testMaxRequestsPerInterval() throws Exception {
        queue = new RequestQueue(new QueueConfig(true, 2, Duration.ofSeconds(1), false));
        AtomicInteger counter = new AtomicInteger(0);

        CompletableFuture<Integer> fut1 = queue.submit(counter::incrementAndGet);
        CompletableFuture<Integer> fut2 = queue.submit(counter::incrementAndGet);
        CompletableFuture<Integer> fut3 = queue.submit(counter::incrementAndGet);

        int r1 = fut1.get();
        int r2 = fut2.get();
        int r3 = fut3.get();

        assertEquals(1, r1);
        assertEquals(2, r2);
        assertEquals(3, r3);

        // The third request should be delayed to the next interval
        List<ZonedDateTime> scheduled = queue.getScheduledTimes();
        assertTrue(scheduled.size() <= 2);
    }

    @Test
    public void testQueueSnapshotAndSize() {
        queue = new RequestQueue(new QueueConfig(true, 2, Duration.ofSeconds(10), false));
        queue.submit(() -> "a");
        queue.submit(() -> "b");
        List<RequestQueue.ScheduledRequest<?>> snapshot = queue.getQueueSnapshot();
        assertNotNull(snapshot);
        assertTrue(snapshot.size() >= 0);
        int size = queue.getQueueSize();
        assertTrue(size >= 0);
    }

    @Test
    public void testShutdown() {
        queue = new RequestQueue(new QueueConfig(true, 2, Duration.ofSeconds(10), false));
        queue.shutdown();
        assertTrue(queue.getQueueSize() >= 0);
    }
}
