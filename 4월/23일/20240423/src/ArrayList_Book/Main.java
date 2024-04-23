package ArrayList_Book;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		// 여러개의 책을 한꺼번에 저장 관리
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		// 추가
		bookList.add(new AniBook("한번더해요", "미티", "원모어", 19));
		bookList.add(new CookBook("백종원의집밥", "백종원", "tvN", true));
		bookList.add(new AniBook("루피의원피스", "루피", "japan", 12));
		bookList.add(new CookBook("이혜정의얼마나맛있게요", "이혜정", "문학", false));
		bookList.add(new CookBook("최현석날따라해봐", "최현석", "소금책", true));
		bookList.add(new ItBook("채쌤 자바", "채규태", "쌤즈", true, true));
		
		System.out.println(bookList);
		
		// 검색
		// 인덱스 번호를 확인하는 메서드 indexOf()
		// 찾으면 인덱스 번호 반환, 못 찾으면 -1
		// 밑에 처럼 코드를 작성하면 이혜정과 주소값을 비교하라는 것이라서 -1을 반환하게 된다
		// System.out.println(bookList.indexOf("이혜정"));
		
		// ArrayList는 length가 아닌 size()를 사용
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
			if(bookList.get(i).getAuthor().equals("이혜정")) {
				System.out.println("찾음");
				System.out.println("인덱스 번호 : " + i);
			}
		}
		
		
		
		
		/*
		 * toString() 메서드
		 * - 인스턴스(객체)에 대한 정보를 문자열로 반환한다.
		 * 
		 * 기본적으로 Object 클래스 toString()
		 * 클래스이름@메모리의주소(16진수 해시코드)
		 * 
		 * 내가 만든 클래스에서 오버라이딩
		 *  내 클래스 멤버에 맞게 재정의
		 *  
		 * 오버라이딩을 하게 되면 변수명만 작성해도 자동으로  toString()메서드가 호출된다. 
		 */
		
	}

}
