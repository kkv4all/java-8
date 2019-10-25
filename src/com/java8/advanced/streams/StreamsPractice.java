package com.java8.advanced.streams;

import static com.java8.advanced.streams.model.EmployeeBuilder.anEmployee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.advanced.streams.model.Department;
import com.java8.advanced.streams.model.Employee;
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

			anEmployee().named("Harris", "Ford")
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

			anEmployee().named("Martha", "Vaughn")
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
		
		//map, sort and collect
		practice.getAllEmployeesNames();
		practice.getAllEmployeesByExperience();
		//find and match
		practice.findAndMatchDepartments();
		practice.findAndMatchEmployees();
		//reduce
		practice.countOfEmployee();
		//filter, limit, min, max
		practice.employeeStatastic();
	}

	private void getAllEmployeesNames() {
		System.out.println("----------- map, flatMap, sort and collect ------------");
		System.out.println("Names of All Employees: ");
		List<Employee> allEmployee = departments.stream()
		.flatMap(department -> department.getEmployees().stream())//flatMap function returns streams
		.collect(Collectors.toList());
		
		allEmployee.forEach(employee -> System.out.println(employee.getName()));
	}

	private void getAllEmployeesByExperience() {
		System.out.println("List of All Employees Ordered by Experience: ");
		List<Employee> allEmployee = departments.stream()
				.flatMap(department -> department.getEmployees().stream())
				.sorted(Comparator.comparing(Employee::getYears).reversed())
				//sorted method need Object to have Comparator implemented and reversed function will reversed order
				.collect(Collectors.toList());
		
		allEmployee.forEach(employee -> System.out.println(employee));
	}
	
	private void findAndMatchDepartments() {
		System.out.println("----------- find and match ------------");
		Predicate<Department> departmentHaveMoreThan5Emp = department -> (department.getEmployees().size()>5);
		Optional<Department> firstDepartmentHavingMoreThan5Employees = departments.stream()
		.filter(departmentHaveMoreThan5Emp)
		.findFirst();
		
		System.out.println("firstDepartmentHavingMoreThan5Employees: "+ firstDepartmentHavingMoreThan5Employees);
		
		boolean doesEveryDepartmentHaveMoreThan5Employees = departments.stream()
				.allMatch(departmentHaveMoreThan5Emp);
		System.out.println("doesEveryDepartmentHaveMoreThan5Employees: "+doesEveryDepartmentHaveMoreThan5Employees);
		
		boolean doesAnyDepartmentHaveMoreThan5Employees = departments.stream()
				.anyMatch(departmentHaveMoreThan5Emp);
		System.out.println("doesAnyDepartmentHaveMoreThan5Employees: "+doesAnyDepartmentHaveMoreThan5Employees);
		
		boolean notASingleDepartmentHasMoreThan5Employees = departments.stream()
				.noneMatch(departmentHaveMoreThan5Emp);
		System.out.println("notASingleDepartmentHasMoreThan5Employees: "+notASingleDepartmentHasMoreThan5Employees);
	}
	
	private void findAndMatchEmployees() {
		List<Employee> employees = departments.stream()
				.flatMap(department -> department.getEmployees().stream())
				.collect(Collectors.toList());
		
		Predicate<Employee> employeeWhoHave5YearsExp = employee -> (employee.getYears()>5);
		
		Optional<Employee> anyEmployeeWhoHave5YearsExp = employees.stream()
		.filter(employeeWhoHave5YearsExp)
		.findAny();
		System.out.println("anyEmployeeWhoHave5YearsExp: "+ anyEmployeeWhoHave5YearsExp);
		
		Predicate<Employee> employeeHavingJavaSkillSet = employee -> employee.getSkills().contains("Java");
		boolean doesEveryEmployeeHavingJavaSkillSet = employees.stream()
				.allMatch(employeeHavingJavaSkillSet );
		System.out.println("doesEveryEmployeeHavingJavaSkillSet: "+doesEveryEmployeeHavingJavaSkillSet);
		
		boolean doesAnyEmployeeHavingJavaSkillSet = employees.stream()
				.anyMatch(employeeHavingJavaSkillSet);
		System.out.println("doesAnyEmployeeHavingJavaSkillSet: "+doesAnyEmployeeHavingJavaSkillSet);
		
		boolean notASingleEmployeeHasJavaSkillSet = employees.stream()
				.noneMatch(employeeHavingJavaSkillSet);
		System.out.println("notASingleEmployeeHasJavaSkillSet : "+notASingleEmployeeHasJavaSkillSet);
	}

	private void countOfEmployee() {
		System.out.println("----------- reduce ------------");
		int countOfAllEmployees = departments.stream()
				.mapToInt(department -> department.getEmployees().size())
				.reduce(0,(sum,count) -> sum+count);
		
		System.out.println("countOfAllEmployees: "+countOfAllEmployees);
	}
	
	private void employeeStatastic() {
		System.out.println("----------- filter, limit, min, max ------------");
		List<Employee> employees = departments.stream()
				.flatMap(department -> department.getEmployees().stream())
				.collect(Collectors.toList());
		
		Map<String, Integer> skillBreakups = employees.stream()
				.flatMap(employee -> employee.getSkills().stream())
				.collect(
						Collectors.toMap(skill -> skill, //keyMapper Function
								skill -> 1, //valueMapper Function
								(count,skill)-> ((int)count+1) //mergeFunction operation to do in case of duplicate key
								));
		System.out.println("Skill Breakouts: "+skillBreakups);
		
		Map<String, Integer> positionBreakups = employees.stream()
				.map(employee -> employee.getPosition().getName())
				.collect(
						Collectors.toMap(position -> position, //keyMapper Function
								position -> 1, //valueMapper Function
								(count,position)-> ((int)count+1) //mergeFunction operation to do in case of duplicate key
								));
		System.out.println("Position Breakouts: "+positionBreakups);
		
		List<Employee> employeeHasSalryMoreThan15K = employees.stream()
				.filter(employee -> employee.getSalary()>15000)
				.collect(Collectors.toList());
		System.out.println("Employee has salry more than 15K: ");
		employeeHasSalryMoreThan15K.forEach(System.out::println);
		
		List<Employee> top5SalaryEarner = employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed())
				.limit(5)
				.collect(Collectors.toList());
		System.out.println("Top 5 Salary Earner: ");
		top5SalaryEarner.forEach(System.out::println);
		
		Optional<Employee> mostExperiencedEmployee = employees.stream()
				.max(Comparator.comparing(Employee::getYears));
		System.out.println("Most experienced employee: " + mostExperiencedEmployee);
		
		Optional<Employee> lowestEarningEmployee = employees.stream()
				.min(Comparator.comparing(Employee::getSalary));
		System.out.println("Lowest earning employee: " + lowestEarningEmployee);
	}
}
