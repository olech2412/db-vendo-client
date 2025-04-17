package de.olech2412.dbvendowrapper.requests;


/**
 * This class represents a request to get trip details by trip ID.
 * It implements the DBVendoRequest interface.
 *
 * @author olech2412
 */
public class TripByIdRequest implements DBVendoRequest {

    private String tripId;

    private boolean stopOvers;

    private boolean remarks;

    private boolean polyline;

    private String language;

    public TripByIdRequest(String tripId) {
        this.tripId = tripId;
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
}
