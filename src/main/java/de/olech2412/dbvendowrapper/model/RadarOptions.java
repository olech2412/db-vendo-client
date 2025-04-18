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

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * RadarOptions
 */
@JsonPropertyOrder({
        RadarOptions.JSON_PROPERTY_RESULTS,
        RadarOptions.JSON_PROPERTY_FRAMES,
        RadarOptions.JSON_PROPERTY_PRODUCTS,
        RadarOptions.JSON_PROPERTY_DURATION,
        RadarOptions.JSON_PROPERTY_SUB_STOPS,
        RadarOptions.JSON_PROPERTY_ENTRANCES,
        RadarOptions.JSON_PROPERTY_POLYLINES,
        RadarOptions.JSON_PROPERTY_WHEN
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class RadarOptions {
    public static final String JSON_PROPERTY_RESULTS = "results";
    public static final String JSON_PROPERTY_FRAMES = "frames";
    public static final String JSON_PROPERTY_PRODUCTS = "products";
    public static final String JSON_PROPERTY_DURATION = "duration";
    public static final String JSON_PROPERTY_SUB_STOPS = "subStops";
    public static final String JSON_PROPERTY_ENTRANCES = "entrances";
    public static final String JSON_PROPERTY_POLYLINES = "polylines";
    public static final String JSON_PROPERTY_WHEN = "when";
    @jakarta.annotation.Nullable
    private BigDecimal results = new BigDecimal("256");
    @jakarta.annotation.Nullable
    private BigDecimal frames = new BigDecimal("3");
    @jakarta.annotation.Nullable
    private Map<String, Boolean> products = new HashMap<>();
    @jakarta.annotation.Nullable
    private BigDecimal duration = new BigDecimal("20");
    @jakarta.annotation.Nullable
    private Boolean subStops = true;
    @jakarta.annotation.Nullable
    private Boolean entrances = true;
    @jakarta.annotation.Nullable
    private Boolean polylines = false;
    @jakarta.annotation.Nullable
    private OffsetDateTime when;

    public RadarOptions() {
    }

    public RadarOptions results(@jakarta.annotation.Nullable BigDecimal results) {

        this.results = results;
        return this;
    }

    /**
     * maximum number of vehicles
     *
     * @return results
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RESULTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getResults() {
        return results;
    }


    @JsonProperty(JSON_PROPERTY_RESULTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setResults(@jakarta.annotation.Nullable BigDecimal results) {
        this.results = results;
    }

    public RadarOptions frames(@jakarta.annotation.Nullable BigDecimal frames) {

        this.frames = frames;
        return this;
    }

    /**
     * nr of frames to compute
     *
     * @return frames
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FRAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getFrames() {
        return frames;
    }


    @JsonProperty(JSON_PROPERTY_FRAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFrames(@jakarta.annotation.Nullable BigDecimal frames) {
        this.frames = frames;
    }

    public RadarOptions products(@jakarta.annotation.Nullable Map<String, Boolean> products) {

        this.products = products;
        return this;
    }

    public RadarOptions putProductsItem(String key, Boolean productsItem) {
        if (this.products == null) {
            this.products = new HashMap<>();
        }
        this.products.put(key, productsItem);
        return this;
    }

    /**
     * Each public transportation network exposes its products as boolean properties. See {@link ProductType}
     *
     * @return products
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PRODUCTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, Boolean> getProducts() {
        return products;
    }


    @JsonProperty(JSON_PROPERTY_PRODUCTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setProducts(@jakarta.annotation.Nullable Map<String, Boolean> products) {
        this.products = products;
    }

    public RadarOptions duration(@jakarta.annotation.Nullable BigDecimal duration) {

        this.duration = duration;
        return this;
    }

    /**
     * compute frames for the next n seconds
     *
     * @return duration
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getDuration() {
        return duration;
    }


    @JsonProperty(JSON_PROPERTY_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDuration(@jakarta.annotation.Nullable BigDecimal duration) {
        this.duration = duration;
    }

    public RadarOptions subStops(@jakarta.annotation.Nullable Boolean subStops) {

        this.subStops = subStops;
        return this;
    }

    /**
     * parse &amp; expose sub-stops of stations?
     *
     * @return subStops
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUB_STOPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getSubStops() {
        return subStops;
    }


    @JsonProperty(JSON_PROPERTY_SUB_STOPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubStops(@jakarta.annotation.Nullable Boolean subStops) {
        this.subStops = subStops;
    }

    public RadarOptions entrances(@jakarta.annotation.Nullable Boolean entrances) {

        this.entrances = entrances;
        return this;
    }

    /**
     * parse &amp; expose entrances of stops/stations?
     *
     * @return entrances
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ENTRANCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getEntrances() {
        return entrances;
    }


    @JsonProperty(JSON_PROPERTY_ENTRANCES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEntrances(@jakarta.annotation.Nullable Boolean entrances) {
        this.entrances = entrances;
    }

    public RadarOptions polylines(@jakarta.annotation.Nullable Boolean polylines) {

        this.polylines = polylines;
        return this;
    }

    /**
     * return a shape for the trip?
     *
     * @return polylines
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_POLYLINES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getPolylines() {
        return polylines;
    }


    @JsonProperty(JSON_PROPERTY_POLYLINES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPolylines(@jakarta.annotation.Nullable Boolean polylines) {
        this.polylines = polylines;
    }

    public RadarOptions when(@jakarta.annotation.Nullable OffsetDateTime when) {

        this.when = when;
        return this;
    }

    /**
     * when
     *
     * @return when
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WHEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public OffsetDateTime getWhen() {
        return when;
    }


    @JsonProperty(JSON_PROPERTY_WHEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWhen(@jakarta.annotation.Nullable OffsetDateTime when) {
        this.when = when;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RadarOptions radarOptions = (RadarOptions) o;
        return Objects.equals(this.results, radarOptions.results) &&
                Objects.equals(this.frames, radarOptions.frames) &&
                Objects.equals(this.products, radarOptions.products) &&
                Objects.equals(this.duration, radarOptions.duration) &&
                Objects.equals(this.subStops, radarOptions.subStops) &&
                Objects.equals(this.entrances, radarOptions.entrances) &&
                Objects.equals(this.polylines, radarOptions.polylines) &&
                Objects.equals(this.when, radarOptions.when);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, frames, products, duration, subStops, entrances, polylines, when);
    }

    @Override
    public String toString() {
        String sb = "class RadarOptions {\n" +
                "    results: " + toIndentedString(results) + "\n" +
                "    frames: " + toIndentedString(frames) + "\n" +
                "    products: " + toIndentedString(products) + "\n" +
                "    duration: " + toIndentedString(duration) + "\n" +
                "    subStops: " + toIndentedString(subStops) + "\n" +
                "    entrances: " + toIndentedString(entrances) + "\n" +
                "    polylines: " + toIndentedString(polylines) + "\n" +
                "    when: " + toIndentedString(when) + "\n" +
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

