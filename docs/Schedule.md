# Schedule

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**id** | **String** |  |  [optional]
**route** | **String** |  |  [optional]
**mode** | [**ModeEnum**](#ModeEnum) |  |  [optional]
**sequence** | [**List&lt;ArrivalDeparture&gt;**](ArrivalDeparture.md) |  |  [optional]
**starts** | **List&lt;String&gt;** | array of Unix timestamps |  [optional]

<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
SCHEDULE | &quot;schedule&quot;

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
