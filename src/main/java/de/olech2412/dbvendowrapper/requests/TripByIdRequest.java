package de.olech2412.dbvendowrapper.requests;

/**
 * <h1>Request-Klasse für Fahrtdetails</h1>
 *
 * <p>Diese Klasse ermöglicht es, detaillierte Informationen zu einer spezifischen Fahrt
 * im DB-System anhand einer Trip-ID abzurufen.</p>
 *
 * <h2>Hauptfunktionen:</h2>
 * <ul>
 *   <li>Abruf von Fahrtdetails mittels eindeutiger Trip-ID</li>
 *   <li>Konfigurierbare Detailtiefe der Ergebnisse:
 *     <ul>
 *       <li>Zwischenhalte ({@code stopOvers})</li>
 *       <li>Hinweise und Störungen ({@code remarks})</li>
 *       <li>Streckenverlauf ({@code polyline})</li>
 *     </ul>
 *   </li>
 *   <li>Mehrsprachige Ausgabe der Informationen</li>
 * </ul>
 *
 * <h2>Anwendungsfälle:</h2>
 * <ul>
 *   <li>Detailansicht einer Fahrt</li>
 *   <li>Anzeige von Zwischenhalten</li>
 *   <li>Visualisierung des Streckenverlaufs</li>
 *   <li>Anzeige von aktuellen Störungen</li>
 * </ul>
 *
 * @author olech2412
 * @version 1.0
 * @see DBVendoRequest
 */
public class TripByIdRequest implements DBVendoRequest {

    private String tripId;

    private boolean stopOvers;

    private boolean remarks;

    private boolean polyline;

    private String language;

    /**
     * Creates a new TripByIdRequest with the required tripId.
     *
     * @param tripId the ID of the trip to retrieve
     */
    public TripByIdRequest(String tripId) {
        this.tripId = tripId;
    }

    /**
     * Creates a new builder for TripByIdRequest.
     *
     * @param tripId the ID of the trip to retrieve (required)
     * @return a new builder instance
     */
    public static Builder builder(String tripId) {
        return new Builder(tripId);
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public boolean isStopOvers() {
        return stopOvers;
    }

    public void setStopOvers(boolean stopOvers) {
        this.stopOvers = stopOvers;
    }

    public boolean isRemarks() {
        return remarks;
    }

    public void setRemarks(boolean remarks) {
        this.remarks = remarks;
    }

    public boolean isPolyline() {
        return polyline;
    }

    public void setPolyline(boolean polyline) {
        this.polyline = polyline;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Builder class for TripByIdRequest.
     */
    public static class Builder {
        private final TripByIdRequest request;

        /**
         * Creates a new builder with the required tripId.
         *
         * @param tripId the ID of the trip to retrieve
         */
        public Builder(String tripId) {
            request = new TripByIdRequest(tripId);
        }

        /**
         * Sets whether to include stop overs in the response.
         *
         * @param stopOvers true to include stop overs, false otherwise
         * @return this builder for method chaining
         */
        public Builder withStopOvers(boolean stopOvers) {
            request.setStopOvers(stopOvers);
            return this;
        }

        /**
         * Sets whether to include remarks in the response.
         *
         * @param remarks true to include remarks, false otherwise
         * @return this builder for method chaining
         */
        public Builder withRemarks(boolean remarks) {
            request.setRemarks(remarks);
            return this;
        }

        /**
         * Sets whether to include polyline in the response.
         *
         * @param polyline true to include polyline, false otherwise
         * @return this builder for method chaining
         */
        public Builder withPolyline(boolean polyline) {
            request.setPolyline(polyline);
            return this;
        }

        /**
         * Sets the language for the response.
         *
         * @param language the language code (e.g., "en", "de")
         * @return this builder for method chaining
         */
        public Builder withLanguage(String language) {
            request.setLanguage(language);
            return this;
        }

        /**
         * Builds the TripByIdRequest.
         *
         * @return the built request
         */
        public TripByIdRequest build() {
            return request;
        }
    }
}
