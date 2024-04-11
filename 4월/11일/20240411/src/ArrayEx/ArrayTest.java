package ArrayEx;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문제1) arr배열에 1~100점 사이의 정수를 5개 저장
		// 예   1) 87, 11, 92, 14, 47
		int[] arr = new int[5];
		System.out.println("숫자 5개 입력 : ");
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		arr[3] = sc.nextInt();
		arr[4] = sc.nextInt();
		
		int i = 0;
		while(i < 5) {
			System.out.print(arr[i] + " ");
			i++;
		}
		
		System.out.println();
		
		
		// 문제2) 전교생의 총점과 평균 출력
		// 예   2) 총점(251) 평균(50.2)
		double[] score = {60, 70, 95, 84, 62, 64, 55, 40, 78, 80};
		double total = 0;
		int j = 0;
		
		for(j = 0; j < score.length; j++) {
			total += score[j];
		}
		double avg = total / score.length;
		System.out.println("총점 : " + total +" 평균 : " + avg);
		
		
		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예   3) 2명
		// 인덱스 0 1 2 3 4
		int[] arr1 = { 87, 11, 45, 98, 23 };
		int count = 0;
		int start = 0;
		
		for(start = 0; start < arr1.length; start++) {
			if(arr1[start] >= 60)
				count++;
		}
		System.out.println(count + "명");
		
		
		// 문제1) 인덱스를 입력받아 성적 출력
		// 정답1) 인덱스 입력 : 1 성적 : 11점
		System.out.print("인덱스 입력 : ");
		int num = sc.nextInt();
		for(int j1 = 0; j1 < arr1.length; j1++) {
			if(num == j1) {
				System.out.println("성적 : " + arr1[j1]);
			}
		}
		
		
		
		// 문제2) 성적을 입력받아 인덱스 출력
		// 정답2) 성적 입력 : 11 인덱스 : 1

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = { 87, 11, 45, 98, 23 };
		
		System.out.print("성적 입력 : ");
		int n = sc.nextInt();
		for(int p = 0; p < scores.length; p++) {
			if(n == scores[p]) {
				System.out.println("인덱스 : " + p);
			}
		}
		

		// 문제3) 학번을 입력받아 성적 출력
		// 정답3) 학번 입력 : 1003 성적 : 45점
		System.out.print("학번 입력 : ");
		int nu = sc.nextInt();
		for(int i1 = 0; i1 < hakbuns.length; i1++) {
			if(nu == hakbuns[i1]) {
				System.out.println("성적 : " + scores[i1]);
			}
		}
		
		
		
		// 문제 4. 길이가 10인 배열을 선언하고 1부터 10까지의 값을 순서대로 넣고 출력 반복문 사용!
		int[] arry = new int[10];
		for(int k = 0; k < arry.length; k++) {
			arry[k] = k + 1;
			System.out.print(arry[k] + " ");
		}
		
		System.out.println();
		
		
		// 문제 5. 길이가 10인 배열을 선언하고 1 부터 10까지의 값을 넣고 역순으로 출력 반복문 사용!
		int[] ary = new int[10];
		for(int k1 = 0; k1 < ary.length; k1++) {
			ary[k1] = 10 - k1;
			System.out.print(ary[k1] + " ");
		}
		
		System.out.println();
		
		
		// 문제 6. 사용자에게 입력 받은 만큼 양의 정수만큼 배열 크기 할당, 1부터 입력받은 값까지 배열에 입력, 출력
		System.out.print("정수 입력 : ");
		int numm = sc.nextInt();
		int[] ar = new int[numm];
		
		for(int u = 0; u < ar.length; u++) {
			ar[u] = u + 1;
			System.out.print(ar[u] + " ");
		}
		
		System.out.println();
		
		// 문제 7. 길이가 5인 String 배열을 선언하고 사과, 귤, 포도, 복숭아, 참외로 초기화 후 귤을 출력
		String[] fru = {"사과", "귤", "포도", "복숭아", "참외"};
		System.out.println(fru[1]);		
		
		
	}

}
