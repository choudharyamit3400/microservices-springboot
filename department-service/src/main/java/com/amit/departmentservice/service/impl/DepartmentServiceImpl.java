package com.amit.departmentservice.service.impl;

import com.amit.departmentservice.service.DepartmentService;
import com.amit.departmentservice.dto.DepartmentDto;
import com.amit.departmentservice.entity.Department;
import com.amit.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

		// convert department dto to department jpa entity
		Department department = new Department(
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartmentCode()
		);

		Department savedDepartment = departmentRepository.save(department);

		DepartmentDto savedDepartmentDto = new DepartmentDto(
				savedDepartment.getId(),
				savedDepartment.getDepartmentName(),
				savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode()
		);

		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {

		Department department = departmentRepository.findByDepartmentCode(departmentCode);

		DepartmentDto departmentDto = new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode()
		);
		return departmentDto;
	}
}
