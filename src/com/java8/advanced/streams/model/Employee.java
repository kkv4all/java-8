package com.java8.advanced.streams.model;

import java.util.List;

public class Employee {
	private String firstName;
	private String lastName;
	private Position position;
	private List<String> skills;
	private int years;
	private int salary;
	
    public Employee(String firstName, String lastName, Position position, int years, int salary) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.position = position;
    	this.years = years;
    	this.salary = salary;
    }
	public String getName() {
        return this.firstName + " " + this.lastName;
    }
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public int getYears() {
		return years;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "{firstName: " + firstName + ", lastName: " + lastName + ", position: " + position.getName() + ", skills: "
				+ skills + ", years: " + years + ", salary: " + salary + "}";
	}
}
