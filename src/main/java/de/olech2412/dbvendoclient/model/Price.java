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
 * Price
 */
@JsonPropertyOrder({
        Price.JSON_PROPERTY_AMOUNT,
        Price.JSON_PROPERTY_CURRENCY,
        Price.JSON_PROPERTY_HINT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-11T16:58:48.518685525+02:00[Europe/Berlin]", comments = "Generator version: 7.12.0")
public class Price {
    public static final String JSON_PROPERTY_AMOUNT = "amount";
    public static final String JSON_PROPERTY_CURRENCY = "currency";
    public static final String JSON_PROPERTY_HINT = "hint";
    @jakarta.annotation.Nullable
    private BigDecimal amount;
    @jakarta.annotation.Nullable
    private String currency;
    @jakarta.annotation.Nullable
    private String hint;

    public Price() {
    }

    public Price amount(@jakarta.annotation.Nullable BigDecimal amount) {

        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_AMOUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getAmount() {
        return amount;
    }


    @JsonProperty(JSON_PROPERTY_AMOUNT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAmount(@jakarta.annotation.Nullable BigDecimal amount) {
        this.amount = amount;
    }

    public Price currency(@jakarta.annotation.Nullable String currency) {

        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CURRENCY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCurrency() {
        return currency;
    }


    @JsonProperty(JSON_PROPERTY_CURRENCY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCurrency(@jakarta.annotation.Nullable String currency) {
        this.currency = currency;
    }

    public Price hint(@jakarta.annotation.Nullable String hint) {

        this.hint = hint;
        return this;
    }

    /**
     * Get hint
     *
     * @return hint
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_HINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getHint() {
        return hint;
    }


    @JsonProperty(JSON_PROPERTY_HINT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setHint(@jakarta.annotation.Nullable String hint) {
        this.hint = hint;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price = (Price) o;
        return Objects.equals(this.amount, price.amount) &&
                Objects.equals(this.currency, price.currency) &&
                Objects.equals(this.hint, price.hint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency, hint);
    }

    @Override
    public String toString() {
        String sb = "class Price {\n" +
                "    amount: " + toIndentedString(amount) + "\n" +
                "    currency: " + toIndentedString(currency) + "\n" +
                "    hint: " + toIndentedString(hint) + "\n" +
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

