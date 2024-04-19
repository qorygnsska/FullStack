package RuntimeDataArea;

class B{
	int hakbun;
	static int count = 1;
	
	B(int hakbun){
		this.hakbun = hakbun;
		System.out.println("학번:"+ hakbun);
		System.out.println("B객체 생성: count:" + count++);
	}
}

class D{
	int data;
	
	void show() {
		System.out.println("non-static");
		
	}
	static void show2() {
		//static이 붙지 않은 변수는 메모리에 생성이 되지 않았기 때문에 사용할 수 없다
		// 그래서 밑에 있는 data를 실행 하려고 하면 에러가 발생한다
		//System.out.println(data);
		System.out.println("static O");
	}
}
public class Main {
	// static이 붙으면 객체 생성 없이 실행가능하다.
	public static void main(String[] args) {
		// D안에 static show2()
		// show2() 어디 있는지는 알려줘야된다.
		D.show2();
		
		B b1 = new B(1001);
		B b2 = new B(1001);
		B b3 = new B(1001);
		
		// static을 쓰면 각각의 인스턴스가 공용으로 쓴다.
		b1.count = 1000; // 따라서 b1만 count를 1000으로 바꿨지만 static이 붙은 전체 count가 1000으로 바뀐다 
		b1.hakbun = 1005;
		
		System.out.println(b1.hakbun);
		System.out.println(b1.count); 
		
		System.out.println(b2.hakbun);
		System.out.println(b2.count); 
		
		System.out.println(b3.hakbun);
		System.out.println(b3.count); 
		
		
		/*
		 * 자바의 메모리 영역
		 * - stack
		 *   메서드가 실행이 될때
		 *   지역변수, 매개변수, 객체의 주소값을 저장하는 참조변수
		 *   함수가 실행하고 끝나면 사라지는 공간
		 *   
		 * - heap
		 *   클래스를 이용해서 만드는 공간(객체)
		 *   new 키워드를 이용해서 메모리 할당
		 *   배열도 마찬가지
		 *   런타임(프로그램이 실행중)중에 생성되는 객체들을 인스턴스라고 함
		 *   
		 *   프로그램이 시작하면 데이터나 변수들이 생성 프로그램이 끝날 때까지 데이터를 유지할 수 있다.
		 *   
		 *   가비지 컬렉터 : 불필요한 메모리를 알아서 정리해준다
		 *   
		 * - 정적영역, method영역
		 *   java 프로그램이 실행하기 전, static변수나 메서드를 첫 단계에 메모리에 올려 프로그램을 실행
		 *   static : 실행 1순위
		 *   자바 가상머신(jvm)에서 객체를 생성하지 않아도 메모리에 호출시켜 할당이 가능함
		 *   main힘수도 실행되기 위해서는 메모리에 올라갸아한다.
		 *   
		 *   자바 변수의 종류
		 *   - 클래스 변수 : static 객체끼리 공유하는 변수로 여러개의 객체를 공통적으로 사용하는 값
		 *   - 인스턴스 변수 : 개별적인 저장공간으로 객체 / 인스턴스마다 다른값을 저장
		 *   - 지역변수 : 함수 내에서 사용할 수 있는 값
		 *   - 매개변수 : 전달되는 값
		 *   
		 *   생성되는 시간에 따라서 구별
		 *   static 붙은 객체들(뱐수, 메서드)
		 *   non-static붙은 객체들(변수, 메서드)
		 *  
		 * 
		 */

	}

}
