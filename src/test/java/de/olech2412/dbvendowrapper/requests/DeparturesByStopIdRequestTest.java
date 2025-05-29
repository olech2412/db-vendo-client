package de.olech2412.dbvendowrapper.requests;

import de.olech2412.dbvendowrapper.model.ProfileSpecificProducts;
import org.junit.Test;

import java.time.OffsetDateTime;

import static org.junit.Assert.*;

/**
 * Testet die DeparturesByStopIdRequest Klasse
 */
public class DeparturesByStopIdRequestTest {

    @Test
    public void testConstructorAndGetters() {
        String stopId = "12345";
        DeparturesByStopIdRequest request = new DeparturesByStopIdRequest(stopId);
        assertEquals("Constructor sollte stopId korrekt setzen", stopId, request.getStopId());

        // Überprüfe Standardwerte nach Konstruktion
        assertNull("departureTime sollte standardmäßig null sein", request.getDepartureTime());
        assertNull("direction sollte standardmäßig null sein", request.getDirection());
        assertEquals("duration sollte standardmäßig 0 sein", 0, request.getDuration());
        assertEquals("maxResults sollte standardmäßig 0 sein", 0, request.getMaxResults());
        assertFalse("linesOfStops sollte standardmäßig false sein", request.isLinesOfStops());
        assertFalse("remarks sollte standardmäßig false sein", request.isRemarks());
        assertNull("profileSpecificProducts sollte standardmäßig null sein", request.getProfileSpecificProducts());
        assertNull("language sollte standardmäßig null sein", request.getLanguage());
    }

    @Test
    public void testSettersAndGetters() {
        DeparturesByStopIdRequest request = new DeparturesByStopIdRequest("stop1");

        // Test für stopId
        request.setStopId("stop2");
        assertEquals("stopId sollte korrekt gesetzt werden", "stop2", request.getStopId());

        // Test für departureTime
        OffsetDateTime now = OffsetDateTime.now();
        request.setDepartureTime(now);
        assertEquals("departureTime sollte korrekt gesetzt werden", now, request.getDepartureTime());

        // Test für direction
        request.setDirection("north");
        assertEquals("direction sollte korrekt gesetzt werden", "north", request.getDirection());

        // Test für duration
        request.setDuration(15);
        assertEquals("duration sollte korrekt gesetzt werden", 15, request.getDuration());

        // Test für maxResults
        request.setMaxResults(10);
        assertEquals("maxResults sollte korrekt gesetzt werden", 10, request.getMaxResults());

        // Test für linesOfStops
        request.setLinesOfStops(true);
        assertTrue("linesOfStops sollte korrekt gesetzt werden", request.isLinesOfStops());

        // Test für remarks
        request.setRemarks(true);
        assertTrue("remarks sollte korrekt gesetzt werden", request.isRemarks());

        // Test für profileSpecificProducts
        ProfileSpecificProducts products = new ProfileSpecificProducts();
        request.setProfileSpecificProducts(products);
        assertEquals("profileSpecificProducts sollte korrekt gesetzt werden", products, request.getProfileSpecificProducts());

        // Test für language
        request.setLanguage("de");
        assertEquals("language sollte korrekt gesetzt werden", "de", request.getLanguage());
    }

    @Test
    public void testNullValues() {
        DeparturesByStopIdRequest request = new DeparturesByStopIdRequest("test");

        request.setStopId(null);
        assertNull("stopId sollte null sein können", request.getStopId());

        request.setDepartureTime(null);
        assertNull("departureTime sollte null sein können", request.getDepartureTime());

        request.setDirection(null);
        assertNull("direction sollte null sein können", request.getDirection());

        request.setProfileSpecificProducts(null);
        assertNull("profileSpecificProducts sollte null sein können", request.getProfileSpecificProducts());

        request.setLanguage(null);
        assertNull("language sollte null sein können", request.getLanguage());
    }

    @Test
    public void testEdgeCases() {
        DeparturesByStopIdRequest request = new DeparturesByStopIdRequest("test");

        // Test negative Werte
        request.setDuration(-1);
        assertEquals("Negative duration sollte möglich sein", -1, request.getDuration());

        request.setMaxResults(-1);
        assertEquals("Negative maxResults sollte möglich sein", -1, request.getMaxResults());

        // Test leere Strings
        request.setStopId("");
        assertEquals("Leere stopId sollte möglich sein", "", request.getStopId());

        request.setDirection("");
        assertEquals("Leere direction sollte möglich sein", "", request.getDirection());

        request.setLanguage("");
        assertEquals("Leere language sollte möglich sein", "", request.getLanguage());
    }

    @Test
    public void testDBVendoRequestImplementation() {
        DeparturesByStopIdRequest request = new DeparturesByStopIdRequest("test");
        assertTrue("Sollte DBVendoRequest implementieren", request instanceof DBVendoRequest);
    }
}

