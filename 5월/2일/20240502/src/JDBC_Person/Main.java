package JDBC_Person;

import java.util.Scanner;


public class Main {
	public static PersonDAO pd = new PersonDAO();
	public static void main(String[] args) {
		/*
		 * 학생과 직원을 선택해서
		 * 추가하는 프로그램을 만드시오
		 * 데이터베이스에 저장!!
		 */
		Scanner sc = new Scanner(System.in);

		int menu = 0;

		while (menu != 3) {
			while (true) {
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
				PersonService.insertStudent();
				break;
			case 2:
				// 사원
				PersonService.insertEmployee();
				
				break;
			}
		}
		System.out.println("프로그램을 종료합니다. 바이바이~~~~~");

	}

	


}
