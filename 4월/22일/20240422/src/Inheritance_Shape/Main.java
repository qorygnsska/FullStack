package Inheritance_Shape;

public class Main {

	public static void main(String[] args) {
		// 사각형 인스턴스를 생성
		Rect rect1 = new Rect();
		
		rect1.draw();
		
		// 원 인스턴스
		Circle c1 = new Circle(10, 10, 10); // 생성자로 private 변수에 초기화 가능
		c1.draw();
		

	}

}
