package PolymorphismTest;

public class Main {

	public static void main(String[] args) {
		// 다형성
		Book b1 = new Book("채쌤 자바", "채규태", "쌤즈");
		Book b2 = new AniBook("원피스", "미상", "미상", 15); // 순서가 바뀌면 안된다 AniBook a1 = new Book() -> 오류 : 부모를 자식 생성자로 생성 불가능
		Book b3 = new CookBook("이혜정선생님 집밥", "이혜정", "요출", true);
		
		// 다형성을 확인하는 연산자
		// 변수명 instanceof 클래스타입
		if(b3 instanceof Book) {
			System.out.println("상속 관계");
		}else {
			System.out.println("상속 관계 아니다");
		}
		
		if(b2 instanceof Book) {
			System.out.println("상속");
		}else {
			System.out.println("노상속");
		}
		
		
		
	}

}
