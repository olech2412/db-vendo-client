package de.olech2412.dbvendowrapper.unit;

import de.olech2412.dbvendowrapper.config.QueueConfig;
import org.junit.Test;

import java.time.Duration;

import static org.junit.Assert.*;

public class QueueConfigTest {

    @Test
    public void testDefaultConfig() {
        QueueConfig config = QueueConfig.DEFAULT;
        assertFalse(config.isEnabled());
        assertEquals(20, config.getMaxRequestsPerInterval());
        assertEquals(Duration.ofMinutes(20), config.getInterval());
        assertFalse(config.isAutoSpread());
    }

    @Test
    public void testCustomConfig() {
        QueueConfig config = new QueueConfig(true, 5, Duration.ofSeconds(10), true);
        assertTrue(config.isEnabled());
        assertEquals(5, config.getMaxRequestsPerInterval());
        assertEquals(Duration.ofSeconds(10), config.getInterval());
        assertTrue(config.isAutoSpread());
    }

    @Test
    public void testDisabledConfig() {
        QueueConfig config = QueueConfig.disabled();
        assertFalse(config.isEnabled());
        assertEquals(0, config.getMaxRequestsPerInterval());
        assertEquals(Duration.ZERO, config.getInterval());
        assertFalse(config.isAutoSpread());
    }
}
