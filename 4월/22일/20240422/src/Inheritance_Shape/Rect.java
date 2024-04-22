package Inheritance_Shape;

public class Rect extends Shape{
	// 사각형 그리기 위해서는 좌표
	int w;
	int h;
	
	// 원하는 값으로 인스턴스 생성과 동시에 초기화
	public Rect(int x, int y, int w, int h) {
		this.w = w;
		this.h = h;
	}
	
	// 기본 생성자
	public Rect() {
		System.out.println("기본 생성자");
	}
	
}
