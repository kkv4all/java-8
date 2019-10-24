package com.java8.advanced.streams.model;

public enum Position {
	DEVELOPER("Developer"),
	DEV_OPS("DevOps"),
	DESIGNER("Designer"),
	QA("Quality Analyst");
	
	private String name;

	Position(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
