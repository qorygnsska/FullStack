package Polymorphism_Coffee;

public class Customer {
	int money = 50000;
	
	// 커피 구매 메서드(다형성 활용)
	// 부모가 가지고 있는 내용을 상속 받아서 자식이 오버라이딩 하게 되면
	// 아무리 참조하는 타입이 부모타입이더라도 자식이 오버라이딩한 메서드의 내용이 우선적으로 나온다.
	void buyCoffee(Coffee coffee) {
		if(money < coffee.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
			money -= coffee.price;
			System.out.println(coffee.toStr() + "메뉴 입니다.");
		
	}
	
}
