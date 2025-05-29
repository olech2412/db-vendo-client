package de.olech2412.dbvendowrapper.requests;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testet die StopByIdRequest Klasse
 */
public class StopByIdRequestTest {

    @Test
    public void testConstructorAndGetters() {
        String stopId = "8098096";
        StopByIdRequest request = new StopByIdRequest(stopId);
        assertEquals("Constructor sollte stopId korrekt setzen", stopId, request.getStopId());

        // Überprüfe Standardwerte nach Konstruktion
        assertFalse("linesOfStops sollte standardmäßig false sein", request.isLinesOfStops());
        assertNull("language sollte standardmäßig null sein", request.getLanguage());
    }

    @Test
    public void testSettersAndGetters() {
        StopByIdRequest request = new StopByIdRequest("stop1");

        // Test für stopId
        request.setStopId("stop2");
        assertEquals("stopId sollte korrekt gesetzt werden", "stop2", request.getStopId());

        // Test für linesOfStops
        request.setLinesOfStops(true);
        assertTrue("linesOfStops sollte korrekt gesetzt werden", request.isLinesOfStops());

        // Test für language
        request.setLanguage("de");
        assertEquals("language sollte korrekt gesetzt werden", "de", request.getLanguage());
    }

    @Test
    public void testNullValues() {
        StopByIdRequest request = new StopByIdRequest("test");

        request.setStopId(null);
        assertNull("stopId sollte null sein können", request.getStopId());

        request.setLanguage(null);
        assertNull("language sollte null sein können", request.getLanguage());
    }

    @Test
    public void testEdgeCases() {
        StopByIdRequest request = new StopByIdRequest("test");

        // Test leere Strings
        request.setStopId("");
        assertEquals("Leere stopId sollte möglich sein", "", request.getStopId());

        request.setLanguage("");
        assertEquals("Leere language sollte möglich sein", "", request.getLanguage());
    }

    @Test
    public void testDBVendoRequestImplementation() {
        StopByIdRequest request = new StopByIdRequest("test");
        assertTrue("Sollte DBVendoRequest implementieren", request instanceof DBVendoRequest);
    }
}

