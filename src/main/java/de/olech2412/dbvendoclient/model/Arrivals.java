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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Arrivals
 */
@JsonPropertyOrder({
        Arrivals.JSON_PROPERTY_ARRIVALS,
        Arrivals.JSON_PROPERTY_REALTIME_DATA_UPDATED_AT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class Arrivals {
    public static final String JSON_PROPERTY_ARRIVALS = "arrivals";
    public static final String JSON_PROPERTY_REALTIME_DATA_UPDATED_AT = "realtimeDataUpdatedAt";
    @jakarta.annotation.Nullable
    private List<Alternative> arrivals = new ArrayList<>();
    @jakarta.annotation.Nullable
    private BigDecimal realtimeDataUpdatedAt;

    public Arrivals() {
    }

    public Arrivals arrivals(@jakarta.annotation.Nullable List<Alternative> arrivals) {

        this.arrivals = arrivals;
        return this;
    }

    public Arrivals addArrivalsItem(Alternative arrivalsItem) {
        if (this.arrivals == null) {
            this.arrivals = new ArrayList<>();
        }
        this.arrivals.add(arrivalsItem);
        return this;
    }

    /**
     * Get arrivals
     *
     * @return arrivals
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ARRIVALS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Alternative> getArrivals() {
        return arrivals;
    }


    @JsonProperty(JSON_PROPERTY_ARRIVALS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setArrivals(@jakarta.annotation.Nullable List<Alternative> arrivals) {
        this.arrivals = arrivals;
    }

    public Arrivals realtimeDataUpdatedAt(@jakarta.annotation.Nullable BigDecimal realtimeDataUpdatedAt) {

        this.realtimeDataUpdatedAt = realtimeDataUpdatedAt;
        return this;
    }

    /**
     * Get realtimeDataUpdatedAt
     *
     * @return realtimeDataUpdatedAt
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REALTIME_DATA_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getRealtimeDataUpdatedAt() {
        return realtimeDataUpdatedAt;
    }


    @JsonProperty(JSON_PROPERTY_REALTIME_DATA_UPDATED_AT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRealtimeDataUpdatedAt(@jakarta.annotation.Nullable BigDecimal realtimeDataUpdatedAt) {
        this.realtimeDataUpdatedAt = realtimeDataUpdatedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Arrivals arrivals = (Arrivals) o;
        return Objects.equals(this.arrivals, arrivals.arrivals) &&
                Objects.equals(this.realtimeDataUpdatedAt, arrivals.realtimeDataUpdatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrivals, realtimeDataUpdatedAt);
    }

    @Override
    public String toString() {
        String sb = "class Arrivals {\n" +
                "    arrivals: " + toIndentedString(arrivals) + "\n" +
                "    realtimeDataUpdatedAt: " + toIndentedString(realtimeDataUpdatedAt) + "\n" +
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

