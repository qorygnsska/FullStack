package Farm;

import java.util.Scanner;

public class FarmMenu {
	Scanner sc = new Scanner(System.in);
	FarmController fc = new FarmController();

	public void mainMenu() {
		while (true) {
			System.out.println("===== KH마트 =====");
			System.out.println("***** 메인 메뉴 *****");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			if (sel == 1) {
				adminMenu();
			} else if (sel == 2) {
				customerMenu();
			} else if (sel == 9) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("번호를 다시 입력하세요!");
			}
		}
	}

	public void adminMenu() {
		while (true) {
			System.out.println("***** 직원 메뉴 *****");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			if (sel == 1) {
				addNewKind();
			} else if (sel == 2) {
				removeKind();
			} else if (sel == 3) {
				changeAmount();
			} else if (sel == 4) {
				printFarm();
			} else if (sel == 9) {
				mainMenu();
			} else {
				System.out.println("번호를 다시 입력하세요!");
			}
		}
	}

	public void customerMenu() {
		while (true) {
			System.out.println("현재 KH마트 농산물 수량");
			printFarm();
			System.out.println("***** 고객 메뉴 *****");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 선택 : ");
			int sel = sc.nextInt();
			sc.nextLine();

			if (sel == 1) {
				buyFarm();
			} else if (sel == 2) {
				removeFarm();
			} else if (sel == 3) {
				printBuyFarm();
			} else if (sel == 9) {
				mainMenu();
			} else {
				System.out.println("번호를 다시 입력하세요!");
			}
		}
	}

	public void addNewKind() {
		
	}

	public void removeKind() {

	}

	public void changeAmount() {

	}

	public void printFarm() {

	}

	public void buyFarm() {

	}

	public void removeFarm() {

	}

	public void printBuyFarm() {

	}
}
