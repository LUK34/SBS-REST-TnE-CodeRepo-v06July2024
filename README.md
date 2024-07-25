## 1.REST-01-JSON

### Description:
- This is exploring the basics of RestApi using JSON
- KT: July 1-5 2024

## 2.REST-02-XML

### Description:
- This is exploring the basics of RestApi using XML
- KT: July 8 2024

## 3.REST-03-JsonXml-ToObject-RequestBody

### Description:
- This is exploring how to post complex data using JSON and XML via Postman.
- KT: July 9 2024

## 4.REST-04-JsonXml-Collections-RequestBody

### Description:
- This is exploring how to post complex Collection of data using JSON and XML via Postman.
- KT: July 9 2024

## 5.REST-05-RqstParamPthVrble

### Description:
- This is exploring different scenario related to RequestParam and PathVariable Annotation.
- KT: July 10 2024

## 6.REST-06-CRUD , 7.REST-06-CRUD-Swagger-3.x.x, 8.REST-06-CRUD-Swagger-2.7.6

### Description:
- Followed Ramesh Fadatarer logic. But in controller layer I am using String and ResponseEntity<?>. The contoller part is different
- ModelMapper applied here
- Exception applied here
- KT: July 11 and 12 2024
- For REST-06-CRUD-Swagger-3.x.x, just inject the swagger dependency in pom.xml file and refer the dto,restcontroller, Application start file
- REST-06-CRUD-Swagger-2.7.6, its a bit complex. The one that is working for you, follow the below points to achieve it:
- 1. URL to access. To access the swagger document for 2.7.6
- http://localhost:8080/swagger-ui.html (use me)
- http://localhost:8080//v3/api-docs (use me)
- 2. Copy the config file present in config package: OpenApiConfig.class
- 3. application.properties:
- springdoc.api-docs.path=/v3/api-docs
- springdoc.swagger-ui.path=/swagger-ui.html 
- 4. Open a new browser if needed. If you see `petstore` default  swagger doc. then you must clear the cache in the browser
- or open a new browser and try. It will work 


