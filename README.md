# geocoding

Build Instructions:
1. Build project using Maven using command "mvn clean package"
2. Get generated "GeoCoding.war" file from /target folder.
3. Deploy to any Web Container such as Tomcat, JBoss, Wildfly.

-----------------------------------
To get request for address: GET:<url>/GeoCoding/getAddress?lat=<latitude>&lon=<longitude>

Sample Request: http://localhost:8080/GeoCoding/getAddress?lat=34.0430776&lon=-84.2913245

Sample Response: 

{
    "lat": 34.0430776,
    "lng": -84.2913245,
    "bldgNumber": "9241",
    "streetName": "Jameson Pass",
    "subAddress": null,
    "county": "Fulton County",
    "state": "Georgia",
    "postalCode": 0,
    "country": "United States of America",
    "countryCode": "us",
    "lookupDate": "2016-12-14 03:58"
}

-----------------------------------------
To get request for last 10 requested addresses: <url>/GeoCoding/getCachedAddresses

Sample Request: http://localhost:8080/GeoCoding/getCachedAddresses

Sample Response:

[{
    "lat": 34.0430776,
    "lng": -84.2913245,
    "bldgNumber": "9241",
    "streetName": "Jameson Pass",
    "subAddress": null,
    "county": "Fulton County",
    "state": "Georgia",
    "postalCode": 0,
    "country": "United States of America",
    "countryCode": "us",
    "lookupDate": "2016-12-14 03:58"
}, {
    "lat": 34.0430776,
    "lng": -84.2913246,
    "bldgNumber": "9241",
    "streetName": "Jameson Pass",
    "subAddress": null,
    "county": "Fulton County",
    "state": "Georgia",
    "postalCode": 0,
    "country": "United States of America",
    "countryCode": "us",
    "lookupDate": "2016-12-14 04:13"
}, {
    "lat": 34.0430776,
    "lng": -84.2913247,
    "bldgNumber": "9241",
    "streetName": "Jameson Pass",
    "subAddress": null,
    "county": "Fulton County",
    "state": "Georgia",
    "postalCode": 0,
    "country": "United States of America",
    "countryCode": "us",
    "lookupDate": "2016-12-14 04:13"
}]
