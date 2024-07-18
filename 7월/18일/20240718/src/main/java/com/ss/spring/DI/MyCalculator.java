package com.ss.spring.DI;

// 사칙연산에 사용할 필드를 선언하고
// Calculator 클래스의 사칙연산을 실행하는 클래스
public class MyCalculator {

	private int firstNum;
	private int secondNum;
	private Calculator calculator;

	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public String toString() {
		return "MyCalculator [firstNum=" + firstNum + ", secondNum=" + secondNum + ", calculator=" + calculator + "]";
	}

	
	// Calculaotr 클래스의 메서드를 실행하는 문장을 작성
	public void add() {
		calculator.add(firstNum, secondNum);
	}

	public void sub() {
		calculator.sub(firstNum, secondNum);
	}
}
