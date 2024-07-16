package com.amit.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
		description = "Department Meta Data"
)
public class DepartmentDto {
	private Long id;
	@Schema(
			description = "Department Name",
			minimum = "3",
			maximum = "32"
	)
	private String departmentName;
	@Schema(
			description = "Department Description",
			minimum = "1",
			maximum = "128"
	)
	private String departmentDescription;
	@Schema(
			description = "Department Code",
			minimum = "5",
			maximum = "12"
	)
	private String departmentCode;
}
