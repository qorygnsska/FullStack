package ClassArray;

import java.util.Scanner;

/* 과정명
 * Java Application 개발을 위한 프로그래밍 기초
 * 
 * 자료구조 및 알고리즘
 */
class Employee {

	int empNo;
	String name;
	String dept;
	char gender;
	int salary;
	double bouns;
	String phone;

}

public class ClassArrayEx3 {

	public static void main(String[] args) {

		Employee emp1 = new Employee();
		emp1.empNo = 1;
		emp1.name = "홍길동";
		emp1.gender = '남';
		emp1.phone = "010-1234-5678";
		emp1.dept = "인사팀";
		emp1.salary = 4000000;

		Employee emp2 = new Employee();

		emp2.empNo = 2;
		emp2.name = "김길순";
		emp2.gender = '여';
		emp2.phone = "010-5678-1234";
		emp2.dept = "영업팀";
		emp2.salary = 3000000;
		emp2.bouns = 3000000;

		// 직원들을 한 곳에 모아놓은 배열
		Employee[] list = new Employee[5];
		list[0] = emp1;
		list[1] = emp2;

		// 직원 수
		// 배열의 공간의 번호로도 사용!
		int count = 2;

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1. 사원추가     ");
			System.out.println("2. 사원수정     ");
			System.out.println("3. 사원삭제     ");
			System.out.println("4. 사원출력     ");
			System.out.println("9. 프로그램종료 ");
			System.out.print("메뉴번호를누르세요:");

			int sel = sc.nextInt();

			switch (sel) {

			case 1:

				// 배열의 공간이 남아있다면 추가
				if (count <= 5) {
					// 새로운 변수 생성
					Employee e = new Employee();

					System.out.print("사원번호:");
					e.empNo = sc.nextInt();

					sc.nextLine();// 버퍼비우기

					System.out.print("사원이름:");
					e.name = sc.nextLine();

					System.out.print("사원성별:");
					e.gender = sc.nextLine().charAt(0);

					System.out.print("사원 부서:");
					e.dept = sc.nextLine();
					
					System.out.print("전화번호:");
					e.phone = sc.nextLine();

					// 직원 관리하는 리스트
					// 현재 입력한 e변수를 저장 한다.
					list[count] = e;

					// 새로운 직원 추가로 직원의 수가 증가
					// 한다.
					count = count + 1;
				} else {
					System.out.println("배열의 공간이 꽉! 찼다!");

				}
				break;
			case 2:
				while (true) {
					System.out.println("가장 마지막 추가된 직원 수정");
					System.out.println("현재 직원수:" + count);

					Employee update = list[count - 1];

					System.out.println("사원의어떤정보를수정하시겠습니까?");
					System.out.println("1. 전화번호");
					System.out.println("2. 사원연봉");
					System.out.println("3. 보너스율");
					System.out.println("9. 돌아가기");
					System.out.print("메뉴번호를누르세요 :");

					int cho = sc.nextInt();

					if (cho == 1) {
						System.out.print("전화번호 수정:");
						sc.nextLine(); // 버퍼 비우기
						update.phone = sc.nextLine();
					} else if (cho == 2) {
						System.out.print("연봉:");
						update.salary = sc.nextInt();
					} else if (cho == 3) {
						System.out.print("보너스율:");
						update.bouns = sc.nextDouble();
					} else if (cho == 9) {
						System.out.println("돌아가기");
						break;
					}
				}
				break; // switch문도 빠져나가라!
			case 3:
				sc.nextLine(); // 버퍼 비우기
				System.out.println("가장 마지막 직원기준으로 삭제");
				// 1. 직원 정보 가져오기
				// Employee delete = list[count -1];
				// 유동적인 배열

				// 고정된 배열을 사용할 경우
				// 공간의 삭제가 안된다. 인덱스 값을 이용해서
				// 데이터가 없다는 뜻 null

				System.out.print("정말 삭제하시겠습니까?(y/n):");
				char ch = sc.nextLine().charAt(0);

				if (ch == 'Y' || ch == 'y') {

					int deleteIdx = count - 1;
					list[deleteIdx] = null;

					count--;
					System.out.println("데이터 삭제에 성공하였습니다.");
				}

				break;
			case 4:
				// 출력

				for (int i = 0; i < count; i++) {
					System.out.println(list[i].name);
					System.out.println(list[i].phone);
					System.out.println(list[i].gender);
					System.out.println(list[i].dept);
					System.out.println(list[i].bouns);
				}

				break;
			case 9:
				return;

			}// switch
		} // while

	}
}

/*
 * 
 * 
 * 
 * Employee emp1 = new Employee(); emp1.empNo = 100; emp1.empName ="홍길동";
 * emp1.dept = "영업부";
 * 
 * Employee emp2 = new Employee(); emp2.empNo = 101; emp2.empName ="이길동";
 * emp2.dept = "영업부";
 * 
 * Employee emp3 = new Employee(); emp3.empNo = 102; emp3.empName ="장길동";
 * emp3.dept = "영업부";
 * 
 * // 객체 배열의 초기화 Employee[] empList = { emp1,emp2,emp3 }; // 객체 배열 초기화2
 * Employee[] empList2 = { new Employee(), new Employee(), new Employee() };
 * 
 * //출력 for(int i = 0; i < empList.length; i++) {
 * System.out.println(empList[i]);
 * 
 * } 직원들을 관리하는 클래스 클래스 이름 ---------------------------------- 채샘 114~125 페이지
 * 
 * 자료구조 책 86~88페이지
 * 
 * 클래스이름 Shape 그림참조! 사각형 너비 10 높이 10 색상 red 객체 생성 삼각형 너비 10 높이 3 색상 blue 객체 생성
 * 
 * //1. main안에 코드 작성 2. 함수 3. 함수를 이용해서 출력 4. 배열에 넣어서 for문을 이용해서 출력
 * 
 * 
 * System.out.println("가장 마지막 추가된 직원 수정"); System.out.println("현재 직원수:" +
 * count);
 * 
 * Employee update = list[count - 1];
 * 
 * System.out.println("사원의어떤정보를수정하시겠습니까?"); System.out.println("1. 전화번호");
 * System.out.println("2. 사원연봉"); System.out.println("3. 보너스율");
 * System.out.println("9. 돌아가기"); System.out.print("메뉴번호를누르세요 :");
 * 
 * int cho = sc.nextInt();
 * 
 * sc.nextLine(); switch(cho) {
 * 
 * case 1: System.out.print("전화번호 수정:"); update.phone = sc.nextLine();
 * 
 * break; case 2: System.out.print("연봉:"); update.salary = sc.nextInt();
 * 
 * break; case 3: System.out.print("보너스율:"); update.bouns = sc.nextDouble();
 * break; case 9: System.out.println("돌아가기"); break;
 * 
 * } break;
 */