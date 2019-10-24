package com.java8.advanced.streams.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EmployeeBuilder {
	private String firstName;
	private String lastName;
	private Position position;
	private String[] skills;
	private int salary;

	public static EmployeeBuilder anEmployee() {
		return new EmployeeBuilder();
	}

	public EmployeeBuilder named(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		return this;	
	}

	public EmployeeBuilder as(Position position) {
		this.position = position;
		return this;
	}

	public EmployeeBuilder withSkills(String... skills) {
        this.skills = skills;
        return this;
	}

	public EmployeeBuilder earns(int salary) {
		this.salary = salary;
		return this;
	}

	public Employee build() {
		Employee employee = new Employee(this.firstName,this.lastName,this.position,this.salary);
		employee.setSkills(Arrays.stream(skills).collect(Collectors.toList()));
		return employee;
	}

}
