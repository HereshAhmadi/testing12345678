package com.deerpointgroup.deerpointliquorstore.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getEmployees();
	}

	@PostMapping
	public String registerEmployee(@RequestParam(required = true) String name,
			@RequestParam(required = true) String position, @RequestParam(required = true) long phone,
			@RequestParam(required = true) String email) {

		Employee user = new Employee(name, position, email, phone);
		return employeeService.insertEmployee(user);

	}

	@PutMapping(path = "{employeeId}")
	public void updateStudent(@PathVariable("employeeId") long employeeId, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email, @RequestParam(required = false) String position,
			@RequestParam(required = false) long phone) {

		Employee user = new Employee(name, email, position, phone);
		user.setId(employeeId);
		employeeService.updateEmployee(user);
	}

	@DeleteMapping(path = "{employeeId}")
	public void deleteStudent(@PathVariable("employeeId") Long employeeId) {
		employeeService.deleteCustomer(employeeId);
	}

}
