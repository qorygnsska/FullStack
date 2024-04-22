package Inheritance_Shape;

public class Circle extends Shape{
	// 원 그리기 위해서는 좌표!!
	private int r;
	
	// 오버라이딩
	@Override
	void draw() {
		System.out.println("원 그리기");
	}
	
	// 변수명이 같으면 구분하기 위해 클래스변수에 this를 붙임
	public Circle(int r, int x, int y) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public Circle() {
		
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	// 출력
	public void info() {
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		System.out.println("반지름 : " + r);
	}
}
