package de.olech2412.dbvendowrapper.requests;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testet die JourneyByRefreshTokenRequest Klasse
 */
public class JourneyByRefreshTokenRequestTest {

    @Test
    public void testConstructorAndGetters() {
        String refreshToken = "test-token-123";
        JourneyByRefreshTokenRequest request = new JourneyByRefreshTokenRequest(refreshToken);
        assertEquals("Constructor sollte refreshToken korrekt setzen", refreshToken, request.getRefreshToken());

        // Überprüfe Standardwerte nach Konstruktion
        assertFalse("stopOvers sollte standardmäßig false sein", request.isStopOvers());
        assertFalse("tickets sollte standardmäßig false sein", request.isTickets());
        assertFalse("polylines sollte standardmäßig false sein", request.isPolylines());
        assertFalse("subStops sollte standardmäßig false sein", request.isSubStops());
        assertFalse("entrances sollte standardmäßig false sein", request.isEntrances());
        assertFalse("remarks sollte standardmäßig false sein", request.isRemarks());
        assertFalse("scheduledDays sollte standardmäßig false sein", request.isScheduledDays());
        assertFalse("notOnlyFastRoutes sollte standardmäßig false sein", request.isNotOnlyFastRoutes());
        assertFalse("bestPrice sollte standardmäßig false sein", request.isBestPrice());
        assertNull("language sollte standardmäßig null sein", request.getLanguage());
    }

    @Test
    public void testSettersAndGetters() {
        JourneyByRefreshTokenRequest request = new JourneyByRefreshTokenRequest("token1");

        // Test für refreshToken
        request.setRefreshToken("token2");
        assertEquals("refreshToken sollte korrekt gesetzt werden", "token2", request.getRefreshToken());

        // Test für boolean Werte
        request.setStopOvers(true);
        assertTrue("stopOvers sollte korrekt gesetzt werden", request.isStopOvers());

        request.setTickets(true);
        assertTrue("tickets sollte korrekt gesetzt werden", request.isTickets());

        request.setPolylines(true);
        assertTrue("polylines sollte korrekt gesetzt werden", request.isPolylines());

        request.setSubStops(true);
        assertTrue("subStops sollte korrekt gesetzt werden", request.isSubStops());

        request.setEntrances(true);
        assertTrue("entrances sollte korrekt gesetzt werden", request.isEntrances());

        request.setRemarks(true);
        assertTrue("remarks sollte korrekt gesetzt werden", request.isRemarks());

        request.setScheduledDays(true);
        assertTrue("scheduledDays sollte korrekt gesetzt werden", request.isScheduledDays());

        request.setNotOnlyFastRoutes(true);
        assertTrue("notOnlyFastRoutes sollte korrekt gesetzt werden", request.isNotOnlyFastRoutes());

        request.setBestPrice(true);
        assertTrue("bestPrice sollte korrekt gesetzt werden", request.isBestPrice());

        // Test für language
        request.setLanguage("de");
        assertEquals("language sollte korrekt gesetzt werden", "de", request.getLanguage());
    }

    @Test
    public void testNullValues() {
        JourneyByRefreshTokenRequest request = new JourneyByRefreshTokenRequest("test");

        request.setRefreshToken(null);
        assertNull("refreshToken sollte null sein können", request.getRefreshToken());

        request.setLanguage(null);
        assertNull("language sollte null sein können", request.getLanguage());
    }

    @Test
    public void testEdgeCases() {
        JourneyByRefreshTokenRequest request = new JourneyByRefreshTokenRequest("test");

        // Test leere Strings
        request.setRefreshToken("");
        assertEquals("Leerer refreshToken sollte möglich sein", "", request.getRefreshToken());

        request.setLanguage("");
        assertEquals("Leere language sollte möglich sein", "", request.getLanguage());
    }

    @Test
    public void testDBVendoRequestImplementation() {
        JourneyByRefreshTokenRequest request = new JourneyByRefreshTokenRequest("test");
        assertTrue("Sollte DBVendoRequest implementieren", request instanceof DBVendoRequest);
    }
}

