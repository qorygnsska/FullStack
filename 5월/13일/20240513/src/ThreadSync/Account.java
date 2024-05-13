package ThreadSync;

// 통장
public class Account {
	String accountNo; // 계좌번호
	String name; // 고객명
	int money; // 잔액

	public Account(String accountNo, String name, int money) {
		this.accountNo = accountNo;
		this.name = name;
		this.money = money;
	}

	public Account() {
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// 입금 메서드
	public void deposit(int amount) {
		money += amount;
	}

	// 출금 메서드
	public int withDraw(int amount) {
		// 잔액과 비교해서 출금이 가능한 경우 출금
		if(amount > money) {
			System.out.println(accountNo + "(" + name + ") 계좌 잔액 부족!!!!");
			return 0;
		}
		money -= amount;
		return amount;
	}

}
