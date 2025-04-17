# DeparturesArrivalsOptions

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**when** | [**OffsetDateTime**](OffsetDateTime.md) | departure date, undefined corresponds to Date.Now |  [optional]
**direction** | **String** | only show departures heading to this station, only supported for &#x60;dbweb&#x60; profile |  [optional]
**line** | **String** | filter by line ID |  [optional]
**duration** | [**BigDecimal**](BigDecimal.md) | show departures for the next n minutes |  [optional]
**results** | [**BigDecimal**](BigDecimal.md) | max. number of results; &#x60;null&#x60; means \&quot;whatever HAFAS wants\&quot; |  [optional]
**subStops** | **Boolean** | parse &amp; expose sub-stops of stations? |  [optional]
**entrances** | **Boolean** | parse &amp; expose entrances of stops/stations? |  [optional]
**linesOfStops** | **Boolean** | parse &amp; expose lines at the stop/station? |  [optional]
**remarks** | **Boolean** | parse &amp; expose hints &amp; warnings? |  [optional]
**stopovers** | **Boolean** | fetch &amp; parse previous/next stopovers? |  [optional]
**includeRelatedStations** | **Boolean** | departures at related stations |  [optional]
**products** | [**Products**](Products.md) |  |  [optional]
**language** | **String** | language |  [optional]
