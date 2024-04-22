package Inheritance_Person;

public class Student extends Person{
	private int grade;
	private String major;
	
	public Student(){}

	public Student(String name, int age, double height, double weight, int grade, String major) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
		
		
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
	void sshow() {
		show();
		System.out.println("학년  : " + grade);
		System.out.println("전공  : " + major);
	}
	
}
