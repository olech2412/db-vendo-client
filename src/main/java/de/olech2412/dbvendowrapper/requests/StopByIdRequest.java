package de.olech2412.dbvendowrapper.requests;

/**
 * StopByIdReqeuest can find a stop by its ID.
 *
 * @author olech2412
 */
public class StopByIdRequest implements DBVendoRequest {

    private String stopId;

    private boolean linesOfStops;

    private String language;

    public StopByIdRequest(String stopId) {
        this.stopId = stopId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
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
