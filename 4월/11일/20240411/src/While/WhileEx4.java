package While;

import java.util.Scanner;

public class WhileEx4 {

	public static void main(String[] args) {
		// 구구단
		Scanner sc = new Scanner(System.in);

		System.out.print("단 수 입력 : ");
		int dan = sc.nextInt();

		int start = 1;

		while (start <= 9) {
			System.out.println(dan + " * " + start + " = " + (dan * start));
			// System.out.pridantf("%d * %d = %d \dan", dan, start, (dan * start));
			start++;
		}

		System.out.println();

		// 입력한 단부터 9단까지 출력
		System.out.print("단 수 입력 : ");
		int dan2 = sc.nextInt();

		while (dan2 <= 9) {
			int start2 = 1;
			System.out.println("======= " + dan2 + "단 =======");
			
			while (start2 <= 9) {
				System.out.println(dan2 + " * " + start2 + " = " + (dan2 * start2));
				start2++;
			}
			dan2++;
		}
		
		//반복문 안에 변수를 만들면 생성 됐다가 삭제 됐다가를 반복한다.
	}

}
