# Route

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**id** | **String** |  |  [optional]
**line** | **String** |  |  [optional]
**mode** | [**ModeEnum**](#ModeEnum) |  |  [optional]
**stops** | **List&lt;String&gt;** | stop ids |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
ROUTE | &quot;route&quot;

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
