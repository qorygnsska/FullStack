package JDBC_Person;

import java.util.Scanner;

public class PersonService {
	public static void insertStudent() {
		System.out.println("PersonService의 insertStudent() 메서드 실행!!");
		Scanner sc = new Scanner(System.in);

		System.out.print("학생 학번 : ");
		int hakbun = sc.nextInt();
		sc.nextLine();
		System.out.print("학생 이름 : ");
		String name = sc.nextLine();
		System.out.print("학생 나이 : ");
		int age = sc.nextInt();
		System.out.print("학생 키 : ");
		int height = sc.nextInt();
		System.out.print("학생 몸무게 : ");
		int weight = sc.nextInt();
		System.out.print("학생 학년 : ");
		int grade = sc.nextInt();
		sc.nextLine();
		System.out.print("학생 전공 : ");
		String major = sc.nextLine();

		Student stu = new Student(hakbun, name, age, height, weight, grade, major);
		if (PersonDAO.insertStudent(stu)) {
			System.out.println("추가 성공!");
		} else {
			System.out.println("추가 실패..");
		}
	}

	public static void insertEmployee() {
		System.out.println("PersonService의 insertEmployee() 메서드 실행!!");
		Scanner sc = new Scanner(System.in);

		System.out.print("직원 번호 : ");
		int empNo = sc.nextInt();
		sc.nextLine();
		System.out.print("직원 이름 : ");
		String name = sc.nextLine();
		System.out.print("직원 나이 : ");
		int age = sc.nextInt();
		System.out.print("직원 키 : ");
		int height = sc.nextInt();
		System.out.print("직원 몸무게 : ");
		int weight = sc.nextInt();
		System.out.print("직원 급여 : ");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.print("직원 부서 : ");
		String dept = sc.nextLine();

		Employee emp = new Employee(empNo, name, age, height, weight, salary, dept);
		if (PersonDAO.insertEmployee(emp)) {
			System.out.println("추가 성공!");
		} else {
			System.out.println("추가 실패..");
		}

	}
}
