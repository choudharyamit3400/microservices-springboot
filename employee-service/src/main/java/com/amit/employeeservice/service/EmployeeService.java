package com.amit.employeeservice.service;

import com.amit.employeeservice.dto.APIResponseDto;
import com.amit.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	APIResponseDto getEmployeeById(Long employeeId);
}
