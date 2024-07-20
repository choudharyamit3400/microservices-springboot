package com.amit.employeeservice.repository;

import com.amit.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// here we have to follow the conventions findBy{entity fieldName-first char as caps}
	Optional<Employee> findByEmail(String email);


	// here you can use any name of the method was we are going to use custom query
	//JPQL with indexed params
	@Query("select e from Employee  e where e.firstName=?1 and e.lastName=?2")
	Employee findByJPQL(String firstName, String lastName);

	//JPQL with named params
	@Query("select e from Employee  e where e.firstName=:firstName and e.lastName=:lastName")
	Employee findByJPQLNamedParams(@Param("firstName") String firstName, @Param("lastName") String lastName);


	//NOTE: did you notice @Query annotation , with JPQL we use  entity name g here Employee but with native query we use table name ef employees
	// here
	// native query with indexed params
	// in native query you have to use the exact column name eg here we have used first_name instead of  firstName unlike JPQL
	@Query(value="select * from employees e where e.first_Name=?1 and e.last_Name=?2",
	nativeQuery = true)
	Employee findByNativeSql(String firstName,String lastName);



	//NOTE: did you notice @Query annotation , with JPQL we use  entity name g here Employee but with native query we use table name ef employees
	// here
	// native query with indexed params
	// in native query you have to use the exact column name eg here we have used first_name instead of  firstName unlike JPQL
	@Query(value="select * from employees e where e.first_Name=:firstName and e.last_Name=:lastName",
			nativeQuery = true)
	Employee findByNativeSqlWithNamedParams(@Param("firstName") String firstName,@Param("lastName") String lastName);
}
