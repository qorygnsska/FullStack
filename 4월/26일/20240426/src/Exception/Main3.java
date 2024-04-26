package Exception;

// 사용자 정의 예외 클래스!
class MyException extends Exception {

	public MyException(String msg) {
		super(msg);
	}
}

public class Main3 {

	public static void main(String[] args) {
		// 내가 클래스를 이용해서 개발하면
		// 내가 개발한 클래스의 예외를 처리할 수있는
		// 객체를 생성하는 틀을 만들어야된다.

		// 내가 만든 예외처리 클래스를 직접 객체 생성을 해야한다.

		try { // 예외발생 문장들;
				// 직접 예외를 발생 시킬수 있다.
				// throw 키워드
			throw new MyException("졸려!!");

		} catch (MyException e) {
			System.out.println("예외:" + e.getMessage()); // 내가 만든 예외 출력
		}
		System.out.println("정상 작동");

	}

}
