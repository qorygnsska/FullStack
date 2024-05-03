package JDBC_Person;

import java.util.Scanner;

public class EmployeeService {
	private Scanner sc = new Scanner(System.in);

	private EmployeeDAO dao = new EmployeeDAO();

	// 직원 메인 메뉴
	public void mainMenu() {

		int menu = 0;

		while (menu != 3) {
			while (true) {
				System.out.println("============================================");
				System.out.println(" 1.직원 추가 2.직원 보기  3.메인으로 돌아가기");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 enter키를 누르세요: ");
				menu = sc.nextInt();
				sc.nextLine();

				if (menu >= 1 && menu <= 3) {
					break;
				}
				System.out.println("메뉴는 1 ~ 3 사이의 정수로 입력해야 합니다.");
			}

			switch (menu) {
			case 1:
				insert();
				break;
			case 2:
				System.out.println("1. 전체 조회 2. 한건 조회");
				System.out.print("입력 : ");
				int sel = sc.nextInt();
				if (sel == 1) {
					print();
				} else if (sel == 2) {
					selcetByEmplyee();
				} else {
					System.out.println("재대로 입력하세요 1~2 사이");
				}
				break;
			}
		}
		System.out.println("메인으로 돌아가기");

	}

	private void selcetByEmplyee() {
		// 1. 학번 조회
		System.out.print("직원번호 입력 : ");
		int empno = sc.nextInt();
		Employee emp = dao.selectByEmpNo(empno);

		// 2. 먼저 학번이 있는지 검색
		// dao에 selectByHakbun(학번)
		// 만약 학번이 있다면 학번의 정보를 출력
		// 한 행을 객체로 반환받고 만약 없으면
		// 찾는 학번은 없습니다! 출력 !
		// 출력은 무조건 서비스에서 하기!
		if (emp == null) {
			System.out.println("찾는 직원번호는 없습니다!");
		} else {
			System.out.println(emp);
		}

	}

	// 추가하기
	public void insert() {

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

		Employee emp = new Employee(name, age, height, weight, salary, dept);
		if (dao.insert(emp)) {
			System.out.println("추가 성공!");
		} else {
			System.out.println("추가 실패..");
		}
	}

	public void print() {
		System.out.println(dao.print());
	}

	// 학생의 현재 수를 카운트하는 메서드
	public int count() {
		return dao.count();
	}
}
