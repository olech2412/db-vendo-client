package de.olech2412.dbvendoclient.requests;


import de.olech2412.dbvendoclient.model.Location;

/**
 * This class represents a request to get locations nearby.
 * It implements the DBVendoRequest interface.
 *
 * @author olech2412
 */
public class LocationsNearbyRequest implements DBVendoRequest {

    private Location location;

    private int maxResults;

    private int distance;

    private boolean stops;

    private boolean poi;

    private boolean linesOfStops;

    private String language;

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
}
