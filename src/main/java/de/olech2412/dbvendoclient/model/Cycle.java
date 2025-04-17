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
import java.util.Objects;

/**
 * Cycle
 */
@JsonPropertyOrder({
        Cycle.JSON_PROPERTY_MIN,
        Cycle.JSON_PROPERTY_MAX,
        Cycle.JSON_PROPERTY_NR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class Cycle {
    public static final String JSON_PROPERTY_MIN = "min";
    public static final String JSON_PROPERTY_MAX = "max";
    public static final String JSON_PROPERTY_NR = "nr";
    @jakarta.annotation.Nullable
    private BigDecimal min;
    @jakarta.annotation.Nullable
    private BigDecimal max;
    @jakarta.annotation.Nullable
    private BigDecimal nr;

    public Cycle() {
    }

    public Cycle min(@jakarta.annotation.Nullable BigDecimal min) {

        this.min = min;
        return this;
    }

    /**
     * Get min
     *
     * @return min
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getMin() {
        return min;
    }


    @JsonProperty(JSON_PROPERTY_MIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMin(@jakarta.annotation.Nullable BigDecimal min) {
        this.min = min;
    }

    public Cycle max(@jakarta.annotation.Nullable BigDecimal max) {

        this.max = max;
        return this;
    }

    /**
     * Get max
     *
     * @return max
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MAX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getMax() {
        return max;
    }


    @JsonProperty(JSON_PROPERTY_MAX)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMax(@jakarta.annotation.Nullable BigDecimal max) {
        this.max = max;
    }

    public Cycle nr(@jakarta.annotation.Nullable BigDecimal nr) {

        this.nr = nr;
        return this;
    }

    /**
     * Get nr
     *
     * @return nr
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getNr() {
        return nr;
    }


    @JsonProperty(JSON_PROPERTY_NR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNr(@jakarta.annotation.Nullable BigDecimal nr) {
        this.nr = nr;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cycle cycle = (Cycle) o;
        return Objects.equals(this.min, cycle.min) &&
                Objects.equals(this.max, cycle.max) &&
                Objects.equals(this.nr, cycle.nr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, nr);
    }

    @Override
    public String toString() {
        String sb = "class Cycle {\n" +
                "    min: " + toIndentedString(min) + "\n" +
                "    max: " + toIndentedString(max) + "\n" +
                "    nr: " + toIndentedString(nr) + "\n" +
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

