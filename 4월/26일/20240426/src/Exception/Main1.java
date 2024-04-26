package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		// 프로그래밍에서 오류가 발생하는 시점 3가지

		// 1. 컴파일 에러(compile-time error)
		// - 컴파일시에 에러가 발생 !
		// - 문법 구문 오류(syntax error)
		// ; 세미콜론 없거나 선언되지 않는 변수를 사용하거나
		// 초기화 되지 않는 변수를 연산하거나 등등..
		// 빨간색으로 표시된다.

		// 2. 런타임 에러(runtime error)
		// - 프로그램 실행시에 발생하는 에러
		// - 실행 오류

		// 3. 논리적 에러(logical error)
		// - 실행은 되지만 의도와 다르게 동작하는 것!
		// - 버그

		// 자바에서 에러와 예외
		// 런타임 실행 시 발생할 수 있다.

		// 에러(error)
		// - 프로그램 코드에서 수습될 수 없는 심각한 오류
		// - 메모리 부족, 스택오버플로우, JVM문제 등...

		// 예외(exception)
		// - 프로그램 코드에 의해서 수술될 수 있는 아주 미약한 오류
		// - 프로그램을 사용하는 사용자가 기반으로 생길 수 있는 예외들을 대응할 수 있게 코드를 작성해야 함

		/*
		 * try ~ catch 문법
		 * 
		 * try{ 예외가 발생할 수 있는 문장들; }catch(){ 처리하는 문장들; }
		 * 
		 * JVM 예외 혹은 에러가 발생했을 때
		 */

		// 예외처리
		// - 비정상적으로 프로그램이 멈추는 걸 막기 위해서 사용하는 기법
		System.out.println("연산");
		try {
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다");
//			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		System.out.println("정상적으로 끝!");

		/*
		 * 키보드로 정수 두개를 입력 그 수를 더하는 프로그램
		 */
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		System.out.println("정수 2개 입력");
		try {
			int n = sc.nextInt();
			int n2 = sc.nextInt();
			System.out.println(n + n2);
			
			arr[3] = n + n2;
			
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력하세요");
		}catch(IndexOutOfBoundsException e){
			System.out.println("저장할 수 없는 공간이다");
		}catch(NullPointerException e) {
			System.out.println("객체 없는데?");
			// 객체가 없는 상태에서 객체를 사용하려고 접근하니까 나는 에러
			// 자바에서 가장 빈번하게 나는 예외중 하나
		}
		System.out.println("정상적으로 끝!");
	}

}
