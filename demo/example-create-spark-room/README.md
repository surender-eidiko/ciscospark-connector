## CiscoSpark Anypoint™ Connector


[Cisco Spark Connector to connect to Cisco Spark]

## Author
: 
Eidiko Systems Integrators.

## Supported Mule runtime versions
:
Mule 3.7.0

## Cisco Spark supported versions
:
Cisco Spark Version 1.0 and above.

## Service or application supported modules
Example:Cisco Spark

## Running the Demo

The Demo is used to create a room in Spark. The Spark connector creates a room for the user whose authorization token is used to connect to it.

To create a room in connector properties select 'create rooms' operation and provide a room name in Title


To run the demo open a browser and type http://localhost:8081/. It will trigger the flow. And you will see the below reply in the browser


{

"statusCode":"200","statusMessage":null,

"id":"Y2lzY29zcGFyazovL3VzL1JPT00vODdjMGI0ZDAtOWYzMy0xMWU1LWFmNTQtODEyY2M0ZmM1YTNk",

"title":"Mule Integration With Spark",

"sipAddress":null,"created":"2015-12-10T11:45:37.437Z",

"additionalProperties":{}

}

