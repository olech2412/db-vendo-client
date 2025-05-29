package de.olech2412.dbvendowrapper.requests;

import de.olech2412.dbvendowrapper.model.ProfileSpecificProducts;
import de.olech2412.dbvendowrapper.requests.JourneySearchRequest;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.Assert.*;

/**
 * Testet die JourneySearchRequest Klasse
 */
public class JourneySearchRequestTest {

    @Test
    public void testConstructorAndDefaultValues() {
        JourneySearchRequest request = new JourneySearchRequest();

        // Überprüfe Standardwerte nach Konstruktion
        assertNull("from sollte standardmäßig null sein", request.getFrom());
        assertNull("fromId sollte standardmäßig null sein", request.getFromId());
        assertNull("fromAddress sollte standardmäßig null sein", request.getFromAddress());
        assertNull("fromLatitude sollte standardmäßig null sein", request.getFromLatitude());
        assertNull("fromLongitude sollte standardmäßig null sein", request.getFromLongitude());

        assertNull("to sollte standardmäßig null sein", request.getTo());
        assertNull("toId sollte standardmäßig null sein", request.getToId());
        assertNull("toAddress sollte standardmäßig null sein", request.getToAddress());
        assertNull("toLatitude sollte standardmäßig null sein", request.getToLatitude());
        assertNull("toLongitude sollte standardmäßig null sein", request.getToLongitude());

        assertNull("departure sollte standardmäßig null sein", request.getDeparture());
        assertNull("arrival sollte standardmäßig null sein", request.getArrival());
        assertNull("earlierThen sollte standardmäßig null sein", request.getEarlierThen());
        assertNull("laterThen sollte standardmäßig null sein", request.getLaterThen());

        assertEquals("maxResults sollte standardmäßig 0 sein", 0, request.getMaxResults());
        assertEquals("maxTransfers sollte standardmäßig 0 sein", 0, request.getMaxTransfers());
        assertEquals("minimumTransferTime sollte standardmäßig 0 sein", 0, request.getMinimumTransferTime());
        assertEquals("age sollte standardmäßig 0 sein", 0, request.getAge());

        assertFalse("stopOvers sollte standardmäßig false sein", request.isStopOvers());
        assertFalse("bikeFriendly sollte standardmäßig false sein", request.isBikeFriendly());
        assertFalse("startWithWalking sollte standardmäßig false sein", request.isStartWithWalking());
        assertFalse("tickets sollte standardmäßig false sein", request.isTickets());
        assertFalse("polylines sollte standardmäßig false sein", request.isPolylines());
        assertFalse("subStops sollte standardmäßig false sein", request.isSubStops());
        assertFalse("entrances sollte standardmäßig false sein", request.isEntrances());
        assertFalse("remarks sollte standardmäßig false sein", request.isRemarks());
        assertFalse("scheduledDays sollte standardmäßig false sein", request.isScheduledDays());
        assertFalse("notOnlyFastRoutes sollte standardmäßig false sein", request.isNotOnlyFastRoutes());
        assertFalse("bestPrice sollte standardmäßig false sein", request.isBestPrice());
        assertFalse("firstClass sollte standardmäßig false sein", request.isFirstClass());
    }

