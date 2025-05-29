package de.olech2412.dbvendowrapper.requests;

import de.olech2412.dbvendowrapper.model.Location;

/**
 * <h1>Request-Klasse für die Umgebungssuche von Standorten</h1>
 *
 * <p>Diese Klasse ermöglicht die Suche nach Haltestellen und anderen Points of Interest (POI)
 * in einem definierten Umkreis um einen gegebenen Standort.</p>
 *
 * <h2>Hauptfunktionen:</h2>
 * <ul>
 *   <li>Suche von Standorten ausgehend von einem Referenzpunkt</li>
 *   <li>Konfigurierbare Suchparameter:
 *     <ul>
 *       <li>Maximale Anzahl der Ergebnisse (Standard: {@code maxResults = 8})</li>
 *       <li>Suchradius in Metern ({@code distance})</li>
 *     </ul>
 *   </li>
 *   <li>Filteroptionen für Standorttypen:
 *     <ul>
 *       <li>Haltestellen (Standard: {@code stops = true})</li>
 *       <li>Points of Interest (Standard: {@code poi = false})</li>
 *       <li>Linieninformationen (Standard: {@code linesOfStops = false})</li>
 *     </ul>
 *   </li>
 *   <li>Mehrsprachige Ausgabe (Standard: {@code language = "en"})</li>
 * </ul>
 *
 * <h2>Verwendungsbeispiel:</h2>
 * <pre>
 * Location referenzPunkt = new Location(52.520008, 13.404954);
 * LocationsNearbyRequest request = LocationsNearbyRequest.builder(referenzPunkt)
 *     .withMaxResults(10)
 *     .withDistance(500)
 *     .withStops(true)
 *     .withPoi(true)
 *     .build();
 * </pre>
 *
 * <h2>Anwendungsfälle:</h2>
 * <ul>
 *   <li>Haltestellen in der Nähe finden</li>
 *   <li>POI-Suche im Umkreis</li>
 *   <li>Mobilitätsanalyse in bestimmten Gebieten</li>
 * </ul>
 *
 * @author olech2412
 * @version 1.0
 * @see DBVendoRequest
 * @see Location
 */
public class LocationsNearbyRequest implements DBVendoRequest {

    /**
     * Der Referenzstandort, um den herum gesucht werden soll.
     * Dies ist ein Pflichtfeld für die Suche.
     */
    private Location location;

    /**
     * Maximale Anzahl der zurückzugebenden Ergebnisse.
     * Standardwert ist 8.
     */
    private int maxResults = 8;

    /**
     * Suchradius in Metern um den Referenzstandort.
     */
    private int distance;

    /**
     * Gibt an, ob Haltestellen in den Ergebnissen enthalten sein sollen.
     * Standardmäßig auf true gesetzt.
     */
    private boolean stops = true;

    /**
     * Gibt an, ob Points of Interest (POI) in den Ergebnissen enthalten sein sollen.
     * Standardmäßig auf false gesetzt.
     */
    private boolean poi = false;

    /**
     * Gibt an, ob Linieninformationen für Haltestellen abgerufen werden sollen.
     * Standardmäßig auf false gesetzt.
     */
    private boolean linesOfStops = false;

    /**
     * Sprachcode für die Ergebnisse (z.B. "de" oder "en").
     * Standardmäßig auf "en" gesetzt.
     */
    private String language = "en";

    /**
     * Creates a new LocationsNearbyRequest with the required location.
     *
     * @param location the location to search nearby (required)
     */
    public LocationsNearbyRequest(Location location) {
        this.location = location;
    }

    /**
     * Creates a new builder for LocationsNearbyRequest.
     *
     * @param location the location to search nearby (required)
     * @return a new builder instance
     */
    public static Builder builder(Location location) {
        return new Builder(location);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isPoi() {
        return poi;
    }

    public void setPoi(boolean poi) {
        this.poi = poi;
    }

    public boolean isStops() {
        return stops;
    }

    public void setStops(boolean stops) {
        this.stops = stops;
    }

    public boolean isLinesOfStops() {
        return linesOfStops;
    }

    public void setLinesOfStops(boolean linesOfStops) {
        this.linesOfStops = linesOfStops;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Builder class for LocationsNearbyRequest.
     */
    public static class Builder {
        private final LocationsNearbyRequest request;

        /**
         * Creates a new builder with the required location.
         *
         * @param location the location to search nearby
         */
        public Builder(Location location) {
            request = new LocationsNearbyRequest(location);
        }

        /**
         * Sets the maximum number of results to return.
         *
         * @param maxResults maximum number of results (default: 8)
         * @return this builder for method chaining
         */
        public Builder withMaxResults(int maxResults) {
            request.setMaxResults(maxResults);
            return this;
        }

        /**
         * Sets the maximum distance in meters.
         *
         * @param distance maximum distance in meters
         * @return this builder for method chaining
         */
        public Builder withDistance(int distance) {
            request.setDistance(distance);
            return this;
        }

        /**
         * Sets whether to include stops/stations in the results.
         *
         * @param stops true to include stops/stations, false otherwise (default: true)
         * @return this builder for method chaining
         */
        public Builder withStops(boolean stops) {
            request.setStops(stops);
            return this;
        }

        /**
         * Sets whether to include points of interest in the results.
         *
         * @param poi true to include points of interest, false otherwise (default: false)
         * @return this builder for method chaining
         */
        public Builder withPoi(boolean poi) {
            request.setPoi(poi);
            return this;
        }

        /**
         * Sets whether to include lines of stops in the results.
         * Note: This is not supported by the API.
         *
         * @param linesOfStops true to include lines of stops, false otherwise (default: false)
         * @return this builder for method chaining
         */
        public Builder withLinesOfStops(boolean linesOfStops) {
            request.setLinesOfStops(linesOfStops);
            return this;
        }

        /**
         * Sets the language for the response.
         *
         * @param language the language code (e.g., "en", "de") (default: "en")
         * @return this builder for method chaining
         */
        public Builder withLanguage(String language) {
            request.setLanguage(language);
            return this;
        }

        /**
         * Builds the LocationsNearbyRequest.
         *
         * @return the built request
         */
        public LocationsNearbyRequest build() {
            return request;
        }
    }
}
