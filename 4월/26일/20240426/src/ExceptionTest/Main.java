package ExceptionTest;

// 예외에 대한 클래스                                                            
class AccountException extends Exception {

	public AccountException(String msg) {
		super(msg);
	}
}

class Account {
	String accNo;
	String ownerName;
	int balance;

	public Account(String accNo, String ownerName, int balance) {
		super();
		this.accNo = accNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	void deposit(int amount) {
		balance += amount;
		System.out.println(amount + "원 입금되었습니다. \n" + balance + "원");
	}

	void withdraw(int amount) throws AccountException {
		if (amount > balance) {
			throw new AccountException("잔액 부족;;;;");
		} else {
			balance -= amount;
			System.out.println(amount + "원 출금됨");
			System.out.println("현재 잔액 : " + balance + "원");
		}
	}

}

class CheckAccount extends Account {

	String cardNumber;

	public CheckAccount(String accNo, String ownerName, int balance, String cardNumber) {
		super(accNo, ownerName, balance);
		this.cardNumber = cardNumber;
	}

	// 카드 번호, 결제 금액 입력받기
	void pay(String cardNumber, int amount) throws AccountException {
		if (!this.cardNumber.equals(cardNumber)) {
			throw new AccountException("카드번호가 일치하지 않습니다!!");
		}
		// 출금이라는 메서드가 잔액이 부족하면 부족!
		// 예외 발생, 결제 금액을 출력!
		withdraw(amount);
	}
}

public class Main {

	public static void main(String[] args) {

		// 계좌 생성
		Account account1 = new Account("111-222-333", "홍길동", 100000);
		Account account2 = new Account("444-555-666", "김철수", 50000);
		Account account3 = new Account("777-888-999", "이영희", 200000);
		Account account4 = new Account("123-456-789", "박영수", 150000);
		Account account5 = new Account("987-654-321", "최민식", 300000);
		CheckAccount checkAcc1 = new CheckAccount("999-88-777", "배교훈", 1000000000, "5555-4444-5555");
		try {
			//account1.withdraw(1000000);
			
			// 결제 테스트
			checkAcc1.pay("5555-4444-5555", 1000000);
		}catch(AccountException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("정상 실행!");
	}

}
