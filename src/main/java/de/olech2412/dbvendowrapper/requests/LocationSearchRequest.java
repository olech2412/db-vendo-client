package de.olech2412.dbvendowrapper.requests;

/**
 * <h1>Request-Klasse für Standortsuche</h1>
 *
 * <p>Diese Klasse ermöglicht eine flexible Suche nach verschiedenen Arten von Standorten
 * wie Haltestellen, Adressen und Points of Interest im DB-System.</p>
 *
 * <h2>Hauptfunktionen:</h2>
 * <ul>
 *   <li>Textbasierte Suche nach Standorten</li>
 *   <li>Unscharfe Suche (Fuzzy-Search) für bessere Suchergebnisse</li>
 *   <li>Filterung nach Standorttypen:
 *     <ul>
 *       <li>Haltestellen ({@code stops})</li>
 *       <li>Adressen ({@code addresses})</li>
 *       <li>POIs ({@code poi})</li>
 *     </ul>
 *   </li>
 *   <li>Begrenzung der Ergebnisanzahl ({@code maxResults})</li>
 * </ul>
 *
 * <h2>Anwendungsfälle:</h2>
 * <ul>
 *   <li>Autovervollständigung in Suchfeldern</li>
 *   <li>Validierung von Benutzerstandorteingaben</li>
 *   <li>Standortbasierte Dienste</li>
 * </ul>
 *
 * @author olech2412
 * @version 1.0
 * @see DBVendoRequest
 */
public class LocationSearchRequest implements DBVendoRequest {

    private String query;

    private boolean fuzzy;

    private int maxResults;

    private boolean stops;

    private boolean addresses;

    private boolean poi;

    private boolean linesOfStops;

    private String language;

    public LocationSearchRequest(String query, int maxResults) {
        this.query = query;
        this.maxResults = maxResults;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public boolean isFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(boolean fuzzy) {
        this.fuzzy = fuzzy;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public boolean isStops() {
        return stops;
    }

    public void setStops(boolean stops) {
        this.stops = stops;
    }

    public boolean isAddresses() {
        return addresses;
    }

    public void setAddresses(boolean addresses) {
        this.addresses = addresses;
    }

    public boolean isPoi() {
        return poi;
    }

    public void setPoi(boolean poi) {
        this.poi = poi;
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
}
