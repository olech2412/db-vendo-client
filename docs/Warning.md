# Warning

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**id** | **String** |  |  [optional]
**icon** | **Map&lt;String, Object&gt;** |  |  [optional]
**summary** | **String** |  |  [optional]
**text** | **String** |  |  [optional]
**category** | **String** |  |  [optional]
**priority** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**products** | [**Products**](Products.md) |  |  [optional]
**edges** | [**List&lt;Edge&gt;**](Edge.md) |  |  [optional]
**events** | [**List&lt;Event&gt;**](Event.md) |  |  [optional]
**validFrom** | **String** |  |  [optional]
**validUntil** | **String** |  |  [optional]
**modified** | **String** |  |  [optional]
**company** | **String** |  |  [optional]
**categories** | [**List&lt;BigDecimal&gt;**](BigDecimal.md) |  |  [optional]
**affectedLines** | [**List&lt;Line&gt;**](Line.md) |  |  [optional]
**fromStops** | **List&lt;AnyOfWarningFromStopsItems&gt;** |  |  [optional]
**toStops** | **List&lt;AnyOfWarningToStopsItems&gt;** |  |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
STATUS | &quot;status&quot;
WARNING | &quot;warning&quot;
