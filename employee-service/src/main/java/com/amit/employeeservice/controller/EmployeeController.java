package com.amit.employeeservice.controller;

import com.amit.employeeservice.dto.APIResponseDto;
import com.amit.employeeservice.dto.EmployeeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import com.amit.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;

	@Operation(
			summary = "Save Employee Rest API",
			description = "Save Employee Rest API is used to save Employee details in database"
	)
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 created"
	)
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	@Operation(
			summary = "Get Employee Rest API",
			description = "Get Employee Rest API is used to get Employee details from database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 Success"
	)
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
		APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
}
