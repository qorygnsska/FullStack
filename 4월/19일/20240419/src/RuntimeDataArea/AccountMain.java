package RuntimeDataArea;

/*
 * 계좌등록
 *  계좌번호는 은행에서 순서대로 발급
 *  int accNumber 계좌번호를 발급 static
 */
class Account{
	static int number = 1000;
	
	private int accNumber;
	private String accName;
	private int money;
	private int password;
	
	Account(String accName, int money, int password){
		accNumber = number++;
		this.accName = accName;
		this.money = money;
		this.password = password;
		
		info();
	}
	
	void info() {
		System.out.println("계좌명 : " + accName);
		System.out.println("계좌번호 : " + accNumber);
		System.out.println("계좌 비밀번호 : " + password);
		System.out.println("잔액 : " + money);
		System.out.println();
	}
	
}

public class AccountMain {

	public static void main(String[] args) {
		
		Account[] list = {
				new Account("댕댕이", 0, 1234),
				new Account("이쌤", 1000, 2222),
				new Account("채쌤", 10000, 3333)
				};
		
		
	}

}
