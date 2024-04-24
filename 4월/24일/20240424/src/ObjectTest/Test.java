package ObjectTest;

/*
 *  멤버 클래스 
 *   멤버: String name
 *               age
 *               id
 *               pw
 *   m1 = 이익준 20 qwer qwer
 *   m2 = 채송화 20 asdf asdf 
 *   m3 = 이익준 20 qwer qwer 
 *   
 *   m1.equals(m2) 확인 했을 때 모든 변수가 
 *   같지 않으면 false 
 *   
 *   m1.equals(m3) true
 *   equals() 메서도 구현하기
 *   객체 데이터가 같은지 true false로 반환받기 
 */
class Member{
	String name;
	int age;
	String id;
	String pw;
	
	public Member(String name, int age, String id, String pw) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.pw = pw;
	}


	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		Member temp = (Member)obj;
		if(this.name == temp.name &&
			this.age == temp.age &&
			this.id == temp.id &&
			this.pw == temp.pw) {
			System.out.println("같다");
			return true;
		}else {
			System.out.println("다르다");
			return false;
		}
	}
	
	
}

public class Test {

	public static void main(String[] args) {
		Member m1 = new Member("이익준", 20, "qwer", "qwer");
		Member m2 = new Member("김준완", 20, "qwer", "qwer");
		Member m3 = new Member("채송화", 20, "qwer", "qwer");
		
		System.out.println(m1.equals(m2));

	}

}
