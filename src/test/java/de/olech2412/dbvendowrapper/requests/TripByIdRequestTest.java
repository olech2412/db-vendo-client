package de.olech2412.dbvendowrapper.requests;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testet die TripByIdRequest Klasse
 */
public class TripByIdRequestTest {

    @Test
    public void testConstructorAndGetters() {
        String tripId = "1|123|0|80|28052025";
        TripByIdRequest request = new TripByIdRequest(tripId);
        assertEquals("Constructor sollte tripId korrekt setzen", tripId, request.getTripId());

        // Überprüfe Standardwerte nach Konstruktion
        assertFalse("stopOvers sollte standardmäßig false sein", request.isStopOvers());
        assertFalse("remarks sollte standardmäßig false sein", request.isRemarks());
        assertFalse("polyline sollte standardmäßig false sein", request.isPolyline());
        assertNull("language sollte standardmäßig null sein", request.getLanguage());
    }

    @Test
    public void testSettersAndGetters() {
        TripByIdRequest request = new TripByIdRequest("trip1");

        // Test für tripId
        request.setTripId("trip2");
        assertEquals("tripId sollte korrekt gesetzt werden", "trip2", request.getTripId());

        // Test für boolean Werte
        request.setStopOvers(true);
        assertTrue("stopOvers sollte korrekt gesetzt werden", request.isStopOvers());

        request.setRemarks(true);
        assertTrue("remarks sollte korrekt gesetzt werden", request.isRemarks());

        request.setPolyline(true);
        assertTrue("polyline sollte korrekt gesetzt werden", request.isPolyline());

        // Test für language
        request.setLanguage("de");
        assertEquals("language sollte korrekt gesetzt werden", "de", request.getLanguage());
    }

    @Test
    public void testBuilderPattern() {
        String tripId = "trip123";
        TripByIdRequest request = TripByIdRequest.builder(tripId)
                .withStopOvers(true)
                .withRemarks(true)
                .withPolyline(true)
                .withLanguage("de")
                .build();

        assertEquals("Builder sollte tripId korrekt setzen", tripId, request.getTripId());
        assertTrue("Builder sollte stopOvers korrekt setzen", request.isStopOvers());
        assertTrue("Builder sollte remarks korrekt setzen", request.isRemarks());
        assertTrue("Builder sollte polyline korrekt setzen", request.isPolyline());
        assertEquals("Builder sollte language korrekt setzen", "de", request.getLanguage());
    }

    @Test
    public void testNullValues() {
        TripByIdRequest request = new TripByIdRequest("test");

        request.setTripId(null);
        assertNull("tripId sollte null sein können", request.getTripId());

        request.setLanguage(null);
        assertNull("language sollte null sein können", request.getLanguage());
    }

    @Test
    public void testEdgeCases() {
        TripByIdRequest request = new TripByIdRequest("test");

        // Test leere Strings
        request.setTripId("");
        assertEquals("Leere tripId sollte möglich sein", "", request.getTripId());

        request.setLanguage("");
        assertEquals("Leere language sollte möglich sein", "", request.getLanguage());
    }

    @Test
    public void testDBVendoRequestImplementation() {
        TripByIdRequest request = new TripByIdRequest("test");
        assertTrue("Sollte DBVendoRequest implementieren", request instanceof DBVendoRequest);
    }
}
