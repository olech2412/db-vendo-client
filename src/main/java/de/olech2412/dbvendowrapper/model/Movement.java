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


package de.olech2412.dbvendowrapper.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Movement
 */
@JsonPropertyOrder({
        Movement.JSON_PROPERTY_DIRECTION,
        Movement.JSON_PROPERTY_TRIP_ID,
        Movement.JSON_PROPERTY_LINE,
        Movement.JSON_PROPERTY_LOCATION,
        Movement.JSON_PROPERTY_NEXT_STOPOVERS,
        Movement.JSON_PROPERTY_FRAMES,
        Movement.JSON_PROPERTY_POLYLINE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class Movement {
    public static final String JSON_PROPERTY_DIRECTION = "direction";
    public static final String JSON_PROPERTY_TRIP_ID = "tripId";
    public static final String JSON_PROPERTY_LINE = "line";
    public static final String JSON_PROPERTY_LOCATION = "location";
    public static final String JSON_PROPERTY_NEXT_STOPOVERS = "nextStopovers";
    public static final String JSON_PROPERTY_FRAMES = "frames";
    public static final String JSON_PROPERTY_POLYLINE = "polyline";
    @jakarta.annotation.Nullable
    private String direction;
    @jakarta.annotation.Nullable
    private String tripId;
    @jakarta.annotation.Nullable
    private Line line;
    @jakarta.annotation.Nullable
    private Location location;
    @jakarta.annotation.Nullable
    private List<StopOver> nextStopovers = new ArrayList<>();
    @jakarta.annotation.Nullable
    private List<Frame> frames = new ArrayList<>();
    @jakarta.annotation.Nullable
    private FeatureCollection polyline;

    public Movement() {
    }

    public Movement direction(@jakarta.annotation.Nullable String direction) {

        this.direction = direction;
        return this;
    }

    /**
     * Get direction
     *
     * @return direction
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DIRECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDirection() {
        return direction;
    }


    @JsonProperty(JSON_PROPERTY_DIRECTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDirection(@jakarta.annotation.Nullable String direction) {
        this.direction = direction;
    }

    public Movement tripId(@jakarta.annotation.Nullable String tripId) {

        this.tripId = tripId;
        return this;
    }

    /**
     * Get tripId
     *
     * @return tripId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRIP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTripId() {
        return tripId;
    }


    @JsonProperty(JSON_PROPERTY_TRIP_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTripId(@jakarta.annotation.Nullable String tripId) {
        this.tripId = tripId;
    }

    public Movement line(@jakarta.annotation.Nullable Line line) {

        this.line = line;
        return this;
    }

    /**
     * Get line
     *
     * @return line
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Line getLine() {
        return line;
    }


    @JsonProperty(JSON_PROPERTY_LINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLine(@jakarta.annotation.Nullable Line line) {
        this.line = line;
    }

    public Movement location(@jakarta.annotation.Nullable Location location) {

        this.location = location;
        return this;
    }

    /**
     * Get location
     *
     * @return location
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOCATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Location getLocation() {
        return location;
    }


    @JsonProperty(JSON_PROPERTY_LOCATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLocation(@jakarta.annotation.Nullable Location location) {
        this.location = location;
    }

    public Movement nextStopovers(@jakarta.annotation.Nullable List<StopOver> nextStopovers) {

        this.nextStopovers = nextStopovers;
        return this;
    }

    public Movement addNextStopoversItem(StopOver nextStopoversItem) {
        if (this.nextStopovers == null) {
            this.nextStopovers = new ArrayList<>();
        }
        this.nextStopovers.add(nextStopoversItem);
        return this;
    }

    /**
     * Get nextStopovers
     *
     * @return nextStopovers
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NEXT_STOPOVERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<StopOver> getNextStopovers() {
        return nextStopovers;
    }


    @JsonProperty(JSON_PROPERTY_NEXT_STOPOVERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNextStopovers(@jakarta.annotation.Nullable List<StopOver> nextStopovers) {
        this.nextStopovers = nextStopovers;
    }

    public Movement frames(@jakarta.annotation.Nullable List<Frame> frames) {

        this.frames = frames;
        return this;
    }

    public Movement addFramesItem(Frame framesItem) {
        if (this.frames == null) {
            this.frames = new ArrayList<>();
        }
        this.frames.add(framesItem);
        return this;
    }

    /**
     * Get frames
     *
     * @return frames
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FRAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Frame> getFrames() {
        return frames;
    }


    @JsonProperty(JSON_PROPERTY_FRAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFrames(@jakarta.annotation.Nullable List<Frame> frames) {
        this.frames = frames;
    }

    public Movement polyline(@jakarta.annotation.Nullable FeatureCollection polyline) {

        this.polyline = polyline;
        return this;
    }

    /**
     * Get polyline
     *
     * @return polyline
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_POLYLINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public FeatureCollection getPolyline() {
        return polyline;
    }


    @JsonProperty(JSON_PROPERTY_POLYLINE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPolyline(@jakarta.annotation.Nullable FeatureCollection polyline) {
        this.polyline = polyline;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movement movement = (Movement) o;
        return Objects.equals(this.direction, movement.direction) &&
                Objects.equals(this.tripId, movement.tripId) &&
                Objects.equals(this.line, movement.line) &&
                Objects.equals(this.location, movement.location) &&
                Objects.equals(this.nextStopovers, movement.nextStopovers) &&
                Objects.equals(this.frames, movement.frames) &&
                Objects.equals(this.polyline, movement.polyline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, tripId, line, location, nextStopovers, frames, polyline);
    }

    @Override
    public String toString() {
        String sb = "class Movement {\n" +
                "    direction: " + toIndentedString(direction) + "\n" +
                "    tripId: " + toIndentedString(tripId) + "\n" +
                "    line: " + toIndentedString(line) + "\n" +
                "    location: " + toIndentedString(location) + "\n" +
                "    nextStopovers: " + toIndentedString(nextStopovers) + "\n" +
                "    frames: " + toIndentedString(frames) + "\n" +
                "    polyline: " + toIndentedString(polyline) + "\n" +
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

