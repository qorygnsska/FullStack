package Function;

import java.util.Scanner;

public class Elevator {
	public static int goUpfloor(int input, int now) {
		// 1층에 있고 5층을 가고싶다
		for(int i = now; i <= input; i++) {
			System.out.println("현재 층 : " + i);
		}
		System.out.println(input + "층에 도착했습니다.");
		return input;
	}
	
	public static int goDownfloor(int input, int now) {
		// 5층에 있고 1층을 가고싶다
		for(int i = now; i >= input; i--) {
			System.out.println("현재 층 : " + i);
		}
		System.out.println(input + "층에 도착했습니다.");
		return input;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int inputLocation;
		int nowLocation;
		
		while(true) {
			System.out.print("가고자하는 층 : ");
			int floor = sc.nextInt();
			
			if(floor < 1 || floor > 6) {
				System.out.println("다른 층(1~6층)을 눌러주세요");
				continue;
			}
			inputLocation = floor;
			System.out.print("현재 층 : ");
			nowLocation = sc.nextInt();
			
			if(nowLocation < inputLocation) {
				goUpfloor(inputLocation, nowLocation);
				break;
			}else{
				goDownfloor(inputLocation, nowLocation);
				break;
			}
		}
		
		
		

	}

}
