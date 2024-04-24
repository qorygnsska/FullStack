package Object;

import java.util.Objects;

class A{
	int num;
	int num2;

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			// 같은 객체는 비교할 필요가 없다
			return true;
		}
		// 업 캐스팅이 되어있는 obj를 다시 자식클래스로 다운 캐스팅
		A temp = (A)obj;
		
		if(this.num == temp.num || this.num2 == temp.num2) {
			System.out.println("같다");
			return true;
		}else {
			System.out.println("다르다");
			return false;
		}
	}


	// Object가 가지고 있는 toString
	// 상속 받았기 때문에 새로운 함수를 만드는 것이 아니라 상속받은 내용을 재정의(변경)
	@Override
	public String toString() {
		return "A [num=" + num + "]";
	}
	
	
}
public class Main {

	public static void main(String[] args) {
		
		// Object 클래스
		// - 모든 자바는 무조건 Object 클래스로부터 시작한다
		// - 자동으로 Object 클래스가 상속된다.
		//   extends 사용하지 않아도 컴파일러가 알아서 상속시켜주고 컴파일 해준다.
		// 개발자가 쓰기 편하라고 구현한 것
		
		// - 필드(변수) 없고 메서드(함수) 구성 되어있다
		
		// Object 클래스 메서드 종류
		// - 역할 : 운영체제와 자바 가상 머신의 사이를 관리

//		A a1 = new A();
//		System.out.println(a1); // .toString() 생략된 것
		// toString()
		// - 객체 자신의 정보를 문자열로 반환
		// - 객체의 고유한 정보를 출력하고 싶을때
		// - 기본적으로 객체를 출력(println) 변수에.toString() 하지 않아도 자동으로 붙여 호출한다
		// - 기본정보를 보기 싫고 내가 원하는대로 내용을 보고싶으면 재정의 하면됨
		
		// Arrays.toString(배열)
		// 배열 자체를 String 문자화 이미 재정의 해놓은 것!!
		
		// 객체를 생성하지 않고도 사용할 수 있는 static 영역에 저장되어 있음
//		boolean result = Objects.equals("이서희", "이서희");
//		System.out.println(result);
		
		
		A a1 = new A();
		a1.num = 10;
		
		A a2 = new A();
		a2.num = 10;
		
		// 객체 끼리 비교!
		// eqauls()
		// 객체의 주소값만 확인함
		boolean res = a1.equals(a2);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(res);
		
		//String의 equals는 이미 만들어져있음
		String str = "이서희";
		String str2 = "이서희";
		
		if(str.equals(str2)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
	}

}
