package Function;

import java.util.Scanner;

public class coffe {
	
	public static int Coffee(String cof) {
		if(cof.equals("아메리카노")) {
			return 3900;
		}else if(cof.equals("카페모카")) {
			return 4500;
		}else if(cof.equals("카페라떼")) {
			return 5000;
		}else if(cof.equals("그린티")) {
			return 5500;
		}else {
			System.out.println("그런 메뉴는 없습니다");
		}return -1;
	}
	
	public static int Size(String sz) {
		if(sz.equals("그란데")) {
			return 1000;
		}else if(sz.equals("레귤러")) {
			return 500;
		}else if(sz.equals("쇼츠")) {
			return 0;
		}else {
			System.out.println("그런 사이즈는 없습니다");
		}return -1;
	}
	
	public static int price(int a, int b) {
		return a + b;
	}
	public static void main(String[] args) {

		// 문제 1. 커피 주문 받는 문제
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Welcome to Harry Cafe");
			System.out.print("커피 선택 : 아메리카노 / 카페모카 / 카페라떼 / 그린티");
			String cof = sc.nextLine();
			System.out.println("사이즈 선택 : 그란데 / 레귤러 / 쇼츠");
			String size = sc.nextLine();
			
			if (Coffee(cof) != -1 && Size(size) != -1) {
				System.out.println("총 금액은 " + price(Coffee(cof), Size(size)) + " 원 입니다.");
				break;
			} else {
				System.out.println("다시 주문하세요");
			}
		
		}
	}

}
