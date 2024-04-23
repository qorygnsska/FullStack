package Polymorphism_Book;

import java.util.Scanner;

public class Main {
	
	public static void print(Book[] booklist) {
		for (int i = 0; i < booklist.length; i++) {
			booklist[i].show();
			System.out.println();
		}
	}
	
	public static void search(Book[] booklist) {
		// 저자 검색
		Scanner sc = new Scanner(System.in);
		while (true) { // 반복
			boolean check = false; // 저자를 찾았니?
			System.out.print("검색할 저자 입력 : ");
			String keyword = sc.nextLine();
			
			for (int i = 0; i < booklist.length; i++) {
				if (booklist[i].getAuthor().contains(keyword)) {
					booklist[i].show();
					System.out.println();
					check = true; // 저자를 찾았다
				}
			}
			if (check == false) { // 저자를 못 찾았다.
				System.out.println("그런 저자는 없습니다.");
			} else {
				break; // 찾았으면 반복 종료
			}
		}
	}
	
	public static void main(String[] args) {
		
		
		// 다형성
		// - 한 타입의 참조변수(주소를 저장하는 변수)를 통해서 여러 타입의 객체를 참조 하는 것!
		// - 부모 클래스 타입의 참조변수를 통해서 자식 클래스 타입의 객체를 참조 할 수 있도록 허용하여
		//   상위 클래스가 동일한 메시지로 하위 클래스들이 서로 다른 동작을 할 수 있도록 한다.
		
		
		// 다형성의 장점
		// - 유지보수 : 여러개의 객체를 하나의 타입으로 관리할 수 있어 유지보수가 용이
		// - 재사용성 : 객체의 재사용이 쉬워 재사용성이 높다.
		
		// 다형성의 조건
		// - 상속관계여야 한다.
		// - 오버라이딩(재정의) 반드시 필요
		// 자식 클래스의 객체가 부모 클래스의 타입으로 형변환(업캐스팅)해야 한다.
		
		
		// Controller(저장소)
		
		// 부모타입으로 자식클래스를 저장하면 부모가 물려준 타입만 저장이 가능
		Book[] booklist = new Book[6];
		booklist[0] = new CookBook("백종원의집밥", "백종원", "tvN", true);
		booklist[1] = new AniBook("한번더해요", "미티", "원모어", 19);
		booklist[2] = new AniBook("루피의원피스", "루피", "japan", 12);
		booklist[3] = new CookBook("이혜정의얼마나맛있게요", "이혜정", "문학", false);
		booklist[4] = new CookBook("최현석날따라해봐", "최현석", "소금책", true);
		booklist[5] = new ItBook("채쌤의 자바프로그래밍 핵심", "채규태", "쌤즈", true, true);
		
		print(booklist);
		search(booklist);
		
		
		
	}

}
