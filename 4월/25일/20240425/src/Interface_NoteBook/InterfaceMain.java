package Interface_NoteBook;

//interface 인터페이스이름{
//	public static final 타입 상수이름 = 값; -> public static final은 생략 가능!
//	public abstract 타입 메서드이름(매개변수); -> public abstract은 생략 가능!
//}

interface Tv {
	// 상수는 변수와 이름이 구별되게 모두 대문자로 작성한다.
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 10;

	void turnOn();

	void turnOff();

	void changeVolum(int volum);

	void changeChannel(int Channel);
	
	// public static final
	// public abstarct
	// 생략 해도 인터페이스를 만들 때 모든 멤버에
	// 적용되는 것이기 때문에 편하게 구현하라고
	// 생략이 가능하다 단! 컴파일 시에 자동으로
	// 추가되서 기능 구현이 된다.
	
	// extends와 implements를 같이 사용할 경우 extends를 먼저 사용해야한다
}

public class InterfaceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
