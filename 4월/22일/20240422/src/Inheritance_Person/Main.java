package Inheritance_Person;

public class Main {

	public static void main(String[] args) {
		Student[] stuList = new Student[3];
		stuList[0] = new Student("강건강", 20, 178.2, 70.0, 1, "정보시스템공학과");
		stuList[1] = new Student("남나눔", 21, 187.3, 80.0, 2, "경영학과");
		stuList[2] = new Student("류라라", 23, 167.0, 45.0, 4, "정보통신공학과");
		for(int i = 0; i < 3; i++) {
			stuList[i].sshow();
		}
		
		Employee[] empList = new Employee[2];
		empList[0] = new Employee("박보배", 26, 180.3, 72.0, 1000000, "영업부");
		empList[1] = new Employee("송성실", 38, 182.0, 76.0, 2000000, "기획부");
		for(int i = 0; i < 2; i++) {
			empList[i].eshow();
		}
	}

}
