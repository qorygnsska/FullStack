package JDBC_Person;

import java.util.Scanner;

// 학생의 데이터베이스를 들어가기 전에
// 처리해야되는 전처리 클래스(입력 + 결과출력)

// jsp에서 service는 오로지 데이터베이스로 가기 위한 전처리만 하는 기능이다
public class StudentService {

	private Scanner sc = new Scanner(System.in);

	private StudentDAO dao = new StudentDAO();

	// 학생 메인 메뉴
	public void mainMenu() {

		int menu = 0;

		while (menu != 5) {
			while (true) {
				System.out.println("============================================");
				System.out.println(" 1.학생 추가 2.학생 보기 3.정보 수정 4.삭제 5.메인으로 돌아가기");
				System.out.println("============================================");
				System.out.print("원하는 메뉴를 입력하고 enter키를 누르세요: ");
				menu = sc.nextInt();
				sc.nextLine();

				if (menu >= 1 && menu <= 5) {
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
					selcetByStudent();
				} else {
					System.out.println("재대로 입력하세요 1~2 사이");
				}

				break;
			case 3:
				update();
				
				break;
			case 4:
				delete();
				break;
			}
		}
		System.out.println("메인으로 돌아가기");

	}
	
	
	private void delete() {
		System.out.print("삭제할 학번 입력 : ");
		int hakbun = sc.nextInt();
		Student stu = dao.selectByHakbun(hakbun);
		if(stu == null) {
			System.out.println("찾는 학번은 없습니다!");
		}else {
			if(dao.delete(hakbun)) {
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제 실패");
			}
		}
		
	}


	// 학번으로 검색해서 학번이 있으면 몸무게와 키를 변경하는 dao
	// 학번이 없으면 없다 출력
	private void update() {
		System.out.print("학번 입력 : ");
		int hakbun = sc.nextInt();
		Student stu = dao.selectByHakbun(hakbun);
		if(stu == null) {
			System.out.println("찾는 학번은 없습니다!");
		}else {
			System.out.print("키 입력 : ");
			int height = sc.nextInt();
			System.out.print("몸무게 입력 : ");
			int weight = sc.nextInt();
			if(dao.update(hakbun, height, weight)) {
				System.out.println("변경 완료");
			}else {
				System.out.println("변경 실패");
			}
		}
		
	}

	private void selcetByStudent() {
		
		// 1. 학번 조회
		System.out.print("학번 입력 : ");
		int hakbun = sc.nextInt();
		Student stu = dao.selectByHakbun(hakbun);

		// 2. 먼저 학번이 있는지 검색
		// dao에 selectByHakbun(학번)
		// 만약 학번이 있다면 학번의 정보를 출력
		// 한 행을 객체로 반환받고 만약 없으면
		// 찾는 학번은 없습니다! 출력 !
		// 출력은 무조건 서비스에서 하기!
		if(stu == null) {
			System.out.println("찾는 학번은 없습니다!");
		}else {
			System.out.println(stu);
		}
	}

	// 추가하기
	public void insert() {

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

		Student stu = new Student(name, age, height, weight, grade, major);
		if (dao.insert(stu)) {
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
