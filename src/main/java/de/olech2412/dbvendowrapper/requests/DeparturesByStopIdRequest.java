package de.olech2412.dbvendowrapper.requests;

import de.olech2412.dbvendowrapper.model.ProfileSpecificProducts;

import java.time.OffsetDateTime;

/**
 * <h1>Request-Klasse für Abfahrtszeiten einer Haltestelle</h1>
 *
 * <p>Diese Klasse ermöglicht die Abfrage von Abfahrtszeiten an einer bestimmten Haltestelle
 * mit verschiedenen Filteroptionen und Konfigurationsmöglichkeiten.</p>
 *
 * <h2>Hauptfunktionen:</h2>
 * <ul>
 *   <li>Abfrage von Abfahrtszeiten für eine spezifische Haltestellen-ID</li>
 *   <li>Zeitliche Einschränkungen:
 *     <ul>
 *       <li>Abfahrtszeit ({@code departureTime})</li>
 *       <li>Betrachtungszeitraum ({@code duration})</li>
 *     </ul>
 *   </li>
 *   <li>Filteroptionen:
 *     <ul>
 *       <li>Richtungsfilter ({@code direction})</li>
 *       <li>Verkehrsmittelfilter ({@code profileSpecificProducts})</li>
 *       <li>Maximale Anzahl Ergebnisse ({@code maxResults})</li>
 *     </ul>
 *   </li>
 *   <li>Zusätzliche Informationen:
 *     <ul>
 *       <li>Linieninformationen ({@code linesOfStops})</li>
 *       <li>Störungsmeldungen ({@code remarks})</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <h2>Anwendungsfälle:</h2>
 * <ul>
 *   <li>Anzeige von Abfahrtstafeln</li>
 *   <li>Fahrplanauskunft an Haltestellen</li>
 *   <li>Echtzeitinformationen zu Abfahrten</li>
 * </ul>
 *
 * @author olech2412
 * @version 1.0
 * @see DBVendoRequest
 * @see ProfileSpecificProducts
 */
public class DeparturesByStopIdRequest implements DBVendoRequest {

    private String stopId;

    private OffsetDateTime departureTime;

    private String direction;

    private int duration;

    private int maxResults;

    private boolean linesOfStops;

    private boolean remarks;

    private ProfileSpecificProducts profileSpecificProducts;

    private String language;

    public DeparturesByStopIdRequest(String stopId) {
        this.stopId = stopId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public OffsetDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(OffsetDateTime departureTime) {
        this.departureTime = departureTime;
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
