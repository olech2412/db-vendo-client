// ...existing code...
import de.olech2412.dbvendowrapper.config.QueueConfig;
import de.olech2412.dbvendowrapper.queue.RequestQueue;
import java.util.concurrent.CompletableFuture;
// ...existing code...

public class DBVendoAPI extends BaseApi {

    // ...existing code...

    /** Konfiguration für das Queuing-Feature */
    private final QueueConfig queueConfig;
    /** Instanz der RequestQueue, falls aktiviert */
    private final RequestQueue requestQueue;

    // ...existing code...

    public DBVendoAPI() {
        this(new ApiClient());
    }

    public DBVendoAPI(ApiClient apiClient) {
        this(apiClient, CacheConfig.DEFAULT, QueueConfig.DEFAULT);
    }

    public DBVendoAPI(ApiClient apiClient, CacheConfig cacheConfig) {
        this(apiClient, cacheConfig, QueueConfig.DEFAULT);
    }

    public DBVendoAPI(ApiClient apiClient, CacheConfig cacheConfig, QueueConfig queueConfig) {
        super(apiClient);
        this.cacheConfig = cacheConfig;
        this.queueConfig = queueConfig;

        // ...existing cache initialisierung...

        if (queueConfig != null && queueConfig.isEnabled()) {
            this.requestQueue = new RequestQueue(queueConfig);
        } else {
            this.requestQueue = null;
        }
    }

    // ...existing code...

    // --- Öffentliche Methoden für Queue-Status ---

    /**
     * Gibt die geplanten Ausführungszeiten der Requests in der Warteschlange zurück.
     */
    public List<java.time.Instant> getScheduledRequestTimes() {
        if (requestQueue == null) return List.of();
        return requestQueue.getScheduledTimes();
    }

    /**
     * Gibt einen Snapshot der aktuellen Warteschlange zurück (nur lesend).
     */
    public List<RequestQueue.ScheduledRequest<?>> getQueueSnapshot() {
        if (requestQueue == null) return List.of();
        return requestQueue.getQueueSnapshot();
    }

    /**
     * Gibt die aktuelle Größe der Warteschlange zurück.
     */
    public int getQueueSize() {
        if (requestQueue == null) return 0;
        return requestQueue.getQueueSize();
    }

    // --- Methoden mit Queue-Integration ---

