package JDBC_Person;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StudentService stuservice = new StudentService();
		EmployeeService empservice = new EmployeeService();

		int menu = 0;
		int stuCount = 0;
		int empCount = 0;

		while (menu != 3) {
			while (true) {
				
				stuCount = stuservice.count();
				empCount = empservice.count();
				System.out.println("현재 저장된 학생 : " + stuCount + "명");
				System.out.println("현재 저장된 직원 : " + empCount + "명");
				
				System.out.println("============================================");
				System.out.println(" 1.학생  2.직원  3.종료");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 enter키를 누르세요: ");
				menu = sc.nextInt();
			
				if (menu >= 1 && menu <= 3) {
					break;
				}
				System.out.println("메뉴는 1 ~ 3 사이의 정수로 입력해야 합니다.");
			}

			switch (menu) {
			case 1:
				// 학생
				stuservice.mainMenu();
				break;
			case 2:
				// 사원
				empservice.mainMenu();
				break;
			}
		}
		System.out.println("프로그램을 종료합니다. 바이바이~~~~~");

	}

}
