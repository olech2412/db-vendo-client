package de.olech2412.dbvendowrapper.config;

import java.time.Duration;

/**
 * Configuration class for caching settings in the DB Vendo Wrapper.
 */
public class CacheConfig {
    private boolean enabled = true;
    private int maximumSize = 1000;
    private Duration expireAfterWrite = Duration.ofMinutes(10);

    public static CacheConfig DEFAULT = new CacheConfig();

    public CacheConfig() {
    }

    public CacheConfig(boolean enabled, int maximumSize, Duration expireAfterWrite) {
        this.enabled = enabled;
        this.maximumSize = maximumSize;
        this.expireAfterWrite = expireAfterWrite;
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

    public static class Builder {
        private boolean enabled = true;
        private int maximumSize = 1000;
        private Duration expireAfterWrite = Duration.ofMinutes(10);

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

        public CacheConfig build() {
            return new CacheConfig(enabled, maximumSize, expireAfterWrite);
        }
    }
}
