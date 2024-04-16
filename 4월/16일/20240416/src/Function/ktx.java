package Function;

import java.util.Scanner;

public class ktx {

	public static int objection(String o) {
		if(o.equals("춘천")) {
			return 5000;
		}else if(o.equals("부산")) {
			return 30000;
		}else if(o.equals("대구")) {
			return 20000;
		}else if(o.equals("수원")) {
			return 10000;
		}else {
			System.out.println("그런 목적지는 없습니다.");
			return -1;
		}
	}
	
	public static int train(String t) {
		if(t.equals("ktx")) {
			return 10000;
		}else if(t.equals("새마을호")) {
			return 5000;
		}else if(t.equals("무궁화호")) {
			return 3000;
		}else {
			System.out.println("그런 기차는 없습니다.");
			return -1;	
		}
	}
	
	public static int ud(String s) {
		if(s.equals("좌석")) {
			return 0;
		}else if(s.equals("입석")) {
			return -2000;
		}else {
			System.out.println("입석 / 좌석 중 입력하세요");
			return -1;
		}
		
	}
	
	public static int pay(int a, int b, int c) {
		return a + b + c;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("춘천(5000원), 부산(30000원), 대구(20000원), 수원(10000원) 목적지 입력 : ");
			String obj = sc.nextLine();
			System.out.print("ktx(10000원), 새마을호(5000원), 무궁화호(3000원) 중 하나 선택 : ");
			String tra = sc.nextLine();
			System.out.print("좌석 / 입석(2000원 할인) 중 하나 선택 : ");
			String ud = sc.nextLine();
			
			if(objection(obj) != -1 && train(tra) != -1 && ud(ud) != -1) {
				System.out.println(pay(objection(obj), train(tra), ud(ud)) + " 원");
				break;
			}else {
				System.out.println("다시 입력하세요.");
			}
		}
	}

}
