package Array;

import java.util.Random;

public class ArrayEx1 {

	public static void main(String[] args) {
		
		// 정수형 2차원 배열
		// 표 형식, 패턴 찍기 편함
		int[][] arr = new int[3][3];
		arr [0][0] = 10;
		arr [0][1] = 20;
		arr [0][2] = 30;
		
		arr [1][0] = 40;
		arr [1][1] = 50;
		arr [1][2] = 60;
		
		arr [2][0] = 70;
		arr [2][1] = 80;
		arr [2][2] = 90;
		
		// 출력
		for(int i = 0; i < 3; i++) {
			// 내부 반복은 열을 반복하는 문장
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
				}
			System.out.println();
		}

		/*
		 * 주사위(1~6) 를 100번 반복했을 때 
		 * 랜덤클래스를 이용해서 정수를 하나씩 뽑는다.
		 * 
		 * 1 : 번 나왔다.
		 * 2 : 번 나왔다.
		 * 3 : 번 나왔다.
		 * 4 : 번 나왔다.
		 * 5 : 번 나왔다.
		 * 6 : 번 나왔다.
		 */
		Random rand = new Random();
		int[] arry = new int[6];
		
		for(int i = 0; i < 100; i++) {
			int dice = rand.nextInt(6) + 1; // 1~6 랜덤 생성
			arry[dice - 1]++; // 배열은 0부터 시작이니 주사위 값 -1 한 인덱스번호에 저장해야함
		}
		for(int j = 0; j < arry.length; j++) {
			System.out.println(j + 1 +" : " + arry[j] + "번 나왔다.");
		}
		
		
	}

}
