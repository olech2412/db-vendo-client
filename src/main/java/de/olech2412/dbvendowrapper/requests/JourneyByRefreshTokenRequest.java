package de.olech2412.dbvendowrapper.requests;


/**
 * This class represents a request to get journey details using a refresh token.
 * It implements the DBVendoRequest interface.
 *
 * @author olech2412
 */
public class JourneyByRefreshTokenRequest implements DBVendoRequest {

    private String refreshToken;

    private boolean stopOvers;

    private boolean tickets;

    private boolean polylines;

    private boolean subStops;

    private boolean entrances;

    private boolean remarks;

    private boolean scheduledDays;

    private boolean notOnlyFastRoutes;

    private boolean bestPrice;

    private String language;

    public JourneyByRefreshTokenRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public boolean isStopOvers() {
        return stopOvers;
    }

    public void setStopOvers(boolean stopOvers) {
        this.stopOvers = stopOvers;
    }

    public boolean isTickets() {
        return tickets;
    }

    public void setTickets(boolean tickets) {
        this.tickets = tickets;
    }

    public boolean isPolylines() {
        return polylines;
    }

    public void setPolylines(boolean polylines) {
        this.polylines = polylines;
    }

    public boolean isSubStops() {
        return subStops;
    }

    public void setSubStops(boolean subStops) {
        this.subStops = subStops;
    }

    public boolean isEntrances() {
        return entrances;
    }

    public void setEntrances(boolean entrances) {
        this.entrances = entrances;
    }

    public boolean isRemarks() {
        return remarks;
    }

    public void setRemarks(boolean remarks) {
        this.remarks = remarks;
    }

    public boolean isScheduledDays() {
        return scheduledDays;
    }

    public void setScheduledDays(boolean scheduledDays) {
        this.scheduledDays = scheduledDays;
    }

    public boolean isNotOnlyFastRoutes() {
        return notOnlyFastRoutes;
    }

    public void setNotOnlyFastRoutes(boolean notOnlyFastRoutes) {
        this.notOnlyFastRoutes = notOnlyFastRoutes;
    }

    public boolean isBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(boolean bestPrice) {
        this.bestPrice = bestPrice;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
