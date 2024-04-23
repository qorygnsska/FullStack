package ArrayList;

class Parent{
	String name;
	int age;
}

class Child extends Parent{
	int number;
	
	void show() {
		System.out.println(number);
	}
}

class Child2 extends Parent{
	
}
public class ParentMain {

	public static void main(String[] args) {
		// 업 캐스팅(자식에서 부모로)
		// (Parent) 형변환 연산기호를 생략할 수있다.
		// 자식클래스가 부모로 업캐스팅 된다는 것은 멤버의 갯수 감소 하는걸 의미한다.
		// 즉, 자식클래스에서만 있는 속성(변수)와 메서드는 실행을 못한다.
		// 사용하고 싶다면 자식 클래스에서 부모가 물려준 메서드를 오버라이딩
		// 부모 클래스의 메서드가 동작하는 것이 아니라 자식 클래스의 메서드가 우선적으로 실행
		// 업캐스팅을 하는이유 : 공통적으로 할 수 있는 부분을 만들어서 간단하게 다루기 위해서
		// 업캐스팅해서 공통부분을 다루었다면 자식들만의 각각의 메서드나 변수를 사용하려고 업캐스팅한 객체를 다시 되돌리는 것을 다운캐스팅!
		Parent p2 = (Parent) new Child();

		// 다운캐스팅(부모에서 자식)
		// 형변환 기호를 생략할 수 없음 (child) 꼭 써야함
		Child c2 = (Child) p2;
		c2.show();

		// 참조변수의 형변화은 사용할 수있는 멤버의
		// 개수를 조절 하는 것이다.
		
		// 같은 부모를 상속 받은 형제 클래스끼리는 서로 캐스팅이 불가능하다.

	}

}
