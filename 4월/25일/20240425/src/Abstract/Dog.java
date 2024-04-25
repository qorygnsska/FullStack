package Abstract;

public class Dog extends Animal{
	@Override
	void 운다() {
		System.out.println("고양이는 멍멍 한다.");
	}
	
	@Override
	void play() {
		System.out.println("강아지 같이 논다.");
	}
	
	@Override
	void 먹는다() {
		System.out.println("강아지 같이 먹는다.");
	}
	
	void 강아지만의기능() {
		System.out.println("강아지만의 기능");
	}
	
	void 안녕() {
		
	}
}
