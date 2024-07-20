package com.amit.employeeservice.repository;

import com.amit.employeeservice.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
// below annotation is needed when you are not using in memory database in your DAO layer eg here we are using mysql
// if we don't specify this then @DataJpaTest would try to replace your db with in memory database and would error out as datasource bean would not
// be created
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTests {
	// we will be using the BDD testing --> given_when_then
	Employee employee;

	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	public void setup() {
		employee =
				Employee.builder().firstName("amit").lastName("kumar").email("ak@gmial.com").departmentCode("IT001").organizationCode("GOOGLE001").build();
	}


	// junit for save employee repository
	@Test
	public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
// given - precondition or setup
		// uncomment if not using BeforeEach
//		Employee employee = Employee.builder().firstName("amit").lastName("kumar").email("ak@gmial.com").departmentCode("IT001").organizationCode(
//				"GOOGLE001").build();

//when - operation or the behaviour that we are going to test eg here we would test save operation on employee object
		Employee savedEmployee = employeeRepository.save(employee);

// then - verify the expected output --> here the given object should be returned after save call .
		// you can use static  import to import the asserThat method and can use directly without class name
		Assertions.assertThat(savedEmployee).isNotNull();
		Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
	}

	// get employees
	@Test
	public void givenEmployeeList_whenFindAll_thenReturnEmployeeList() {
// given - precondition or setup
//		Employee employee = Employee.builder().firstName("amit").lastName("kumar").email("ak@gmial.com").departmentCode("IT001").organizationCode(
//				"GOOGLE001").build();
		Employee employee2 = Employee.builder().firstName("john").lastName("cena").email("jc@gmial.com").departmentCode("IT001").organizationCode(
				"GOOGLE001").build();
		employeeRepository.save(employee);
		employeeRepository.save(employee2);
//when - operation or the behaviour that we are going to test eg here we would test save operation on employee object


		List<Employee> list = employeeRepository.findAll();
// then - verify the expected output --> here we have saved 2 objects thus  2 objects should be returned from findALL CALL

		// test for find all
		Assertions.assertThat(list).isNotNull();
		Assertions.assertThat(list.size()).isEqualTo(2);

// ideal way is to create a separate tests for getByEmployeeID method
		// test for getEmployee i.e. by employee id
		Employee emp = employeeRepository.findById(list.get(0).getId()).get();
		Assertions.assertThat(emp).isNotNull();
		Assertions.assertThat(emp.getId()).isEqualTo(list.get(0).getId());
	}

	// findByEmail
	@Test
	public void givenEmail_whenFindByEmail_thenReturnEmployee() {
// given - precondition or setup--> check before each for object creation
		employeeRepository.save(employee);

//when - operation or the behaviour that we are going to test eg here we would test findByEmail operation on employee object
		Employee resp = employeeRepository.findByEmail(employee.getEmail()).get();
// then - verify the expected output --> here we have saved 1 objects so  object with matching email  should be returned from findByEmail CALL

		// test for findByEmail
		Assertions.assertThat(resp).isNotNull();
		Assertions.assertThat(resp.getEmail()).isEqualTo(employee.getEmail());
	}

	//updateEmployee
	@Test
	public void givenEmployeeObject_whenUpdate_thenReturnUpdatedEmployee() {
// given - precondition or setup
		employeeRepository.save(employee);

//when - operation or the behaviour that we are going to test eg here we would test update operation on employee object
		Employee saved = employeeRepository.findById(employee.getId()).get();
		saved.setFirstName("updated first name");
		saved.setLastName("updated last name");
		Employee resp = employeeRepository.save(saved);
// then - verify the expected output --> here we have updated the saved object thus  updated object should be returned

		// assert updated properties are matching or not
		Assertions.assertThat(resp).isNotNull();
		Assertions.assertThat(resp.getFirstName()).isEqualTo(saved.getFirstName());
		Assertions.assertThat(resp.getLastName()).isEqualTo(saved.getLastName());
	}

	// delete employee operation
	@Test
	public void givenEmployeeObject_whenDelete_thenDeleteEmployee() {
// given - precondition or setup
		employeeRepository.save(employee);

//when - operation or the behaviour that we are going to test eg here we would test delete operation on employee object
		employeeRepository.delete(employee);

// then - verify the expected output --> here we have updated the saved object thus  updated object should be returned
		Optional<Employee> resp = employeeRepository.findByEmail(employee.getEmail());
		// assert resp is empty- as repository  findBy calls returns Optional thus we have to check empty instead of null
		Assertions.assertThat(resp).isEmpty();
		Assertions.assertThat(resp.isPresent()).isFalse();
	}

	// JPQL with indexed params (we use firstName=?1 and lastName=?2)
	// we  have firstName & lastName
	@Test
	public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnEmployee() {
// given - precondition or setup
		employeeRepository.save(employee);

//when - operation or the behaviour that we are going to test eg here we would test findBY operation on employee object
		Employee resp = employeeRepository.findByJPQL(employee.getFirstName(), employee.getLastName());

// then - verify the expected output --> here  from findByJPQL call should return the matching object
		// assert resp is empty- as repository  findBy calls returns Optional thus we have to check empty instead of null
		Assertions.assertThat(resp).isNotNull();
		Assertions.assertThat(resp.getFirstName()).isEqualTo(employee.getFirstName());
		Assertions.assertThat(resp.getLastName()).isEqualTo(employee.getLastName());
	}

	// JPQL with names params (we use firstName=:firstName and lastName=:lastName) & have used @Param annotation in method arguments
	// we  have firstName & lastName
	@Test
	public void givenFirstNameAndLastName_whenFindByJPQLNamedParam_thenReturnEmployee() {
// given - precondition or setup
		employeeRepository.save(employee);

//when - operation or the behaviour that we are going to test eg here we would test findBY JPQL named operation on employee object
		Employee resp = employeeRepository.findByJPQLNamedParams(employee.getFirstName(), employee.getLastName());

// then - verify the expected output --> here  from findByJPQLNamedParams call should return the matching object
		// assert resp is empty- as repository  findBy calls returns Optional thus we have to check empty instead of null
		Assertions.assertThat(resp).isNotNull();
		Assertions.assertThat(resp.getFirstName()).isEqualTo(employee.getFirstName());
		Assertions.assertThat(resp.getLastName()).isEqualTo(employee.getLastName());
	}


	// Native Query (we use exact column names in query ef first_name=?1 and last_name=?3
	// we  have firstName & lastName
	@Test
	public void givenFirstNameAndLastName_whenFindByNativeSqlIndexedQuery_thenReturnEmployee() {
// given - precondition or setup
		employeeRepository.save(employee);

//when - operation or the behaviour that we are going to test eg here we would test findBY JPQL named operation on employee object
		Employee resp = employeeRepository.findByNativeSql(employee.getFirstName(), employee.getLastName());

// then - verify the expected output --> here  from findByJPQL call should return the matching object
		// assert resp is empty- as repository  findByNativeSql calls returns Optional thus we have to check empty instead of null
		Assertions.assertThat(resp).isNotNull();
		Assertions.assertThat(resp.getFirstName()).isEqualTo(employee.getFirstName());
		Assertions.assertThat(resp.getLastName()).isEqualTo(employee.getLastName());
	}

	// Native Query (we use exact column names in query ef first_name=?1 and last_name=?3
	// as named params we  have used @Param annotation in method arguments eg: mName(@Param("firstname" String firstName ,@Param("lastName) String
	// lastName))
	@Test
	public void givenFirstNameAndLastName_whenFindByNativeSqlNamedParams_thenReturnEmployee() {
// given - precondition or setup
		employeeRepository.save(employee);

//when - operation or the behaviour that we are going to test eg here we would test findBY JPQL named operation on employee object
		Employee resp = employeeRepository.findByNativeSqlWithNamedParams(employee.getFirstName(), employee.getLastName());

// then - verify the expected output --> here  from findByNativeSqlWithNamedParams call should return the matching object
		// assert resp is empty- as repository  findBy calls returns Optional thus we have to check empty instead of null
		Assertions.assertThat(resp).isNotNull();
		Assertions.assertThat(resp.getFirstName()).isEqualTo(employee.getFirstName());
		Assertions.assertThat(resp.getLastName()).isEqualTo(employee.getLastName());
	}
}
