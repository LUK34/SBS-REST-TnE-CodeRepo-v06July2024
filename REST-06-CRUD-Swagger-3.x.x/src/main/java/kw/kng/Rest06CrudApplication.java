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
					title="Tourist REST API  CRUD Swagger 3.3.1 Documentation",
					description="Tourist REST API  CRUD Swagger 3.3.1 Documentation",
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
											description="Tourist REST API  CRUD Swagger 3.3.1 Documentation",
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
