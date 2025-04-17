/*
 * db-vendo-client
 * Schema for db-vendo-client/hafas-rest-api's Friendly Public Transport Format REST API
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.olech2412.dbvendoclient.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

/**
 * HafasClient
 */
@JsonPropertyOrder({
        HafasClient.JSON_PROPERTY_JOURNEYS,
        HafasClient.JSON_PROPERTY_REFRESH_JOURNEY,
        HafasClient.JSON_PROPERTY_TRIP,
        HafasClient.JSON_PROPERTY_DEPARTURES,
        HafasClient.JSON_PROPERTY_ARRIVALS,
        HafasClient.JSON_PROPERTY_JOURNEYS_FROM_TRIP,
        HafasClient.JSON_PROPERTY_LOCATIONS,
        HafasClient.JSON_PROPERTY_STOP,
        HafasClient.JSON_PROPERTY_NEARBY,
        HafasClient.JSON_PROPERTY_REACHABLE_FROM,
        HafasClient.JSON_PROPERTY_RADAR,
        HafasClient.JSON_PROPERTY_TRIPS_BY_NAME,
        HafasClient.JSON_PROPERTY_REMARKS,
        HafasClient.JSON_PROPERTY_LINES,
        HafasClient.JSON_PROPERTY_SERVER_INFO
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class HafasClient {
    public static final String JSON_PROPERTY_JOURNEYS = "journeys";
    public static final String JSON_PROPERTY_REFRESH_JOURNEY = "refreshJourney";
    public static final String JSON_PROPERTY_TRIP = "trip";
    public static final String JSON_PROPERTY_DEPARTURES = "departures";
    public static final String JSON_PROPERTY_ARRIVALS = "arrivals";
    public static final String JSON_PROPERTY_JOURNEYS_FROM_TRIP = "journeysFromTrip";
    public static final String JSON_PROPERTY_LOCATIONS = "locations";
    public static final String JSON_PROPERTY_STOP = "stop";
    public static final String JSON_PROPERTY_NEARBY = "nearby";
    public static final String JSON_PROPERTY_REACHABLE_FROM = "reachableFrom";
    public static final String JSON_PROPERTY_RADAR = "radar";
    public static final String JSON_PROPERTY_TRIPS_BY_NAME = "tripsByName";
    public static final String JSON_PROPERTY_REMARKS = "remarks";
    public static final String JSON_PROPERTY_LINES = "lines";
    public static final String JSON_PROPERTY_SERVER_INFO = "serverInfo";
    @jakarta.annotation.Nullable
    private Object journeys;
    @jakarta.annotation.Nullable
    private Object refreshJourney;
    @jakarta.annotation.Nullable
    private Object trip;
    @jakarta.annotation.Nullable
    private Object departures;
    @jakarta.annotation.Nullable
    private Object arrivals;
    @jakarta.annotation.Nullable
    private Object journeysFromTrip;
    @jakarta.annotation.Nullable
    private Object locations;
    @jakarta.annotation.Nullable
    private Object stop;
    @jakarta.annotation.Nullable
    private Object nearby;
    @jakarta.annotation.Nullable
    private Object reachableFrom;
    @jakarta.annotation.Nullable
    private Object radar;
    @jakarta.annotation.Nullable
    private Object tripsByName;
    @jakarta.annotation.Nullable
    private Object remarks;
    @jakarta.annotation.Nullable
    private Object lines;
    @jakarta.annotation.Nullable
    private Object serverInfo;

    public HafasClient() {
    }

    public HafasClient journeys(@jakarta.annotation.Nullable Object journeys) {

        this.journeys = journeys;
        return this;
    }

    /**
     * Retrieves journeys
     *
     * @return journeys
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JOURNEYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getJourneys() {
        return journeys;
    }


    @JsonProperty(JSON_PROPERTY_JOURNEYS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJourneys(@jakarta.annotation.Nullable Object journeys) {
        this.journeys = journeys;
    }

    public HafasClient refreshJourney(@jakarta.annotation.Nullable Object refreshJourney) {

        this.refreshJourney = refreshJourney;
        return this;
    }

    /**
     * refreshes a Journey
     *
     * @return refreshJourney
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REFRESH_JOURNEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getRefreshJourney() {
        return refreshJourney;
    }


    @JsonProperty(JSON_PROPERTY_REFRESH_JOURNEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRefreshJourney(@jakarta.annotation.Nullable Object refreshJourney) {
        this.refreshJourney = refreshJourney;
    }

    public HafasClient trip(@jakarta.annotation.Nullable Object trip) {

        this.trip = trip;
        return this;
    }

    /**
     * Refetch information about a trip
     *
     * @return trip
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRIP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getTrip() {
        return trip;
    }


    @JsonProperty(JSON_PROPERTY_TRIP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTrip(@jakarta.annotation.Nullable Object trip) {
        this.trip = trip;
    }

    public HafasClient departures(@jakarta.annotation.Nullable Object departures) {

        this.departures = departures;
        return this;
    }

    /**
     * Retrieves departures
     *
     * @return departures
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPARTURES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getDepartures() {
        return departures;
    }


    @JsonProperty(JSON_PROPERTY_DEPARTURES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDepartures(@jakarta.annotation.Nullable Object departures) {
        this.departures = departures;
    }

    public HafasClient arrivals(@jakarta.annotation.Nullable Object arrivals) {

        this.arrivals = arrivals;
        return this;
    }

    /**
     * Retrieves arrivals
     *
     * @return arrivals
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ARRIVALS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getArrivals() {
        return arrivals;
    }


    @JsonProperty(JSON_PROPERTY_ARRIVALS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setArrivals(@jakarta.annotation.Nullable Object arrivals) {
        this.arrivals = arrivals;
    }

    public HafasClient journeysFromTrip(@jakarta.annotation.Nullable Object journeysFromTrip) {

        this.journeysFromTrip = journeysFromTrip;
        return this;
    }

    /**
     * Retrieves journeys from trip id to station
     *
     * @return journeysFromTrip
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JOURNEYS_FROM_TRIP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getJourneysFromTrip() {
        return journeysFromTrip;
    }


    @JsonProperty(JSON_PROPERTY_JOURNEYS_FROM_TRIP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJourneysFromTrip(@jakarta.annotation.Nullable Object journeysFromTrip) {
        this.journeysFromTrip = journeysFromTrip;
    }

    public HafasClient locations(@jakarta.annotation.Nullable Object locations) {

        this.locations = locations;
        return this;
    }

    /**
     * Retrieves locations or stops
     *
     * @return locations
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOCATIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getLocations() {
        return locations;
    }


    @JsonProperty(JSON_PROPERTY_LOCATIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLocations(@jakarta.annotation.Nullable Object locations) {
        this.locations = locations;
    }

    public HafasClient stop(@jakarta.annotation.Nullable Object stop) {

        this.stop = stop;
        return this;
    }

    /**
     * Retrieves information about a stop
     *
     * @return stop
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STOP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getStop() {
        return stop;
    }


    @JsonProperty(JSON_PROPERTY_STOP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStop(@jakarta.annotation.Nullable Object stop) {
        this.stop = stop;
    }

    public HafasClient nearby(@jakarta.annotation.Nullable Object nearby) {

        this.nearby = nearby;
        return this;
    }

    /**
     * Retrieves nearby stops from location
     *
     * @return nearby
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NEARBY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getNearby() {
        return nearby;
    }


    @JsonProperty(JSON_PROPERTY_NEARBY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNearby(@jakarta.annotation.Nullable Object nearby) {
        this.nearby = nearby;
    }

    public HafasClient reachableFrom(@jakarta.annotation.Nullable Object reachableFrom) {

        this.reachableFrom = reachableFrom;
        return this;
    }

    /**
     * Retrieves stations reachable within a certain time from a location
     *
     * @return reachableFrom
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REACHABLE_FROM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getReachableFrom() {
        return reachableFrom;
    }


    @JsonProperty(JSON_PROPERTY_REACHABLE_FROM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReachableFrom(@jakarta.annotation.Nullable Object reachableFrom) {
        this.reachableFrom = reachableFrom;
    }

    public HafasClient radar(@jakarta.annotation.Nullable Object radar) {

        this.radar = radar;
        return this;
    }

    /**
     * Retrieves all vehicles currently in an area.
     *
     * @return radar
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RADAR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getRadar() {
        return radar;
    }


    @JsonProperty(JSON_PROPERTY_RADAR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRadar(@jakarta.annotation.Nullable Object radar) {
        this.radar = radar;
    }

    public HafasClient tripsByName(@jakarta.annotation.Nullable Object tripsByName) {

        this.tripsByName = tripsByName;
        return this;
    }

    /**
     * Retrieves trips by name.
     *
     * @return tripsByName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRIPS_BY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getTripsByName() {
        return tripsByName;
    }


    @JsonProperty(JSON_PROPERTY_TRIPS_BY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTripsByName(@jakarta.annotation.Nullable Object tripsByName) {
        this.tripsByName = tripsByName;
    }

    public HafasClient remarks(@jakarta.annotation.Nullable Object remarks) {

        this.remarks = remarks;
        return this;
    }

    /**
     * Fetches all remarks known to the HAFAS endpoint
     *
     * @return remarks
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REMARKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getRemarks() {
        return remarks;
    }


    @JsonProperty(JSON_PROPERTY_REMARKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRemarks(@jakarta.annotation.Nullable Object remarks) {
        this.remarks = remarks;
    }

    public HafasClient lines(@jakarta.annotation.Nullable Object lines) {

        this.lines = lines;
        return this;
    }

    /**
     * Fetches all lines known to the HAFAS endpoint
     *
     * @return lines
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getLines() {
        return lines;
    }


    @JsonProperty(JSON_PROPERTY_LINES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLines(@jakarta.annotation.Nullable Object lines) {
        this.lines = lines;
    }

    public HafasClient serverInfo(@jakarta.annotation.Nullable Object serverInfo) {

        this.serverInfo = serverInfo;
        return this;
    }

    /**
     * Fetches meta information from the HAFAS endpoint
     *
     * @return serverInfo
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SERVER_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Object getServerInfo() {
        return serverInfo;
    }


    @JsonProperty(JSON_PROPERTY_SERVER_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setServerInfo(@jakarta.annotation.Nullable Object serverInfo) {
        this.serverInfo = serverInfo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HafasClient hafasClient = (HafasClient) o;
        return Objects.equals(this.journeys, hafasClient.journeys) &&
                Objects.equals(this.refreshJourney, hafasClient.refreshJourney) &&
                Objects.equals(this.trip, hafasClient.trip) &&
                Objects.equals(this.departures, hafasClient.departures) &&
                Objects.equals(this.arrivals, hafasClient.arrivals) &&
                Objects.equals(this.journeysFromTrip, hafasClient.journeysFromTrip) &&
                Objects.equals(this.locations, hafasClient.locations) &&
                Objects.equals(this.stop, hafasClient.stop) &&
                Objects.equals(this.nearby, hafasClient.nearby) &&
                Objects.equals(this.reachableFrom, hafasClient.reachableFrom) &&
                Objects.equals(this.radar, hafasClient.radar) &&
                Objects.equals(this.tripsByName, hafasClient.tripsByName) &&
                Objects.equals(this.remarks, hafasClient.remarks) &&
                Objects.equals(this.lines, hafasClient.lines) &&
                Objects.equals(this.serverInfo, hafasClient.serverInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(journeys, refreshJourney, trip, departures, arrivals, journeysFromTrip, locations, stop, nearby, reachableFrom, radar, tripsByName, remarks, lines, serverInfo);
    }

    @Override
    public String toString() {
        String sb = "class HafasClient {\n" +
                "    journeys: " + toIndentedString(journeys) + "\n" +
                "    refreshJourney: " + toIndentedString(refreshJourney) + "\n" +
                "    trip: " + toIndentedString(trip) + "\n" +
                "    departures: " + toIndentedString(departures) + "\n" +
                "    arrivals: " + toIndentedString(arrivals) + "\n" +
                "    journeysFromTrip: " + toIndentedString(journeysFromTrip) + "\n" +
                "    locations: " + toIndentedString(locations) + "\n" +
                "    stop: " + toIndentedString(stop) + "\n" +
                "    nearby: " + toIndentedString(nearby) + "\n" +
                "    reachableFrom: " + toIndentedString(reachableFrom) + "\n" +
                "    radar: " + toIndentedString(radar) + "\n" +
                "    tripsByName: " + toIndentedString(tripsByName) + "\n" +
                "    remarks: " + toIndentedString(remarks) + "\n" +
                "    lines: " + toIndentedString(lines) + "\n" +
                "    serverInfo: " + toIndentedString(serverInfo) + "\n" +
                "}";
        return sb;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

