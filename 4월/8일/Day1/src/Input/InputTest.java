package Input;

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		
		//키보드로 입력받는 것 하고 싶을 땐 필수적으로 선언
		Scanner sc = new Scanner(System.in);
		
		// 문제0. 키보드로 입력 받은 하나의 정수가 양수면 양수다 아니면 양수가 아니다 출력
		System.out.print("정수를 입력하세요 : ");
		int n1 = sc.nextInt();
		// 삼항 연산자 (비교문 ? 참인 경우 : 거짓인 경우)
		String resultt = n1 > 0 ? "양수다" : "양수가 아니다";
		System.out.println(resultt);
				
		
		// 문제1. 키보드로 입력 받은 하나의 정수가 짝수이면 짝수다 아니면 홀수다 출력
		System.out.print("정수를 입력하세요 : ");
		int n2 = sc.nextInt();
		String result = n2 % 2 == 0 ? "짝수다" : "홀수다";
		System.out.println(result);
		
		
		// 문제2. 키보드로 나이를 입력 받는다, 입력받은 나이가  20세 미만이면 "청소년" 이상이면 "성인"
		System.out.print("나이를 입력핳세요 : ");
		int age = sc.nextInt();
		String result2 = age < 20 ? "청소년" : "성인";
		System.out.println(result2);
		
		
		// 문제3. 실수를 입력받고 정수형으로 출력
		System.out.print("실수를 입력하세요 : ");
		double flo = sc.nextDouble();
		System.out.println((int)flo);
		
		/*
		 * 4. 논리 연산자
		 * 
		 * 1. 종류
		 * 1) &&(and) 그리고 : 양쪽 모두 참이어야, 참 

		 * 2) || (or) 또는 : 양쪽중 어느 한쪽이라도 참이면, 참  
		   // ||의 키보드위치는  쉬프트 + 한글 원(돈) 표시이다.
		 * 
		 * 2. 역할

		 * 1) 논리 연산자를 통해 여러개의 비교연산자를 연결할 수 있다.
		 * 2) 논리 연산자를 통해 범위 설정이 가능하다. 
		 */
		
		// 문제4. number, n, m number가 n의 배수이면서 m의 배수이면 1 아니면 0
		System.out.print("number 입력하세요 : ");
		int number = sc.nextInt();
		System.out.print("n 입력하세요 : ");
		int n = sc.nextInt();
		System.out.print("m 입력하세요 : ");
		int m = sc.nextInt();
		int result3 = number % n == 0 && number % m == 0 ? 1 : 0;
		System.out.println(result3);
		
		// 참과 거짓을 저장하는 타입
		boolean isResult = true;
		boolean isResult2 = false;
//		boolean isResult3 = 1; 에러
//		boolean isResult4 = 1.1; 에러
		boolean isResult5 = (10 == 10);		
		
		// 예약어
		// 자바에서 미리 지정해 놓은 기능, 변수명으로 사용할 수 없음!
		
		//문제5. a와 b의 값을 바꿔라
		int a = 10;
		int b = 20;
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("a의 값 : " + a + ", b의 값 : " + b);
		
		// 문제6. 정수 두개 입력 받아 num1, num2 각각 저장 그리고 다른 정수를 입력받아 그 수가 num1 이하거나 num2 초과이면 true 아니면 false 단 num1은 num2보다 작음
		System.out.print("num1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("num2 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("num3 입력 : ");
		int num3 = sc.nextInt();
		boolean isresult = num3 <= num1 || num3 > num2 ? true : false;
		System.out.println(isresult);
		
		
	}

}
