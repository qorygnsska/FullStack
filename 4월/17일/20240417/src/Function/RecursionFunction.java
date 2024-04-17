package Function;


public class RecursionFunction {
	
	public static void hello(int end) {
		if(end == 0) {
			return;
		}
		System.out.println("hello!");
		hello(end - 1);
	}
	
	public static void a() {
		b();
		System.out.println("a");
	}
	public static void b() {
		c();
		System.out.println("b");
	}
	public static void c() {
		System.out.println("c!");
	}
	
	// n과 n-1까지의 합을 계산하는 재귀함수
	public static int sum(int n) {
		if(n == 1) {
			return 1;
		}
		return n + sum(n-1);
	}
	
	/*
	 * 팩토리얼 구하기 
	 *   - 1에서부터 입력한 n까지 정수를 모두 곱한 것
	 */
	public static int factorial(int n) {
		if(n == 1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	
	public static void main(String[] args) {
		
		hello(7);
		
		// a >> b >> c 순서로 진행할 것임
		
		a();
		System.out.println("main 끝");
		
		// 재귀함수
		// - 함수 안에서 자기 자신을 호출하는 것
		// - 함수가 자신을 반복적으로 호출하면서 원하는 결과를 갖는다.
		
		// 호출 스택(call stack)
		// - 프로그램에서 함수나 메서드를 호출할 때 해당 함수나 메서드의 실행이 끝날 때까지 
		//   실행되는 다른 함수나 메서드의 호출 정보를 저장하는 자료구조
		
		// StackOverflowError
		// 호출스택이 꽉 차버리는 경우에 생긴다.
		// 함수를 멈출 수 있는 조건을 줘야한다.
		
		// 재귀를 이용해서 데이터를 저장하는 방식
		// 트리구조
		
		int result = sum(10);
		System.out.println("총합 : " + result);
		
		int fact = factorial(5);
		System.out.println(fact);
		
		 /*  거듭제곱(pow)
		 *   - 하나의 숫자를 다른 숫자(지수)만큼 곱하는것!
		 *   - 22222
		 *   - Math.pow() 함수를 이용하면 재귀함수를
		 *    사용하지 않고도 간단하게 구할 수있다.
		 */
	}

}
