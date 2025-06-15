package de.olech2412.dbvendowrapper.api;

import de.olech2412.dbvendowrapper.ApiClient;
import de.olech2412.dbvendowrapper.BaseApi;
import de.olech2412.dbvendowrapper.model.*;
import de.olech2412.dbvendowrapper.requests.*;
import de.olech2412.dbvendowrapper.config.CacheConfig;
import de.olech2412.dbvendowrapper.config.QueueConfig;
import de.olech2412.dbvendowrapper.config.RetryConfig;
import de.olech2412.dbvendowrapper.queue.RequestQueue;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * Default API implementation providing cached access to transportation-related services.
 *
 * This class extends BaseApi and provides caching functionality using Caffeine cache
 * for various transportation API endpoints including trips, journeys, locations,
 * arrivals, departures, and stops.
 *
 * The caching behavior is controlled by the CacheConfig parameter and can be
 * completely disabled if needed.
 *
 * The queuing behavior is controlled by the QueueConfig parameter and can be
 * enabled to limit and spread requests over time.
 *
 * The retry behavior is controlled by the RetryConfig parameter and can be
 * enabled to retry failed requests based on specific conditions.
 *
 * @author olech2412
 */
public class DBVendoAPI extends BaseApi {

    /** Configuration object that controls caching behavior */
    private final CacheConfig cacheConfig;

    /** Configuration object that controls queuing behavior */
    private final QueueConfig queueConfig;

    /** Retry configuration */
    private final RetryConfig retryConfig;

    /** Request queue instance if queuing is enabled */
    private final RequestQueue requestQueue;

    /** Cache for trip information indexed by TripByIdRequest */
    private final Cache<TripByIdRequest, TripsIdResponse> tripCache;

    /** Cache for journey search results indexed by JourneySearchRequest */
    private final Cache<JourneySearchRequest, JourneysResponse> journeyCache;

    /** Cache for journey refresh operations indexed by JourneyByRefreshTokenRequest */
    private final Cache<JourneyByRefreshTokenRequest, JourneysRefreshResponse> journeyRefreshCache;

    /** Cache for location search results indexed by LocationSearchRequest */
    private final Cache<LocationSearchRequest, List<StopsIdResponse>> locationSearchCache;

    /** Cache for nearby locations indexed by LocationsNearbyRequest */
    private final Cache<LocationsNearbyRequest, List<StopsIdResponse>> locationsNearbyCache;

    /** Cache for arrival information indexed by ArrivalsByStopIdRequest */
    private final Cache<ArrivalsByStopIdRequest, StopsIdArrivalsResponse> arrivalsCache;

    /** Cache for departure information indexed by DeparturesByStopIdRequest */
    private final Cache<DeparturesByStopIdRequest, StopsIdDeparturesResponse> departuresCache;

    /** Cache for stop information indexed by StopByIdRequest */
    private final Cache<StopByIdRequest, StopsIdResponse> stopCache;

    /**
     * Default constructor that creates a new DBVendoAPI instance with default ApiClient, CacheConfig, and QueueConfig.
     */
    public DBVendoAPI() {
        this(new ApiClient());
    }

    /**
     * Constructor that creates a new DBVendoAPI instance with the specified ApiClient and default CacheConfig and QueueConfig.
     *
     * @param apiClient the ApiClient to use for API calls
     */
    public DBVendoAPI(ApiClient apiClient) {
        this(apiClient, CacheConfig.DEFAULT, QueueConfig.DEFAULT);
    }

    /**
     * Constructor that creates a new DBVendoAPI instance with the specified ApiClient and CacheConfig, and default QueueConfig.
     *
     * @param apiClient the ApiClient to use for API calls
     * @param cacheConfig the cache configuration to control caching behavior
     */
    public DBVendoAPI(ApiClient apiClient, CacheConfig cacheConfig) {
        this(apiClient, cacheConfig, QueueConfig.DEFAULT);
    }

    /**
     * Constructor that creates a new DBVendoAPI instance with the specified ApiClient, CacheConfig, and QueueConfig.
     *
     * @param apiClient the ApiClient to use for API calls
     * @param cacheConfig the cache configuration to control caching behavior
     * @param queueConfig the queue configuration to control queuing behavior
     */
    public DBVendoAPI(ApiClient apiClient, CacheConfig cacheConfig, QueueConfig queueConfig) {
        this(apiClient, cacheConfig, queueConfig, RetryConfig.DEFAULT);
    }

