package Array;

import java.util.Scanner;

public class ArrayEx3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] apt = {
				{101, 102, 103},	
				{201, 202, 203},	
				{301, 302, 303}	
			};
			
		int[][] pay = {
				{1000, 2100, 1300},	
				{4100, 2000, 1000},	
				{3000, 1600,  800}
			};
			
		// 문제 1) 각층별 관리비 합 출력
		// 정답 1) 4400, 7100, 5400
		int a = 0, b = 0, c = 0;
		for(int i = 0; i < pay.length; i++) {
			for(int j = 0; j < pay.length; j++) {
				if(i == 0) {
					a += pay[i][j];
				}else if(i == 1) {
					b += pay[i][j];
				}else {
					c += pay[i][j];
				}
			}
		}
		System.out.println(a  + ", " + b + ", " + c);
		
		
		// 문제 2) 호를 입력하면 관리비 출력
		// 예    2) 입력 : 202	관리비 출력 : 2000
		System.out.print("호 입력 : ");
		int n = sc.nextInt();
		for(int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt.length; j++) {
				if(n == apt[i][j]) {
					System.out.println(" 관리비 출력 : " + pay[i][j]);
				}
			}
		}
		
		
		// 문제 3) 관리비가 가장 많이 나온 집, 적게 나온 집 출력
		// 정답 3) 가장 많이 나온 집(201), 가장 적게 나온 집(303)
		int max = pay[0][0];
		int min = pay[0][0];
		int index1 = 0, index2 = 0, index3 = 0, index4 = 0;
		for(int i = 0; i < pay.length; i++) {
			for(int j = 0; j < pay.length; j++) {
				if(max < pay[i][j]) {
					max = pay[i][j];
					index1 = i;
					index2 = j;
				}
				if(min > pay[i][j]) {
					min = pay[i][j];
					index3 = i;
					index4 = j;
				}
			}
		}
		System.out.println("가장 많이 나온 집(" + apt[index1][index2] + "), 가장 적게 나온 집(" + apt[index3][index4] + ")");
		
		
		// 문제 4) 호 2개를 입력하면 관리비 교체
		int a1 = 0, b1 = 0, c1= 0, d1 = 0;
		System.out.println("호 2개 입력 : ");
		int apt1 = sc.nextInt();
		int apt2 = sc.nextInt();
		for(int i = 0; i < apt.length; i++) {
			for(int j = 0; j < apt.length; j++) {
				if(apt1 == apt[i][j]) {
					a1 = i;
					b1 = j;
				}
				if(apt2 == apt[i][j]) {
					c1 = i;
					d1 = j;
				}
			}
		}
		int temp = pay[a1][b1];
		pay[a1][b1] = pay[c1][d1];
		pay[c1][d1] = temp;
		System.out.println(apt[a1][b1] + "호 관리비 : " + pay[a1][b1] + ", " + apt[c1][d1] + "호 관리비 : " + pay[c1][d1]);
	}

}