    @Test
    public void testSettersAndGetters() {
        JourneySearchRequest request = new JourneySearchRequest();

        request.setFrom("A");
        assertEquals("A", request.getFrom());

        request.setFromId("fromId");
        assertEquals("fromId", request.getFromId());

        request.setFromAddress("fromAddress");
        assertEquals("fromAddress", request.getFromAddress());

        BigDecimal fromLat = new BigDecimal("52.1");
        request.setFromLatitude(fromLat);
        assertEquals(fromLat, request.getFromLatitude());

        BigDecimal fromLon = new BigDecimal("13.2");
        request.setFromLongitude(fromLon);
        assertEquals(fromLon, request.getFromLongitude());

        request.setTo("B");
        assertEquals("B", request.getTo());

        request.setToId("toId");
        assertEquals("toId", request.getToId());

        request.setToAddress("toAddress");
        assertEquals("toAddress", request.getToAddress());

        BigDecimal toLat = new BigDecimal("48.1");
        request.setToLatitude(toLat);
        assertEquals(toLat, request.getToLatitude());

        BigDecimal toLon = new BigDecimal("11.5");
        request.setToLongitude(toLon);
        assertEquals(toLon, request.getToLongitude());

        OffsetDateTime dep = OffsetDateTime.now();
        request.setDeparture(dep);
        assertEquals(dep, request.getDeparture());

        OffsetDateTime arr = OffsetDateTime.now();
        request.setArrival(arr);
        assertEquals(arr, request.getArrival());

        request.setEarlierThen("earlier");
        assertEquals("earlier", request.getEarlierThen());

        request.setLaterThen("later");
        assertEquals("later", request.getLaterThen());

        request.setMaxResults(10);
        assertEquals(10, request.getMaxResults());

        request.setStopOvers(true);
        assertTrue(request.isStopOvers());

        request.setMaxTransfers(2);
        assertEquals(2, request.getMaxTransfers());

        request.setMinimumTransferTime(5);
        assertEquals(5, request.getMinimumTransferTime());

        request.setAccessibility("wheelchair");
        assertEquals("wheelchair", request.getAccessibility());

        request.setBikeFriendly(true);
        assertTrue(request.isBikeFriendly());

        request.setStartWithWalking(true);
        assertTrue(request.isStartWithWalking());

        request.setWalkingSpeed("fast");
        assertEquals("fast", request.getWalkingSpeed());

        request.setTickets(true);
        assertTrue(request.isTickets());

        request.setPolylines(true);
        assertTrue(request.isPolylines());

        request.setSubStops(true);
        assertTrue(request.isSubStops());

        request.setEntrances(true);
        assertTrue(request.isEntrances());

        request.setRemarks(true);
        assertTrue(request.isRemarks());

        request.setScheduledDays(true);
        assertTrue(request.isScheduledDays());

        request.setNotOnlyFastRoutes(true);
        assertTrue(request.isNotOnlyFastRoutes());

        request.setBestPrice(true);
        assertTrue(request.isBestPrice());

        request.setLanguage("de");
        assertEquals("de", request.getLanguage());

        request.setLoyaltyCard("card123");
        assertEquals("card123", request.getLoyaltyCard());

        request.setFirstClass(true);
        assertTrue(request.isFirstClass());

        request.setAge(30);
        assertEquals(30, request.getAge());

        ProfileSpecificProducts products = new ProfileSpecificProducts();
        request.setProfileSpecificProducts(products);
        assertEquals(products, request.getProfileSpecificProducts());
    }

    @Test
    public void testStartLocationSetters() {
        JourneySearchRequest request = new JourneySearchRequest();

        request.setFrom("Berlin Hbf");
        assertEquals("from sollte korrekt gesetzt werden", "Berlin Hbf", request.getFrom());

        request.setFromId("8011160");
        assertEquals("fromId sollte korrekt gesetzt werden", "8011160", request.getFromId());

        request.setFromAddress("Europaplatz 1, 10557 Berlin");
        assertEquals("fromAddress sollte korrekt gesetzt werden", "Europaplatz 1, 10557 Berlin", request.getFromAddress());

        BigDecimal lat = new BigDecimal("52.525589");
        BigDecimal lon = new BigDecimal("13.369433");
        request.setFromLatitude(lat);
        request.setFromLongitude(lon);
        assertEquals("fromLatitude sollte korrekt gesetzt werden", lat, request.getFromLatitude());
        assertEquals("fromLongitude sollte korrekt gesetzt werden", lon, request.getFromLongitude());
    }

    @Test
    public void testDestinationSetters() {
        JourneySearchRequest request = new JourneySearchRequest();

        request.setTo("München Hbf");
        assertEquals("to sollte korrekt gesetzt werden", "München Hbf", request.getTo());

        request.setToId("8000261");
        assertEquals("toId sollte korrekt gesetzt werden", "8000261", request.getToId());

        request.setToAddress("Bayerstraße 10, 80335 München");
        assertEquals("toAddress sollte korrekt gesetzt werden", "Bayerstraße 10, 80335 München", request.getToAddress());

        BigDecimal lat = new BigDecimal("48.140229");
        BigDecimal lon = new BigDecimal("11.558339");
        request.setToLatitude(lat);
        request.setToLongitude(lon);
        assertEquals("toLatitude sollte korrekt gesetzt werden", lat, request.getToLatitude());
        assertEquals("toLongitude sollte korrekt gesetzt werden", lon, request.getToLongitude());
    }

    @Test
    public void testTimeRelatedSetters() {
        JourneySearchRequest request = new JourneySearchRequest();

        OffsetDateTime now = OffsetDateTime.now();
        request.setDeparture(now);
        assertEquals("departure sollte korrekt gesetzt werden", now, request.getDeparture());

        request.setArrival(now.plusHours(4));
        assertEquals("arrival sollte korrekt gesetzt werden", now.plusHours(4), request.getArrival());

        request.setEarlierThen("earlier-token");
        assertEquals("earlierThen sollte korrekt gesetzt werden", "earlier-token", request.getEarlierThen());

        request.setLaterThen("later-token");
        assertEquals("laterThen sollte korrekt gesetzt werden", "later-token", request.getLaterThen());
    }

