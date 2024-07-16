package com.amit.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
		description = "Employee Meta Data"
)
public class EmployeeDto {
	private Long id;
	@Schema(
			description = "Employee firstname",
			minimum = "3",
			maximum = "32"
	)
	private String firstName;
	@Schema(
			description = "Employee last name",
			minimum = "3",
			maximum = "32"
	)
	private String lastName;
	@Schema(
			description = "Employee email",
			minimum = "3",
			maximum = "32"
	)
	private String email;
	@Schema(
			description = "Department code",
			minimum = "3",
			maximum = "32"
	)
	private String departmentCode;
	@Schema(
			description = "Organization Code",
			minimum = "3",
			maximum = "32"
	)
	private String organizationCode;
}
