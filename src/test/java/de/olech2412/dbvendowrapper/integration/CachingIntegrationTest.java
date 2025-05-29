package de.olech2412.dbvendowrapper.integration;

import de.olech2412.dbvendowrapper.ApiClient;
import de.olech2412.dbvendowrapper.api.DBVendoAPI;
import de.olech2412.dbvendowrapper.model.*;
import de.olech2412.dbvendowrapper.requests.*;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Integrationstests für das Caching-System des DB Vendo Wrappers.
 * Diese Tests überprüfen die korrekte Funktionsweise des Cachings für verschiedene API-Aufrufe.
 */
public class CachingIntegrationTest {

    @ClassRule
    public static GenericContainer<?> dbVendoClient = new GenericContainer<>(DockerImageName.parse("ghcr.io/public-transport/db-vendo-client"))
            .withEnv("USER_AGENT", "db-vendo-wrapper-test")
            .withEnv("DB_PROFILE", "dbnav")
            .withExposedPorts(3000);

    private DBVendoAPI dbVendoAPI;

    @Before
    public void setUp() {
        String baseUrl = String.format("http://%s:%d", dbVendoClient.getHost(), dbVendoClient.getMappedPort(3000));
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(baseUrl);
        dbVendoAPI = new DBVendoAPI(apiClient);
    }

    @Test
    public void testStopByIdCaching() {
        String stopId = "8011160"; // Berlin Hbf
        StopByIdRequest request = new StopByIdRequest(stopId);

        // Erster Aufruf
        StopsIdResponse result1 = dbVendoAPI.stopsIdGet(request);
        assertNotNull("Erster Aufruf sollte Ergebnis liefern", result1);
        assertFalse("Erster Aufruf sollte nicht aus dem Cache kommen", result1.isFromCache());

        // Zweiter Aufruf sollte aus dem Cache kommen
        StopsIdResponse result2 = dbVendoAPI.stopsIdGet(request);
        assertNotNull("Zweiter Aufruf sollte Ergebnis aus Cache liefern", result2);
        assertTrue("Zweiter Aufruf sollte aus dem Cache kommen", result2.isFromCache());
    }

    @Test
    public void testArrivalsCaching() {
        String stopId = "8011160"; // Berlin Hbf
        ArrivalsByStopIdRequest request = new ArrivalsByStopIdRequest(stopId);
        request.setArrivalTime(OffsetDateTime.now());

        // Erster Aufruf
        StopsIdArrivalsResponse result1 = dbVendoAPI.stopsIdArrivalsGet(request);
        assertNotNull("Erster Aufruf sollte Ergebnis liefern", result1);
        assertFalse("Erster Aufruf sollte nicht aus dem Cache kommen", result1.isFromCache());

        // Zweiter Aufruf sollte aus dem Cache kommen
        StopsIdArrivalsResponse result2 = dbVendoAPI.stopsIdArrivalsGet(request);
        assertNotNull("Zweiter Aufruf sollte Ergebnis aus Cache liefern", result2);
        assertTrue("Zweiter Aufruf sollte aus dem Cache kommen", result2.isFromCache());
    }

    @Test
    public void testDeparturesCaching() {
        String stopId = "8011160"; // Berlin Hbf
        DeparturesByStopIdRequest request = new DeparturesByStopIdRequest(stopId);
        request.setDepartureTime(OffsetDateTime.now());

        // Erster Aufruf
        StopsIdDeparturesResponse result1 = dbVendoAPI.stopsIdDeparturesGet(request);
        assertNotNull("Erster Aufruf sollte Ergebnis liefern", result1);
        assertFalse("Erster Aufruf sollte nicht aus dem Cache kommen", result1.isFromCache());

        // Zweiter Aufruf sollte aus dem Cache kommen
        StopsIdDeparturesResponse result2 = dbVendoAPI.stopsIdDeparturesGet(request);
        assertNotNull("Zweiter Aufruf sollte Ergebnis aus Cache liefern", result2);
        assertTrue("Zweiter Aufruf sollte aus dem Cache kommen", result2.isFromCache());
    }

    @Test
    public void testLocationSearchCaching() {
        LocationSearchRequest request = new LocationSearchRequest("Berlin");
        request.setMaxResults(5);

        // Erster Aufruf
        List<StopsIdResponse> result1 = dbVendoAPI.locationsGet(request);
        assertNotNull("Erster Aufruf sollte Ergebnis liefern", result1);
        assertFalse("Erster Aufruf sollte nicht aus dem Cache kommen", result1.isEmpty() ? false : result1.get(0).isFromCache());

        // Zweiter Aufruf sollte aus dem Cache kommen
        List<StopsIdResponse> result2 = dbVendoAPI.locationsGet(request);
        assertNotNull("Zweiter Aufruf sollte Ergebnis aus Cache liefern", result2);
        assertTrue("Zweiter Aufruf sollte aus dem Cache kommen", result2.isEmpty() ? false : result2.get(0).isFromCache());
    }

    @Test
    public void testJourneySearchCaching() {
        JourneySearchRequest request = new JourneySearchRequest();
        request.setFrom("8011160"); // Berlin Hbf (IBNR)
        request.setTo("8000261");   // München Hbf (IBNR)
        request.setDeparture(OffsetDateTime.now());

        // Erster Aufruf
        JourneysResponse result1 = dbVendoAPI.journeysGet(request);
        assertNotNull("Erster Aufruf sollte Ergebnis liefern", result1);
        assertFalse("Erster Aufruf sollte nicht aus dem Cache kommen", result1.isFromCache());

        // Zweiter Aufruf sollte aus dem Cache kommen
        JourneysResponse result2 = dbVendoAPI.journeysGet(request);
        assertNotNull("Zweiter Aufruf sollte Ergebnis aus Cache liefern", result2);
        assertTrue("Zweiter Aufruf sollte aus dem Cache kommen", result2.isFromCache());
    }

