package com.amit.departmentservice.service;

import com.amit.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartmentByCode(String code);
}
