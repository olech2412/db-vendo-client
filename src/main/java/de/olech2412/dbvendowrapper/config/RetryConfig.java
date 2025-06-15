package de.olech2412.dbvendowrapper.config;

import java.time.Duration;
import java.util.function.Predicate;

public class RetryConfig {

    public static final RetryConfig DEFAULT = new RetryConfig(0, Duration.ofMillis(0), t -> false);

    private final int maxRetries;
    private final Duration retryInterval;
    private final Predicate<Throwable> shouldRetry;

    public RetryConfig(int maxRetries, Duration retryInterval, Predicate<Throwable> shouldRetry) {
        this.maxRetries = maxRetries;
        this.retryInterval = retryInterval;
        this.shouldRetry = shouldRetry;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public Duration getRetryInterval() {
        return retryInterval;
    }

    public boolean shouldRetry(Throwable t) {
        return shouldRetry.test(t);
    }

    public static RetryConfig forHttpStatusCodes(int maxRetries, Duration retryInterval, int... statusCodes) {
        return new RetryConfig(maxRetries, retryInterval, t -> {
            Throwable cause = t;
            while (cause != null) {
                if (cause instanceof org.springframework.web.client.HttpStatusCodeException) {
                    int code = ((org.springframework.web.client.HttpStatusCodeException) cause).getRawStatusCode();
                    for (int sc : statusCodes) {
                        if (sc == code) return true;
                    }
                }
                cause = cause.getCause();
            }
            return false;
        });
    }
}