    @Test
    public void testOptionsSetters() {
        JourneySearchRequest request = new JourneySearchRequest();

        request.setMaxResults(5);
        assertEquals("maxResults sollte korrekt gesetzt werden", 5, request.getMaxResults());

        request.setMaxTransfers(2);
        assertEquals("maxTransfers sollte korrekt gesetzt werden", 2, request.getMaxTransfers());

        request.setMinimumTransferTime(10);
        assertEquals("minimumTransferTime sollte korrekt gesetzt werden", 10, request.getMinimumTransferTime());

        request.setAccessibility("barrier-free");
        assertEquals("accessibility sollte korrekt gesetzt werden", "barrier-free", request.getAccessibility());

        request.setBikeFriendly(true);
        assertTrue("bikeFriendly sollte korrekt gesetzt werden", request.isBikeFriendly());

        request.setWalkingSpeed("fast");
        assertEquals("walkingSpeed sollte korrekt gesetzt werden", "fast", request.getWalkingSpeed());

        request.setLanguage("de");
        assertEquals("language sollte korrekt gesetzt werden", "de", request.getLanguage());

        request.setLoyaltyCard("bahncard");
        assertEquals("loyaltyCard sollte korrekt gesetzt werden", "bahncard", request.getLoyaltyCard());

        request.setAge(25);
        assertEquals("age sollte korrekt gesetzt werden", 25, request.getAge());
    }

    @Test
    public void testBooleanOptionsSetters() {
        JourneySearchRequest request = new JourneySearchRequest();

        request.setStopOvers(true);
        assertTrue("stopOvers sollte korrekt gesetzt werden", request.isStopOvers());

        request.setStartWithWalking(true);
        assertTrue("startWithWalking sollte korrekt gesetzt werden", request.isStartWithWalking());

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

        request.setFirstClass(true);
        assertTrue("firstClass sollte korrekt gesetzt werden", request.isFirstClass());
    }

    @Test
    public void testProfileSpecificProducts() {
        JourneySearchRequest request = new JourneySearchRequest();
        ProfileSpecificProducts products = new ProfileSpecificProducts();
        request.setProfileSpecificProducts(products);
        assertEquals("profileSpecificProducts sollte korrekt gesetzt werden", products, request.getProfileSpecificProducts());
    }

    @Test
    public void testNullValues() {
        JourneySearchRequest request = new JourneySearchRequest();

        // Test String-Felder
        request.setFrom(null);
        assertNull("from sollte null sein können", request.getFrom());

        request.setFromId(null);
        assertNull("fromId sollte null sein können", request.getFromId());

        request.setTo(null);
        assertNull("to sollte null sein können", request.getTo());

        request.setToId(null);
        assertNull("toId sollte null sein können", request.getToId());

        // Test komplexe Objekte
        request.setFromLatitude(null);
        assertNull("fromLatitude sollte null sein können", request.getFromLatitude());

        request.setDeparture(null);
        assertNull("departure sollte null sein können", request.getDeparture());

        request.setProfileSpecificProducts(null);
        assertNull("profileSpecificProducts sollte null sein können", request.getProfileSpecificProducts());
    }

    @Test
    public void testEdgeCases() {
        JourneySearchRequest request = new JourneySearchRequest();

        // Test negative Werte
        request.setMaxResults(-1);
        assertEquals("Negative maxResults sollte möglich sein", -1, request.getMaxResults());

        request.setMaxTransfers(-1);
        assertEquals("Negative maxTransfers sollte möglich sein", -1, request.getMaxTransfers());

        request.setMinimumTransferTime(-1);
        assertEquals("Negative minimumTransferTime sollte möglich sein", -1, request.getMinimumTransferTime());

        request.setAge(-1);
        assertEquals("Negative age sollte möglich sein", -1, request.getAge());

        // Test leere Strings
        request.setFrom("");
        assertEquals("Leere from sollte möglich sein", "", request.getFrom());

        request.setTo("");
        assertEquals("Leere to sollte möglich sein", "", request.getTo());

        request.setAccessibility("");
        assertEquals("Leere accessibility sollte möglich sein", "", request.getAccessibility());
    }

    @Test
    public void testDBVendoRequestImplementation() {
        JourneySearchRequest request = new JourneySearchRequest();
        assertTrue("Sollte DBVendoRequest implementieren", request instanceof DBVendoRequest);
    }
}

