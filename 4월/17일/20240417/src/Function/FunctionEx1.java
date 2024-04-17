package Function;

import java.util.Arrays;
import java.util.Random;

public class FunctionEx1 {
	public static int hello() {
		int n1 = 10;
		int n2 = 20;
		return n2;
	}

	public static void loop(int[] arr) {
		Random rand = new Random();
		
		for (int i = 1; i <= 100; i++) {
			int ran = rand.nextInt(6);
			arr[ran]++;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {

		System.out.println(hello());
		/*
		 * 함수  
		 * 1. 내장함수
		 * - 자바가 미리 만들어놓은 함수
		 * - println(), nextInt()...
		 * 
		 * 2. 사용자 정의 함수
		 * - 개발자가 만들어 놓은 함수이기 떄문에 자바 컴파일이 모른다
		 *   그걸 알려주기 위해 main함수 밖에 작성한다.
		 */
		
		// 함수의 리턴은 값 한개만 넘길 수 있다.
		// 해결법
		// - 클래스로 만들어서 넘기기
		// - 변수를 이용해서 배열의 공간과 개수를 같이 사용하는 방법

		// 주사위 문제
		// 주사위를 100번 반복
		// 1~6사이에 개수를 카운트한다.
		
		int[] arr = new int[6];
		loop(arr);
		
	}
}