    public TripsIdResponse tripsIdGet(TripByIdRequest tripByIdRequest) throws RestClientException {
        if (requestQueue != null) {
            CompletableFuture<TripsIdResponse> fut = requestQueue.submit(() -> tripsIdGetInternal(tripByIdRequest));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RestClientException("Fehler beim Ausführen des Requests aus der Queue", e);
            }
        } else {
            return tripsIdGetInternal(tripByIdRequest);
        }
    }

    private TripsIdResponse tripsIdGetInternal(TripByIdRequest tripByIdRequest) throws RestClientException {
        TripsIdResponse response = tripsIdGetWithHttpInfo(
                tripByIdRequest.getTripId(),
                tripByIdRequest.isStopOvers(),
                tripByIdRequest.isRemarks(),
                tripByIdRequest.isPolyline(),
                tripByIdRequest.getLanguage()
        ).getBody();
        return getCachedOrFetch(tripCache, tripByIdRequest, response);
    }

    public JourneysRefreshResponse journeysRefGet(JourneyByRefreshTokenRequest request) throws RestClientException {
        if (requestQueue != null) {
            CompletableFuture<JourneysRefreshResponse> fut = requestQueue.submit(() -> journeysRefGetInternal(request));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RestClientException("Fehler beim Ausführen des Requests aus der Queue", e);
            }
        } else {
            return journeysRefGetInternal(request);
        }
    }

    private JourneysRefreshResponse journeysRefGetInternal(JourneyByRefreshTokenRequest request) throws RestClientException {
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
    }

    public JourneysResponse journeysGet(JourneySearchRequest journeySearchRequest) throws RestClientException {
        if (requestQueue != null) {
            CompletableFuture<JourneysResponse> fut = requestQueue.submit(() -> journeysGetInternal(journeySearchRequest));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RestClientException("Fehler beim Ausführen des Requests aus der Queue", e);
            }
        } else {
            return journeysGetInternal(journeySearchRequest);
        }
    }

    private JourneysResponse journeysGetInternal(JourneySearchRequest journeySearchRequest) throws RestClientException {
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
    }

    public List<StopsIdResponse> locationsGet(LocationSearchRequest locationSearchRequest) throws RestClientException {
        if (requestQueue != null) {
            CompletableFuture<List<StopsIdResponse>> fut = requestQueue.submit(() -> locationsGetInternal(locationSearchRequest));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RestClientException("Fehler beim Ausführen des Requests aus der Queue", e);
            }
        } else {
            return locationsGetInternal(locationSearchRequest);
        }
    }

    private List<StopsIdResponse> locationsGetInternal(LocationSearchRequest locationSearchRequest) throws RestClientException {
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
    }

    public List<StopsIdResponse> locationsNearbyGet(LocationsNearbyRequest locationsNearbyRequest) throws RestClientException {
        if (requestQueue != null) {
            CompletableFuture<List<StopsIdResponse>> fut = requestQueue.submit(() -> locationsNearbyGetInternal(locationsNearbyRequest));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RestClientException("Fehler beim Ausführen des Requests aus der Queue", e);
            }
        } else {
            return locationsNearbyGetInternal(locationsNearbyRequest);
        }
    }

    private List<StopsIdResponse> locationsNearbyGetInternal(LocationsNearbyRequest locationsNearbyRequest) throws RestClientException {
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
    }

    public StopsIdArrivalsResponse stopsIdArrivalsGet(ArrivalsByStopIdRequest arrivalsByStopIdRequest) throws RestClientException {
        if (requestQueue != null) {
            CompletableFuture<StopsIdArrivalsResponse> fut = requestQueue.submit(() -> stopsIdArrivalsGetInternal(arrivalsByStopIdRequest));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RestClientException("Fehler beim Ausführen des Requests aus der Queue", e);
            }
        } else {
            return stopsIdArrivalsGetInternal(arrivalsByStopIdRequest);
        }
    }

    private StopsIdArrivalsResponse stopsIdArrivalsGetInternal(ArrivalsByStopIdRequest arrivalsByStopIdRequest) throws RestClientException {
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
    }

    public StopsIdDeparturesResponse stopsIdDeparturesGet(DeparturesByStopIdRequest departuresByStopIdRequest) throws RestClientException {
        if (requestQueue != null) {
            CompletableFuture<StopsIdDeparturesResponse> fut = requestQueue.submit(() -> stopsIdDeparturesGetInternal(departuresByStopIdRequest));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RestClientException("Fehler beim Ausführen des Requests aus der Queue", e);
            }
        } else {
            return stopsIdDeparturesGetInternal(departuresByStopIdRequest);
        }
    }

    private StopsIdDeparturesResponse stopsIdDeparturesGetInternal(DeparturesByStopIdRequest departuresByStopIdRequest) throws RestClientException {
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
    }

    public StopsIdResponse stopsIdGet(StopByIdRequest stopByIdRequest) throws RestClientException {
        if (requestQueue != null) {
            CompletableFuture<StopsIdResponse> fut = requestQueue.submit(() -> stopsIdGetInternal(stopByIdRequest));
            try {
                return fut.get();
            } catch (Exception e) {
                throw new RestClientException("Fehler beim Ausführen des Requests aus der Queue", e);
            }
        } else {
            return stopsIdGetInternal(stopByIdRequest);
        }
    }

    private StopsIdResponse stopsIdGetInternal(StopByIdRequest stopByIdRequest) throws RestClientException {
        StopsIdResponse response = stopsIdGetWithHttpInfo(
                stopByIdRequest.getStopId(),
                stopByIdRequest.isLinesOfStops(),
                stopByIdRequest.getLanguage()
        ).getBody();
        return getCachedOrFetch(stopCache, stopByIdRequest, response);
    }

    // ...existing code...
}
