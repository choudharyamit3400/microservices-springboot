package com.amit.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
@OpenAPIDefinition(
		info = @Info(
				title = "Employee  Service",
				version = "v1..0",
				description = "Employee  Service API for CRUD operations related to Employee",
				license = @License(name = "Apache 2.0", url = "https://amit.com"),
				contact = @Contact(url = "https://amitkumar.com", name = "Amit", email = "amit.kumar@gmail.com")
		),
		externalDocs = @ExternalDocumentation(description = "definition docs desc",url = "https://amit.com")
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
