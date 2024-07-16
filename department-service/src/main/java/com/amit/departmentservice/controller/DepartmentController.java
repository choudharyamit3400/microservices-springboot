package com.amit.departmentservice.controller;

import com.amit.departmentservice.dto.DepartmentDto;
import com.amit.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
		name="Department Service - Department Controller",
		description = "Rest apis for CRUD  operations on Department"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;
	@Operation(
			summary = "Save Department Rest API",
			description = "Save Department Rest API is used to save department details in database"
	)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 created"
	)
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	@Operation(
			summary = "Get Department Rest API",
			description = "Get Department Rest API is used to get department details from database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 Success"
	)
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode) {
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	}
}
