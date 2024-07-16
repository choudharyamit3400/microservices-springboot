package com.amit.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "Department  Service",
				version = "v1..0",
				description = "Department  Service API for CRUD operations related to Department",
				license = @License(name = "Apache 2.0", url = "https://amit.com"),
				contact = @Contact(url = "https://amitkumar.com", name = "Amit", email = "amit.kumar@gmail.com")
		),
		externalDocs = @ExternalDocumentation(description = "definition docs desc",url = "https://amit.com")
)
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
