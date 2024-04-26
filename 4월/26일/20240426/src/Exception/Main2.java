package Exception;

//class A{
//
//void z() {
//	try {
//	System.out.println(10 / 0);
//	}catch(Exception e) {
//		e.printStackTrace();
//		// 예외가 발생하면 어디서 어떤함수에서
//		// 생겼는지 그 함수와 연결된 모든 
//		// 내용들을 스택구조(쌓아서) 보여준다.
//		
//	}
//}
//}

class A {

// 메서드를 실행할 때 모든 예외에 대해서
// z를 호출한다(z라는 메서드를 실행)
// 예외를 던진다.
	void z() throws Exception {

		System.out.println(10 / 0);

	}

	void z1() throws IndexOutOfBoundsException, ArithmeticException {

		System.out.println(10 / 0);

	}
}

public class Main2 {

	public static void z() throws Exception {
		System.out.println(10 / 0);
	}

	public static void y() throws Exception {
		z();
	}

	public static void x() throws Exception {
		y();
	}

	public static void main(String[] args) {

		A a1 = new A();
		A a2 = new A();
		A a3 = new A();
		A a4 = new A();
		A a5 = new A();

		try {
			a2.z();
			a1.z1();
			x();
		} catch (Exception e) {
			// 예외의 부모클래스로 업 캐스팅해서
			// 예외에 관한 모든 자식들을 처리한다.
			e.printStackTrace();
		}

	}

}