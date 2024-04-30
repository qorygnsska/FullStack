package StringTokenTest;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenMenu {
	Scanner sc = new Scanner(System.in);
	TokenController tc = new TokenController();

	public void mainMenu() {
		while (true) {
			System.out.println("1. 지정 문자열");
			System.out.println("2. 입력 문자열");
			System.out.println("3. 프로그램 끝내기");
			System.out.print("입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			if(sel == 1) {
				tokenMenu();
			}else if(sel == 2) {
				inputMenu();
			}else if(sel == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("번호를 다시 입력하세요.");
			}
		}
	}

	public void tokenMenu() {
		String str = "J a v a P r o g r a m";
		System.out.println("토큰 처리 전 글자 : " + str);
		System.out.println("토큰 처리 전 개수 : " + str.length());
		System.out.println("===== 토큰 작업 실행 =====");
		String tstr = tc.afterToken(str);
		System.out.println("토큰 처리 후 글자 : " + tstr);
		System.out.println("토큰 처리 후 개수 : " + tstr.length());
		System.out.println("대문자로 변환 : " + tstr.toUpperCase());
	}

	public void inputMenu() {
		System.out.print("문자열을 입력하세요 : ");
		String str2 = sc.nextLine();
		System.out.println("첫글자 대문자 변환 : " + tc.firstCap(str2));
		
		System.out.print("찾을 문자 하나를 입력하세요 : ");
		char c = sc.nextLine().charAt(0);
		System.out.println(c + "문자가 들어간 개수 : " + tc.findChar(str2, c));
	}
}
