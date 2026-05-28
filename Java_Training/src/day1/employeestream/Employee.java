package employeestream;

public class Employee {
	
	private String id;
	private String name;
	private String department;
	private int salary;
	private boolean activeStatus;
	
	public Employee(String id, String name, String department, int salary, boolean activeStatus) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.activeStatus = activeStatus;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", activeStatus=" + activeStatus + "]";
	}

}
