package de.olech2412.dbvendowrapper.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import de.olech2412.dbvendowrapper.requests.DBVendoRequest;

/**
 * Configuration class for caching settings in the DB Vendo Wrapper.
 */
public class CacheConfig {
    private boolean enabled = true;
    private int maximumSize = 1000;
    private Duration expireAfterWrite = Duration.ofMinutes(10);

    public static CacheConfig DEFAULT = new CacheConfig();

    // Konfiguration pro Endpunkt (optional, kann null sein)
    private EndpointCacheConfig stopsConfig;
    private EndpointCacheConfig tripsConfig;
    private EndpointCacheConfig journeysConfig;
    private EndpointCacheConfig locationsConfig;
    private EndpointCacheConfig arrivalsConfig;
    private EndpointCacheConfig departuresConfig;

    // Liste zusätzlicher Requests, die verarbeitet werden sollen
    private final List<DBVendoRequest> additionalRequests = new ArrayList<>();

    public CacheConfig() {
    }

    public CacheConfig(boolean enabled, int maximumSize, Duration expireAfterWrite) {
        this.enabled = enabled;
        this.maximumSize = maximumSize;
        this.expireAfterWrite = expireAfterWrite;
    }

    // Erweiterte Konstruktoren
    public CacheConfig(boolean enabled, int maximumSize, Duration expireAfterWrite,
                      EndpointCacheConfig stopsConfig,
                      EndpointCacheConfig tripsConfig,
                      EndpointCacheConfig journeysConfig,
                      EndpointCacheConfig locationsConfig,
                      EndpointCacheConfig arrivalsConfig,
                      EndpointCacheConfig departuresConfig) {
        this.enabled = enabled;
        this.maximumSize = maximumSize;
        this.expireAfterWrite = expireAfterWrite;
        this.stopsConfig = stopsConfig;
        this.tripsConfig = tripsConfig;
        this.journeysConfig = journeysConfig;
        this.locationsConfig = locationsConfig;
        this.arrivalsConfig = arrivalsConfig;
        this.departuresConfig = departuresConfig;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getMaximumSize() {
        return maximumSize;
    }

    public Duration getExpireAfterWrite() {
        return expireAfterWrite;
    }

    // Getter für Endpunkt-Konfigurationen (mit Fallback auf global)
    public EndpointCacheConfig getStopsConfig() {
        return stopsConfig != null ? stopsConfig : new EndpointCacheConfig(enabled, maximumSize, expireAfterWrite);
    }
    public EndpointCacheConfig getTripsConfig() {
        return tripsConfig != null ? tripsConfig : new EndpointCacheConfig(enabled, maximumSize, expireAfterWrite);
    }
    public EndpointCacheConfig getJourneysConfig() {
        return journeysConfig != null ? journeysConfig : new EndpointCacheConfig(enabled, maximumSize, expireAfterWrite);
    }
    public EndpointCacheConfig getLocationsConfig() {
        return locationsConfig != null ? locationsConfig : new EndpointCacheConfig(enabled, maximumSize, expireAfterWrite);
    }
    public EndpointCacheConfig getArrivalsConfig() {
        return arrivalsConfig != null ? arrivalsConfig : new EndpointCacheConfig(enabled, maximumSize, expireAfterWrite);
    }
    public EndpointCacheConfig getDeparturesConfig() {
        return departuresConfig != null ? departuresConfig : new EndpointCacheConfig(enabled, maximumSize, expireAfterWrite);
    }

    // Neue verschachtelte Konfiguration pro Endpunkt
    public static class EndpointCacheConfig {
        private boolean enabled;
        private int maximumSize;
        private Duration expireAfterWrite;

        public EndpointCacheConfig(boolean enabled, int maximumSize, Duration expireAfterWrite) {
            this.enabled = enabled;
            this.maximumSize = maximumSize;
            this.expireAfterWrite = expireAfterWrite;
        }

        public boolean isEnabled() { return enabled; }
        public int getMaximumSize() { return maximumSize; }
        public Duration getExpireAfterWrite() { return expireAfterWrite; }
    }

    public static class Builder {
        private boolean enabled = true;
        private int maximumSize = 1000;
        private Duration expireAfterWrite = Duration.ofMinutes(10);

        private EndpointCacheConfig stopsConfig;
        private EndpointCacheConfig tripsConfig;
        private EndpointCacheConfig journeysConfig;
        private EndpointCacheConfig locationsConfig;
        private EndpointCacheConfig arrivalsConfig;
        private EndpointCacheConfig departuresConfig;

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder maximumSize(int maximumSize) {
            this.maximumSize = maximumSize;
            return this;
        }

        public Builder expireAfterWrite(Duration expireAfterWrite) {
            this.expireAfterWrite = expireAfterWrite;
            return this;
        }

        public Builder stopsConfig(EndpointCacheConfig config) {
            this.stopsConfig = config;
            return this;
        }
        public Builder tripsConfig(EndpointCacheConfig config) {
            this.tripsConfig = config;
            return this;
        }
        public Builder journeysConfig(EndpointCacheConfig config) {
            this.journeysConfig = config;
            return this;
        }
        public Builder locationsConfig(EndpointCacheConfig config) {
            this.locationsConfig = config;
            return this;
        }
        public Builder arrivalsConfig(EndpointCacheConfig config) {
            this.arrivalsConfig = config;
            return this;
        }
        public Builder departuresConfig(EndpointCacheConfig config) {
            this.departuresConfig = config;
            return this;
        }

        public CacheConfig build() {
            CacheConfig config = new CacheConfig(enabled, maximumSize, expireAfterWrite,
                    stopsConfig, tripsConfig, journeysConfig, locationsConfig, arrivalsConfig, departuresConfig);
            return config;
        }
    }
}
