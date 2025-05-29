package de.olech2412.dbvendowrapper.requests;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testet die LocationSearchRequest Klasse
 */
public class LocationSearchRequestTest {

    @Test
    public void testConstructorAndGetters() {
        String query = "Berlin Hbf";
        LocationSearchRequest request = new LocationSearchRequest(query);
        assertEquals("Constructor sollte query korrekt setzen", query, request.getQuery());

        // Überprüfe Standardwerte nach Konstruktion
        assertFalse("fuzzy sollte standardmäßig false sein", request.isFuzzy());
        assertEquals("maxResults sollte standardmäßig 0 sein", 0, request.getMaxResults());
        assertFalse("stops sollte standardmäßig false sein", request.isStops());
        assertFalse("addresses sollte standardmäßig false sein", request.isAddresses());
        assertFalse("poi sollte standardmäßig false sein", request.isPoi());
        assertFalse("linesOfStops sollte standardmäßig false sein", request.isLinesOfStops());
        assertNull("language sollte standardmäßig null sein", request.getLanguage());
    }

    @Test
    public void testSettersAndGetters() {
        LocationSearchRequest request = new LocationSearchRequest("test-query");

        // Test für query
        request.setQuery("new-query");
        assertEquals("query sollte korrekt gesetzt werden", "new-query", request.getQuery());

        // Test für maxResults
        request.setMaxResults(5);
        assertEquals("maxResults sollte korrekt gesetzt werden", 5, request.getMaxResults());

        // Test für boolean Werte
        request.setFuzzy(true);
        assertTrue("fuzzy sollte korrekt gesetzt werden", request.isFuzzy());

        request.setStops(true);
        assertTrue("stops sollte korrekt gesetzt werden", request.isStops());

        request.setAddresses(true);
        assertTrue("addresses sollte korrekt gesetzt werden", request.isAddresses());

        request.setPoi(true);
        assertTrue("poi sollte korrekt gesetzt werden", request.isPoi());

        request.setLinesOfStops(true);
        assertTrue("linesOfStops sollte korrekt gesetzt werden", request.isLinesOfStops());

        // Test für language
        request.setLanguage("de");
        assertEquals("language sollte korrekt gesetzt werden", "de", request.getLanguage());
    }

    @Test
    public void testNullValues() {
        LocationSearchRequest request = new LocationSearchRequest("test");

        request.setQuery(null);
        assertNull("query sollte null sein können", request.getQuery());

        request.setLanguage(null);
        assertNull("language sollte null sein können", request.getLanguage());
    }

    @Test
    public void testEdgeCases() {
        LocationSearchRequest request = new LocationSearchRequest("test");

        // Test negative Werte
        request.setMaxResults(-1);
        assertEquals("Negative maxResults sollte möglich sein", -1, request.getMaxResults());

        // Test leere Strings
        request.setQuery("");
        assertEquals("Leere query sollte möglich sein", "", request.getQuery());

        request.setLanguage("");
        assertEquals("Leere language sollte möglich sein", "", request.getLanguage());
    }

    @Test
    public void testDBVendoRequestImplementation() {
        LocationSearchRequest request = new LocationSearchRequest("test");
        assertTrue("Sollte DBVendoRequest implementieren", request instanceof DBVendoRequest);
    }
}

