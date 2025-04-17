# JourneysOptionsCommon

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**departure** | [**OffsetDateTime**](OffsetDateTime.md) | departure date, undefined corresponds to Date.Now |  [optional]
**arrival** | [**OffsetDateTime**](OffsetDateTime.md) | arrival date, departure and arrival are mutually exclusive. |  [optional]
**earlierThan** | **String** | earlierThan, use {@link Journeys#earlierRef}, earlierThan and departure/arrival are mutually exclusive. |  [optional]
**laterThan** | **String** | laterThan, use {@link Journeys#laterRef}, laterThan and departure/arrival are mutually exclusive. |  [optional]
**results** | [**BigDecimal**](BigDecimal.md) | how many search results? |  [optional]
**via** | **String** | let journeys pass this station |  [optional]
**stopovers** | **Boolean** | return stations on the way? |  [optional]
**transfers** | [**BigDecimal**](BigDecimal.md) | Maximum nr of transfers. Default: Let HAFAS decide. |  [optional]
**transferTime** | [**BigDecimal**](BigDecimal.md) | minimum time for a single transfer in minutes |  [optional]
**accessibility** | **String** | &#x27;none&#x27;, &#x27;partial&#x27; or &#x27;complete&#x27; |  [optional]
**bike** | **Boolean** | only bike-friendly journeys |  [optional]
**products** | [**Products**](Products.md) |  |  [optional]
**tickets** | **Boolean** | return tickets? only available with some profiles |  [optional]
**polylines** | **Boolean** | return a shape for each leg? |  [optional]
**subStops** | **Boolean** | parse &amp; expose sub-stops of stations? |  [optional]
**entrances** | **Boolean** | parse &amp; expose entrances of stops/stations? |  [optional]
**remarks** | **Boolean** | parse &amp; expose hints &amp; warnings? |  [optional]
**walkingSpeed** | **String** | &#x27;slow&#x27;, &#x27;normal&#x27;, &#x27;fast&#x27; |  [optional]
**startWithWalking** | **Boolean** | start with walking |  [optional]
**language** | **String** | language to get results in |  [optional]
**scheduledDays** | **Boolean** | parse which days each journey is valid on |  [optional]
**when** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
