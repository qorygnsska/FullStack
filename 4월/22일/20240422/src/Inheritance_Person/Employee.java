package Inheritance_Person;

public class Employee extends Person{
	int salary;
	String dept;
	
	public Employee() {}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
		
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
	
	void eshow() {
		show();
		System.out.println("급여 : " + salary);
		System.out.println("부서 : " + dept);
	}
	
}
