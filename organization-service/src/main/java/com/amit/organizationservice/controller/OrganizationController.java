package com.amit.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import com.amit.organizationservice.dto.OrganizationDto;
import com.amit.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;

	@Operation(
			summary = "Save Organization Rest API",
			description = "Save Organization Rest API is used to save Organization details in database"
	)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 created"
	)
			@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
		OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
	}

	@Operation(
			summary = "Get Organization Rest API",
			description = "Get Organization Rest API is used to get Organization details from database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 Success"
	)
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode) {
		OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
		return ResponseEntity.ok(organizationDto);
	}

}
