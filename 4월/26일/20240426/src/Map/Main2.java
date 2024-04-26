package Map;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		HashMap<String, Member> list = new HashMap<String, Member>();

		// 임의의 멤버 5명 추가
		list.put("홍길동", new Member("홍길동", "1234"));
		list.put("이순신", new Member("이순신", "abcd"));
		list.put("김철수", new Vip());
		list.get("김철수").name = "김철수";
		list.get("김철수").password = "qwer";

		list.put("박영희", new Member("박영희", "abcd1234"));
		list.put("정대만", new Vip());
		list.get("정대만").name = "정대만";
		list.get("정대만").password = "1234qwer";
		
		// 출력
		for(String key : list.keySet()) {
			System.out.println(key);
			list.get(key).print();
			System.out.println();
		}

		Scanner sc = new Scanner(System.in);

		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.print("선택 > ");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1:
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("새 비밀번호 : ");
			String password = sc.nextLine();
			
			if(list.containsKey(name)) {
				list.get(name).password = password;
				System.out.println(name + "의 비밀번호가 변경되었습니다.");
			}else {
				System.out.println("존재하지 않는 멤버");
			}
			break;
			
		case 2:
			System.out.print("현재 이름 : ");
			String current = sc.nextLine();
			System.out.print("새 이름 : ");
			String newName = sc.nextLine();
			
			if(list.containsKey(current)) {
				// 기존 이름의 멤버
				// remover(key) : 삭제한 멤버의 객체를 반환
				Member member = list.remove(current);
				
				// 반환된 객체의 이름을 수정
				member.name = newName;
				
				// 새 멤버로 추가
				list.put(newName, member);
				System.out.println(current + "의 이름이 " + newName + "으로 변경되었습니다.");
			}else {
				System.out.println("존재하지 않는 멤버");
			}
			
			break;
			
		default:
			System.out.println("제대로 입력");
			break;
		}
		
		// 출력
		for(String key : list.keySet()) {
			System.out.println(key);
			list.get(key).print();
			System.out.println();
		}
	}
}