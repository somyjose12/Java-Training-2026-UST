package employeestream;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> list = Arrays.asList(new Employee("101", "Anu", "HR", 50000, true)
				,new Employee("102", "Aaron", "Finance", 70000, true),
				 new Employee("103", "Silpa", "IT", 60000, false),
				 new Employee("104", "Remya", "HR", 40000, true),
				 new Employee("105", "Manu", "IT", 90000, false));
		
		// Fetch Employees with salary > 60000
		List<Employee> empListBySalary = list.stream().filter(e -> e.getSalary() > 60000)
						.collect(Collectors.toList());
		
		System.out.println("Employees with salary > 60000");
		for(Employee e: empListBySalary) {
			System.out.println(e.getName() + " " + e.getSalary());
		}
		
		// Convert Employee names to Uppercase
		List<Employee> updatedNameList = list.stream()
				.map(e -> new Employee(
						e.getId(), 
						e.getName().toUpperCase(),
						e.getDepartment(),
						e.getSalary(),
						e.isActiveStatus()
						)).toList();
		
		System.out.println("Updated Names List");
		
		//updatedNameList.forEach(System.out::println);
		
		list.stream().map(Employee::getName)
					.map(String::toUpperCase)
					.forEach(System.out::println);
		
		//Sort Employees by salary descending
		List<Employee> sortedListBySalary = list.stream()
				.sorted((e1,e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
				.collect(Collectors.toList());
		
		System.out.println("Sorted List By Salary");
		
		sortedListBySalary.forEach(System.out::println);
		
		//Count of active employees
		System.out.println("Count of active employees");
		
		list.stream().filter(Employee::isActiveStatus)
					.map(Employee::getName)
					.forEach(System.out::println);
		
		//Group employees departmentwise
		System.out.println("Group employees departmentwise");
		
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		
		//Highest salaried employee
		Optional<Employee> highestSalariedEmployee = list.stream()
				.max(Comparator.comparingInt(Employee::getSalary));
		
		System.out.println("Highest paid employee");
		
		highestSalariedEmployee.ifPresent(e -> System.out.print(e));
		
		//Second highest salary Employee
		Optional<Employee> secondHighestSalariedEmployee = list.stream()
				.sorted(Comparator.comparingInt(Employee::getSalary).reversed())
				.skip(1)
				.findFirst();
		
		System.out.println("Second highest paid employee");
		
		secondHighestSalariedEmployee.ifPresent(e -> System.out.print(e));
	}
}
		