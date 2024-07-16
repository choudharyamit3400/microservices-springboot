package com.amit.employeeservice.service;

import com.amit.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("DEPARTMENT-SERVICE")
public interface APIClient {
	// Build get department rest api
	@GetMapping("api/departments/{department-code}")
	DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
