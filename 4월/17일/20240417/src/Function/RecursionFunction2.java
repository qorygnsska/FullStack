package Function;

import java.util.Scanner;

public class RecursionFunction2 {
	
	// 피보나치 수열 출력 재귀함수
	public static int fibonacci(int num) {
		if(num == 0) {
			return 0;
		}else if(num == 1) {
			return 1;
		}else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}
	
	public static void main(String[] args) {
		
		// 피보나치 수열
		// - 첫번 및 둘째 항이 1이며, 그 뒤의 모든 항은 바로 앞 두 항의 합인 수열
		int a = 1; // 1번째 값 초기화
		int b = 1; // 2번째 값 초기화
		int y = 2; // 1번째 값 + 2번째 값 더한 합계
		// n번째 항 까지의 피보나치 수열의 합을 기억한다
		// 피보나치 수열의 합계를 계산할 항을 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("피보나치 수열의 합계를 계산할 항을 입력 : ");
		int n = sc.nextInt();
		
		// 2번째 항 까지는 이미 계산이 되어있는 상태이므로 3번째 항부터 n번째 항까지 반복하며 합계를 계산
		for(int k = 3; k <= n; k++) {
			int c = a + b;
			
			y += c;
			// 피보나치 수열의 다음 항 값을 계산하기 위해서 변수의 값을 수정한다.
			a = b;
			b = c;
		}
		
		System.out.println("피보나치 수열의 " + n + "번째 항까지의 합 : " + y);
		
		
		// 소수 구하기
		// - 내가 키보드로 입력한 숫자가 소수인 지 판단하는 프로그램 만들기
		System.out.print("정수 입력 : ");
		int n2 = sc.nextInt();
		int i;
		for(i = 2; i <= n2; i++) {
			if(n2 % i == 0) {
				// 나눠서 떨어지면 반복 탈출
				break;
			}
		}
		
		// 소수인 지 판단
		if(n2 == i) {
			System.out.println(n2 + "은 소수 입니다.");
		}else {
			System.out.println(n2 + "은 소수가 아닙니다.");
		}
		
		
		
		
		
		
		
		
		
		
	}

}
