package com.deerpointgroup.deerpointliquorstore.employee;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deerpointgroup.deerpointliquorstore.customer.Customer;

@Service
public class EmployeeService {

//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	public String insertEmployee(Employee user) {
//
//		if (user == null || user.getEmail().length() == 0 || user.getName().length() == 0
//				|| user.getPosition().length() == 0 || (user.getPhone() + "").length() != 10) {
//			return "Invalid Information of Employee!!!";
//		}
//
//		Optional<Customer> alreadyExist = employeeRepository.findEmployeeByEmail(user.getEmail());
//
//		if (alreadyExist.isPresent()) {
//			return "Email already exist!!!";
//		}
//
//		employeeRepository.save(user);
//		return "Employee Account created";
//
//	}
//
////	public void deleteEmployee(Employee user) {
////
////		long empId = user.getId();
////		boolean exists = employeeRepository.existsById(empId);
////
////		if (!exists) {
////			throw new IllegalStateException("Employee with id" + empId + " does not exist");
////		}
////
////		employeeRepository.deleteById(empId);
////	}
//
//	@Transactional
//	public void updateEmployee(Employee user) {
//
//		long empId = user.getId();
//		boolean exists = employeeRepository.existsById(empId);
//
//		if (!exists) {
//			throw new IllegalStateException("Employee with id" + empId + " does not exist");
//		}
//
//		if (user == null || user.getEmail().length() == 0 || user.getName().length() == 0
//				|| user.getPosition().length() == 0 || (user.getPhone() + "").length() < 10) {
//			throw new IllegalStateException("Customer with id" + empId + " does not exist");
//		}
//
//		Employee employee = employeeRepository.getById(empId);
//
//		String email = user.getEmail();
//		long number = user.getPhone();
//
//		if (email != null & email.equals(" ") && !Objects.equals(employee.getEmail(), email)) {
//
//			Optional<Customer> empOptional = employeeRepository.findEmployeeByEmail(email);
//
//			if (empOptional.isPresent()) {
//				throw new IllegalStateException("Email taken");
//			}
//
//		}
//
//		if ((number + "").length() < 10) {
//
//			Optional<Customer> empOptional = employeeRepository.findEmployeeByPhone(number);
//
//			if (empOptional.isPresent()) {
//				throw new IllegalStateException("Phone Number already exist");
//			}
//
//		}
//
//		employee.setEmail(user.getEmail());
//		employee.setName(user.getName());
//		employee.setPhone(user.getPhone());
//		employee.setPosition(user.getPosition());
//
//		employeeRepository.save(employee);
//
//	}
//
//	public List<Employee> getEmployees() {
//		return employeeRepository.findAll();
//	}
//
//	public List<Employee> getEmployee(String name) {
//		List<Employee> list = employeeRepository.getEmployeeByName(name);
//		return list;
//	}
//
//	public void deleteCustomer(Long empId) {
//
//		boolean exists = employeeRepository.existsById(empId);
//
//		if (!exists) {
//			throw new IllegalStateException("Employee with id" + empId + " does not exist");
//		}
//
//		employeeRepository.deleteById(empId);
//
//	}

}
