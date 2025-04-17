# Line

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**id** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**adminCode** | **String** |  |  [optional]
**fahrtNr** | **String** |  |  [optional]
**additionalName** | **String** |  |  [optional]
**product** | **String** |  |  [optional]
**_public** | **Boolean** |  |  [optional]
**mode** | [**ModeEnum**](#ModeEnum) |  |  [optional]
**routes** | **List&lt;String&gt;** | routes ids |  [optional]
**operator** | [**Operator**](Operator.md) |  |  [optional]
**express** | **Boolean** |  |  [optional]
**metro** | **Boolean** |  |  [optional]
**night** | **Boolean** |  |  [optional]
**nr** | [**BigDecimal**](BigDecimal.md) |  |  [optional]
**symbol** | **String** |  |  [optional]
**directions** | **List&lt;String&gt;** |  |  [optional]
**productName** | **String** |  |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
LINE | &quot;line&quot;

<a name="ModeEnum"></a>
## Enum: ModeEnum
Name | Value
---- | -----
AIRCRAFT | &quot;aircraft&quot;
BICYCLE | &quot;bicycle&quot;
BUS | &quot;bus&quot;
CAR | &quot;car&quot;
GONDOLA | &quot;gondola&quot;
TAXI | &quot;taxi&quot;
TRAIN | &quot;train&quot;
WALKING | &quot;walking&quot;
WATERCRAFT | &quot;watercraft&quot;
