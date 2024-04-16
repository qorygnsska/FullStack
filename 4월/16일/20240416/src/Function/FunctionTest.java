package Function;

import java.util.Scanner;

public class FunctionTest {
	
	// 입력 받은 횟수 만큼 hello java!출력하기
	public static void print(int 횟수) {
		for(int i = 1; i <= 횟수; i++) {
			System.out.print("Hello java! ");
		}
	}
	
	// 1부터 횟수까지의 합을 출력하는 함수 
	public static void sum(int 횟수) {
		int total = 0;
		for(int i = 1; i <= 횟수; i++) {
			total += i;
		}
		System.out.println("총합 : " + total);
	}
	
	// 열차 예매 함수
	public static void reservation() {
		Scanner sc = new Scanner(System.in);
		
		String[] arr = {"춘천", "부산", "대구", "수원"};
		boolean check = false;
		int[] pay = {5000, 30000, 20000, 10000};
		while (true) {
			System.out.print("춘천(운임 : 5000원) / 부산(운임 : 30000원) / 대구(운임 : 20000원) / 수원(운임 : 10000원) 한곳을 입력하세요 :  ");
			String city = sc.nextLine();
			for (int i = 0; i < arr.length; i++) {
				if (city.equals(arr[i])) {
					System.out.println(arr[i] + "까지의 금액은 " + pay[i] + "원 입니다.");
					check = true;
					return;
				}
			}
			if (check == false) {
				System.out.println("그런 도시는 없습니다.");
			}
		}
	}
		
	
	
	// 입력받은 두 수의 차를 구하는 함수
	public static void sub_number(int number1, int number2) {
		int sub = number1 - number2;
		System.out.println("두 수의 차 : " + sub);
	}
	
	public static void main(String[] args) {
		
		// 입력 받은 횟수 만큼 hello java!출력하기 print();
		print(3);
		
		System.out.println();
		
		
		// 1부터 횟수까지의 합을 출력하는 함수 sum()
		sum(100);
		
		
		// 열차 예매 함수 reservation(); 
		// 각 도시당 가격이 든다. 도시 이름을 입력하면 금액을 출력하는 함수
		reservation();
		
		
		// 두 개의 숫자를 입력받아 두 수의 차를 구하는 함수 sub_number(). 
		// 인자로 number1,number2를 입력
		sub_number(3, 1);
		
		
		
		
		
		
	}

}
