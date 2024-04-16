package Function;

public class FunctionEx3 {
	
	public static void printFor(int 시작,int 끝) {
		
		for (int start = 시작; start <= 끝; 
								start++) {
			System.out.println(start);
		}
		//줄바꿈 혹은 공백 한 칸 만들어라!
		System.out.println();
	}
	
	public static void main(String[] args) {
		// (매개변수)
		// 함수의 장점
		// - 재사용성이 좋다!
		// - 중복코드를 제거할 수있다.
		// - 코드를 추가하거나 삭제하거나 변경을 할 때
		// 코드마다 직접 가서 변경하는 것이 아니라
		// 하나의 함수안에서 변경하면 된다.
		// 유지 보수 효율이 좋다.
		
		// for문 이용해서 1~5까지
		printFor(1,5);		
		// for문 이용해서 1~50까지 출력
		printFor(1,50);	
		// for문 이용해서 1~100까지 출력
		printFor(1,100);
		// for문 이용해서 -6~6까지 출력
		printFor(-6,6);
		// for문 이용해서 100~1000까지 출력
		printFor(100, 1000);
		// 입력받은 정수부터 100까지 출력 
		printFor(99, 100);
		// 1부터 입력받은 정수까지 출력 
		printFor(1, 10);

	}
	
	/*
	 * 
	 * // for문 이용해서 1~5까지
		printFor1();

		// for문 이용해서 1~50까지 출력
		printFor2();

		// for문 이용해서 1~100까지 출력
		printFor3();
	 * 
	 */
	//
//	// 함수이름은 중복이름을 쓸 수 없다!
//	public static void printFor1() {
//		// for문 이용해서 1~5까지
//		for (int start = 1; start <= 5; start++) {
//			System.out.println(start);
//		}
//	}
//
//	public static void printFor2() {
//		// for문 이용해서 1~50까지 출력
//		for (int start = 1; start <= 50; start++) {
//			System.out.println(start);
//		}
//	}
//
//	public static void printFor3() {
//		for (int start = 1; start <= 100; start++) {
//			System.out.println(start);
//		}
//	}
//   위에 내용은 모든 내용이 똑같고 시작하는 값과 끝나는 값만
	// 다르다!
}