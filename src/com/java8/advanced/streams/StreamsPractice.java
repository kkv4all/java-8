package com.java8.advanced.streams;

import java.util.Arrays;
import java.util.List;

import com.java8.advanced.streams.model.Department;
import com.java8.advanced.streams.model.Employee;
import com.java8.advanced.streams.model.EmployeeBuilder;
import com.java8.advanced.streams.model.Position;

public class StreamsPractice {
	List<Department> departments;
	List<Employee> webDevs = Arrays.asList(
			EmployeeBuilder.anEmployee()
			.named("John", "Doe")
			.as(Position.DEVELOPER).withSkills("Java", "JSP", "GlassFish", "MySql", "AngularJS").earns(10000)
			.build(),
			EmployeeBuilder.anEmployee().named("John", "Doe")
			.as(Position.DEVELOPER).withSkills("Java", "MySQL", "MSSQL", "Spring", "AngularJS").earns(10000)
			.build(),
			EmployeeBuilder.anEmployee().named("Dave","Moriss")
			.as(Position.DEVELOPER).withSkills("C#", "ASP.NET", "React", "AngularJS")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Brad", "Johston")
			.as(Position.DESIGNER).withSkills("AngularJS", "React", "CSS","Grunt")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Ronald", "Wynn")
			.as(Position.QA).withSkills("Selenium", "C#", "Java")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Erich", "Kohn")
			.as(Position.QA).withSkills("Selenium", "JavaScript", "Protractor")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Philip", "Branson")
			.as(Position.DEV_OPS).withSkills("CentOS", "bash", "c", "puppet", "chef", "Ansible")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Philip", "Branson")
			.as(Position.DEV_OPS).withSkills("CentOS", "bash", "c", "puppet", "chef", "Ansible")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Karl", "Madsen")
			.as(Position.DEV_OPS).withSkills("Ubuntu", "bash", "Python", "chef")
			.earns(10000).build()
			);
	List<Employee> windowDevs = Arrays.asList(
			EmployeeBuilder.anEmployee().named("Eric","Morisson")
			.as(Position.DEVELOPER).withSkills("C#", "VB.NET", "WPF", "MSSQL")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Bradly", "Coops")
			.as(Position.DEVELOPER).withSkills("Java", "MySQL", "Swing")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Paul", "McGraw")
			.as(Position.QA).withSkills("Selenium", "C#", "Java")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Karl", "Boris")
			.as(Position.DEV_OPS).withSkills("CentOS", "bash", "c", "puppet", "chef", "Ansible")
			.earns(10000).build()
			);
	List<Employee> mobileDevs = Arrays.asList(
			EmployeeBuilder.anEmployee().named("Larry","Bezz")
			.as(Position.DEVELOPER).withSkills("Android", "Firebase", "Java", "Ionic")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("George", "Potts")
			.as(Position.DEVELOPER).withSkills("Swift", "Objective-C", "Cocoa Touch")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Amanda", "Luise")
			.as(Position.QA).withSkills("Selenium", "C#", "Java")
			.earns(10000).build(),

			EmployeeBuilder.anEmployee().named("Peter", "Kips")
			.as(Position.DEV_OPS).withSkills("CentOS", "bash", "c", "puppet", "chef", "Ansible")
			.earns(10000).build()
			);

	StreamsPractice(){
		departments = Arrays.asList(
				new Department("Web Development",webDevs),
				new Department("Windows Development",windowDevs),
				new Department("Mobile Development Development",mobileDevs)
			);
	}
}
