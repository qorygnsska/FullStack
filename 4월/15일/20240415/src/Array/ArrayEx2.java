package Array;

import java.util.Scanner;

public class ArrayEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[3][3];
		int k = 1;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = 10 * k;
				k += 1;
			}
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		// 문제 1) 인덱스 2개를 입력받아 값 출력
		// 예    1) 인덱스1 입력 : 1	인덱스2 입력 : 2
		//		   값 출력 : 60 
		System.out.print("인덱스 1 입력 : ");
		int index1 = sc.nextInt();
		System.out.print("인덱스 2 입력 : ");
		int index2 = sc.nextInt();
		System.out.println(arr[index1][index2]);
		
		
		// 문제 2) 값을 입력받아 인덱스 2개 출력
		// 예    2) 값 입력 : 60
		//		   인덱스1 출력 : 1	인덱스2 출력 : 2
		int row = 0, col = 0;
		boolean check = false;
		System.out.print("값 입력 : ");
		int num = sc.nextInt();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(num == arr[i][j]) {
					row = i;
					col = j;
					check =  true;
				}
			}
		}
		if(check == true) {
			System.out.println("인덱스 1 출력 : " + row + ", 인덱스 2 출력 : " + col);
		}else {
			System.out.println("찾으시는 값이 없습니다..");
		}
		
		
		// 문제 3) 가장 큰 값의 인덱스 2개 출력
		// 정답 3) 2 2
		int max = arr[0][0];
		int row2 = 0, col2 = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
					row2 = i;
					col2 = j;
				}
			}
		}
		System.out.println(row2 + " " + col2);
		
		
		
		// 문제 4) 값 2개를 입력받아 값 교체
		System.out.println("값 2개 입력 : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int a = 0, b = 0, c = 0, d = 0;
		int temp;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(n1 == arr[i][j]) {
					a = i;
					b = j;
				}
				if(n2 == arr[i][j]) {
					c = i;
					d = j;
				}
			}
		}
		temp = arr[a][b]; arr[a][b] = arr[c][d]; arr[c][d] = temp;
		System.out.println(arr[a][b] + " " + arr[c][d]);
		
		
		// 자바 편집모드 alt + shift +a : 여러줄 동시에 수정하기 편함
		// 2차원배열을 1차원 배열로 변경해서
		// 문제를 푸는 방식
		// Arrays.stream()메서드
		// flatMapToInt() 메서드
		// toArray() 메서드

		// Arrays.binarySearch(배열,값)
		// 정렬은 무조건!
	}

}
