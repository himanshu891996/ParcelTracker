Deployment steps:
1.Maven should be installed on your system . If it is not installed then first install maven on sysytem.
2 Open cmd and go to the path where src folder is present then run "mvn clean package" it will create jar in "target" folder.
3.Then if you want to deploy jar on google app engine. Then first create account on google cloud platform.
4. Install google cloud sdk on your system.
5 After that open cmd and go to folder where sdk is installed and then run command "gcloud init" after that it will ask for your email id project name etc.
6.Confirm that once then go to folder where your jar file is kept nad open cmd and run "gcloud app deploy <jarname>" it will again want some confirmation and then deploy it to the server.
7.you will get a url on command prompt of that server.
8.After that run api with body from ptools like postman and you will get tracking number. See below example for reference.

Method:POST  
Url: <UrlOfServer>/api/generateTrackingNumber
 eg: https://interview-456309.an.r.appspot.com/api/generateTrackingNumber

body:{
    "originCountryId": "US",
    "destinationCountryId": "IN",
    "weight": "123.005",
    "createdAt": "2025-03-29T12:00:00Z",
    "customerId": "123e4567-e89b-12d3-a456-426614174000",
    "customerName": "john",
    "customerSlug": "john-slug"
}
