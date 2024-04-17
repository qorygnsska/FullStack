package Function;

import java.util.Scanner;

public class FunctionTest2 {
	public static void checkJumin() {
		// 주민번호 입력
		// 13자리를 '-'없이 입력받아 성별 판단하기
		// String으로 풀기
		
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("주민번호 13자리 입력(- 제외) : ");
			String jumin = sc.nextLine().trim();// 문자열의 앞 뒤 공백 제거 trim(), 가운데 공백은 제거하지 않는다
			if(jumin.length() == 13 && jumin.charAt(6) != 48) {
				if(jumin.charAt(6) % 2 == 0) {
					System.out.println("여자 입니다.");
				}else {
					System.out.println("남자 입니다.");
				}
				break;
			}else {
				System.out.println("13자리를 정확하게 입력해주세요.");
			}
		}
	}
	
	public static void checkJumin2() {
		Scanner sc = new Scanner(System.in);
		// 주민번호 입력
		// 13자리를 '-'없이 입력받아 성별 판단하기
		
		// long으로 풀기
		System.out.print("주민번호 입력(-제외) : ");
		long jumin = sc.nextLong();
		long check = jumin/1000000%10;
		if(check % 2 == 0) {
			System.out.println("여자");
		}else {
			System.out.println("남자");
		}
		
	}
	
	public static void checkJumin3() {
		Scanner sc = new Scanner(System.in);
		// 주민번호를 - 포함 입력받고 성별 판단
		System.out.print("주민번호 입력(-포함) : ");
		String jumin = sc.nextLine();
		
		String[] jumin2 = jumin.split("-");
		System.out.println(jumin2[0]);
		System.out.println(jumin2[1]);
		System.out.println(jumin2[1].charAt(0));
		if(jumin2[1].charAt(0) % 2 == 0) {
			System.out.println("여자");
		}else {
			System.out.println("남자");
		}
		
	}

	public static void main(String[] args) {
		checkJumin();
		checkJumin2();
		checkJumin3();
		
	}

}
