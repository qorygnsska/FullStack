package JDBC_Person;

public class Student extends Person{
	
	
	// 학번을 각각 정하는 인스턴스 변수
	private int hakbun;
	private int grade;
	private String major;
	
	public Student() {}

	public Student(String name, int age, int height, int weight, int grade, String major) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
	}
	
	public Student(int hakbun, String name, int age, int height, int weight, int grade, String major) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
		this.hakbun = hakbun;
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
		return super.toString() + ", hakbun=" + hakbun + ", grade=" + grade + ", major=" + major + "]\n";
	}

	
	
	
}
