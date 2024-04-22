package Inheritance;

class A{
	private int num;
	int num2;
	
	public A(int num, int num2) {
		this.num = num;
		this.num2 = num2;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
}

// 상속을 하게 되면 부모가 매개변수 받는 생성자를 만들어 놓으면 
// 부모가 객체를 먼저 생성하고 매개변수 데이터 저장해서 자식한테 보내줘야함
class B extends A{
	
	// 부모 클래스의 생성자를 호출하는 키워드
	public B(int num, int num2) {
		super(num, num2); // this는 나 super는 부모
	
	}
	
}


public class InheritanceEx1 {

	public static void main(String[] args) {
		// 상속 중 접근제어자 private
		// 자식 클래스에서 부모 클래스의 priavte 변수나 메서드에 접근이 불가능함
		// getter setter 사용하면 됨
		B b1 = new B(10, 20);
		// b1.num = 1; 에러 
		b1.setNum(100);
		System.out.println(b1.getNum());
		
		// 상속
		// - 클래스들 안에 중복적으로 들어가는
		//   변수나 메서드를 하나의 클래스 만든다.
		
		// - 기본적인 클래스를 만들어서 새로운 클래스를 만들 때
		//   기본 클래스를 적용해서 추가적인 내용만 클래스로 만든다.
		
		// 상속할 때 extends 부모클래스명{}
		// 상속은 하나의 클래스만 가능하다
		// 여러개의 클래스(다중 상속)를 상속할 수 없다
		// 그래서 인터페이스르 사용

	}

}