    /**
     * Constructor that creates a new DBVendoAPI instance with the specified ApiClient, CacheConfig, QueueConfig, and RetryConfig.
     *
     * @param apiClient the ApiClient to use for API calls
     * @param cacheConfig the cache configuration to control caching behavior
     * @param queueConfig the queue configuration to control queuing behavior
     * @param retryConfig the retry configuration to control retry behavior
     */
    public DBVendoAPI(ApiClient apiClient, CacheConfig cacheConfig, QueueConfig queueConfig, RetryConfig retryConfig) {
        super(apiClient);
        this.cacheConfig = cacheConfig;
        this.queueConfig = queueConfig;
        this.retryConfig = retryConfig != null ? retryConfig : RetryConfig.DEFAULT;

        if (queueConfig != null && queueConfig.isEnabled()) {
            this.requestQueue = new RequestQueue(queueConfig);
        } else {
            this.requestQueue = null;
        }

        // Initialize caches nur, wenn caching global aktiviert ist
        if (cacheConfig.isEnabled()) {
            CacheConfig.EndpointCacheConfig stopsCfg = cacheConfig.getStopsConfig();
            this.stopCache = stopsCfg.isEnabled() ?
                    Caffeine.newBuilder()
                            .maximumSize(stopsCfg.getMaximumSize())
                            .expireAfterWrite(stopsCfg.getExpireAfterWrite())
                            .build() : null;
            CacheConfig.EndpointCacheConfig tripsCfg = cacheConfig.getTripsConfig();
            this.tripCache = tripsCfg.isEnabled() ?
                    Caffeine.newBuilder()
                            .maximumSize(tripsCfg.getMaximumSize())
                            .expireAfterWrite(tripsCfg.getExpireAfterWrite())
                            .build() : null;
            CacheConfig.EndpointCacheConfig journeysCfg = cacheConfig.getJourneysConfig();
            this.journeyCache = journeysCfg.isEnabled() ?
                    Caffeine.newBuilder()
                            .maximumSize(journeysCfg.getMaximumSize())
                            .expireAfterWrite(journeysCfg.getExpireAfterWrite())
                            .build() : null;
            this.journeyRefreshCache = journeysCfg.isEnabled() ?
                    Caffeine.newBuilder()
                            .maximumSize(journeysCfg.getMaximumSize())
                            .expireAfterWrite(journeysCfg.getExpireAfterWrite())
                            .build() : null;
            CacheConfig.EndpointCacheConfig locationsCfg = cacheConfig.getLocationsConfig();
            this.locationSearchCache = locationsCfg.isEnabled() ?
                    Caffeine.newBuilder()
                            .maximumSize(locationsCfg.getMaximumSize())
                            .expireAfterWrite(locationsCfg.getExpireAfterWrite())
                            .build() : null;
            this.locationsNearbyCache = locationsCfg.isEnabled() ?
                    Caffeine.newBuilder()
                            .maximumSize(locationsCfg.getMaximumSize())
                            .expireAfterWrite(locationsCfg.getExpireAfterWrite())
                            .build() : null;
            CacheConfig.EndpointCacheConfig arrivalsCfg = cacheConfig.getArrivalsConfig();
            this.arrivalsCache = arrivalsCfg.isEnabled() ?
                    Caffeine.newBuilder()
                            .maximumSize(arrivalsCfg.getMaximumSize())
                            .expireAfterWrite(arrivalsCfg.getExpireAfterWrite())
                            .build() : null;
            CacheConfig.EndpointCacheConfig departuresCfg = cacheConfig.getDeparturesConfig();
            this.departuresCache = departuresCfg.isEnabled() ?
                    Caffeine.newBuilder()
                            .maximumSize(departuresCfg.getMaximumSize())
                            .expireAfterWrite(departuresCfg.getExpireAfterWrite())
                            .build() : null;
        } else {
            this.tripCache = null;
            this.journeyCache = null;
            this.journeyRefreshCache = null;
            this.locationSearchCache = null;
            this.locationsNearbyCache = null;
            this.arrivalsCache = null;
            this.departuresCache = null;
            this.stopCache = null;
        }
    }

    /**
     * Clears all internal caches (for integration tests).
     */
    public void clearAllCaches() {
        if (tripCache != null) tripCache.invalidateAll();
        if (journeyCache != null) journeyCache.invalidateAll();
        if (journeyRefreshCache != null) journeyRefreshCache.invalidateAll();
        if (locationSearchCache != null) locationSearchCache.invalidateAll();
        if (locationsNearbyCache != null) locationsNearbyCache.invalidateAll();
        if (arrivalsCache != null) arrivalsCache.invalidateAll();
        if (departuresCache != null) departuresCache.invalidateAll();
        if (stopCache != null) stopCache.invalidateAll();
    }

    /**
     * Gibt die geplanten Ausführungszeiten der Requests in der Queue zurück (Europe/Berlin).
     * @return Liste der geplanten Ausführungszeiten, oder leer wenn Queue deaktiviert
     */
    public List<ZonedDateTime> getScheduledRequestTimes() {
        if (requestQueue == null) return List.of();
        return requestQueue.getScheduledTimes();
    }

