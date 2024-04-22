package Inheritance_Account;

// 은행에서 발급하는 체크카드는 계좌와 연결
// 계좌의 정보를 가져온다
public class Card extends Account{
	// 카드의 정보
	String cardNumber;
	int cardPw;
	int cvc;
	
	// account 가지고 있는 메서드 사용
	
	void pay(int money) {
		withdraw();
	}
	
	
	public Card() {
		
	}


	public Card(String cardNumber, int cardPw, int cvc, String accNumber, int accPw, String accName, int money) {
		this.accNumber = accNumber;		
		this.accPw =accPw;				
		this.accName =accName;			
		this.money = money;				
		this.cardNumber = cardNumber;
		this.cardPw = cardPw;
		this.cvc = cvc;
	}

}
