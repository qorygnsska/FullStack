package Input; // 새로운 패키지 생성

import java.util.Scanner;

public class InputEx {

	public static void main(String[] args) {
		
		//코드를 이동 Alt + 방향키 신기하네 ㅋ
		System.out.println("시작하는 함수");
		
		// 입력창, 검색창, 매번 다른값을 키보드로 입력 하는 것
		// Scanner(java.util 폴더)
		Scanner sc = new Scanner(System.in);
		
		/*
		    * 연산자?
		    *  - 연산을 수행하는 기호
		    
		    * 피연산자?
		    * - 연산에 참여하는 변수나 상수 값


			 * 3. 비교 연산자
			 * => 어떤 결과를 비교해서  결과를  참(true) 또는 거짓(false)으로 나타내는 연산자
			 * 1. 크니?				>             
			 * 2. 작니?				<
			 * 3. 같니?				==
			 * 4. 다르니?				!=
			 * 5. 크거나 같니?			>=
			 * 6. 작거나 같니?			<=
		*/
		System.out.println(10 >= 10);
		System.out.println(10 == 10);
		
		System.out.print("정수를 입력하세요 : ");

		// 키보드로 정수를 입력
		int num = sc.nextInt();
	    System.out.println("입력하신 숫자는 " + num + "입니다.");
		
		// 실수
	    System.out.print("실수를 입력하세요 : ");
		
		// 키보드로 정수를 입력
		double num2 = sc.nextInt();
		System.out.println("입력하신 숫자는 " + num2 + "입니다.");
		
	}

}
