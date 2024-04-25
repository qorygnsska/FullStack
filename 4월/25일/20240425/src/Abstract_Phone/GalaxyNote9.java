package Abstract_Phone;

// 갤럭시 노트9은 스마트폰이면서 폰이다!
// 자바는 다중상속 불가
public class GalaxyNote9 extends SmartPhone {
	@Override
	void printInfomation() {
		System.out.println("갤럭시 노트 9입니다.");
	}

	@Override
	String makeCall() {

		return null;
	}

	@Override
	String takeCall() {

		return null;
	}
	
	// 갤럭시노트만의 기능이기 때문에 오버라이딩 대상이 아님
	void picture() {

	}

	void charge() {

	}

	void touch() {

	}

	void bluetoothPen() {

	}
}
