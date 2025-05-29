package de.olech2412.dbvendowrapper.requests;

import de.olech2412.dbvendowrapper.model.Location;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testet die LocationsNearbyRequest Klasse
 */
public class LocationsNearbyRequestTest {

    @Test
    public void testConstructorAndGetters() {
        Location location = new Location();
        LocationsNearbyRequest request = new LocationsNearbyRequest(location);
        assertEquals("Constructor sollte location korrekt setzen", location, request.getLocation());

        // Überprüfe Standardwerte nach Konstruktion
        assertEquals("maxResults sollte standardmäßig 8 sein", 8, request.getMaxResults());
        assertEquals("distance sollte standardmäßig 0 sein", 0, request.getDistance());
        assertTrue("stops sollte standardmäßig true sein", request.isStops());
        assertFalse("poi sollte standardmäßig false sein", request.isPoi());
        assertFalse("linesOfStops sollte standardmäßig false sein", request.isLinesOfStops());
        assertEquals("language sollte standardmäßig 'en' sein", "en", request.getLanguage());
    }

    @Test
    public void testSettersAndGetters() {
        LocationsNearbyRequest request = new LocationsNearbyRequest(new Location());

        // Test für location
        Location newLocation = new Location();
        request.setLocation(newLocation);
        assertEquals("location sollte korrekt gesetzt werden", newLocation, request.getLocation());

        // Test für maxResults
        request.setMaxResults(10);
        assertEquals("maxResults sollte korrekt gesetzt werden", 10, request.getMaxResults());

        // Test für distance
        request.setDistance(500);
        assertEquals("distance sollte korrekt gesetzt werden", 500, request.getDistance());

        // Test für boolean Werte
        request.setStops(false);
        assertFalse("stops sollte korrekt gesetzt werden", request.isStops());

        request.setPoi(true);
        assertTrue("poi sollte korrekt gesetzt werden", request.isPoi());

        request.setLinesOfStops(true);
        assertTrue("linesOfStops sollte korrekt gesetzt werden", request.isLinesOfStops());

        // Test für language
        request.setLanguage("de");
        assertEquals("language sollte korrekt gesetzt werden", "de", request.getLanguage());
    }

    @Test
    public void testBuilderPattern() {
        Location location = new Location();
        LocationsNearbyRequest request = LocationsNearbyRequest.builder(location)
                .withMaxResults(15)
                .withDistance(1000)
                .withStops(false)
                .withPoi(true)
                .withLinesOfStops(true)
                .withLanguage("de")
                .build();

        assertEquals("Builder sollte location korrekt setzen", location, request.getLocation());
        assertEquals("Builder sollte maxResults korrekt setzen", 15, request.getMaxResults());
        assertEquals("Builder sollte distance korrekt setzen", 1000, request.getDistance());
        assertFalse("Builder sollte stops korrekt setzen", request.isStops());
        assertTrue("Builder sollte poi korrekt setzen", request.isPoi());
        assertTrue("Builder sollte linesOfStops korrekt setzen", request.isLinesOfStops());
        assertEquals("Builder sollte language korrekt setzen", "de", request.getLanguage());
    }

    @Test
    public void testNullValues() {
        LocationsNearbyRequest request = new LocationsNearbyRequest(new Location());

        request.setLocation(null);
        assertNull("location sollte null sein können", request.getLocation());

        request.setLanguage(null);
        assertNull("language sollte null sein können", request.getLanguage());
    }

    @Test
    public void testEdgeCases() {
        LocationsNearbyRequest request = new LocationsNearbyRequest(new Location());

        // Test negative Werte
        request.setMaxResults(-1);
        assertEquals("Negative maxResults sollte möglich sein", -1, request.getMaxResults());

        request.setDistance(-1);
        assertEquals("Negative distance sollte möglich sein", -1, request.getDistance());

        // Test leere Strings
        request.setLanguage("");
        assertEquals("Leere language sollte möglich sein", "", request.getLanguage());
    }

    @Test
    public void testDBVendoRequestImplementation() {
        LocationsNearbyRequest request = new LocationsNearbyRequest(new Location());
        assertTrue("Sollte DBVendoRequest implementieren", request instanceof DBVendoRequest);
    }
}