    @Test
    public void testCacheEviction() {
        String stopId = "8011160"; // Berlin Hbf
        StopByIdRequest request = new StopByIdRequest(stopId);

        // Erster Aufruf
        StopsIdResponse result1 = dbVendoAPI.stopsIdGet(request);
        assertNotNull(result1);
        assertFalse("Erster Aufruf sollte nicht aus dem Cache kommen", result1.isFromCache());

        // Cache leeren
        dbVendoAPI.clearAllCaches();

        // Erneuter Aufruf sollte wieder API ansprechen
        StopsIdResponse result2 = dbVendoAPI.stopsIdGet(request);
        assertNotNull(result2);
        assertFalse("Nach Cache-Löschung sollte nicht aus dem Cache kommen", result2.isFromCache());
    }

    @Test
    public void testCacheWithDifferentParameters() {
        String stopId = "8011160"; // Berlin Hbf

        // Request 1 mit Standardparametern
        StopByIdRequest request1 = new StopByIdRequest(stopId);
        StopsIdResponse result1 = dbVendoAPI.stopsIdGet(request1);
        assertNotNull(result1);
        assertFalse("Erster Aufruf sollte nicht aus dem Cache kommen", result1.isFromCache());

        // Request 2 mit zusätzlichen Parametern
        StopByIdRequest request2 = new StopByIdRequest(stopId);
        request2.setLinesOfStops(true);
        StopsIdResponse result2 = dbVendoAPI.stopsIdGet(request2);
        assertNotNull(result2);
        assertFalse("Zweiter Aufruf mit anderem Parameter sollte nicht aus dem Cache kommen", result2.isFromCache());
    }

    @Test
    public void testConcurrentCacheAccess() throws InterruptedException {
        String stopId = "8011160"; // Berlin Hbf
        StopByIdRequest request = new StopByIdRequest(stopId);

        // Parallel-Zugriffe simulieren
        Runnable cacheTask = () -> {
            StopsIdResponse result = dbVendoAPI.stopsIdGet(request);
            assertNotNull(result);
            assertFalse(result.isFromCache());
        };

        // 5 parallele Threads erstellen
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(cacheTask);
            threads[i].start();
        }

        // Auf Beendigung aller Threads warten
        for (Thread thread : threads) {
            thread.join();
        }
    }

    @Test
    public void testCacheExpiry() throws InterruptedException {
        String stopId = "8011160"; // Berlin Hbf
        StopByIdRequest request = new StopByIdRequest(stopId);

        // Custom CacheConfig mit kurzer Ablaufzeit (2 Sekunden)
        de.olech2412.dbvendowrapper.config.CacheConfig shortExpiryConfig =
                new de.olech2412.dbvendowrapper.config.CacheConfig(true, 1000, java.time.Duration.ofSeconds(2));
        String baseUrl = String.format("http://%s:%d", dbVendoClient.getHost(), dbVendoClient.getMappedPort(3000));
        DBVendoAPI shortExpiryApi = new DBVendoAPI(new ApiClient(), shortExpiryConfig);
        shortExpiryApi.getApiClient().setBasePath(baseUrl);

        // Erster Aufruf
        StopsIdResponse result1 = shortExpiryApi.stopsIdGet(request);
        assertNotNull(result1);
        assertFalse(result1.isFromCache());

        // Warten bis Cache abläuft (z.B. 2 Sekunden in der Testkonfiguration)
        Thread.sleep(2100);

        // Erneuter Aufruf sollte wieder API ansprechen
        StopsIdResponse result2 = shortExpiryApi.stopsIdGet(request);
        assertNotNull(result2);
        assertFalse(result2.isFromCache());

        Thread.sleep(2100);

        // Frage nochmals ab
        StopsIdResponse result3 = shortExpiryApi.stopsIdGet(request);
        assertNotNull(result3);
        assertFalse(result3.isFromCache());

        Thread.sleep(500);

        // Sollte jetzt wieder aus dem Cache kommen
        StopsIdResponse result4 = shortExpiryApi.stopsIdGet(request);
        assertNotNull(result4);
        assertTrue(result4.isFromCache());
    }

    @Test
    public void testCacheKeyGeneration() {
        // Test verschiedener Kombinationen von Request-Parametern
        JourneySearchRequest request1 = new JourneySearchRequest();
        request1.setFrom("8011160"); // Berlin Hbf (IBNR)
        request1.setTo("8000261");   // München Hbf (IBNR)

        JourneySearchRequest request2 = new JourneySearchRequest();
        request2.setFrom("8000261"); // München Hbf (IBNR)
        request2.setTo("8011160");   // Berlin Hbf (IBNR)

        JourneySearchRequest request3 = new JourneySearchRequest();
        request3.setFrom("8011160"); // Berlin Hbf (IBNR)
        request3.setTo("8000261");   // München Hbf (IBNR)
        request3.setMaxResults(5);

        // Alle Requests sollten unterschiedliche Cache-Keys erzeugen
        JourneysResponse r1 = dbVendoAPI.journeysGet(request1);
        JourneysResponse r2 = dbVendoAPI.journeysGet(request2);
        JourneysResponse r3 = dbVendoAPI.journeysGet(request3);
        assertFalse(r1.isFromCache());
        assertFalse(r2.isFromCache());
        assertFalse(r3.isFromCache());
    }
}
