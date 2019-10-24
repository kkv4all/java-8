package com.java8.advanced.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.advanced.streams.model.Department;
import com.java8.advanced.streams.model.Employee;
import static com.java8.advanced.streams.model.EmployeeBuilder.anEmployee;
import com.java8.advanced.streams.model.Position;

public class StreamsPractice {
	private List<Department> departments;

	private List<Employee> webDevs = Arrays.asList(
			anEmployee().named("John", "Doe")
			.as(Position.DEVELOPER)
			.withSkills("Java", "JSP", "GlassFish", "MySql", "AngularJS")
			.expericeOf(5)
			.earns(25000)
			.build(),

			anEmployee().named("John", "Doe")
			.as(Position.DEVELOPER)
			.withSkills("Java", "MySQL", "MSSQL", "Spring", "AngularJS")
			.expericeOf(3)
			.earns(15000)
			.build(),

			anEmployee().named("Dave","Moriss")
			.as(Position.DEVELOPER)
			.withSkills("C#", "ASP.NET", "React", "AngularJS")
			.expericeOf(3)
			.earns(20000)
			.build(),

			anEmployee().named("Brad", "Johston")
			.as(Position.DESIGNER)
			.withSkills("AngularJS", "React", "CSS","Grunt")
			.expericeOf(3)
			.earns(16000)
			.build(),

			anEmployee().named("Ronald", "Wynn")
			.as(Position.QA)
			.withSkills("Selenium", "C#", "Java")
			.expericeOf(1)
			.earns(12000)
			.build(),

			anEmployee().named("Erich", "Kohn")
			.as(Position.QA)
			.withSkills("Selenium", "JavaScript", "Protractor")
			.expericeOf(3)
			.earns(15000)
			.build(),

			anEmployee().named("Philip", "Branson")
			.as(Position.DEV_OPS)
			.withSkills("CentOS", "bash", "c", "puppet", "chef", "Ansible")
			.expericeOf(4)
			.earns(18000)
			.build(),

			anEmployee().named("Philip", "Branson")
			.as(Position.DEV_OPS).withSkills("CentOS", "bash", "c", "puppet", "chef", "Ansible").earns(12500)
			.build(),

			anEmployee().named("Karl", "Madsen")
			.as(Position.DEV_OPS)
			.withSkills("Ubuntu", "bash", "Python", "chef")
			.expericeOf(2)
			.earns(10000)
			.build()
		);
	private List<Employee> windowDevs = Arrays.asList(
			anEmployee().named("Eric","Morisson")
			.as(Position.DEVELOPER)
			.withSkills("C#", "VB.NET", "WPF", "MSSQL")
			.expericeOf(4)
			.earns(16000)
			.build(),

			anEmployee().named("Bradly", "Coops")
			.as(Position.DEVELOPER)
			.withSkills("Java", "MySQL", "Swing")
			.expericeOf(4)
			.earns(17500)
			.build(),

			anEmployee().named("Paul", "McGraw")
			.as(Position.QA)
			.withSkills("Selenium", "C#", "Java")
			.expericeOf(6)
			.earns(20000)
			.build(),

			anEmployee().named("Karl", "Boris")
			.as(Position.DEV_OPS)
			.withSkills("CentOS", "bash", "c", "puppet", "chef", "Ansible")
			.expericeOf(2)
			.earns(10500)
			.build()
		);
	private List<Employee> mobileDevs = Arrays.asList(
			anEmployee().named("Larry","Bezz")
			.as(Position.DEVELOPER)
			.withSkills("Android", "Firebase", "Java", "Ionic")
			.expericeOf(3)
			.earns(20000)
			.build(),

			anEmployee().named("George", "Potts")
			.as(Position.DEVELOPER)
			.withSkills("Swift", "Objective-C", "Cocoa Touch")
			.expericeOf(4)
			.earns(27500)
			.build(),

			anEmployee().named("Amanda", "Luise")
			.as(Position.QA)
			.withSkills("Appium", "Ruby", "Java")
			.expericeOf(2)
			.earns(12500)
			.build(),

			anEmployee().named("Peter", "Kips")
			.as(Position.DEV_OPS)
			.withSkills("Xamarin", "Azure", "Java", "Objective-C", "Swift")
			.expericeOf(1)
			.earns(14000).build()
			);

	public StreamsPractice(){
		departments = Arrays.asList(
				new Department("Web Development",webDevs),
				new Department("Windows Development",windowDevs),
				new Department("Mobile Development",mobileDevs)
				);
	}

	public static void main(String[] args) {
		StreamsPractice practice = new StreamsPractice();
		
		practice.getAllEmployeesNames();
	}

	private void getAllEmployeesNames() {
		List<Employee> allEmployee = departments.stream()
		.map(department -> department.getEmployees())
		.collect(Collectors.toList()); //Compilation error: Type mismatch: cannot convert from List<List<Employee>> to List<Employee>
	}
}
