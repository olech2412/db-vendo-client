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
import java.util.Objects;

/**
 * JourneyWithRealtimeData
 */
@JsonPropertyOrder({
        JourneyWithRealtimeData.JSON_PROPERTY_JOURNEY,
        JourneyWithRealtimeData.JSON_PROPERTY_REALTIME_DATA_UPDATED_AT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class JourneyWithRealtimeData {
    public static final String JSON_PROPERTY_JOURNEY = "journey";
    public static final String JSON_PROPERTY_REALTIME_DATA_UPDATED_AT = "realtimeDataUpdatedAt";
    @jakarta.annotation.Nullable
    private Journey journey;
    @jakarta.annotation.Nullable
    private BigDecimal realtimeDataUpdatedAt;

    public JourneyWithRealtimeData() {
    }

    public JourneyWithRealtimeData journey(@jakarta.annotation.Nullable Journey journey) {

        this.journey = journey;
        return this;
    }

    /**
     * Get journey
     *
     * @return journey
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_JOURNEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Journey getJourney() {
        return journey;
    }


    @JsonProperty(JSON_PROPERTY_JOURNEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setJourney(@jakarta.annotation.Nullable Journey journey) {
        this.journey = journey;
    }

    public JourneyWithRealtimeData realtimeDataUpdatedAt(@jakarta.annotation.Nullable BigDecimal realtimeDataUpdatedAt) {

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
        JourneyWithRealtimeData journeyWithRealtimeData = (JourneyWithRealtimeData) o;
        return Objects.equals(this.journey, journeyWithRealtimeData.journey) &&
                Objects.equals(this.realtimeDataUpdatedAt, journeyWithRealtimeData.realtimeDataUpdatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(journey, realtimeDataUpdatedAt);
    }

    @Override
    public String toString() {
        String sb = "class JourneyWithRealtimeData {\n" +
                "    journey: " + toIndentedString(journey) + "\n" +
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

