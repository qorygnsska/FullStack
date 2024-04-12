package For;

import java.util.Random;
import java.util.Scanner;

public class ForEx {

	public static void main(String[] args) {
		/* 
		 * for
		 *  - 동작의 순서는 while문 하고 똑같다
		 *  - 코드 작성하는 법이 조금 다르다.
		 *  - 한줄에 초기식,비교식(조건),증감식
		 *    작성하기 때문에 중요한 정보를 한번에
		 *    볼 수 있고 코드를 읽을 때 가독성 높아진다.
		 *    
		 *  for(초기식; 비교식; 증감식){
		 *  	반복을 실행하는 문장;
		 *  }
		 *  
		 *  
		 *  
		 *  while 위에서 부터 하나씩 순서대로 
		 *  	  내려가면서 작성 
		 *  
		 *  초기식;
		 *  while(비교식){
		 *  	반복하는 명령문;
		 *  	증감식;
		 *  }
		 * 
		 */
		
		// 1~5까지 for문으로 출력
		for(long i = 1; i <= 5; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		/*
		 * 1 ~ 100 까지 출력
		 * 1 ~ 100 까지 합 출력
		 */
		int sum = 0;
		for(int j =1; j <= 100; j++) {
			sum += j;
		}
		System.out.println("1~100까지의 합 : " + sum);
		
		System.out.println();
		
		
		/* 1 ~ 100까지 반복 홀수의 값만 출력
		 * 				 홀수의 합을 출력
		 * 
		 */ 
		int sum2 = 0;
		for(int i2 = 1; i2 <= 100; i2++) {
			if(i2 % 2 == 1) {
				sum2 += i2;
			}
		}
		System.out.println("1~100까지 홀수의 합 : " + sum2);
		 
		System.out.println();
		
		
		/* # 랜덤학생
		 * 1. 10회 반복을 한다.
		 * 2. 1~100 사이의 랜덤 숫자를 저장한다.(학생의 성적)
		 * 3. 성적이 60점 이상이면 합격생이다.
		 * ---------------------------------------
		 * . 전교생(10명)의 총점과 평균을 출력한다.
		 * . 합격자 수를 출력한다.
		 * . 1등 학생의 번호와 성적을 출력한다.
		 */
		Random rand = new Random();
		int max = 0; // 최고점
		int index = 0; // 학생 번호
		int count = 0; // 합격자 수
		int[] arr = new int[10];
		for(int j2 = 0; j2 < 10; j2++) {
			int num = rand.nextInt(100) + 1;
			arr[j2] = num;
			if(arr[j2] >= 60) {
				System.out.println(j2 + "번 학생 " + arr[j2] + "점 합격!!");
				count++;
			}
		}
		for(int j3 = 0; j3 < 10; j3++) {
			if(arr[j3] > max) {
				max = arr[j3];
				index = j3;
			}
		}
		System.out.println("합격자 수 : " + count);
		System.out.println("1등 학생 번호 : " + index +"번(" + max + "점)");
		
		
	}

}
