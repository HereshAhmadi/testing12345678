package com.deerpointgroup.deerpointliquorstore.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deerpointgroup.deerpointliquorstore.customer.Customer;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.email = ?1")
	Optional<Customer> findEmployeeByEmail(String email);

	@Query("SELECT e FROM Employee e WHERE e.phone = ?1")
	Optional<Customer> findEmployeeByPhone(long number);

	@Query("SELECT e FROM Employee e WHERE e.name = ?1")
	List<Employee> getEmployeeByName(String name);

}
