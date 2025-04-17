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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * JourneysFromTripOptions
 */
@JsonPropertyOrder({
        JourneysFromTripOptions.JSON_PROPERTY_STOPOVERS,
        JourneysFromTripOptions.JSON_PROPERTY_TRANSFER_TIME,
        JourneysFromTripOptions.JSON_PROPERTY_ACCESSIBILITY,
        JourneysFromTripOptions.JSON_PROPERTY_TICKETS,
        JourneysFromTripOptions.JSON_PROPERTY_POLYLINES,
        JourneysFromTripOptions.JSON_PROPERTY_SUB_STOPS,
        JourneysFromTripOptions.JSON_PROPERTY_ENTRANCES,
        JourneysFromTripOptions.JSON_PROPERTY_REMARKS,
        JourneysFromTripOptions.JSON_PROPERTY_PRODUCTS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class JourneysFromTripOptions {
    public static final String JSON_PROPERTY_STOPOVERS = "stopovers";
    public static final String JSON_PROPERTY_TRANSFER_TIME = "transferTime";
    public static final String JSON_PROPERTY_ACCESSIBILITY = "accessibility";
    public static final String JSON_PROPERTY_TICKETS = "tickets";
    public static final String JSON_PROPERTY_POLYLINES = "polylines";
    public static final String JSON_PROPERTY_SUB_STOPS = "subStops";
    public static final String JSON_PROPERTY_ENTRANCES = "entrances";
    public static final String JSON_PROPERTY_REMARKS = "remarks";
    public static final String JSON_PROPERTY_PRODUCTS = "products";
    @jakarta.annotation.Nullable
    private Boolean stopovers = false;
    @jakarta.annotation.Nullable
    private BigDecimal transferTime = new BigDecimal("0");
    @jakarta.annotation.Nullable
    private String accessibility = "'none'";
    @jakarta.annotation.Nullable
    private Boolean tickets = false;
    @jakarta.annotation.Nullable
    private Boolean polylines = false;
    @jakarta.annotation.Nullable
    private Boolean subStops = true;
    @jakarta.annotation.Nullable
    private Boolean entrances = true;
    @jakarta.annotation.Nullable
    private Boolean remarks = true;
    @jakarta.annotation.Nullable
    private Map<String, Boolean> products = new HashMap<>();

    public JourneysFromTripOptions() {
    }

    public JourneysFromTripOptions stopovers(@jakarta.annotation.Nullable Boolean stopovers) {

        this.stopovers = stopovers;
        return this;
    }

    /**
     * return stations on the way?
     *
     * @return stopovers
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STOPOVERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getStopovers() {
        return stopovers;
    }


    @JsonProperty(JSON_PROPERTY_STOPOVERS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setStopovers(@jakarta.annotation.Nullable Boolean stopovers) {
        this.stopovers = stopovers;
    }

    public JourneysFromTripOptions transferTime(@jakarta.annotation.Nullable BigDecimal transferTime) {

        this.transferTime = transferTime;
        return this;
    }

    /**
     * minimum time for a single transfer in minutes
     *
     * @return transferTime
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TRANSFER_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getTransferTime() {
        return transferTime;
    }


    @JsonProperty(JSON_PROPERTY_TRANSFER_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTransferTime(@jakarta.annotation.Nullable BigDecimal transferTime) {
        this.transferTime = transferTime;
    }

    public JourneysFromTripOptions accessibility(@jakarta.annotation.Nullable String accessibility) {

        this.accessibility = accessibility;
        return this;
    }

    /**
     * &#39;none&#39;, &#39;partial&#39; or &#39;complete&#39;
     *
     * @return accessibility
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACCESSIBILITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAccessibility() {
        return accessibility;
    }


    @JsonProperty(JSON_PROPERTY_ACCESSIBILITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAccessibility(@jakarta.annotation.Nullable String accessibility) {
        this.accessibility = accessibility;
    }

    public JourneysFromTripOptions tickets(@jakarta.annotation.Nullable Boolean tickets) {

        this.tickets = tickets;
        return this;
    }

    /**
     * return tickets? only available with some profiles
     *
     * @return tickets
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TICKETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getTickets() {
        return tickets;
    }


    @JsonProperty(JSON_PROPERTY_TICKETS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTickets(@jakarta.annotation.Nullable Boolean tickets) {
        this.tickets = tickets;
    }

    public JourneysFromTripOptions polylines(@jakarta.annotation.Nullable Boolean polylines) {

        this.polylines = polylines;
        return this;
    }

    /**
     * return leg shapes?
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

    public JourneysFromTripOptions subStops(@jakarta.annotation.Nullable Boolean subStops) {

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

    public JourneysFromTripOptions entrances(@jakarta.annotation.Nullable Boolean entrances) {

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

    public JourneysFromTripOptions remarks(@jakarta.annotation.Nullable Boolean remarks) {

        this.remarks = remarks;
        return this;
    }

    /**
     * parse &amp; expose hints &amp; warnings?
     *
     * @return remarks
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REMARKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getRemarks() {
        return remarks;
    }


    @JsonProperty(JSON_PROPERTY_REMARKS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRemarks(@jakarta.annotation.Nullable Boolean remarks) {
        this.remarks = remarks;
    }

    public JourneysFromTripOptions products(@jakarta.annotation.Nullable Map<String, Boolean> products) {

        this.products = products;
        return this;
    }

    public JourneysFromTripOptions putProductsItem(String key, Boolean productsItem) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JourneysFromTripOptions journeysFromTripOptions = (JourneysFromTripOptions) o;
        return Objects.equals(this.stopovers, journeysFromTripOptions.stopovers) &&
                Objects.equals(this.transferTime, journeysFromTripOptions.transferTime) &&
                Objects.equals(this.accessibility, journeysFromTripOptions.accessibility) &&
                Objects.equals(this.tickets, journeysFromTripOptions.tickets) &&
                Objects.equals(this.polylines, journeysFromTripOptions.polylines) &&
                Objects.equals(this.subStops, journeysFromTripOptions.subStops) &&
                Objects.equals(this.entrances, journeysFromTripOptions.entrances) &&
                Objects.equals(this.remarks, journeysFromTripOptions.remarks) &&
                Objects.equals(this.products, journeysFromTripOptions.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopovers, transferTime, accessibility, tickets, polylines, subStops, entrances, remarks, products);
    }

    @Override
    public String toString() {
        String sb = "class JourneysFromTripOptions {\n" +
                "    stopovers: " + toIndentedString(stopovers) + "\n" +
                "    transferTime: " + toIndentedString(transferTime) + "\n" +
                "    accessibility: " + toIndentedString(accessibility) + "\n" +
                "    tickets: " + toIndentedString(tickets) + "\n" +
                "    polylines: " + toIndentedString(polylines) + "\n" +
                "    subStops: " + toIndentedString(subStops) + "\n" +
                "    entrances: " + toIndentedString(entrances) + "\n" +
                "    remarks: " + toIndentedString(remarks) + "\n" +
                "    products: " + toIndentedString(products) + "\n" +
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

