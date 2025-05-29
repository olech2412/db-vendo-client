# 🚆 db-vendo-wrapper

A convenience-focused Java client that wraps around an auto-generated Swagger client for Deutsche Bahn's public transport APIs. This wrapper enhances usability and efficiency by providing additional features and abstractions.

---

## 📖 About

While leveraging the capabilities of the auto-generated Swagger client, `db-vendo-wrapper` introduces several enhancements to streamline interaction with the API:

- **Typed Request Classes**  
  Clearly defined request classes simplify understanding of required and optional parameters.

- **Active Maintenance**  
  Underlying libraries are regularly updated to ensure compatibility and stability.

- **Built-in Caching**
  Frequently accessed data, such as trip or stop queries, will be cached to improve performance and reduce redundant API calls.

- **(Upcoming) Request Queueing**  
  A built-in queuing system will manage large volumes of requests in an API-friendly manner, protecting the interface and simplifying bulk processing.

> ⚠️ **Note:** Queuing feature is currently **in development** and not yet available in the latest version.

---

## 🔗 API Source & Further Information

This client builds upon the [`db-vendo-client`](https://github.com/public-transport/db-vendo-client), a JavaScript client for bahn.de public transport APIs. The underlying API is maintained by the open-source community and offers a modern, Swagger-based interface to Deutsche Bahn's HAFAS platform.

A big thank you to the [public-transport community](https://github.com/public-transport).

👉 [https://github.com/public-transport/db-vendo-client](https://github.com/public-transport/db-vendo-client)

---

## 🚀 Installation

To install the API client library to your local Maven repository, execute:

```bash
mvn clean install
```

### Maven Dependency

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

## 🧩 Usage Examples

### Caching-Feature

Das Caching ist standardmäßig aktiviert und speichert häufig genutzte API-Antworten für 10 Minuten. Die Lebensdauer und Größe des Caches können jedoch individuell angepasst werden, indem eine eigene CacheConfig beim Erstellen der DBVendoAPI-Instanz übergeben wird.

**Beispiel: Eigene CacheConfig mit kurzer Ablaufzeit (z.B. für Tests)**

```java
import de.olech2412.dbvendowrapper.ApiClient;
import de.olech2412.dbvendowrapper.api.DBVendoAPI;
import de.olech2412.dbvendowrapper.config.CacheConfig;

// Eigene CacheConfig: 2 Sekunden Ablaufzeit, max. 1000 Einträge
CacheConfig cacheConfig = new CacheConfig(true, 1000, java.time.Duration.ofSeconds(2));
DBVendoAPI api = new DBVendoAPI(new ApiClient(), cacheConfig);
```

**Standardverhalten:**

Ohne explizite Konfiguration wird ein Cache mit 10 Minuten Ablaufzeit und 1000 Einträgen verwendet.

### Builder Pattern for Request Creation

This library provides a builder pattern for creating request objects, making it easy to set optional parameters. The builder pattern allows for a more fluent and readable API, especially when dealing with requests that have many optional parameters.

For example, to create a TripByIdRequest:

1. Use the static builder method with the required parameter(s)
2. Chain method calls to set optional parameters
3. Call build() to create the final request object

```
// Example: Fetching a Trip by ID
TripByIdRequest tripRequest = TripByIdRequest.builder("trip123")
    .withStopOvers(true)
    .withRemarks(true)
    .withLanguage("en")
    .build();
```

The same pattern applies to other request types like LocationsNearbyRequest, which requires a Location object as a parameter.

#### Example 1: Fetching a Trip by ID

```java
// Create a request using the builder pattern
TripByIdRequest request = TripByIdRequest.builder("trip123")
    .withStopOvers(true)
    .withRemarks(true)
    .withPolyline(true)
    .withLanguage("en")
    .build();

// Execute the request
DBVendoAPI api = new DBVendoAPI();
TripsIdGet2XXResponse response = api.tripsIdGet(request);
```

#### Example 2: Finding Locations Nearby

```java
// Create a location
Location location = new Location();
location.setLatitude(new BigDecimal("52.5200"));
location.setLongitude(new BigDecimal("13.4050"));

// Create a request using the builder pattern
LocationsNearbyRequest request = LocationsNearbyRequest.builder(location)
    .withMaxResults(10)
    .withDistance(1000)
    .withStops(true)
    .withPoi(true)
    .build();

// Execute the request
DBVendoAPI api = new DBVendoAPI();
List<StopsIdGet2XXResponse> locations = api.locationsNearbyGet(request);
```

## 📚 Documentation for API Endpoints

All URIs are relative to */*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DBVendoAPI* | [**journeysGet**](docs/DBVendoAPI.md#journeysGet) | **GET** /journeys | Finds journeys from A to B.
*DBVendoAPI* | [**journeysRefGet**](docs/DBVendoAPI.md#journeysRefGet) | **GET** /journeys/{ref} | Fetches up-to-date realtime data for a journey computed before.
*DBVendoAPI* | [**locationsGet**](docs/DBVendoAPI.md#locationsGet) | **GET** /locations | Finds stops/stations, POIs and addresses matching a query.
*DBVendoAPI* | [**locationsNearbyGet**](docs/DBVendoAPI.md#locationsNearbyGet) | **GET** /locations/nearby | Finds stops/stations &amp; POIs close to a geolocation.
*DBVendoAPI* | [**stopsIdArrivalsGet**](docs/DBVendoAPI.md#stopsIdArrivalsGet) | **GET** /stops/{id}/arrivals | Fetches arrivals at a stop/station.
*DBVendoAPI* | [**stopsIdDeparturesGet**](docs/DBVendoAPI.md#stopsIdDeparturesGet) | **GET** /stops/{id}/departures | Fetches departures at a stop/station.
*DBVendoAPI* | [**stopsIdGet**](docs/DBVendoAPI.md#stopsIdGet) | **GET** /stops/{id} | Finds a stop/station by ID.
*DBVendoAPI* | [**tripsIdGet**](docs/DBVendoAPI.md#tripsIdGet) | **GET** /trips/{id} | Fetches a trip by ID.

## 📚 Documentation for Models

 - [AgeGroup](docs/AgeGroup.md)
 - [Alternative](docs/Alternative.md)
 - [AnyOfAlternativeDestination](docs/AnyOfAlternativeDestination.md)
 - [AnyOfAlternativeOrigin](docs/AnyOfAlternativeOrigin.md)
 - [AnyOfAlternativeRemarksItems](docs/AnyOfAlternativeRemarksItems.md)
 - [AnyOfAlternativeStop](docs/AnyOfAlternativeStop.md)
 - [AnyOfDurationStationsItems](docs/AnyOfDurationStationsItems.md)
 - [AnyOfEdgeFromLocation](docs/AnyOfEdgeFromLocation.md)
 - [AnyOfEdgeToLocation](docs/AnyOfEdgeToLocation.md)
 - [AnyOfEventFromLocation](docs/AnyOfEventFromLocation.md)
 - [AnyOfEventToLocation](docs/AnyOfEventToLocation.md)
 - [AnyOfFeatureProperties](docs/AnyOfFeatureProperties.md)
 - [AnyOfFrameDestination](docs/AnyOfFrameDestination.md)
 - [AnyOfFrameOrigin](docs/AnyOfFrameOrigin.md)
 - [AnyOfJourneyRemarksItems](docs/AnyOfJourneyRemarksItems.md)
 - [AnyOfLegDestination](docs/AnyOfLegDestination.md)
 - [AnyOfLegOrigin](docs/AnyOfLegOrigin.md)
 - [AnyOfLegRemarksItems](docs/AnyOfLegRemarksItems.md)
 - [AnyOfRemarksOptionsFrom](docs/AnyOfRemarksOptionsFrom.md)
 - [AnyOfRemarksOptionsTo](docs/AnyOfRemarksOptionsTo.md)
 - [AnyOfStationStopsItems](docs/AnyOfStationStopsItems.md)
 - [AnyOfStopOverRemarksItems](docs/AnyOfStopOverRemarksItems.md)
 - [AnyOfStopOverStop](docs/AnyOfStopOverStop.md)
 - [AnyOfTripDestination](docs/AnyOfTripDestination.md)
 - [AnyOfTripOrigin](docs/AnyOfTripOrigin.md)
 - [AnyOfTripRemarksItems](docs/AnyOfTripRemarksItems.md)
 - [AnyOfWarningFromStopsItems](docs/AnyOfWarningFromStopsItems.md)
 - [AnyOfWarningToStopsItems](docs/AnyOfWarningToStopsItems.md)
 - [ArrivalDeparture](docs/ArrivalDeparture.md)
 - [Arrivals](docs/Arrivals.md)
 - [BoundingBox](docs/BoundingBox.md)
 - [Cycle](docs/Cycle.md)
 - [Departures](docs/Departures.md)
 - [DeparturesArrivalsOptions](docs/DeparturesArrivalsOptions.md)
 - [Duration](docs/Duration.md)
 - [DurationsWithRealtimeData](docs/DurationsWithRealtimeData.md)
 - [Edge](docs/Edge.md)
 - [Event](docs/Event.md)
 - [Facilities](docs/Facilities.md)
 - [Feature](docs/Feature.md)
 - [FeatureCollection](docs/FeatureCollection.md)
 - [Filter](docs/Filter.md)
 - [Frame](docs/Frame.md)
 - [Geometry](docs/Geometry.md)
 - [HafasClient](docs/HafasClient.md)
 - [Hint](docs/Hint.md)
 - [IcoCrd](docs/IcoCrd.md)
 - [Ids](docs/Ids.md)
 - [InlineResponse2XX](docs/InlineResponse2XX.md)
 - [InlineResponse2XX1](docs/InlineResponse2XX1.md)
 - [InlineResponse2XX2](docs/InlineResponse2XX2.md)
 - [InlineResponse2XX3](docs/InlineResponse2XX3.md)
 - [InlineResponse2XX4](docs/InlineResponse2XX4.md)
 - [InlineResponse2XX5](docs/InlineResponse2XX5.md)
 - [Journey](docs/Journey.md)
 - [JourneyWithRealtimeData](docs/JourneyWithRealtimeData.md)
 - [Journeys](docs/Journeys.md)
 - [JourneysFromTripOptions](docs/JourneysFromTripOptions.md)
 - [JourneysOptions](docs/JourneysOptions.md)
 - [JourneysOptionsCommon](docs/JourneysOptionsCommon.md)
 - [JourneysOptionsDbProfile](docs/JourneysOptionsDbProfile.md)
 - [Leg](docs/Leg.md)
 - [Line](docs/Line.md)
 - [LinesOptions](docs/LinesOptions.md)
 - [LinesWithRealtimeData](docs/LinesWithRealtimeData.md)
 - [Location](docs/Location.md)
 - [LocationsOptions](docs/LocationsOptions.md)
 - [LoyaltyCard](docs/LoyaltyCard.md)
 - [Movement](docs/Movement.md)
 - [NearByOptions](docs/NearByOptions.md)
 - [Operator](docs/Operator.md)
 - [Price](docs/Price.md)
 - [ProductType](docs/ProductType.md)
 - [Products](docs/Products.md)
 - [Profile](docs/Profile.md)
 - [ProfileSpecificProducts](docs/ProfileSpecificProducts.md)
 - [PrognosisType](docs/PrognosisType.md)
 - [Radar](docs/Radar.md)
 - [RadarOptions](docs/RadarOptions.md)
 - [ReachableFromOptions](docs/ReachableFromOptions.md)
 - [RealtimeDataUpdatedAt](docs/RealtimeDataUpdatedAt.md)
 - [RefreshJourneyOptions](docs/RefreshJourneyOptions.md)
 - [Region](docs/Region.md)
 - [ReisezentrumOpeningHours](docs/ReisezentrumOpeningHours.md)
 - [RemarksOptions](docs/RemarksOptions.md)
 - [Route](docs/Route.md)
 - [RoutingMode](docs/RoutingMode.md)
 - [Schedule](docs/Schedule.md)
 - [ScheduledDays](docs/ScheduledDays.md)
 - [ServerInfo](docs/ServerInfo.md)
 - [ServerOptions](docs/ServerOptions.md)
 - [Station](docs/Station.md)
 - [Status](docs/Status.md)
 - [Stop](docs/Stop.md)
 - [StopOptions](docs/StopOptions.md)
 - [StopOver](docs/StopOver.md)
 - [Trip](docs/Trip.md)
 - [TripOptions](docs/TripOptions.md)
 - [TripWithRealtimeData](docs/TripWithRealtimeData.md)
 - [TripsByNameOptions](docs/TripsByNameOptions.md)
 - [TripsWithRealtimeData](docs/TripsWithRealtimeData.md)
 - [Warning](docs/Warning.md)
 - [WarningsWithRealtimeData](docs/WarningsWithRealtimeData.md)

## 🔐 Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## 💡 Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.
