package While;

import java.util.Scanner;

public class WhileEx3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 // break : 반복문을 끝낸다
		
		 // continue : 반복문은 끝내지 말고 밑에 있는 문장 실행 안 함(반복문의 현재 단계를 중단)
		 // - 아래식을 실행시키고 싶지 않을 때 사용, continue는 else를 이용해서 충분히 사용하지 않고 식을 만들 수 있다.
		
		while(true) {
			System.out.println("1. 조회");
			System.out.println("2. 추가");
			System.out.println("3. 삭제");
			System.out.println("0. 종료");
			System.out.print(">");
			int sel = sc.nextInt();
			
			if(sel > 3 || sel < 0) {
				System.out.println("메뉴를 다시 입력하세요");
				continue; // 밑에 있는 문장은 무시하고 다시 while문으로 올라감
			}else if(sel == 1) {
				System.out.println("조회 메뉴");
			}else if(sel == 2) {
				System.out.println("추가 메뉴");
			}else if(sel == 3) {
				System.out.println("삭제 메뉴");
			}else {
				System.out.println("종료");
				break;
			}
			
		}
		// 1~5까지 반복
		// 3을 건너뛰기
		int i = 1;
				
		while(i <= 5) {
			if(i == 3) {
				// i가 3이면 이번 반복을 건너뛰고 다음 반복으로 넘어간다.
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
		
	}
}
	
				
