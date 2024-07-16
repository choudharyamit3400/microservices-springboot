package com.amit.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
		description = "Employee Details"
)
public class APIResponseDto {
	private EmployeeDto employee;
	private DepartmentDto department;
	private OrganizationDto organization;
}