    /**
     * Gibt einen Snapshot der aktuellen Queue zurück (read-only, geplante Zeiten in Europe/Berlin).
     * @return Liste der geplanten Requests, oder leer wenn Queue deaktiviert
     */
    public List<RequestQueue.ScheduledRequest<?>> getQueueSnapshot() {
        if (requestQueue == null) return List.of();
        return requestQueue.getQueueSnapshot();
    }

    /**
     * Returns the current size of the queue.
     * @return queue size, or 0 if queuing is disabled
     */
    public int getQueueSize() {
        if (requestQueue == null) return 0;
        return requestQueue.getQueueSize();
    }

    /**
     * Fügt eine Liste von DBVendoRequests der Queue hinzu und gibt die zugehörigen Futures zurück.
     * Die Requests werden nach den Regeln der QueueConfig abgearbeitet.
     */
    public List<CompletableFuture<?>> enqueueRequests(List<DBVendoRequest> requests) {
        if (requestQueue == null || requests == null) return List.of();
        List<java.util.function.Supplier<Object>> suppliers = new java.util.ArrayList<>();
        for (DBVendoRequest req : requests) {
            suppliers.add(() -> this.executeRequest(req));
        }
        // Nutze die Batch-Logik der RequestQueue
        return new java.util.ArrayList<>(requestQueue.enqueueRequests(suppliers));
    }

    /**
     * Führt einen beliebigen DBVendoRequest aus (Dispatch auf die passende API-Methode).
     * Hier können weitere Request-Typen ergänzt werden.
     */
    private Object executeRequest(DBVendoRequest req) {
        // WICHTIG: Hier KEINEN Methodenaufruf verwenden, der wieder queueOrDirect nutzt!
        if (req instanceof TripByIdRequest) {
            TripByIdRequest r = (TripByIdRequest) req;
            TripsIdResponse response = tripsIdGetWithHttpInfo(
                r.getTripId(),
                r.isStopOvers(),
                r.isRemarks(),
                r.isPolyline(),
                r.getLanguage()
            ).getBody();
            return getCachedOrFetch(tripCache, r, response);
        } else if (req instanceof JourneyByRefreshTokenRequest) {
            JourneyByRefreshTokenRequest r = (JourneyByRefreshTokenRequest) req;
            JourneysRefreshResponse response = journeysRefGetWithHttpInfo(
                r.getRefreshToken(),
                r.isStopOvers(),
                r.isTickets(),
                r.isPolylines(),
                r.isSubStops(),
                r.isEntrances(),
                r.isRemarks(),
                r.isScheduledDays(),
                r.isNotOnlyFastRoutes(),
                r.isBestPrice(),
                r.getLanguage()
            ).getBody();
            return getCachedOrFetch(journeyRefreshCache, r, response);
        } else if (req instanceof JourneySearchRequest) {
            JourneySearchRequest r = (JourneySearchRequest) req;
            JourneysResponse response = journeysGetWithHttpInfo(
                r.getFrom(),
                r.getFromId(),
                r.getFromAddress(),
                r.getFromLatitude(),
                r.getFromLongitude(),
                r.getTo(),
                r.getToId(),
                r.getToAddress(),
                r.getToLatitude(),
                r.getToLongitude(),
                r.getDeparture(),
                r.getArrival(),
                r.getEarlierThen(),
                r.getLaterThen(),
                r.getMaxResults(),
                r.isStopOvers(),
                r.getMaxTransfers(),
                r.getMinimumTransferTime(),
                r.getAccessibility(),
                r.isBikeFriendly(),
                r.isStartWithWalking(),
                r.getWalkingSpeed(),
                r.isTickets(),
                r.isPolylines(),
                r.isSubStops(),
                r.isEntrances(),
                r.isRemarks(),
                r.isScheduledDays(),
                r.isNotOnlyFastRoutes(),
                r.isBestPrice(),
                r.getLanguage(),
                r.getLoyaltyCard(),
                r.isFirstClass(),
                r.getAge(),
                r.getProfileSpecificProducts()
            ).getBody();
            return getCachedOrFetch(journeyCache, r, response);
        } else if (req instanceof LocationSearchRequest) {
            LocationSearchRequest r = (LocationSearchRequest) req;
            List<StopsIdResponse> response = locationsGetWithHttpInfo(
                r.getQuery(),
                r.isFuzzy(),
                r.getMaxResults(),
                r.isStops(),
                r.isAddresses(),
                r.isPoi(),
                r.isLinesOfStops(),
                r.getLanguage()
            ).getBody();
            return getCachedOrFetch(locationSearchCache, r, response);
        } else if (req instanceof LocationsNearbyRequest) {
            LocationsNearbyRequest r = (LocationsNearbyRequest) req;
            List<StopsIdResponse> response = locationsNearbyGetWithHttpInfo(
                r.getLocation(),
                r.getMaxResults(),
                r.getDistance(),
                r.isStops(),
                r.isPoi(),
                r.isLinesOfStops(),
                r.getLanguage()
            ).getBody();
            return getCachedOrFetch(locationsNearbyCache, r, response);
        } else if (req instanceof ArrivalsByStopIdRequest) {
            ArrivalsByStopIdRequest r = (ArrivalsByStopIdRequest) req;
            StopsIdArrivalsResponse response = stopsIdArrivalsGetWithHttpInfo(
                r.getStopId(),
                r.getArrivalTime(),
                r.getDirection(),
                r.getDuration(),
                r.getMaxResults(),
                r.isLinesOfStops(),
                r.isRemarks(),
                r.getLanguage(),
                r.getProfileSpecificProducts()
            ).getBody();
            return getCachedOrFetch(arrivalsCache, r, response);
        } else if (req instanceof DeparturesByStopIdRequest) {
            DeparturesByStopIdRequest r = (DeparturesByStopIdRequest) req;
            StopsIdDeparturesResponse response = stopsIdDeparturesGetWithHttpInfo(
                r.getStopId(),
                r.getDepartureTime(),
                r.getDirection(),
                r.getDuration(),
                r.getMaxResults(),
                r.isLinesOfStops(),
                r.isRemarks(),
                r.getLanguage(),
                r.getProfileSpecificProducts()
            ).getBody();
            return getCachedOrFetch(departuresCache, r, response);
        } else if (req instanceof StopByIdRequest) {
            StopByIdRequest r = (StopByIdRequest) req;
            StopsIdResponse response = stopsIdGetWithHttpInfo(
                r.getStopId(),
                r.isLinesOfStops(),
                r.getLanguage()
            ).getBody();
            return getCachedOrFetch(stopCache, r, response);
        }
        throw new IllegalArgumentException("Unbekannter Request-Typ: " + req.getClass());
    }

