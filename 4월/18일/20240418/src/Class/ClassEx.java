package Class;

import java.awt.Image;

import java.time.LocalDateTime;
//클래스 만드는 곳
// 클래스 이름을 작성할 때는 첫 글자는 무조건 대문자
class 주민등록증{
	String 이름;
	String 주소;
	String 주민번호;
	String 발급기관;
	int 발급일자;
	Image 사진;
	
}

class Board{
	int no; 			// 글 번호
	String title; 		// 제목
	String content; 	// 내용
	String name; 		// 이름
	String id; 			// 아이디
	int readCount;		// 조회수
	LocalDateTime date; // 작성일
}

class 꼬부기{
	String 이름;
	String 이미지;
	String 타입;
	double 키;
	double 몸무게;
	char 성별;
	String 속성;
}

public class ClassEx {

	public static void main(String[] args) {
		// 배열의 단점
		// - 같은 타입의 자료형만 저장 가능해요

		// 클래스
		// - 사용자 정의 자료형
		// - 개발자가 한꺼번에 저장해야되는 타입을
		// 묶는다.
		// - 각각 타입이 다른 자료형을 묶는다.
		// - 키워드 class
		
		
		// 클래스
		// - 변수를 만들면 자동으로 초기화 됨
		// - 정수(int) 0
		// - 실수(double) 0.0
		// - 문자 ' ', 문자열 null
		// - boolean false
		
		// 새로운 변수를 만들어라!
		주민등록증 jumin1 = new 주민등록증();
		
		// 저장
		jumin1.이름 = "홍길동";
		jumin1.주민번호 = "990101-1234567";
		jumin1.발급일자 = 20240418; // LocalDateTime now();
		jumin1.발급기관 = "서울시청";
		
		System.out.println(jumin1.이름);
		System.out.println(jumin1.발급일자);
		
		// 게시글 한 건을 작성한다
		// 새로운 변수 생성!
		Board board1 = new Board();
		Board board2 = new Board();
		Board board3 = new Board();
		
		꼬부기 포켓몬1 = new 꼬부기();

	}

}
