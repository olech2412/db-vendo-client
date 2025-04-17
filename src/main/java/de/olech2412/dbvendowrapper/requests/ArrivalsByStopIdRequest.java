package de.olech2412.dbvendowrapper.requests;

import de.olech2412.dbvendowrapper.model.ProfileSpecificProducts;

import java.time.OffsetDateTime;

/**
 * This class represents a request to get arrivals by stop ID.
 * It implements the DBVendoRequest interface.
 *
 * @author olech2412
 */
public class ArrivalsByStopIdRequest implements DBVendoRequest {

    private String stopId;

    private OffsetDateTime arrivalTime;

    private String direction;

    private int duration;

    private int maxResults;

    private boolean linesOfStops;

    private boolean remarks;

    private ProfileSpecificProducts profileSpecificProducts;

    private String language;

    public ArrivalsByStopIdRequest(String stopId) {
        this.stopId = stopId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public OffsetDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(OffsetDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public boolean isLinesOfStops() {
        return linesOfStops;
    }

    public void setLinesOfStops(boolean linesOfStops) {
        this.linesOfStops = linesOfStops;
    }

    public boolean isRemarks() {
        return remarks;
    }

    public void setRemarks(boolean remarks) {
        this.remarks = remarks;
    }

    public ProfileSpecificProducts getProfileSpecificProducts() {
        return profileSpecificProducts;
    }

    public void setProfileSpecificProducts(ProfileSpecificProducts profileSpecificProducts) {
        this.profileSpecificProducts = profileSpecificProducts;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
