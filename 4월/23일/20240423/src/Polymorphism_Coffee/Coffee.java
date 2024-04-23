package Polymorphism_Coffee;

public class Coffee {
	int price;

	public Coffee(int price) {
		this.price = price;
	}
	
	public String toStr() {
		return "";
	}
	
}

class Americano extends Coffee{

	public Americano() {
		super(4100); // 부모에게 고정된 값을 넘겨줘도 된다
	}
	
	@Override
	public String toStr() {
		return "아메리카노";
	}
	
}

class CaffeLatte extends Coffee{

	public CaffeLatte() {
		super(5000);
	}
	
	@Override
	public String toStr() {
		return "카페라떼";
	}
	
}
