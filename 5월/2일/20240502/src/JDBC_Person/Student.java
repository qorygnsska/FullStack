package JDBC_Person;

public class Student extends Person{
	private int hakbun;
	private int grade;
	private String major;
	
	public Student() {}

	public Student(int hakbun, String name, int age, int height, int weight, int grade, String major) {
		super(name, age, height, weight);
		this.hakbun = hakbun;
		this.grade = grade;
		this.major = major;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
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

	@Override
	public String toString() {
		return "Student [hakbun=" + hakbun + ", grade=" + grade + ", major=" + major + "]";
	}

	
	
	
}
