package Abstract;

public class Cat extends Animal{
	
	// 상속을 받으면 고양이의 내용으로 변경
	@Override
	void 운다() {
		System.out.println("고양이는 야옹 한다.");
	}
	
	@Override
	void play() {
		System.out.println("고양이 같이 논다.");
	}
	
	@Override
	void 먹는다() {
		System.out.println("고양이 같이 먹는다.");
	}
	
	void 고양이만의기능() {
		System.out.println("고양이만의 기능");
	}
	
void 안녕() {
		
	}
}
