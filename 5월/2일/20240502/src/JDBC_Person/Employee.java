package JDBC_Person;

public class Employee extends Person{
	private int empNo;
	private int salary;
	private String dept;
	public Employee(int empNo, String name, int age, int height, int weight, int salary, String dept) {
		super(name, age, height, weight);
		this.empNo = empNo;
		this.salary = salary;
		this.dept = dept;
	}
	
	public Employee() {}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", salary=" + salary + ", dept=" + dept + "]";
	}

	
	
}
