package com.deerpointgroup.deerpointliquorstore.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", allocationSize = 1)

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
	private Long id;

	private String name;
	private String position;
	private String email;
	private long phone;

	public Employee() {

	}

	public Employee(String name, String position, String email, long phone) {

		this.name = name;
		this.position = position;
		this.email = email;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}
