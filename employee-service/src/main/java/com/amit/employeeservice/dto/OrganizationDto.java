package com.amit.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
		description = "Organization Meta Data"
)
public class OrganizationDto {
	private Long id;
	@Schema(
			description = "Organization Name",
			minimum = "3",
			maximum = "32"
	)
	private String organizationName;
	@Schema(
			description = "Organization Description",
			minimum = "3",
			maximum = "128"
	)
	private String organizationDescription;
	@Schema(
			description = "Organization Code",
			minimum = "3",
			maximum = "8"
	)
	private String organizationCode;
	@Schema(
			description = "Organization creation date "
	)
	private LocalDateTime createdDate;
}
