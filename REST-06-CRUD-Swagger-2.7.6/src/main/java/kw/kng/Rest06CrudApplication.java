package kw.kng;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info=@Info(
					title="Tourist REST API  CRUD Swagger 2.7.6 Documentation",
					description="Tourist REST API  CRUD Swagger 2.7.6 Documentation",
					version="v25July2024",
					contact=@Contact(
										name="Luke Rajan Mathew",
										email="",
										url=""
									),
					license=@License(
										name="",
										url=""
									)
				),
	   externalDocs= @ExternalDocumentation(
											description="Tourist REST API  CRUD Swagger 2.7.6 Documentation",
											url="https://www.javaguides.net/external-doc.html"
										)
)
@SpringBootApplication
public class Rest06CrudApplication 
{
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

	public static void main(String[] args) 
	{
		SpringApplication.run(Rest06CrudApplication.class, args);
	}

}


/*
 
// -----------------------------------------------------------------------------------------------------------
 For 2.7.6 version to access the swagger doc for this application
 
 
 1. URL to access. To access the swagger document for 2.7.6
 
 http://localhost:8080/swagger-ui.html (use me)
 http://localhost:8080//v3/api-docs (use me)
 
 2. Copy the config file present in config package:
 
 OpenApiConfig.class
 
 3. application.properties
 
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
 
 
 4. Open a new browser if needed. If you see `petstore` default  swagger doc. then you must clear the cache in the browser
 or open a new browser and try. It will work 
 
// ----------------------------------------------------------------------------------------------------------- 

 
 */


