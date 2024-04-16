package Function;

import java.util.Scanner;

public class FunctionEx {
	// 함수 만드는 곳
	public static void info() {
		String str = "배교훈";
		int age = 20;
		
		System.out.println("이름 : " + str);
		System.out.println("나이 : " + age);
	}
	
	public static void hello() {
		System.out.println("hello world!");
	}
	
	public static void main(String[] args) {
		
		// 함수 : 긴 코드를 짧게 변경하는 것
		// - 코드를 작성하는 공간은 main함수 밖이다.
		/*
		 * 누구나 접근해서 만드다 함수명() {
		 * 	  긴 코드를 작성;
		 * }
		 * 접근제한자 반환타입 함수명() {
		 *    실행할 문장들;(중복되는 문장들)
		 * }
		 * 함수 이름은 코드와 연관있는 이름
		 */
		
		info();
		hello();
		hello();
		hello();
		hello();
		hello();
		input();		
		

	}
	// 함수 만드는 곳
	public static void input() {
		// 키보드로 정수 하나 입력 받는다
		// 그걸 출력하는 함수
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		System.out.println("내가 입력한 숫자 : " + num);
	}
}
