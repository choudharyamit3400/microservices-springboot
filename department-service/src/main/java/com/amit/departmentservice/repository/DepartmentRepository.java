package com.amit.departmentservice.repository;

import com.amit.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String departmentCode);
}
