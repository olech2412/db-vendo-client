package de.olech2412.dbvendowrapper.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import de.olech2412.dbvendowrapper.requests.DBVendoRequest;

/**
 * Configuration class for the queuing feature.
 *
 * This class allows you to control the queuing behavior for API requests:
 * - Enable/disable queuing
 * - Set the maximum number of requests per interval
 * - Set the interval duration
 * - Enable automatic spreading of requests across the interval
 */
public class QueueConfig {

    /** Default configuration: disabled, 20 requests per 20 minutes, no auto-spread */
    public static final QueueConfig DEFAULT = new QueueConfig(false, 20, Duration.ofMinutes(20), false);

    private final boolean enabled;
    private final int maxRequestsPerInterval;
    private final Duration interval;
    private final boolean autoSpread;

    // Liste zusätzlicher Requests, die verarbeitet werden sollen
    private final List<DBVendoRequest> additionalRequests = new ArrayList<>();

    /**
     * Create a new QueueConfig.
     *
     * @param enabled Whether queuing is enabled
     * @param maxRequestsPerInterval Maximum number of requests per interval
     * @param interval Duration of the interval
     * @param autoSpread Whether requests should be automatically spread evenly across the interval
     */
    public QueueConfig(boolean enabled, int maxRequestsPerInterval, Duration interval, boolean autoSpread) {
        this.enabled = enabled;
        this.maxRequestsPerInterval = maxRequestsPerInterval;
        this.interval = interval;
        this.autoSpread = autoSpread;
    }

    /** @return true if queuing is enabled */
    public boolean isEnabled() {
        return enabled;
    }

    /** @return maximum number of requests per interval */
    public int getMaxRequestsPerInterval() {
        return maxRequestsPerInterval;
    }

    /** @return interval duration */
    public Duration getInterval() {
        return interval;
    }

    /** @return true if requests are automatically spread across the interval */
    public boolean isAutoSpread() {
        return autoSpread;
    }

    // Methode zum Anhängen von Requests
    public void addRequests(List<DBVendoRequest> requests) {
        if (requests != null) {
            this.additionalRequests.addAll(requests);
        }
    }

    // Getter für die Requests (unmodifiable)
    public List<DBVendoRequest> getAdditionalRequests() {
        return Collections.unmodifiableList(additionalRequests);
    }

    /**
     * @return a disabled QueueConfig
     */
    public static QueueConfig disabled() {
        return new QueueConfig(false, 0, Duration.ZERO, false);
    }

    // Optional: Builder für komfortable Konfiguration
    public static class Builder {
        private boolean enabled = false;
        private int maxRequestsPerInterval = 20;
        private Duration interval = Duration.ofMinutes(20);
        private boolean autoSpread = false;
        private List<DBVendoRequest> additionalRequests = new ArrayList<>();

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }
        public Builder maxRequestsPerInterval(int max) {
            this.maxRequestsPerInterval = max;
            return this;
        }
        public Builder interval(Duration interval) {
            this.interval = interval;
            return this;
        }
        public Builder autoSpread(boolean autoSpread) {
            this.autoSpread = autoSpread;
            return this;
        }
        public Builder additionalRequests(List<DBVendoRequest> requests) {
            if (requests != null) {
                this.additionalRequests.addAll(requests);
            }
            return this;
        }
        public QueueConfig build() {
            QueueConfig config = new QueueConfig(enabled, maxRequestsPerInterval, interval, autoSpread);
            config.addRequests(this.additionalRequests);
            return config;
        }
    }
}
