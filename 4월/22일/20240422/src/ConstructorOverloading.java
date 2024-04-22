
class Naver{
	private String email;
	private String passwd;
	private String id;
	
	// 생성자 오버로딩
	public Naver(String email, String passwd, String id) {
		this.email = email;
		this.passwd = passwd;
		this.id = id;
	}
	
	public Naver(String passwd, String id) {
		this.passwd = passwd;
		this.id = id;
	}
	
	// 함수에서 제일 중요한 부분
	// 접근제어자 반환타입 함수명(매개변수 타입만!)
	// 매개변수의 이름은 안본다.
//	public Naver(String d1 String d2) {
//		this.passwd = d1;
//		this.id = d2;
//	}
	
	public Naver() {}
	
}

class animal{
	String name;
	String breeds;
	int age;
	
	void makesound() {
		
	}
	public animal() {}
	
	public animal(String name){
		super();
		this.name = name;
	}
	
	public animal(String name, String breeds){
		super();
		this.name = name;
		this.breeds = breeds;
	}
	
	public animal(String name, String breeds, int age){
		super();
		this.name = name;
		this.breeds = breeds;
		this.age = age;
	}
}
/*
 * 오버라이딩
 * - 부모가 물려준 함수의 내용을 변경하는 것!
 * - 함수를 새로 만드는것이 아니다!
 * - 함수명, 매개변수 개수 및 타입, 반환타입 모두 부모가 만든 함수랑 같아야함!
 * - 변경 할 수 있는건 실행내용만 변경 가능하다
 */
class cat extends animal{
//	public cat(String name){
//		super(name);
//		this.name = name;
//	}
//	
//	public cat(String name, String breeds){
//		super(name, breeds);
//		this.name = name;
//		this.breeds = breeds;
//	}
//	
//	public cat(String name, String breeds, int age){
//		super(name, breeds, age);
//		this.name = name;
//		this.breeds = breeds;
//		this.age = age;
//	}
	@Override
	void makesound() {
		System.out.println("야옹!");
	}
	
}

class dog extends animal{
//	public dog(String name){
//		super(name);
//		this.name = name;
//	}
//	
//	public dog(String name, String breeds){
//		super(name, breeds);
//		this.name = name;
//		this.breeds = breeds;
//	}
//	
//	public dog(String name, String breeds, int age){
//		super(name, breeds, age);
//		this.name = name;
//		this.breeds = breeds;
//		this.age = age;
//	}
	@Override
	void makesound() {
		System.out.println("멍멍!!");
	}
	
}

public class ConstructorOverloading {
	public static void main(String[] args) {
		Naver n1 = new Naver();
		
		Naver n2 = new Naver("qqqq", "qqqq");
		
		Naver n3 = new Naver("email", "passwd", "id");
		
		
		/*
		 *  동물클래스 
		 *  
		 *   이름,품종,나이
		 *   이름만 입력!
		 *   이름하고 품종만 입력!
		 *   3다 입력 할 수도 있다!
		 *  cat
		 *  
		 *  dog 
		 */
		cat cat1 = new cat();
	}
}
