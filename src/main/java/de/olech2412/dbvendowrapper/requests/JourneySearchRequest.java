package de.olech2412.dbvendowrapper.requests;

import de.olech2412.dbvendowrapper.model.ProfileSpecificProducts;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * <h1>Request-Klasse für Reiseverbindungssuche</h1>
 *
 * <p>Diese Klasse bietet umfangreiche Möglichkeiten zur Konfiguration der Reiseverbindungssuche
 * mit verschiedenen Start- und Zielpunkten sowie zusätzlichen Suchparametern.</p>
 *
 * <h2>Hauptfunktionen:</h2>
 * <ul>
 *   <li>Flexible Startpunkt-Definition:
 *     <ul>
 *       <li>Über Namen oder ID ({@code from}, {@code fromId})</li>
 *       <li>Über Adresse ({@code fromAddress})</li>
 *       <li>Über geografische Koordinaten ({@code fromLatitude}, {@code fromLongitude})</li>
 *     </ul>
 *   </li>
 *   <li>Flexible Zielpunkt-Definition mit denselben Optionen</li>
 *   <li>Zeitliche Steuerung:
 *     <ul>
 *       <li>Abfahrtszeit ({@code departure})</li>
 *       <li>Ankunftszeit ({@code arrival})</li>
 *       <li>Früher/Später-Optionen ({@code earlierThan}, {@code laterThan})</li>
 *     </ul>
 *   </li>
 *   <li>Umfangreiche Filtermöglichkeiten:
 *     <ul>
 *       <li>Verkehrsmittel ({@code profileSpecificProducts})</li>
 *       <li>Transferzeiten ({@code minimumTransferTime})</li>
 *       <li>Barrierefreiheit ({@code accessibility})</li>
 *       <li>Preiskategorien ({@code firstClass}, {@code bestPrice})</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <h2>Besonders geeignet für:</h2>
 * <ul>
 *   <li>Komplexe Reiseplanungen</li>
 *   <li>Verbindungssuchen mit spezifischen Anforderungen</li>
 *   <li>Optimierung nach verschiedenen Kriterien (Zeit, Preis, Komfort)</li>
 * </ul>
 *
 * @author olech2412
 * @version 1.0
 * @see DBVendoRequest
 * @see ProfileSpecificProducts
 */
public class JourneySearchRequest implements DBVendoRequest {

    private String from;

    private String fromId;

    private String fromAddress;

    private BigDecimal fromLatitude;

    private BigDecimal fromLongitude;

    private String to;

    private String toId;

    private String toAddress;

    private BigDecimal toLatitude;

    private BigDecimal toLongitude;

    private OffsetDateTime departure;

    private OffsetDateTime arrival;

    private String earlierThen;

    private String laterThen;

    private int maxResults;

    private boolean stopOvers;

    private int maxTransfers;

    private int minimumTransferTime;

    private String accessibility;

    private boolean bikeFriendly;

    private boolean startWithWalking;

    // slow, normal, fast
    private String walkingSpeed;

    private boolean tickets;

    private boolean polylines;

    private boolean subStops;

    private boolean entrances;

    private boolean remarks;

    private boolean scheduledDays;

    private boolean notOnlyFastRoutes;

    private boolean bestPrice;

    private String language;

    private String loyaltyCard;

    private boolean firstClass;

    private int age;

    private ProfileSpecificProducts profileSpecificProducts;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public BigDecimal getFromLatitude() {
        return fromLatitude;
    }

    public void setFromLatitude(BigDecimal fromLatitude) {
        this.fromLatitude = fromLatitude;
    }

    public BigDecimal getFromLongitude() {
        return fromLongitude;
    }

    public void setFromLongitude(BigDecimal fromLongitude) {
        this.fromLongitude = fromLongitude;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public BigDecimal getToLatitude() {
        return toLatitude;
    }

    public void setToLatitude(BigDecimal toLatitude) {
        this.toLatitude = toLatitude;
    }

    public BigDecimal getToLongitude() {
        return toLongitude;
    }

    public void setToLongitude(BigDecimal toLongitude) {
        this.toLongitude = toLongitude;
    }

    public OffsetDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(OffsetDateTime departure) {
        this.departure = departure;
    }

    public String getEarlierThen() {
        return earlierThen;
    }

    public void setEarlierThen(String earlierThen) {
        this.earlierThen = earlierThen;
    }

    public OffsetDateTime getArrival() {
        return arrival;
    }

    public void setArrival(OffsetDateTime arrival) {
        this.arrival = arrival;
    }

    public String getLaterThen() {
        return laterThen;
    }

    public void setLaterThen(String laterThen) {
        this.laterThen = laterThen;
    }

    public boolean isStopOvers() {
        return stopOvers;
    }

    public void setStopOvers(boolean stopOvers) {
        this.stopOvers = stopOvers;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getMaxTransfers() {
        return maxTransfers;
    }

    public void setMaxTransfers(int maxTransfers) {
        this.maxTransfers = maxTransfers;
    }

    public int getMinimumTransferTime() {
        return minimumTransferTime;
    }

    public void setMinimumTransferTime(int minimumTransferTime) {
        this.minimumTransferTime = minimumTransferTime;
    }

    public boolean isBikeFriendly() {
        return bikeFriendly;
    }

    public void setBikeFriendly(boolean bikeFriendly) {
        this.bikeFriendly = bikeFriendly;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public boolean isStartWithWalking() {
        return startWithWalking;
    }

    public void setStartWithWalking(boolean startWithWalking) {
        this.startWithWalking = startWithWalking;
    }

    public String getWalkingSpeed() {
        return walkingSpeed;
    }

    public void setWalkingSpeed(String walkingSpeed) {
        this.walkingSpeed = walkingSpeed;
    }

    public boolean isTickets() {
        return tickets;
    }

    public void setTickets(boolean tickets) {
        this.tickets = tickets;
    }

    public boolean isSubStops() {
        return subStops;
    }

    public void setSubStops(boolean subStops) {
        this.subStops = subStops;
    }

    public boolean isPolylines() {
        return polylines;
    }

    public void setPolylines(boolean polylines) {
        this.polylines = polylines;
    }

    public boolean isEntrances() {
        return entrances;
    }

    public void setEntrances(boolean entrances) {
        this.entrances = entrances;
    }

    public boolean isRemarks() {
        return remarks;
    }

    public void setRemarks(boolean remarks) {
        this.remarks = remarks;
    }

    public boolean isScheduledDays() {
        return scheduledDays;
    }

    public void setScheduledDays(boolean scheduledDays) {
        this.scheduledDays = scheduledDays;
    }

    public boolean isNotOnlyFastRoutes() {
        return notOnlyFastRoutes;
    }

    public void setNotOnlyFastRoutes(boolean notOnlyFastRoutes) {
        this.notOnlyFastRoutes = notOnlyFastRoutes;
    }

    public boolean isBestPrice() {
        return bestPrice;
    }

    public void setBestPrice(boolean bestPrice) {
        this.bestPrice = bestPrice;
    }

    public String getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(String loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isFirstClass() {
        return firstClass;
    }

    public void setFirstClass(boolean firstClass) {
        this.firstClass = firstClass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ProfileSpecificProducts getProfileSpecificProducts() {
        return profileSpecificProducts;
    }

    public void setProfileSpecificProducts(ProfileSpecificProducts profileSpecificProducts) {
        this.profileSpecificProducts = profileSpecificProducts;
    }
}
