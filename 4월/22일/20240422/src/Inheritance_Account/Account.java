package Inheritance_Account;

import java.util.Scanner;

// 고객의 정보를 저장하는 클래스
public class Account {
	String accNumber;
	int accPw;
	String accName;
	int money;
	
	Scanner sc = new Scanner(System.in);
	
	// 입금
	void deposit(int money) {
		this.money = money;
	}
	
	// 출금
	void withdraw() {
		
		// 잔액이 0원이면 출금할 수 없다
		if(money <= 0) {
			System.out.println("잔액이 없습니다.");
			return;
		}
		// 출금을 진행할 출금액을 받는다.
		System.out.print("출금액 : ");
		int temp = sc.nextInt();
		
		if(temp > money) {
			System.out.println("잔액 부족입니다.");
		}else {
			money -= temp;
			System.out.println("출금 완료!");
			System.out.println("현재 잔액 : " + money + "원");
		}
		
	}
}
