package While;

import java.util.Scanner;

public class WhileEx {
	
	// 무조건 시작점 main함수
	public static void main(String[] args) {
		
		/*
		 * 반복문
		 * - 원하는 코드를 반복하기 위해서 사용하는 제어문
		 * 
		 * 반복문
		 *   1. 횟수
		 *   	for
		 *   
		 *   2. 조건
		 *   	while(비교){
		 *   	참이면 반복할 문장;
		 *   
		 *   }
		 * */
		
		// 안녕하세요 5번 반복
		// 반복을 할 때는 카운트를 세야한다.
		
		// 반복문 3요소
		// - 시작하는 값 (초기식)
		// - 비교하는 문장(조건식)
		// - 증가하거나 감소(증감식)
		int count = 0;
		
		while(count <= 5) {
			// 반복할 문장
			System.out.println("안녕하세요");
			count = count + 1;
		}
		
		// 1~5까지 출력
		// 시작하는 값 : 1
		// 비교훈 : 1이 5보다 작거나 같을 때 까지만 반복
		// 증감식 : 1씩 증가
		int start = 1;
		
		while(start <= 5) {
			System.out.println("시작하는 값 : " + start);
			start = start + 1;
		}
		
		// 중간에 공백
		System.out.println();
		
		// 1~100까지 출력
		start = 1; // 위에서 사용한 변수를 다시 1로 변경해서 사용
		
		// 물어보고 실행 그 기준 true
		while(start <= 100) {
			System.out.println(start);
			start = start + 1;
		}
		
		System.out.println();
		
		// 카운트 다운
		// 5 4 3 2 1
		// 비교문 start2 > 0 or start >= 1 or start2 != 0
		int start2 = 5;
		while(start2 >= 1) {
			System.out.println(start2);
			start2 = start2 - 1;
		}
		
		
	}

}

