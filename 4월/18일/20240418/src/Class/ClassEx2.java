package Class;

class Member{
	String memberId;
	String memberPw;
	String memberName;
	int age;
	char gender;
	String sex;
	String phone;
	String email;
}

// 중복적으로 생기는 변수들을 막기 위해서
// 하나의 공통되는 틀을 만들어서 사용한다.
// ValueObject - 한 건의 데이터를 저장하는 것
// VO
class Cookie{
	// 클래스 멤버 변수(필드)
	String name;
	int level;
	int hp;
	char grade;
	String attr;
	
	// 함수
	// 변수 생성 후 초기화하는 함수
	void init(String n, int l, int i, char g, String a) {
		name = n;
		grade = g;
		attr = a;
		level = l;
		hp = i;
	}
}

public class ClassEx2 {

	public static void main(String[] args) {
		
		Cookie c1 = new Cookie();
		c1.init("와인맛쿠기", 5, 160, 'S', "와인 던지기");
		
		Cookie c2 = new Cookie();
		c2.init("용감한쿠기", 1, 80, 'A', "그냥 용감해");
		
		Cookie c3 = new Cookie();
		c3.init("천사맛쿠키", 3, 140, 'A', "자력");
		
		
		// 클래스타입@메모리가 생성된 주소
//		Member member1 = new Member();
//		System.out.println(member1);
//		
//		Board a = new Board();
//		System.out.println(new Board());

	}

}