    /**
     * Helper method to handle queuing or direct execution for a supplier.
     */
    private <T> T queueOrDirect(java.util.function.Supplier<T> supplier) {
        if (requestQueue != null) {
            CompletableFuture<T> fut = requestQueue.submit(() -> executeWithRetry(supplier));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RuntimeException("Error executing request from queue", e);
            }
        } else {
            return executeWithRetry(supplier);
        }
    }

    /**
     * Executes a supplier with retry logic based on the RetryConfig.
     */
    private <T> T executeWithRetry(java.util.function.Supplier<T> supplier) {
        int attempts = 0;
        Throwable lastError = null;
        while (attempts <= retryConfig.getMaxRetries()) {
            try {
                return supplier.get();
            } catch (Throwable t) {
                if (!retryConfig.shouldRetry(t) || attempts == retryConfig.getMaxRetries()) {
                    lastError = t;
                    break;
                }
                attempts++;
                try {
                    Thread.sleep(retryConfig.getRetryInterval().toMillis());
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        // Logging
        System.err.println("Request failed after " + (attempts + 1) + " attempts: " + (lastError != null ? lastError.getMessage() : "unknown error"));
        throw new RuntimeException("Request failed after " + (attempts + 1) + " attempts", lastError);
    }

    /**
     * Generic helper method to handle caching logic for API responses.
     *
     * This method first checks if caching is enabled and the cache exists.
     * If so, it tries to retrieve a cached value for the given key.
     * If no cached value exists, it stores the fetched value in the cache
     * and returns it.
     *
     * @param <T> the type of the cached value
     * @param cache the cache instance to use
     * @param key the cache key
     * @param fetchedValue the freshly fetched value from the API
     * @return either the cached value or the fetched value
     */
    private <T> T getCachedOrFetch(Cache<?, T> cache, Object key, T fetchedValue) {
        if (!cacheConfig.isEnabled() || cache == null) {
            setFromCacheFlag(fetchedValue, false);
            return fetchedValue;
        }

        @SuppressWarnings("unchecked")
        T cached = ((Cache<Object, T>) cache).getIfPresent(key);

        if (cached != null) {
            setFromCacheFlag(cached, true);
            return cached;
        }

        if (fetchedValue != null) {
            ((Cache<Object, T>) cache).put(key, fetchedValue);
            setFromCacheFlag(fetchedValue, false);
        }

        return fetchedValue;
    }

    /**
     * Sets the fromCache flag for single responses or lists of responses.
     */
    private void setFromCacheFlag(Object obj, boolean fromCache) {
        if (obj instanceof CachedAwareResponse) {
            ((CachedAwareResponse) obj).setFromCache(fromCache);
        } else if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                if (o instanceof CachedAwareResponse) {
                    ((CachedAwareResponse) o).setFromCache(fromCache);
                }
            }
        }
    }

    /**
     * Retrieves trip information by trip ID with optional parameters.
     *
     * This method fetches detailed information about a specific trip including
     * stop-overs, remarks, polyline data, and supports multiple languages.
     * The result is cached based on the request parameters.
     *
     * @param tripByIdRequest the request object containing trip ID and optional parameters
     * @return trip information response containing detailed trip data
     * @throws RestClientException if the API call fails
     */
    public TripsIdResponse tripsIdGet(TripByIdRequest tripByIdRequest) throws RestClientException {
        return queueOrDirect(() -> {
            TripsIdResponse response = tripsIdGetWithHttpInfo(
                    tripByIdRequest.getTripId(),
                    tripByIdRequest.isStopOvers(),
                    tripByIdRequest.isRemarks(),
                    tripByIdRequest.isPolyline(),
                    tripByIdRequest.getLanguage()
            ).getBody();
            return getCachedOrFetch(tripCache, tripByIdRequest, response);
        });
    }

    /**
     * Refreshes journey information using a refresh token.
     *
     * This method allows updating journey information without performing a new search
     * by using a previously obtained refresh token. Useful for getting updated
     * departure/arrival times and delays.
     *
     * @param request the request object containing refresh token and optional parameters
     * @return refreshed journey information
     * @throws RestClientException if the API call fails
     */
    public JourneysRefreshResponse journeysRefGet(JourneyByRefreshTokenRequest request) throws RestClientException {
        return queueOrDirect(() -> {
            JourneysRefreshResponse response = journeysRefGetWithHttpInfo(
                    request.getRefreshToken(),
                    request.isStopOvers(),
                    request.isTickets(),
                    request.isPolylines(),
                    request.isSubStops(),
                    request.isEntrances(),
                    request.isRemarks(),
                    request.isScheduledDays(),
                    request.isNotOnlyFastRoutes(),
                    request.isBestPrice(),
                    request.getLanguage()
            ).getBody();
            return getCachedOrFetch(journeyRefreshCache, request, response);
        });
    }

    /**
     * Searches for journeys between two locations.
     *
     * This method performs a comprehensive journey search with support for various
     * parameters including departure/arrival times, accessibility options, transfer
     * settings, and ticket information. Results are cached for improved performance.
     *
     * @param journeySearchRequest the request object containing search parameters
     * @return journey search results containing available routes
     * @throws RestClientException if the API call fails
     */
    public JourneysResponse journeysGet(JourneySearchRequest journeySearchRequest) throws RestClientException {
        return queueOrDirect(() -> {
            JourneysResponse response = journeysGetWithHttpInfo(
                    journeySearchRequest.getFrom(),
                    journeySearchRequest.getFromId(),
                    journeySearchRequest.getFromAddress(),
                    journeySearchRequest.getFromLatitude(),
                    journeySearchRequest.getFromLongitude(),
                    journeySearchRequest.getTo(),
                    journeySearchRequest.getToId(),
                    journeySearchRequest.getToAddress(),
                    journeySearchRequest.getToLatitude(),
                    journeySearchRequest.getToLongitude(),
                    journeySearchRequest.getDeparture(),
                    journeySearchRequest.getArrival(),
                    journeySearchRequest.getEarlierThen(),
                    journeySearchRequest.getLaterThen(),
                    journeySearchRequest.getMaxResults(),
                    journeySearchRequest.isStopOvers(),
                    journeySearchRequest.getMaxTransfers(),
                    journeySearchRequest.getMinimumTransferTime(),
                    journeySearchRequest.getAccessibility(),
                    journeySearchRequest.isBikeFriendly(),
                    journeySearchRequest.isStartWithWalking(),
                    journeySearchRequest.getWalkingSpeed(),
                    journeySearchRequest.isTickets(),
                    journeySearchRequest.isPolylines(),
                    journeySearchRequest.isSubStops(),
                    journeySearchRequest.isEntrances(),
                    journeySearchRequest.isRemarks(),
                    journeySearchRequest.isScheduledDays(),
                    journeySearchRequest.isNotOnlyFastRoutes(),
                    journeySearchRequest.isBestPrice(),
                    journeySearchRequest.getLanguage(),
                    journeySearchRequest.getLoyaltyCard(),
                    journeySearchRequest.isFirstClass(),
                    journeySearchRequest.getAge(),
                    journeySearchRequest.getProfileSpecificProducts()
            ).getBody();
            return getCachedOrFetch(journeyCache, journeySearchRequest, response);
        });
    }

    /**
     * Searches for locations by query string.
     *
     * This method allows searching for stops, addresses, and points of interest
     * based on a text query. Supports fuzzy matching and various filter options.
     * Results are cached for improved performance.
     *
     * @param locationSearchRequest the request object containing search query and filters
     * @return list of matching locations
     * @throws RestClientException if the API call fails
     */
    public List<StopsIdResponse> locationsGet(LocationSearchRequest locationSearchRequest) throws RestClientException {
        return queueOrDirect(() -> {
            List<StopsIdResponse> response = locationsGetWithHttpInfo(
                    locationSearchRequest.getQuery(),
                    locationSearchRequest.isFuzzy(),
                    locationSearchRequest.getMaxResults(),
                    locationSearchRequest.isStops(),
                    locationSearchRequest.isAddresses(),
                    locationSearchRequest.isPoi(),
                    locationSearchRequest.isLinesOfStops(),
                    locationSearchRequest.getLanguage()
            ).getBody();
            return getCachedOrFetch(locationSearchCache, locationSearchRequest, response);
        });
    }

    /**
     * Finds locations near a specified point.
     *
     * This method searches for stops and points of interest within a specified
     * distance from a given location (coordinates or location name).
     * Results are cached for improved performance.
     *
     * @param locationsNearbyRequest the request object containing location and search parameters
     * @return list of nearby locations
     * @throws RestClientException if the API call fails
     */
    public List<StopsIdResponse> locationsNearbyGet(LocationsNearbyRequest locationsNearbyRequest) throws RestClientException {
        return queueOrDirect(() -> {
            List<StopsIdResponse> response = locationsNearbyGetWithHttpInfo(
                    locationsNearbyRequest.getLocation(),
                    locationsNearbyRequest.getMaxResults(),
                    locationsNearbyRequest.getDistance(),
                    locationsNearbyRequest.isStops(),
                    locationsNearbyRequest.isPoi(),
                    locationsNearbyRequest.isLinesOfStops(),
                    locationsNearbyRequest.getLanguage()
            ).getBody();
            return getCachedOrFetch(locationsNearbyCache, locationsNearbyRequest, response);
        });
    }

    /**
     * Retrieves arrival information for a specific stop.
     *
     * This method fetches upcoming arrivals at a specified stop with support
     * for filtering by direction, time range, and maximum number of results.
     * Results are cached for improved performance.
     *
     * @param arrivalsByStopIdRequest the request object containing stop ID and filter parameters
     * @return arrival information for the specified stop
     * @throws RestClientException if the API call fails
     */
    public StopsIdArrivalsResponse stopsIdArrivalsGet(ArrivalsByStopIdRequest arrivalsByStopIdRequest) throws RestClientException {
        return queueOrDirect(() -> {
            StopsIdArrivalsResponse response = stopsIdArrivalsGetWithHttpInfo(
                    arrivalsByStopIdRequest.getStopId(),
                    arrivalsByStopIdRequest.getArrivalTime(),
                    arrivalsByStopIdRequest.getDirection(),
                    arrivalsByStopIdRequest.getDuration(),
                    arrivalsByStopIdRequest.getMaxResults(),
                    arrivalsByStopIdRequest.isLinesOfStops(),
                    arrivalsByStopIdRequest.isRemarks(),
                    arrivalsByStopIdRequest.getLanguage(),
                    arrivalsByStopIdRequest.getProfileSpecificProducts()
            ).getBody();
            return getCachedOrFetch(arrivalsCache, arrivalsByStopIdRequest, response);
        });
    }

    /**
     * Retrieves departure information for a specific stop.
     *
     * This method fetches upcoming departures from a specified stop with support
     * for filtering by direction, time range, and maximum number of results.
     * Results are cached for improved performance.
     *
     * @param departuresByStopIdRequest the request object containing stop ID and filter parameters
     * @return departure information for the specified stop
     * @throws RestClientException if the API call fails
     */
    public StopsIdDeparturesResponse stopsIdDeparturesGet(DeparturesByStopIdRequest departuresByStopIdRequest) throws RestClientException {
        return queueOrDirect(() -> {
            StopsIdDeparturesResponse response = stopsIdDeparturesGetWithHttpInfo(
                    departuresByStopIdRequest.getStopId(),
                    departuresByStopIdRequest.getDepartureTime(),
                    departuresByStopIdRequest.getDirection(),
                    departuresByStopIdRequest.getDuration(),
                    departuresByStopIdRequest.getMaxResults(),
                    departuresByStopIdRequest.isLinesOfStops(),
                    departuresByStopIdRequest.isRemarks(),
                    departuresByStopIdRequest.getLanguage(),
                    departuresByStopIdRequest.getProfileSpecificProducts()
            ).getBody();
            return getCachedOrFetch(departuresCache, departuresByStopIdRequest, response);
        });
    }

    /**
     * Retrieves detailed information about a specific stop.
     *
     * This method fetches comprehensive information about a stop including
     * its lines and supports multiple languages. Results are cached for
     * improved performance.
     *
     * @param stopByIdRequest the request object containing stop ID and optional parameters
     * @return detailed stop information
     * @throws RestClientException if the API call fails
     */
    public StopsIdResponse stopsIdGet(StopByIdRequest stopByIdRequest) throws RestClientException {
        return queueOrDirect(() -> {
            StopsIdResponse response = stopsIdGetWithHttpInfo(
                    stopByIdRequest.getStopId(),
                    stopByIdRequest.isLinesOfStops(),
                    stopByIdRequest.getLanguage()
            ).getBody();
            return getCachedOrFetch(stopCache, stopByIdRequest, response);
        });
    }

    private ResponseEntity<JourneysResponse> journeysGetWithHttpInfo(String from, String fromId, String fromAddress, BigDecimal fromLatitude, BigDecimal fromLongitude, String to, String toId, String toAddress, BigDecimal toLatitude, BigDecimal toLongitude, OffsetDateTime departure, OffsetDateTime arrival, String earlierThan, String laterThan, Integer results, Boolean stopovers, Integer transfers, Integer transferTime, String accessibility, Boolean bike, Boolean startWithWalking, String walkingSpeed, Boolean tickets, Boolean polylines, Boolean subStops, Boolean entrances, Boolean remarks, Boolean scheduledDays, Boolean notOnlyFastRoutes, Boolean bestprice, String language, String loyaltyCard, Boolean firstClass, Integer age, ProfileSpecificProducts products) throws RestClientException {
        Object localVarPostBody = null;


        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "from", from));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "from.id", fromId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "from.address", fromAddress));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "from.latitude", fromLatitude));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "from.longitude", fromLongitude));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "to", to));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "to.id", toId));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "to.address", toAddress));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "to.latitude", toLatitude));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "to.longitude", toLongitude));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "departure", departure));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "arrival", arrival));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "earlierThan", earlierThan));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "laterThan", laterThan));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "results", results));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "stopovers", stopovers));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "transfers", transfers));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "transferTime", transferTime));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "accessibility", accessibility));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "bike", bike));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "startWithWalking", startWithWalking));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "walkingSpeed", walkingSpeed));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "tickets", tickets));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "polylines", polylines));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "subStops", subStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "entrances", entrances));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "remarks", remarks));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "scheduledDays", scheduledDays));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "notOnlyFastRoutes", notOnlyFastRoutes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "bestprice", bestprice));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "loyaltyCard", loyaltyCard));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "firstClass", firstClass));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "age", age));

        if (products != null) {
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "nationalExpress", products.getNationalExpress()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "national", products.getNational()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "regionalExpress", products.getRegionalExpress()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "regional", products.getRegional()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "suburban", products.getSuburban()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "bus", products.getBus()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "ferry", products.getFerry()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "subway", products.getSubway()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "tram", products.getTram()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "taxi", products.getTaxi()));
        }


        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        ParameterizedTypeReference<JourneysResponse> localReturnType = new ParameterizedTypeReference<JourneysResponse>() {
        };
        return apiClient.invokeAPI("/journeys", HttpMethod.GET, Collections.emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    private ResponseEntity<JourneysRefreshResponse> journeysRefGetWithHttpInfo(String ref, Boolean stopovers, Boolean tickets, Boolean polylines, Boolean subStops, Boolean entrances, Boolean remarks, Boolean scheduledDays, Boolean notOnlyFastRoutes, Boolean bestprice, String language) throws RestClientException {
        Object localVarPostBody = null;

        // verify the required parameter 'ref' is set
        if (ref == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ref' when calling journeysRefGet");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("ref", ref);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "stopovers", stopovers));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "tickets", tickets));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "polylines", polylines));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "subStops", subStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "entrances", entrances));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "remarks", remarks));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "scheduledDays", scheduledDays));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "notOnlyFastRoutes", notOnlyFastRoutes));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "bestprice", bestprice));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));


        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        ParameterizedTypeReference<JourneysRefreshResponse> localReturnType = new ParameterizedTypeReference<JourneysRefreshResponse>() {
        };
        return apiClient.invokeAPI("/journeys/{ref}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    private ResponseEntity<List<StopsIdResponse>> locationsGetWithHttpInfo(String query, Boolean fuzzy, Integer results, Boolean stops, Boolean addresses, Boolean poi, Boolean linesOfStops, String language) throws RestClientException {
        Object localVarPostBody = null;

        // verify the required parameter 'query' is set
        if (query == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'query' when calling locationsGet");
        }


        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "query", query));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "fuzzy", fuzzy));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "results", results));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "stops", stops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "addresses", addresses));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "poi", poi));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "linesOfStops", linesOfStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));


        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        ParameterizedTypeReference<List<StopsIdResponse>> localReturnType = new ParameterizedTypeReference<List<StopsIdResponse>>() {
        };
        return apiClient.invokeAPI("/locations", HttpMethod.GET, Collections.emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    private ResponseEntity<List<StopsIdResponse>> locationsNearbyGetWithHttpInfo(Location location, Integer results, Integer distance, Boolean stops, Boolean poi, Boolean linesOfStops, String language) throws RestClientException {
        Object localVarPostBody = null;


        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();


        if (location != null) {
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "type", location.getType()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", location.getId()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", location.getName()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "poi", location.getPoi()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "address", location.getAddress()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "longitude", location.getLongitude()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "latitude", location.getLatitude()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "altitude", location.getAltitude()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "distance", location.getDistance()));
        }
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "results", results));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "distance", distance));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "stops", stops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "poi", poi));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "linesOfStops", linesOfStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));


        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        ParameterizedTypeReference<List<StopsIdResponse>> localReturnType = new ParameterizedTypeReference<List<StopsIdResponse>>() {
        };
        return apiClient.invokeAPI("/locations/nearby", HttpMethod.GET, Collections.emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    private ResponseEntity<StopsIdArrivalsResponse> stopsIdArrivalsGetWithHttpInfo(String id, OffsetDateTime when, String direction, Integer duration, Integer results, Boolean linesOfStops, Boolean remarks, String language, ProfileSpecificProducts products) throws RestClientException {
        Object localVarPostBody = null;

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling stopsIdArrivalsGet");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "when", when));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "direction", direction));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "duration", duration));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "results", results));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "linesOfStops", linesOfStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "remarks", remarks));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));

        if (products != null) {
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "nationalExpress", products.getNationalExpress()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "national", products.getNational()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "regionalExpress", products.getRegionalExpress()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "regional", products.getRegional()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "suburban", products.getSuburban()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "bus", products.getBus()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "ferry", products.getFerry()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "subway", products.getSubway()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "tram", products.getTram()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "taxi", products.getTaxi()));
        }


        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        ParameterizedTypeReference<StopsIdArrivalsResponse> localReturnType = new ParameterizedTypeReference<StopsIdArrivalsResponse>() {
        };
        return apiClient.invokeAPI("/stops/{id}/arrivals", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    private ResponseEntity<StopsIdDeparturesResponse> stopsIdDeparturesGetWithHttpInfo(String id, OffsetDateTime when, String direction, Integer duration, Integer results, Boolean linesOfStops, Boolean remarks, String language, ProfileSpecificProducts products) throws RestClientException {
        Object localVarPostBody = null;

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling stopsIdDeparturesGet");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "when", when));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "direction", direction));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "duration", duration));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "results", results));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "linesOfStops", linesOfStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "remarks", remarks));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));

        if (products != null) {
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "nationalExpress", products.getNationalExpress()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "national", products.getNational()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "regionalExpress", products.getRegionalExpress()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "regional", products.getRegional()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "suburban", products.getSuburban()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "bus", products.getBus()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "ferry", products.getFerry()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "subway", products.getSubway()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "tram", products.getTram()));
            localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "taxi", products.getTaxi()));
        }


        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        ParameterizedTypeReference<StopsIdDeparturesResponse> localReturnType = new ParameterizedTypeReference<StopsIdDeparturesResponse>() {
        };
        return apiClient.invokeAPI("/stops/{id}/departures", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    private ResponseEntity<StopsIdResponse> stopsIdGetWithHttpInfo(String id, Boolean linesOfStops, String language) throws RestClientException {
        Object localVarPostBody = null;

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling stopsIdGet");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "linesOfStops", linesOfStops));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));


        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        ParameterizedTypeReference<StopsIdResponse> localReturnType = new ParameterizedTypeReference<StopsIdResponse>() {
        };
        return apiClient.invokeAPI("/stops/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    private ResponseEntity<TripsIdResponse> tripsIdGetWithHttpInfo(String id, Boolean stopovers, Boolean remarks, Boolean polyline, String language) throws RestClientException {
        Object localVarPostBody = null;

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling tripsIdGet");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "stopovers", stopovers));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "remarks", remarks));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "polyline", polyline));
        localVarQueryParams.putAll(apiClient.parameterToMultiValueMap(null, "language", language));


        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        ParameterizedTypeReference<TripsIdResponse> localReturnType = new ParameterizedTypeReference<TripsIdResponse>() {
        };
        return apiClient.invokeAPI("/trips/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    public <T> ResponseEntity<T> invokeAPI(String url, HttpMethod method, Object request, ParameterizedTypeReference<T> returnType) throws RestClientException {
        String localVarPath = url.replace(apiClient.getBasePath(), "");
        Object localVarPostBody = request;

        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {};
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[]{};

        return apiClient.invokeAPI(localVarPath, method, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, returnType);
    }
}
