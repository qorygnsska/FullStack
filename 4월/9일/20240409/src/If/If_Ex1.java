package If;

import java.util.Scanner;


public class If_Ex1 {

	public static void main(String[] args) {
		// 제어문
		// 프로그램을 실행할 때 선택을 하거나 선택한 내용을 반복해야되는 키워드(명령문)
		
		// 조건문(선택)
		// if, switch
		
		// 반복문
		// while, for
		
		
		// if
		/*
		 * if (비교){
		 * 		참이면 실행;
		 * }
		 관계연산자(비교)
		 연산 결과 무조건 참(true) 또는 거짓(false)
		 */
		
		if(true) {
			System.out.println("보임");
		}
		if(false) {
			System.out.println("안보임");
		}
		
		
		// 상수 : 프로그램에서 처리할 데이터를 의미함.
		// 변수 : 프로그램에서 처리할 데이터(상수)를 기억하는 장소
		// 변수 이름은 영문자, 숫자, 특수문자(_)를 사용해서 만들고 첫 글자는 반드시 문자로 시작해야함
		
		// "=" 오른쪽의 데이터를 왼쪽의 기억장소에 대입(할당, 배정) 시키라는 의미
		
		// 1. 자격증 시험 합격 조회
		// 70점 이상 합격 출력
		int score = 70;
		
		if(score >= 70) {
			System.out.println("합격");
		}
		
		
		// 문제 1. 메뉴를 출력하고 번호를 누르면 ~~메뉴입니다.를 출력, 종료 버튼 누를 시 프로그램 종료 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴 번호를 입력하세요 : ");
		
		int num;
		num = sc.nextInt();
		// "==" 같으면 true, 다르면 false
		if(num == 1) {
			System.out.println("입력 메뉴입니다.");
		}
		if(num == 2) {
			System.out.println("수정 메뉴입니다.");
		}
		if(num == 3) {
			System.out.println("조회 메뉴입니다.");
		}
		if(num == 4) {
			System.out.println("삭제 메뉴입니다.");
		}
		if(num == 7) {
			System.out.println("프로그램이 종료됩니다.");
		}
		
		//===========================================
		
		String result = "";
		if(num == 1) {
			result = "입력";
		}
		if(num == 2) {
			result = "수정";
		}
		if(num == 3) {
			result = "조회";
		}
		if(num == 4) {
			result = "삭제";
		}
		if(num == 7) {
			result = "종료";
		}
		System.out.println(result + " 메뉴입니다.");
		
		
		// 90점 이상! A
		// 80점 이상 90점 미만 B
		// 70점 이상 80점 미만 C
		// 60점 이상 70점 미만 D
		// 그외에 F
		System.out.print("평균을 입력하세요 : ");
		int avg = sc.nextInt();
		if (avg >= 90) {
			System.out.println("A");
		}else if(avg >= 80) {
			System.out.println("B");
		}else if(avg >= 70) {
			System.out.println("C");
		}else if(avg >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
		// 키보드로 입력 받는 기능을 더 이상 사용하고 싶지 않으면 close()
		//sc.close();
		
	}

}
