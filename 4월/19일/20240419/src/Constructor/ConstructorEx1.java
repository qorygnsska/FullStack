package Constructor;

class Cat{
	// 상태
	String name;   // 이름
	String breeds; // 품종
	double weight; // 무게
	
	// 생성자(클래스명과 같음)
	Cat(String n, String b, double w){
		name = n;
		breeds = b;
		weight = w;
	}
	
	// 동작
	void claw() {}
	void meow() {}
}

class Dog{
	// 상태
	String name;
	String breeds;
	int age;
	
	Dog(String n, String b ,int a){
		name = n;
		breeds = b;
		age = a;
	}
}

public class ConstructorEx1 {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍
		 *  - 조립식 프로그램 
		 *  - 객체를 조립하여 전체적인 프로그램 
		 *    만드는 것! 
		 *    
		 *  - 클래스 (설계도)
		 *    객체를 만들기 위한 설계도 
		 *  - 설계도를 기준으로 해서 실제 물건
		 *    객체(인스턴스)
		 *    
		 *  클래스 
		 *    - 상태(data) 와 동작(메서드)
		 */
		
		
		// 메모리 할당(새로운 변수 생성)
		// 안에 변수들이 초기화 된 상태
//		System.out.println(cat1.name);
		
//		cat1.name = "나비"; // 생성자를 이용해 더 편하게 값 할당 가능
//		cat1.breeds = "턱시도";
		
		// 생성자
		// - 객체를 만드는 특별한 메서드
		// 객체 생성 시 내가 원하는 값으로 초기화를 할 수 있다.
		
		// 생성자는 2가지 일을 한다
		// - 객체 생성 : 객체를 만든다(메모리 공간 만들기)
		// - 객체 초기화 : 객체 안에 변수들의 값을 저장
		
		Cat cat1 = new Cat("나비", "턱시도", 2.0);
		System.out.println(cat1.name);
		
		Cat cat2 = new Cat("야옹이", "턱시도", 4.0);
		System.out.println(cat2.name);
		
		// 객체 생성 후 초기화까지 한번에 실행할 수 있는 것 = 생성자
		Dog dog1 = new Dog("최여름", "셔틀랜드 쉽독", 2);
		System.out.println(dog1.name + " " + dog1.breeds + " " + dog1.age + "살");
		
	}

}
