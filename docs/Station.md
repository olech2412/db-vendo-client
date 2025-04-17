# Station

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**id** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**station** | [**Station**](Station.md) |  |  [optional]
**location** | [**Location**](Location.md) |  |  [optional]
**products** | [**Products**](Products.md) |  |  [optional]
**lines** | [**List&lt;Line&gt;**](Line.md) |  |  [optional]
**isMeta** | **Boolean** |  |  [optional]
**regions** | **List&lt;String&gt;** | region ids |  [optional]
**facilities** | [**Facilities**](Facilities.md) |  |  [optional]
**reisezentrumOpeningHours** | [**ReisezentrumOpeningHours**](ReisezentrumOpeningHours.md) |  |  [optional]
**stops** | **List&lt;AnyOfStationStopsItems&gt;** |  |  [optional]
**entrances** | [**List&lt;Location&gt;**](Location.md) |  |  [optional]
**transitAuthority** | **String** |  |  [optional]
**distance** | [**BigDecimal**](BigDecimal.md) |  |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
STATION | &quot;station&quot;
