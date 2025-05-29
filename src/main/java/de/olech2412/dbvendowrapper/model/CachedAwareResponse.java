package de.olech2412.dbvendowrapper.model;

public interface CachedAwareResponse {
    void setFromCache(boolean fromCache);
    boolean isFromCache();
}

