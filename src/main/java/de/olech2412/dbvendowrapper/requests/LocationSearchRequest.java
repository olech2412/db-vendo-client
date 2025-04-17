package de.olech2412.dbvendowrapper.requests;


/**
 * This class represents a request to search for locations.
 * It implements the DBVendoRequest interface.
 *
 * @author olech2412
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

    public LocationSearchRequest(String query) {
        this.query = query;
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
