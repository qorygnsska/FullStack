package Map_Member;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// map으로 Member들을 저장한다.
		// key id값을 이용해 저장
		// valus Member 객체 저장
		HashMap<String, Member> map = new HashMap<String, Member>();

		// 저장
		map.put("qwer", new Member("qwer", "qwer"));
		map.put("asdf", new Member("asdf", "asdf"));
		map.put("zxcv", new Member("zxcv", "zxcv"));
		map.put("abcd", new Member("abcd", "abcd"));

		System.out.println(map);

//		// 객체 자체를 삭제하는 것이 아니라 map의 공간을 삭제하는 것!
//		map.remove("abcd");
//		System.out.println(map);
//		
//		// 전체 지우기
//		map.clear();
//		System.out.println(map);

		/*
		 * 1.로그인 기능 - 아이디하고 패스워드를 받아서 아이디와 패스워드가 맞으면 로그인 성공 실패 2.로그아웃 3. 종료
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		boolean result = false;
		while (true) {
			System.out.println("1. 로그인");
			System.out.println("2. 로그아웃");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			if (sel == 1) {
				if (result == true) {
					System.out.println("이미 로그인 하셨는데용?");
				} else {
					System.out.print("아이디 입력 : ");
					String id = sc.nextLine();
					System.out.print("비밀번호 입력 : ");
					String pw = sc.nextLine();
					if (map.containsKey(id)) {
						// System.out.println("키가 있습니다 : " + map.get(id).getId());
						if (map.get(id).getId().equals(id) && map.get(id).getPw().equals(pw)) {
							System.out.println("로그인 성공!!");
							result = true;
						} else {
							System.out.println("아이디와 비밀번호를 제대로 입력하셈!!!");
						}
					} else {
						System.out.println("아이디와 비밀번호를 제대로 입력하셈!!!");
					}
				}
			} else if (sel == 2) {
				if (result == true) {
					System.out.println("로그아웃 완료");
					result = false;
				} else {
					System.out.println("로그인을 안 하셨는데용?");
				}

			} else if (sel == 3) {
				System.out.println("종료");
				break;
			} else {
				System.out.println("메뉴를 다시 입력하세요");
			}
		}

	}

}
