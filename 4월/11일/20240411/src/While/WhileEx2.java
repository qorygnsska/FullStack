package While;

import java.util.Scanner;

public class WhileEx2 {

	public static void main(String[] args) {
		
		// 대입 연산자를 할 때 변수명이 중복돼서
		// 나오는 걸 방지하기 위해서 사용하는 연산자
		
		int a = 10;
		int b = 1;
		
		System.out.println(a += b); // a = a + b
		System.out.println(a -= b); // a = a - b
		System.out.println(a *= b); // a = a * b
		System.out.println(a /= b); // a = a / b
		System.out.println(a %= b); // a = a % b
		
		/*
		 * 증감 연산자
		 * - 무조건 1만 증가하거나 감소한다.
		 * - ++, --(단항 연산자)
		 * 
		 * 변수++ : 사용 후 증가
		 * - 변수에 저장된 값을 사용(출력, 연산)하고 ;(마침표)를 만나서 문장이 종료될 때 1식 증가함
		 * 
		 * ++변수 : 증가 후 사용
		 * - 변수에 저장된 값을 1증가하고 사용함
		 * 
		 * 변수-- : 사용 후 감소
		 * - 변수에 저장된 값을 사용(출력, 연산)하고 ;(마침표)를 만나서 문장이 종료될 때 1식 감소함
		 * 
		 * --변수 : 감소 후 사용
		 * - 변수에 저장된 값을 1감소하고 사용함
		 */
		
		int c = 1, d = 0, e = 0;
		System.out.println("초기식");
		System.out.println("c : " + c);
		System.out.println("d : " + d);
		System.out.println("e : " + e);
		
		d = c++;
		System.out.println("c++ : " + d); 

		System.out.println("++d : " + (++d));
		System.out.println("d++ : " + (d++));
		
		System.out.println(d);
		
		int num = 10;
		int num2 = ++num - 2;
		
		System.out.println(num);
		System.out.println(num2);
		
		// 문제 1. 숫자를 입력받아 1부터 그 숫자들을 출력. 단 1미만의 숫자가 입력됐다면 1 이상의 숫자를 입력해주세요 출력
		Scanner sc = new Scanner(System.in);
				
		System.out.print("숫자를 입력하세요 : ");
		int number = sc.nextInt();
				
		if(number >= 1) {
			int start = 1;
			while(number >= start) {
				System.out.print(start + " ");
				start++;
			}
		}else {
			System.out.println("1이상의 숫자를 입력해주세요");
		}
				
		System.out.println();
				
		// 문제 2. 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		System.out.print("몇 번 반복? : ");
		int n = sc.nextInt();
		while(n >= 1) {
			System.out.print("A, B입력 : ");
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(A + B);
			n--;
		}
				
		// 문제 3. 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 출력
		System.out.print("정수를 입력하세요 : ");
		int input = sc.nextInt();
		int i = 1;
		// 합계, 누적 등등..
		int sum = 0;
		
		while(input >= i) {
			sum += i;
			i++;
		}
		System.out.println("합 : " + sum);
		
		// 문제 4. 1부터 50까지 홀수의 합을 구하시오!
		int j = 1;
		int total = 0;
		while(j <= 50) {
			total += j;
			j = j + 2;
		}
		System.out.println("1~50까지 홀수의 합 : " + total);
	}

}
