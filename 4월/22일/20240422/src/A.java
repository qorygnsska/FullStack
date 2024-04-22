
public class A {
	
	// 컴파일 후 메모리 로드시에 메모리공간에 이미 할당
	// static 붙은 변수나 메서드는 이미 만들어졌기 때문에 어떤 함수든 데이터를 출력하거나 가져갈 수 있음
	// 단 dufault로 선언되어 있기때문에 가능한거임 private면 안됨
	static int top;
	
	void push() {
		System.out.println("현재 top : " + top);
	}
	
	void show() {
		top += 1;
	}
}
