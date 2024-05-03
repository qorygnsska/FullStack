package JDBC_Person;

public class Employee extends Person{
	private int salary;
	private String dept;
	private int empno;
	
	public Employee() {}

	public Employee(String name, int age, int height, int weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
	}
	
	public Employee(int empno, String name, int age, int height, int weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
		this.empno = empno;
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

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	@Override
	public String toString() {
		
		return super.toString() + ", salary=" + salary + ", dept=" + dept + ", empno=" + empno + "]";
	}
	
	
	
	
}
