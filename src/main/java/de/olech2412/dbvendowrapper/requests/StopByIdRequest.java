package de.olech2412.dbvendowrapper.requests;

/**
 * Request-Klasse für die Abfrage von Haltestelleninformationen anhand einer spezifischen ID.
 * Diese Klasse ermöglicht es, detaillierte Informationen zu einer einzelnen Haltestelle
 * im DB-System abzurufen.
 *
 * Die Klasse unterstützt folgende Hauptfunktionen:
 * - Abruf von Haltestellendaten mittels eindeutiger ID
 * - Optionale Einbeziehung von Linieninformationen
 * - Sprachspezifische Ausgabe der Informationen
 *
 * Anwendungsfälle:
 * - Detailansicht einer Haltestelle
 * - Anzeige von verfügbaren Linien an einer Haltestelle
 * - Integration in mehrsprachige Benutzeroberflächen
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
