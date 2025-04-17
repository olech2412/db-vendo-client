# DefaultApi

All URIs are relative to */*

Method | HTTP request | Description
------------- | ------------- | -------------
[**journeysGet**](DefaultApi.md#journeysGet) | **GET** /journeys | Finds journeys from A to B.
[**journeysRefGet**](DefaultApi.md#journeysRefGet) | **GET** /journeys/{ref} | Fetches up-to-date realtime data for a journey computed before.
[**locationsGet**](DefaultApi.md#locationsGet) | **GET** /locations | Finds stops/stations, POIs and addresses matching a query.
[**locationsNearbyGet**](DefaultApi.md#locationsNearbyGet) | **GET** /locations/nearby | Finds stops/stations &amp; POIs close to a geolocation.
[**stopsIdArrivalsGet**](DefaultApi.md#stopsIdArrivalsGet) | **GET** /stops/{id}/arrivals | Fetches arrivals at a stop/station.
[**stopsIdDeparturesGet**](DefaultApi.md#stopsIdDeparturesGet) | **GET** /stops/{id}/departures | Fetches departures at a stop/station.
[**stopsIdGet**](DefaultApi.md#stopsIdGet) | **GET** /stops/{id} | Finds a stop/station by ID.
[**tripsIdGet**](DefaultApi.md#tripsIdGet) | **GET** /trips/{id} | Fetches a trip by ID.

<a name="journeysGet"></a>
# **journeysGet**
> InlineResponse2XX3 journeysGet(from, fromId, fromAddress, fromLatitude, fromLongitude, to, toId, toAddress, toLatitude, toLongitude, departure, arrival, earlierThan, laterThan, results, stopovers, transfers, transferTime, accessibility, bike, startWithWalking, walkingSpeed, tickets, polylines, subStops, entrances, remarks, scheduledDays, notOnlyFastRoutes, bestprice, language, loyaltyCard, firstClass, age, products, pretty)

Finds journeys from A to B.

Uses [&#x60;hafasClient.journeys()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/journeys.md) to **find journeys from A (&#x60;from&#x60;) to B (&#x60;to&#x60;)**.

### Example
```java
// Import classes:
//import de.olech2412.dbvendoclient.ApiException;
//import de.olech2412.dbvendoclient.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String from = "from_example"; // String | \"from\" as stop/station ID (e.g. from=8010159 for Halle (Saale) Hbf)
String fromId = "fromId_example"; // String | \"from\" as POI (e.g. from.id=991561765&from.latitude=51.48364&from.longitude=11.98084 for Halle+(Saale),+Stadtpark+Halle+(Grünanlagen))
String fromAddress = "fromAddress_example"; // String | \"from\" as an address (e.g. from.latitude=51.25639&from.longitude=7.46685&from.address=Hansestadt+Breckerfeld,+Hansering+3 for Hansestadt Breckerfeld, Hansering 3)
BigDecimal fromLatitude = new BigDecimal(); // BigDecimal | 
BigDecimal fromLongitude = new BigDecimal(); // BigDecimal | 
String to = "to_example"; // String | \"to\" as stop/station ID
String toId = "toId_example"; // String | \"to\" as POI
String toAddress = "toAddress_example"; // String | \"to\" as an address
BigDecimal toLatitude = new BigDecimal(); // BigDecimal | 
BigDecimal toLongitude = new BigDecimal(); // BigDecimal | 
OffsetDateTime departure = new OffsetDateTime(); // OffsetDateTime | Compute journeys departing at this date/time. Mutually exclusive with `arrival`. – Default: *now*
OffsetDateTime arrival = new OffsetDateTime(); // OffsetDateTime | Compute journeys arriving at this date/time. Mutually exclusive with `departure`. – Default: *now*
String earlierThan = "earlierThan_example"; // String | Compute journeys \"before\" an `earlierRef`.
String laterThan = "laterThan_example"; // String | Compute journeys \"after\" an `laterRef`.
Integer results = 3; // Integer | Max. number of journeys.
Boolean stopovers = false; // Boolean | Fetch & parse stopovers on the way?
Integer transfers = 56; // Integer | Maximum number of transfers. – Default: *let HAFAS decide*
Integer transferTime = 0; // Integer | Minimum time in minutes for a single transfer.
String accessibility = "accessibility_example"; // String | not supported
Boolean bike = false; // Boolean | Compute only bike-friendly journeys?
Boolean startWithWalking = true; // Boolean | not supported
String walkingSpeed = "normal"; // String | not supported
Boolean tickets = false; // Boolean | Return information about available tickets? only supported for /journeys/{ref}
Boolean polylines = false; // Boolean | Fetch & parse a shape for each journey leg? only supported for /journeys/{ref}
Boolean subStops = true; // Boolean | not supported
Boolean entrances = true; // Boolean | not supported
Boolean remarks = true; // Boolean | Parse & return hints & warnings?
Boolean scheduledDays = false; // Boolean | Parse & return dates the journey is valid on?, returns a field `serviceDays` (instead of `scheduledDays` in hafas-client!) with a different, human-readable structure
Boolean notOnlyFastRoutes = false; // Boolean | if true, also show journeys that are mathematically non-optimal
Boolean bestprice = false; // Boolean | search for lowest prices across the entire day
String language = "en"; // String | Language of the results.
String loyaltyCard = "loyaltyCard_example"; // String | Type of loyalty card in use. – Default: *none*
Boolean firstClass = false; // Boolean | Search for first-class options?
Integer age = 56; // Integer | Age of traveller – Default: *adult*
ProfileSpecificProducts products = new ProfileSpecificProducts(); // ProfileSpecificProducts | Filter by profile-specific products (e.g. regional transport only).
Boolean pretty = true; // Boolean | Pretty-print JSON responses?
try {
    InlineResponse2XX3 result = apiInstance.journeysGet(from, fromId, fromAddress, fromLatitude, fromLongitude, to, toId, toAddress, toLatitude, toLongitude, departure, arrival, earlierThan, laterThan, results, stopovers, transfers, transferTime, accessibility, bike, startWithWalking, walkingSpeed, tickets, polylines, subStops, entrances, remarks, scheduledDays, notOnlyFastRoutes, bestprice, language, loyaltyCard, firstClass, age, products, pretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#journeysGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **from** | **String**| \&quot;from\&quot; as stop/station ID (e.g. from&#x3D;8010159 for Halle (Saale) Hbf) | [optional]
 **fromId** | **String**| \&quot;from\&quot; as POI (e.g. from.id&#x3D;991561765&amp;from.latitude&#x3D;51.48364&amp;from.longitude&#x3D;11.98084 for Halle+(Saale),+Stadtpark+Halle+(Grünanlagen)) | [optional]
 **fromAddress** | **String**| \&quot;from\&quot; as an address (e.g. from.latitude&#x3D;51.25639&amp;from.longitude&#x3D;7.46685&amp;from.address&#x3D;Hansestadt+Breckerfeld,+Hansering+3 for Hansestadt Breckerfeld, Hansering 3) | [optional]
 **fromLatitude** | **BigDecimal**|  | [optional]
 **fromLongitude** | **BigDecimal**|  | [optional]
 **to** | **String**| \&quot;to\&quot; as stop/station ID | [optional]
 **toId** | **String**| \&quot;to\&quot; as POI | [optional]
 **toAddress** | **String**| \&quot;to\&quot; as an address | [optional]
 **toLatitude** | **BigDecimal**|  | [optional]
 **toLongitude** | **BigDecimal**|  | [optional]
 **departure** | **OffsetDateTime**| Compute journeys departing at this date/time. Mutually exclusive with &#x60;arrival&#x60;. – Default: *now* | [optional]
 **arrival** | **OffsetDateTime**| Compute journeys arriving at this date/time. Mutually exclusive with &#x60;departure&#x60;. – Default: *now* | [optional]
 **earlierThan** | **String**| Compute journeys \&quot;before\&quot; an &#x60;earlierRef&#x60;. | [optional]
 **laterThan** | **String**| Compute journeys \&quot;after\&quot; an &#x60;laterRef&#x60;. | [optional]
 **results** | **Integer**| Max. number of journeys. | [optional] [default to 3]
 **stopovers** | **Boolean**| Fetch &amp; parse stopovers on the way? | [optional] [default to false]
 **transfers** | **Integer**| Maximum number of transfers. – Default: *let HAFAS decide* | [optional]
 **transferTime** | **Integer**| Minimum time in minutes for a single transfer. | [optional] [default to 0]
 **accessibility** | **String**| not supported | [optional]
 **bike** | **Boolean**| Compute only bike-friendly journeys? | [optional] [default to false]
 **startWithWalking** | **Boolean**| not supported | [optional] [default to true]
 **walkingSpeed** | **String**| not supported | [optional] [default to normal] [enum: slow, normal, fast]
 **tickets** | **Boolean**| Return information about available tickets? only supported for /journeys/{ref} | [optional] [default to false]
 **polylines** | **Boolean**| Fetch &amp; parse a shape for each journey leg? only supported for /journeys/{ref} | [optional] [default to false]
 **subStops** | **Boolean**| not supported | [optional] [default to true]
 **entrances** | **Boolean**| not supported | [optional] [default to true]
 **remarks** | **Boolean**| Parse &amp; return hints &amp; warnings? | [optional] [default to true]
 **scheduledDays** | **Boolean**| Parse &amp; return dates the journey is valid on?, returns a field &#x60;serviceDays&#x60; (instead of &#x60;scheduledDays&#x60; in hafas-client!) with a different, human-readable structure | [optional] [default to false]
 **notOnlyFastRoutes** | **Boolean**| if true, also show journeys that are mathematically non-optimal | [optional] [default to false]
 **bestprice** | **Boolean**| search for lowest prices across the entire day | [optional] [default to false]
 **language** | **String**| Language of the results. | [optional] [default to en]
 **loyaltyCard** | **String**| Type of loyalty card in use. – Default: *none* | [optional] [enum: bahncard-1st-25, bahncard-2nd-25, bahncard-1st-50, bahncard-2nd-50, bahncard-1st-100, bahncard-2nd-100, vorteilscard, halbtaxabo, generalabonnement-1st, generalabonnement-2nd, nl-40, at-klimaticket]
 **firstClass** | **Boolean**| Search for first-class options? | [optional] [default to false]
 **age** | **Integer**| Age of traveller – Default: *adult* | [optional]
 **products** | [**ProfileSpecificProducts**](.md)| Filter by profile-specific products (e.g. regional transport only). | [optional]
 **pretty** | **Boolean**| Pretty-print JSON responses? | [optional]

### Return type

[**InlineResponse2XX3**](InlineResponse2XX3.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="journeysRefGet"></a>
# **journeysRefGet**
> InlineResponse2XX5 journeysRefGet(ref, stopovers, tickets, polylines, subStops, entrances, remarks, scheduledDays, notOnlyFastRoutes, bestprice, language, pretty)

Fetches up-to-date realtime data for a journey computed before.

Uses [&#x60;hafasClient.refreshJourney()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/refresh-journey.md) to **\&quot;refresh\&quot; a journey, using its &#x60;refreshToken&#x60;**.  The journey will be the same (equal &#x60;from&#x60;, &#x60;to&#x60;, &#x60;via&#x60;, date/time &amp; vehicles used), but you can get up-to-date realtime data, like delays &amp; cancellations.

### Example
```java
// Import classes:
//import de.olech2412.dbvendoclient.ApiException;
//import de.olech2412.dbvendoclient.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String ref = "ref_example"; // String | The journey's `refreshToken`.
Boolean stopovers = false; // Boolean | Fetch & parse stopovers on the way?
Boolean tickets = false; // Boolean | Return information about available tickets? mutually exclusive with polylines
Boolean polylines = false; // Boolean | Fetch & parse a shape for each journey leg? mutually exclusive with tickets
Boolean subStops = true; // Boolean | not supported
Boolean entrances = true; // Boolean | not supported
Boolean remarks = true; // Boolean | Parse & return hints & warnings?
Boolean scheduledDays = false; // Boolean | Parse & return dates the journey is valid on?, returns a field `serviceDays` (instead of `scheduledDays` in hafas-client!) with a different, human-readable structure
Boolean notOnlyFastRoutes = false; // Boolean | if true, also show journeys that are mathematically non-optimal
Boolean bestprice = false; // Boolean | search for lowest prices across the entire day
String language = "en"; // String | Language of the results.
Boolean pretty = true; // Boolean | Pretty-print JSON responses?
try {
    InlineResponse2XX5 result = apiInstance.journeysRefGet(ref, stopovers, tickets, polylines, subStops, entrances, remarks, scheduledDays, notOnlyFastRoutes, bestprice, language, pretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#journeysRefGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ref** | **String**| The journey&#x27;s &#x60;refreshToken&#x60;. |
 **stopovers** | **Boolean**| Fetch &amp; parse stopovers on the way? | [optional] [default to false]
 **tickets** | **Boolean**| Return information about available tickets? mutually exclusive with polylines | [optional] [default to false]
 **polylines** | **Boolean**| Fetch &amp; parse a shape for each journey leg? mutually exclusive with tickets | [optional] [default to false]
 **subStops** | **Boolean**| not supported | [optional] [default to true]
 **entrances** | **Boolean**| not supported | [optional] [default to true]
 **remarks** | **Boolean**| Parse &amp; return hints &amp; warnings? | [optional] [default to true]
 **scheduledDays** | **Boolean**| Parse &amp; return dates the journey is valid on?, returns a field &#x60;serviceDays&#x60; (instead of &#x60;scheduledDays&#x60; in hafas-client!) with a different, human-readable structure | [optional] [default to false]
 **notOnlyFastRoutes** | **Boolean**| if true, also show journeys that are mathematically non-optimal | [optional] [default to false]
 **bestprice** | **Boolean**| search for lowest prices across the entire day | [optional] [default to false]
 **language** | **String**| Language of the results. | [optional] [default to en]
 **pretty** | **Boolean**| Pretty-print JSON responses? | [optional]

### Return type

[**InlineResponse2XX5**](InlineResponse2XX5.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="locationsGet"></a>
# **locationsGet**
> List&lt;Object&gt; locationsGet(query, fuzzy, results, stops, addresses, poi, linesOfStops, language, pretty)

Finds stops/stations, POIs and addresses matching a query.

Uses [&#x60;hafasClient.locations()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/locations.md) to **find stops/stations, POIs and addresses matching &#x60;query&#x60;**.

### Example
```java
// Import classes:
//import de.olech2412.dbvendoclient.ApiException;
//import de.olech2412.dbvendoclient.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String query = "query_example"; // String | The term to search for.
Boolean fuzzy = true; // Boolean | Find more than exact matches?
Integer results = 10; // Integer | How many stations shall be shown?
Boolean stops = true; // Boolean | Show stops/stations?
Boolean addresses = true; // Boolean | Show addresses?
Boolean poi = true; // Boolean | Show points of interest?
Boolean linesOfStops = false; // Boolean | Parse & return lines of each stop/station?
String language = "en"; // String | Language of the results.
Boolean pretty = true; // Boolean | Pretty-print JSON responses?
try {
    List<Object> result = apiInstance.locationsGet(query, fuzzy, results, stops, addresses, poi, linesOfStops, language, pretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#locationsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **query** | **String**| The term to search for. |
 **fuzzy** | **Boolean**| Find more than exact matches? | [optional] [default to true]
 **results** | **Integer**| How many stations shall be shown? | [optional] [default to 10]
 **stops** | **Boolean**| Show stops/stations? | [optional] [default to true]
 **addresses** | **Boolean**| Show addresses? | [optional] [default to true]
 **poi** | **Boolean**| Show points of interest? | [optional] [default to true]
 **linesOfStops** | **Boolean**| Parse &amp; return lines of each stop/station? | [optional] [default to false]
 **language** | **String**| Language of the results. | [optional] [default to en]
 **pretty** | **Boolean**| Pretty-print JSON responses? | [optional]

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="locationsNearbyGet"></a>
# **locationsNearbyGet**
> List&lt;Object&gt; locationsNearbyGet(location, results, distance, stops, poi, linesOfStops, language, pretty)

Finds stops/stations &amp; POIs close to a geolocation.

Uses [&#x60;hafasClient.nearby()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/nearby.md) to **find stops/stations &amp; POIs close to the given geolocation**.

### Example
```java
// Import classes:
//import de.olech2412.dbvendoclient.ApiException;
//import de.olech2412.dbvendoclient.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Location location = new Location(); // Location | 
Integer results = 8; // Integer | maximum number of results
Integer distance = 56; // Integer | maximum walking distance in meters – Default: –
Boolean stops = true; // Boolean | Return stops/stations?
Boolean poi = false; // Boolean | Return points of interest?
Boolean linesOfStops = false; // Boolean | not supported
String language = "en"; // String | Language of the results.
Boolean pretty = true; // Boolean | Pretty-print JSON responses?
try {
    List<Object> result = apiInstance.locationsNearbyGet(location, results, distance, stops, poi, linesOfStops, language, pretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#locationsNearbyGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **location** | [**Location**](.md)|  | [optional]
 **results** | **Integer**| maximum number of results | [optional] [default to 8]
 **distance** | **Integer**| maximum walking distance in meters – Default: – | [optional]
 **stops** | **Boolean**| Return stops/stations? | [optional] [default to true]
 **poi** | **Boolean**| Return points of interest? | [optional] [default to false]
 **linesOfStops** | **Boolean**| not supported | [optional] [default to false]
 **language** | **String**| Language of the results. | [optional] [default to en]
 **pretty** | **Boolean**| Pretty-print JSON responses? | [optional]

### Return type

**List&lt;Object&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="stopsIdArrivalsGet"></a>
# **stopsIdArrivalsGet**
> InlineResponse2XX2 stopsIdArrivalsGet(id, when, direction, duration, results, linesOfStops, remarks, language, products, pretty)

Fetches arrivals at a stop/station.

Works like &#x60;/stops/{id}/departures&#x60;, except that it uses [&#x60;hafasClient.arrivals()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/arrivals.md) to **query arrivals at a stop/station**.

### Example
```java
// Import classes:
//import de.olech2412.dbvendoclient.ApiException;
//import de.olech2412.dbvendoclient.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | stop/station ID to show arrivals for
OffsetDateTime when = new OffsetDateTime(); // OffsetDateTime | Date & time to get departures for. – Default: *now*
String direction = "direction_example"; // String | not supported
Integer duration = 10; // Integer | Show departures for how many minutes?
Integer results = 56; // Integer | Max. number of departures. – Default: *whatever HAFAS wants*
Boolean linesOfStops = false; // Boolean | not supported
Boolean remarks = true; // Boolean | Parse & return hints & warnings?
String language = "en"; // String | Language of the results.
ProfileSpecificProducts products = new ProfileSpecificProducts(); // ProfileSpecificProducts | Filter by profile-specific products (e.g. regional transport only).
Boolean pretty = true; // Boolean | Pretty-print JSON responses?
try {
    InlineResponse2XX2 result = apiInstance.stopsIdArrivalsGet(id, when, direction, duration, results, linesOfStops, remarks, language, products, pretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#stopsIdArrivalsGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| stop/station ID to show arrivals for |
 **when** | **OffsetDateTime**| Date &amp; time to get departures for. – Default: *now* | [optional]
 **direction** | **String**| not supported | [optional]
 **duration** | **Integer**| Show departures for how many minutes? | [optional] [default to 10]
 **results** | **Integer**| Max. number of departures. – Default: *whatever HAFAS wants* | [optional]
 **linesOfStops** | **Boolean**| not supported | [optional] [default to false]
 **remarks** | **Boolean**| Parse &amp; return hints &amp; warnings? | [optional] [default to true]
 **language** | **String**| Language of the results. | [optional] [default to en]
 **products** | [**ProfileSpecificProducts**](.md)| Filter by profile-specific products (e.g. regional transport only). | [optional]
 **pretty** | **Boolean**| Pretty-print JSON responses? | [optional]

### Return type

[**InlineResponse2XX2**](InlineResponse2XX2.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="stopsIdDeparturesGet"></a>
# **stopsIdDeparturesGet**
> InlineResponse2XX1 stopsIdDeparturesGet(id, when, direction, duration, results, linesOfStops, remarks, language, products, pretty)

Fetches departures at a stop/station.

Uses [&#x60;hafasClient.departures()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/departures.md) to **query departures at a stop/station**.

### Example
```java
// Import classes:
//import de.olech2412.dbvendoclient.ApiException;
//import de.olech2412.dbvendoclient.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | stop/station ID to show departures for
OffsetDateTime when = new OffsetDateTime(); // OffsetDateTime | Date & time to get departures for. – Default: *now*
String direction = "direction_example"; // String | not supported
Integer duration = 10; // Integer | Show departures for how many minutes?
Integer results = 56; // Integer | Max. number of departures. – Default: *whatever HAFAS wants
Boolean linesOfStops = false; // Boolean | not supported
Boolean remarks = true; // Boolean | Parse & return hints & warnings?
String language = "en"; // String | Language of the results.
ProfileSpecificProducts products = new ProfileSpecificProducts(); // ProfileSpecificProducts | Filter by profile-specific products (e.g. regional transport only).
Boolean pretty = true; // Boolean | Pretty-print JSON responses?
try {
    InlineResponse2XX1 result = apiInstance.stopsIdDeparturesGet(id, when, direction, duration, results, linesOfStops, remarks, language, products, pretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#stopsIdDeparturesGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| stop/station ID to show departures for |
 **when** | **OffsetDateTime**| Date &amp; time to get departures for. – Default: *now* | [optional]
 **direction** | **String**| not supported | [optional]
 **duration** | **Integer**| Show departures for how many minutes? | [optional] [default to 10]
 **results** | **Integer**| Max. number of departures. – Default: *whatever HAFAS wants | [optional]
 **linesOfStops** | **Boolean**| not supported | [optional] [default to false]
 **remarks** | **Boolean**| Parse &amp; return hints &amp; warnings? | [optional] [default to true]
 **language** | **String**| Language of the results. | [optional] [default to en]
 **products** | [**ProfileSpecificProducts**](.md)| Filter by profile-specific products (e.g. regional transport only). | [optional]
 **pretty** | **Boolean**| Pretty-print JSON responses? | [optional]

### Return type

[**InlineResponse2XX1**](InlineResponse2XX1.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="stopsIdGet"></a>
# **stopsIdGet**
> InlineResponse2XX stopsIdGet(id, linesOfStops, language, pretty)

Finds a stop/station by ID.

Uses [&#x60;hafasClient.stop()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/stop.md) to **find a stop/station by ID**.

### Example
```java
// Import classes:
//import de.olech2412.dbvendoclient.ApiException;
//import de.olech2412.dbvendoclient.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | stop/station ID
Boolean linesOfStops = false; // Boolean | Parse & expose lines at each stop/station?
String language = "en"; // String | Language of the results.
Boolean pretty = true; // Boolean | Pretty-print JSON responses?
try {
    InlineResponse2XX result = apiInstance.stopsIdGet(id, linesOfStops, language, pretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#stopsIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| stop/station ID |
 **linesOfStops** | **Boolean**| Parse &amp; expose lines at each stop/station? | [optional] [default to false]
 **language** | **String**| Language of the results. | [optional] [default to en]
 **pretty** | **Boolean**| Pretty-print JSON responses? | [optional]

### Return type

[**InlineResponse2XX**](InlineResponse2XX.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="tripsIdGet"></a>
# **tripsIdGet**
> InlineResponse2XX4 tripsIdGet(id, stopovers, remarks, polyline, language, pretty)

Fetches a trip by ID.

Uses [&#x60;hafasClient.trip()&#x60;](https://github.com/public-transport/hafas-client/blob/6/docs/trip.md) to **fetch a trip by ID**.

### Example
```java
// Import classes:
//import de.olech2412.dbvendoclient.ApiException;
//import de.olech2412.dbvendoclient.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | trip ID
Boolean stopovers = true; // Boolean | Fetch & parse stopovers on the way?
Boolean remarks = true; // Boolean | Parse & return hints & warnings?
Boolean polyline = false; // Boolean | Fetch & parse the geographic shape of the trip? (does not work for RIS trip ids from boards of db profile)
String language = "en"; // String | Language of the results.
Boolean pretty = true; // Boolean | Pretty-print JSON responses?
try {
    InlineResponse2XX4 result = apiInstance.tripsIdGet(id, stopovers, remarks, polyline, language, pretty);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#tripsIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| trip ID |
 **stopovers** | **Boolean**| Fetch &amp; parse stopovers on the way? | [optional] [default to true]
 **remarks** | **Boolean**| Parse &amp; return hints &amp; warnings? | [optional] [default to true]
 **polyline** | **Boolean**| Fetch &amp; parse the geographic shape of the trip? (does not work for RIS trip ids from boards of db profile) | [optional] [default to false]
 **language** | **String**| Language of the results. | [optional] [default to en]
 **pretty** | **Boolean**| Pretty-print JSON responses? | [optional]

### Return type

[**InlineResponse2XX4**](InlineResponse2XX4.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

