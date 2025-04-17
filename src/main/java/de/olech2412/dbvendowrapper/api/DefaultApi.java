package de.olech2412.dbvendowrapper.api;

import de.olech2412.dbvendowrapper.ApiClient;
import de.olech2412.dbvendowrapper.BaseApi;
import de.olech2412.dbvendowrapper.model.*;
import de.olech2412.dbvendowrapper.requests.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class DefaultApi extends BaseApi {

    public DefaultApi() {
        super(new ApiClient());
    }

    public DefaultApi(ApiClient apiClient) {
        super(apiClient);
    }

    /**
     * Finds journeys from A to B.
     * Uses [&#x60;hafasClient.journeys()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/journeys.md) to **find journeys from A (&#x60;from&#x60;) to B (&#x60;to&#x60;)**.
     * <p><b>2XX</b> - An object with an array of journeys, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/journeys.md).
     *
     * @param journeySearchRequest The request object containing all parameters for the journey search.
     * @return JourneysGet2XXResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.journeys()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/journeys.md">Finds journeys from A to B. Documentation</a>
     */
    public JourneysGet2XXResponse journeysGet(JourneySearchRequest journeySearchRequest) throws RestClientException {
        return journeysGetWithHttpInfo(journeySearchRequest.getFrom(), journeySearchRequest.getFromId(), journeySearchRequest.getFromAddress(), journeySearchRequest.getFromLatitude(), journeySearchRequest.getFromLongitude(), journeySearchRequest.getTo(), journeySearchRequest.getToId(), journeySearchRequest.getToAddress(), journeySearchRequest.getToLatitude(), journeySearchRequest.getToLongitude(), journeySearchRequest.getDeparture(), journeySearchRequest.getArrival(), journeySearchRequest.getEarlierThen(), journeySearchRequest.getLaterThen(), journeySearchRequest.getMaxResults(), journeySearchRequest.isStopOvers(), journeySearchRequest.getMaxTransfers(), journeySearchRequest.getMinimumTransferTime(), journeySearchRequest.getAccessibility(), journeySearchRequest.isBikeFriendly(), journeySearchRequest.isStartWithWalking(), journeySearchRequest.getWalkingSpeed(), journeySearchRequest.isTickets(), journeySearchRequest.isPolylines(), journeySearchRequest.isSubStops(), journeySearchRequest.isEntrances(), journeySearchRequest.isRemarks(), journeySearchRequest.isScheduledDays(), journeySearchRequest.isNotOnlyFastRoutes(), journeySearchRequest.isBestPrice(), journeySearchRequest.getLanguage(), journeySearchRequest.getLoyaltyCard(), journeySearchRequest.isFirstClass(), journeySearchRequest.getAge(), journeySearchRequest.getProfileSpecificProducts()).getBody();
    }

    /**
     * Finds journeys from A to B.
     * Uses [&#x60;hafasClient.journeys()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/journeys.md) to **find journeys from A (&#x60;from&#x60;) to B (&#x60;to&#x60;)**.
     * <p><b>2XX</b> - An object with an array of journeys, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/journeys.md).
     *
     * @param from              \&quot;from\&quot; as stop/station ID (e.g. from&#x3D;8010159 for Halle (Saale) Hbf) (optional)
     * @param fromId            \&quot;from\&quot; as POI (e.g. from.id&#x3D;991561765&amp;from.latitude&#x3D;51.48364&amp;from.longitude&#x3D;11.98084 for Halle+(Saale),+Stadtpark+Halle+(Grünanlagen)) (optional)
     * @param fromAddress       \&quot;from\&quot; as an address (e.g. from.latitude&#x3D;51.25639&amp;from.longitude&#x3D;7.46685&amp;from.address&#x3D;Hansestadt+Breckerfeld,+Hansering+3 for Hansestadt Breckerfeld, Hansering 3) (optional)
     * @param fromLatitude      (optional)
     * @param fromLongitude     (optional)
     * @param to                \&quot;to\&quot; as stop/station ID (optional)
     * @param toId              \&quot;to\&quot; as POI (optional)
     * @param toAddress         \&quot;to\&quot; as an address (optional)
     * @param toLatitude        (optional)
     * @param toLongitude       (optional)
     * @param departure         Compute journeys departing at this date/time. Mutually exclusive with &#x60;arrival&#x60;. – Default: *now* (optional)
     * @param arrival           Compute journeys arriving at this date/time. Mutually exclusive with &#x60;departure&#x60;. – Default: *now* (optional)
     * @param earlierThan       Compute journeys \&quot;before\&quot; an &#x60;earlierRef&#x60;. (optional)
     * @param laterThan         Compute journeys \&quot;after\&quot; an &#x60;laterRef&#x60;. (optional)
     * @param results           Max. number of journeys. (optional, default to 3)
     * @param stopovers         Fetch &amp; parse stopovers on the way? (optional, default to false)
     * @param transfers         Maximum number of transfers. – Default: *let HAFAS decide* (optional)
     * @param transferTime      Minimum time in minutes for a single transfer. (optional, default to 0)
     * @param accessibility     not supported (optional)
     * @param bike              Compute only bike-friendly journeys? (optional, default to false)
     * @param startWithWalking  not supported (optional, default to true)
     * @param walkingSpeed      not supported (optional, default to normal)
     * @param tickets           Return information about available tickets? only supported for /journeys/{ref} (optional, default to false)
     * @param polylines         Fetch &amp; parse a shape for each journey leg? only supported for /journeys/{ref} (optional, default to false)
     * @param subStops          not supported (optional, default to true)
     * @param entrances         not supported (optional, default to true)
     * @param remarks           Parse &amp; return hints &amp; warnings? (optional, default to true)
     * @param scheduledDays     Parse &amp; return dates the journey is valid on?, returns a field &#x60;serviceDays&#x60; (instead of &#x60;scheduledDays&#x60; in hafas-client!) with a different, human-readable structure (optional, default to false)
     * @param notOnlyFastRoutes if true, also show journeys that are mathematically non-optimal (optional, default to false)
     * @param bestprice         search for lowest prices across the entire day (optional, default to false)
     * @param language          Language of the results. (optional, default to en)
     * @param loyaltyCard       Type of loyalty card in use. – Default: *none* (optional)
     * @param firstClass        Search for first-class options? (optional, default to false)
     * @param age               Age of traveller – Default: *adult* (optional)
     * @param products          Filter by profile-specific products (e.g. regional transport only). (optional)
     * @return ResponseEntity&lt;JourneysGet2XXResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.journeys()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/journeys.md">Finds journeys from A to B. Documentation</a>
     */
    public ResponseEntity<JourneysGet2XXResponse> journeysGetWithHttpInfo(String from, String fromId, String fromAddress, BigDecimal fromLatitude, BigDecimal fromLongitude, String to, String toId, String toAddress, BigDecimal toLatitude, BigDecimal toLongitude, OffsetDateTime departure, OffsetDateTime arrival, String earlierThan, String laterThan, Integer results, Boolean stopovers, Integer transfers, Integer transferTime, String accessibility, Boolean bike, Boolean startWithWalking, String walkingSpeed, Boolean tickets, Boolean polylines, Boolean subStops, Boolean entrances, Boolean remarks, Boolean scheduledDays, Boolean notOnlyFastRoutes, Boolean bestprice, String language, String loyaltyCard, Boolean firstClass, Integer age, ProfileSpecificProducts products) throws RestClientException {
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

        ParameterizedTypeReference<JourneysGet2XXResponse> localReturnType = new ParameterizedTypeReference<JourneysGet2XXResponse>() {
        };
        return apiClient.invokeAPI("/journeys", HttpMethod.GET, Collections.emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    /**
     * Fetches up-to-date realtime data for a journey computed before.
     * Uses [&#x60;hafasClient.refreshJourney()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/refresh-journey.md) to **\&quot;refresh\&quot; a journey, using its &#x60;refreshToken&#x60;**.  The journey will be the same (equal &#x60;from&#x60;, &#x60;to&#x60;, &#x60;via&#x60;, date/time &amp; vehicles used), but you can get up-to-date realtime data, like delays &amp; cancellations.
     * <p><b>2XX</b> - An object with the up-to-date journey, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/refresh-journey.md).
     *
     * @param journeyByRefreshTokenRequest The request object containing all parameters for the journey refresh.
     * @return JourneysRefGet2XXResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.refreshJourney()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/refresh-journey.md">Fetches up-to-date realtime data for a journey computed before. Documentation</a>
     */
    public JourneysRefGet2XXResponse journeysRefGet(JourneyByRefreshTokenRequest journeyByRefreshTokenRequest) throws RestClientException {
        return journeysRefGetWithHttpInfo(journeyByRefreshTokenRequest.getRefreshToken(), journeyByRefreshTokenRequest.isStopOvers(), journeyByRefreshTokenRequest.isTickets(), journeyByRefreshTokenRequest.isPolylines(), journeyByRefreshTokenRequest.isSubStops(), journeyByRefreshTokenRequest.isEntrances(), journeyByRefreshTokenRequest.isRemarks(), journeyByRefreshTokenRequest.isScheduledDays(), journeyByRefreshTokenRequest.isNotOnlyFastRoutes(), journeyByRefreshTokenRequest.isBestPrice(), journeyByRefreshTokenRequest.getLanguage()).getBody();
    }

    /**
     * Fetches up-to-date realtime data for a journey computed before.
     * Uses [&#x60;hafasClient.refreshJourney()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/refresh-journey.md) to **\&quot;refresh\&quot; a journey, using its &#x60;refreshToken&#x60;**.  The journey will be the same (equal &#x60;from&#x60;, &#x60;to&#x60;, &#x60;via&#x60;, date/time &amp; vehicles used), but you can get up-to-date realtime data, like delays &amp; cancellations.
     * <p><b>2XX</b> - An object with the up-to-date journey, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/refresh-journey.md).
     *
     * @param ref               The journey&#39;s &#x60;refreshToken&#x60;. (required)
     * @param stopovers         Fetch &amp; parse stopovers on the way? (optional, default to false)
     * @param tickets           Return information about available tickets? mutually exclusive with polylines (optional, default to false)
     * @param polylines         Fetch &amp; parse a shape for each journey leg? mutually exclusive with tickets (optional, default to false)
     * @param subStops          not supported (optional, default to true)
     * @param entrances         not supported (optional, default to true)
     * @param remarks           Parse &amp; return hints &amp; warnings? (optional, default to true)
     * @param scheduledDays     Parse &amp; return dates the journey is valid on?, returns a field &#x60;serviceDays&#x60; (instead of &#x60;scheduledDays&#x60; in hafas-client!) with a different, human-readable structure (optional, default to false)
     * @param notOnlyFastRoutes if true, also show journeys that are mathematically non-optimal (optional, default to false)
     * @param bestprice         search for lowest prices across the entire day (optional, default to false)
     * @param language          Language of the results. (optional, default to en)
     * @return ResponseEntity&lt;JourneysRefGet2XXResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.refreshJourney()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/refresh-journey.md">Fetches up-to-date realtime data for a journey computed before. Documentation</a>
     */
    public ResponseEntity<JourneysRefGet2XXResponse> journeysRefGetWithHttpInfo(String ref, Boolean stopovers, Boolean tickets, Boolean polylines, Boolean subStops, Boolean entrances, Boolean remarks, Boolean scheduledDays, Boolean notOnlyFastRoutes, Boolean bestprice, String language) throws RestClientException {
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

        ParameterizedTypeReference<JourneysRefGet2XXResponse> localReturnType = new ParameterizedTypeReference<JourneysRefGet2XXResponse>() {
        };
        return apiClient.invokeAPI("/journeys/{ref}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    /**
     * Finds stops/stations, POIs and addresses matching a query.
     * Uses [&#x60;hafasClient.locations()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/locations.md) to **find stops/stations, POIs and addresses matching &#x60;query&#x60;**.
     * <p><b>2XX</b> - An array of locations, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/locations.md).
     *
     * @param locationSearchRequest The request object containing all parameters for the location search.
     * @return List&lt;StopsIdGet2XXResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.locations()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/locations.md">Finds stops/stations, POIs and addresses matching a query. Documentation</a>
     */
    public List<StopsIdGet2XXResponse> locationsGet(LocationSearchRequest locationSearchRequest) throws RestClientException {
        return locationsGetWithHttpInfo(locationSearchRequest.getQuery(), locationSearchRequest.isFuzzy(), locationSearchRequest.getMaxResults(), locationSearchRequest.isStops(), locationSearchRequest.isAddresses(), locationSearchRequest.isPoi(), locationSearchRequest.isLinesOfStops(), locationSearchRequest.getLanguage()).getBody();
    }

    /**
     * Finds stops/stations, POIs and addresses matching a query.
     * Uses [&#x60;hafasClient.locations()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/locations.md) to **find stops/stations, POIs and addresses matching &#x60;query&#x60;**.
     * <p><b>2XX</b> - An array of locations, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/locations.md).
     *
     * @param query        The term to search for. (required)
     * @param fuzzy        Find more than exact matches? (optional, default to true)
     * @param results      How many stations shall be shown? (optional, default to 10)
     * @param stops        Show stops/stations? (optional, default to true)
     * @param addresses    Show addresses? (optional, default to true)
     * @param poi          Show points of interest? (optional, default to true)
     * @param linesOfStops Parse &amp; return lines of each stop/station? (optional, default to false)
     * @param language     Language of the results. (optional, default to en)
     * @return ResponseEntity&lt;List&lt;StopsIdGet2XXResponse&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.locations()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/locations.md">Finds stops/stations, POIs and addresses matching a query. Documentation</a>
     */
    public ResponseEntity<List<StopsIdGet2XXResponse>> locationsGetWithHttpInfo(String query, Boolean fuzzy, Integer results, Boolean stops, Boolean addresses, Boolean poi, Boolean linesOfStops, String language) throws RestClientException {
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

        ParameterizedTypeReference<List<StopsIdGet2XXResponse>> localReturnType = new ParameterizedTypeReference<List<StopsIdGet2XXResponse>>() {
        };
        return apiClient.invokeAPI("/locations", HttpMethod.GET, Collections.emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    /**
     * Finds stops/stations &amp; POIs close to a geolocation.
     * Uses [&#x60;hafasClient.nearby()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/nearby.md) to **find stops/stations &amp; POIs close to the given geolocation**.
     * <p><b>2XX</b> - An array of locations, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/nearby.md).
     *
     * @param locationsNearbyRequest The request object containing all parameters for the nearby search.
     * @return List&lt;StopsIdGet2XXResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.nearby()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/nearby.md">Finds stops/stations &amp; POIs close to a geolocation. Documentation</a>
     */
    public List<StopsIdGet2XXResponse> locationsNearbyGet(LocationsNearbyRequest locationsNearbyRequest) throws RestClientException {
        return locationsNearbyGetWithHttpInfo(locationsNearbyRequest.getLocation(), locationsNearbyRequest.getMaxResults(), locationsNearbyRequest.getDistance(), locationsNearbyRequest.isStops(), locationsNearbyRequest.isPoi(), locationsNearbyRequest.isLinesOfStops(), locationsNearbyRequest.getLanguage()).getBody();
    }

    /**
     * Finds stops/stations &amp; POIs close to a geolocation.
     * Uses [&#x60;hafasClient.nearby()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/nearby.md) to **find stops/stations &amp; POIs close to the given geolocation**.
     * <p><b>2XX</b> - An array of locations, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/nearby.md).
     *
     * @param location     (optional)
     * @param results      maximum number of results (optional, default to 8)
     * @param distance     maximum walking distance in meters – Default: – (optional)
     * @param stops        Return stops/stations? (optional, default to true)
     * @param poi          Return points of interest? (optional, default to false)
     * @param linesOfStops not supported (optional, default to false)
     * @param language     Language of the results. (optional, default to en)
     * @return ResponseEntity&lt;List&lt;StopsIdGet2XXResponse&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.nearby()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/nearby.md">Finds stops/stations &amp; POIs close to a geolocation. Documentation</a>
     */
    public ResponseEntity<List<StopsIdGet2XXResponse>> locationsNearbyGetWithHttpInfo(Location location, Integer results, Integer distance, Boolean stops, Boolean poi, Boolean linesOfStops, String language) throws RestClientException {
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

        ParameterizedTypeReference<List<StopsIdGet2XXResponse>> localReturnType = new ParameterizedTypeReference<List<StopsIdGet2XXResponse>>() {
        };
        return apiClient.invokeAPI("/locations/nearby", HttpMethod.GET, Collections.emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    /**
     * Fetches arrivals at a stop/station.
     * Works like &#x60;/stops/{id}/departures&#x60;, except that it uses [&#x60;hafasClient.arrivals()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/arrivals.md) to **query arrivals at a stop/station**.
     * <p><b>2XX</b> - An object with an array of arrivals, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/arrivals.md).
     *
     * @param arrivalsByStopIdRequest the request object containing the parameters to be passed
     * @return StopsIdArrivalsGet2XXResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.arrivals()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/arrivals.md">Fetches arrivals at a stop/station. Documentation</a>
     */
    public StopsIdArrivalsGet2XXResponse stopsIdArrivalsGet(ArrivalsByStopIdRequest arrivalsByStopIdRequest) throws RestClientException {
        return stopsIdArrivalsGetWithHttpInfo(arrivalsByStopIdRequest.getStopId(), arrivalsByStopIdRequest.getArrivalTime(), arrivalsByStopIdRequest.getDirection(), arrivalsByStopIdRequest.getDuration(), arrivalsByStopIdRequest.getMaxResults(), arrivalsByStopIdRequest.isLinesOfStops(), arrivalsByStopIdRequest.isRemarks(), arrivalsByStopIdRequest.getLanguage(), arrivalsByStopIdRequest.getProfileSpecificProducts()).getBody();
    }

    /**
     * Fetches arrivals at a stop/station.
     * Works like &#x60;/stops/{id}/departures&#x60;, except that it uses [&#x60;hafasClient.arrivals()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/arrivals.md) to **query arrivals at a stop/station**.
     * <p><b>2XX</b> - An object with an array of arrivals, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/arrivals.md).
     *
     * @param id           stop/station ID to show arrivals for (required)
     * @param when         Date &amp; time to get departures for. – Default: *now* (optional)
     * @param direction    not supported (optional)
     * @param duration     Show departures for how many minutes? (optional, default to 10)
     * @param results      Max. number of departures. – Default: *whatever HAFAS wants* (optional)
     * @param linesOfStops not supported (optional, default to false)
     * @param remarks      Parse &amp; return hints &amp; warnings? (optional, default to true)
     * @param language     Language of the results. (optional, default to en)
     * @param products     Filter by profile-specific products (e.g. regional transport only). (optional)
     * @return ResponseEntity&lt;StopsIdArrivalsGet2XXResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.arrivals()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/arrivals.md">Fetches arrivals at a stop/station. Documentation</a>
     */
    public ResponseEntity<StopsIdArrivalsGet2XXResponse> stopsIdArrivalsGetWithHttpInfo(String id, OffsetDateTime when, String direction, Integer duration, Integer results, Boolean linesOfStops, Boolean remarks, String language, ProfileSpecificProducts products) throws RestClientException {
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

        ParameterizedTypeReference<StopsIdArrivalsGet2XXResponse> localReturnType = new ParameterizedTypeReference<StopsIdArrivalsGet2XXResponse>() {
        };
        return apiClient.invokeAPI("/stops/{id}/arrivals", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    /**
     * Fetches departures at a stop/station.
     * Uses [&#x60;hafasClient.departures()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/departures.md) to **query departures at a stop/station**.
     * <p><b>2XX</b> - An object with an array of departures, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/departures.md).
     *
     * @param departuresByStopIdRequest the request object containing all parameters
     * @return StopsIdDeparturesGet2XXResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.departures()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/departures.md">Fetches departures at a stop/station. Documentation</a>
     */
    public StopsIdDeparturesGet2XXResponse stopsIdDeparturesGet(DeparturesByStopIdRequest departuresByStopIdRequest) throws RestClientException {
        return stopsIdDeparturesGetWithHttpInfo(departuresByStopIdRequest.getStopId(), departuresByStopIdRequest.getDepartureTime(), departuresByStopIdRequest.getDirection(), departuresByStopIdRequest.getDuration(), departuresByStopIdRequest.getMaxResults(), departuresByStopIdRequest.isLinesOfStops(), departuresByStopIdRequest.isRemarks(), departuresByStopIdRequest.getLanguage(), departuresByStopIdRequest.getProfileSpecificProducts()).getBody();
    }

    /**
     * Fetches departures at a stop/station.
     * Uses [&#x60;hafasClient.departures()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/departures.md) to **query departures at a stop/station**.
     * <p><b>2XX</b> - An object with an array of departures, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/departures.md).
     *
     * @param id           stop/station ID to show departures for (required)
     * @param when         Date &amp; time to get departures for. – Default: *now* (optional)
     * @param direction    not supported (optional)
     * @param duration     Show departures for how many minutes? (optional, default to 10)
     * @param results      Max. number of departures. – Default: *whatever HAFAS wants (optional)
     * @param linesOfStops not supported (optional, default to false)
     * @param remarks      Parse &amp; return hints &amp; warnings? (optional, default to true)
     * @param language     Language of the results. (optional, default to en)
     * @param products     Filter by profile-specific products (e.g. regional transport only). (optional)
     * @return ResponseEntity&lt;StopsIdDeparturesGet2XXResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.departures()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/departures.md">Fetches departures at a stop/station. Documentation</a>
     */
    public ResponseEntity<StopsIdDeparturesGet2XXResponse> stopsIdDeparturesGetWithHttpInfo(String id, OffsetDateTime when, String direction, Integer duration, Integer results, Boolean linesOfStops, Boolean remarks, String language, ProfileSpecificProducts products) throws RestClientException {
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

        ParameterizedTypeReference<StopsIdDeparturesGet2XXResponse> localReturnType = new ParameterizedTypeReference<StopsIdDeparturesGet2XXResponse>() {
        };
        return apiClient.invokeAPI("/stops/{id}/departures", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    /**
     * Finds a stop/station by ID.
     * Uses [&#x60;hafasClient.stop()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/stop.md) to **find a stop/station by ID**.
     * <p><b>2XX</b> - The stop, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/stop.md).
     *
     * @param stopByIdRequest the request object containing the stop ID and other parameters
     * @return StopsIdGet2XXResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.stop()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/stop.md">Finds a stop/station by ID. Documentation</a>
     */
    public StopsIdGet2XXResponse stopsIdGet(StopByIdRequest stopByIdRequest) throws RestClientException {
        return stopsIdGetWithHttpInfo(stopByIdRequest.getStopId(), stopByIdRequest.isLinesOfStops(), stopByIdRequest.getLanguage()).getBody();
    }

    /**
     * Finds a stop/station by ID.
     * Uses [&#x60;hafasClient.stop()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/stop.md) to **find a stop/station by ID**.
     * <p><b>2XX</b> - The stop, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/stop.md).
     *
     * @param id           stop/station ID (required)
     * @param linesOfStops Parse &amp; expose lines at each stop/station? (optional, default to false)
     * @param language     Language of the results. (optional, default to en)
     * @return ResponseEntity&lt;StopsIdGet2XXResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.stop()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/stop.md">Finds a stop/station by ID. Documentation</a>
     */
    private ResponseEntity<StopsIdGet2XXResponse> stopsIdGetWithHttpInfo(String id, Boolean linesOfStops, String language) throws RestClientException {
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

        ParameterizedTypeReference<StopsIdGet2XXResponse> localReturnType = new ParameterizedTypeReference<StopsIdGet2XXResponse>() {
        };
        return apiClient.invokeAPI("/stops/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    /**
     * Fetches a trip by ID.
     * Uses [&#x60;hafasClient.trip()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/trip.md) to **fetch a trip by ID**.
     * <p><b>2XX</b> - An object with the trip, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/trip.md).
     *
     * @param tripByIdRequest the request object containing the trip ID and other parameters
     * @return TripsIdGet2XXResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.trip()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/trip.md">Fetches a trip by ID. Documentation</a>
     */
    public TripsIdGet2XXResponse tripsIdGet(TripByIdRequest tripByIdRequest) throws RestClientException {
        return tripsIdGetWithHttpInfo(tripByIdRequest.getTripId(), tripByIdRequest.isStopOvers(), tripByIdRequest.isRemarks(), tripByIdRequest.isPolyline(), tripByIdRequest.getLanguage()).getBody();
    }

    /**
     * Fetches a trip by ID.
     * Uses [&#x60;hafasClient.trip()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/trip.md) to **fetch a trip by ID**.
     * <p><b>2XX</b> - An object with the trip, in the [&#x60;hafas-client&#x60; format](https://github.com/public-transport/hafas-client/blob/6/docs/trip.md).
     *
     * @param id        trip ID (required)
     * @param stopovers Fetch &amp; parse stopovers on the way? (optional, default to true)
     * @param remarks   Parse &amp; return hints &amp; warnings? (optional, default to true)
     * @param polyline  Fetch &amp; parse the geographic shape of the trip? (does not work for RIS trip ids from boards of db profile) (optional, default to false)
     * @param language  Language of the results. (optional, default to en)
     * @return ResponseEntity&lt;TripsIdGet2XXResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     *                             &#x60;hafasClient.trip()&#x60; documentation
     * @see <a href="https://github.com/public-transport/hafas-client/blob/6/docs/trip.md">Fetches a trip by ID. Documentation</a>
     */
    public ResponseEntity<TripsIdGet2XXResponse> tripsIdGetWithHttpInfo(String id, Boolean stopovers, Boolean remarks, Boolean polyline, String language) throws RestClientException {
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

        ParameterizedTypeReference<TripsIdGet2XXResponse> localReturnType = new ParameterizedTypeReference<TripsIdGet2XXResponse>() {
        };
        return apiClient.invokeAPI("/trips/{id}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }

    @Override
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
