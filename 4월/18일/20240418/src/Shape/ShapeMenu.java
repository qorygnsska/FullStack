package Shape;

import java.util.Scanner;

public class ShapeMenu {
	SquareController scr = new SquareController();
	TriangleController tc = new TriangleController();
	Scanner sc = new Scanner(System.in);

	void inputMenu() {

		while (true) {
			System.out.println("==== 도형 프로그램 ====");
			System.out.printf("3. 삼각형\n4. 사각형\n9. 프로그램 종료\n");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			if (num != 3 && num != 4 && num != 9) {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			} else if (num == 3) { // 삼각형 선택 triangleMenu()
				triangleMenu();
				break;
			} else if (num == 4) { // 사각형 선택 squareMenu()
				squareMenu();
				break;
			} else {
				System.out.println("프로그램 종료");
				break;
			}

		}
	}

	void triangleMenu() {
		while (true) {
			System.out.println("==== 삼각형 ====");
			System.out.printf("1. 삼각형 면적\n2. 삼각형 색칠\n3. 삼각형 정보\n9. 메인으로\n");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			if (num != 1 && num != 2 && num != 3 && num != 9) {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			} else if (num == 1) { // 삼각형 면적 inPutSize()
				inputSize(3, 1);
				break;
			} else if (num == 2) { // 삼각형 색칠 inputSize()
				inputSize(3, 2);
				break;
			} else if (num == 3) { // 삼각형 정보 printInformation()
				printInformation(3);
				break;
			} else {
				System.out.println("메인으로 돌아갑니다."); // inputMenu()
				inputMenu();
				break;
			}
		}
	}

	void squareMenu() {
		while (true) {
			System.out.println("==== 사각형 ====");
			System.out.printf("1. 사각형 둘레\n2. 사각형 면적\n3. 사각형 색칠\n4. 사각형 정보\n9. 메인으로\n");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			if (num != 1 && num != 2 && num != 3 && num != 4 && num != 9) {
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
			} else if (num == 1) { // 사각형 둘레 inPutSize()
				inputSize(4, 1);
				break;
			} else if (num == 2) { // 사각형 면적 inputSize()
				inputSize(4, 2);
				break;
			} else if (num == 3) { // 사각형 색칠 inputSize()
				inputSize(4, 3);
				break;
			} else if (num == 4) { // 사각형 정보 printInformation()
				printInformation(4);
				break;
			} else {
				System.out.println("메인으로 돌아갑니다."); // inputMenu()
				inputMenu();
				break;
			}
		}
	}

	void inputSize(int type, int menuNum) {
		if (type == 3 && menuNum == 1) {
			System.out.print("높이 : ");
			double height = sc.nextInt();
			System.out.print("너비 : ");
			double width = sc.nextInt();
			System.out.println("삼각형 면적 : " + tc.calcArea(height, width));
			triangleMenu();
		}
		if (type == 3 && menuNum == 2) {

			System.out.println("색깔을 입력하세요 : ");
			String color = sc.nextLine();
			tc.paintColor(color);
			System.out.println("색이 수정되었습니다.");
			triangleMenu();
		}
		if (type == 4 && menuNum == 1) {
			System.out.print("높이 : ");
			double height = sc.nextInt();
			System.out.print("너비 : ");
			double width = sc.nextInt();
			System.out.println("사각형 둘레 : " + scr.calcPerimeter(height, width));
			squareMenu();
		}
		if (type == 4 && menuNum == 2) {
			System.out.print("높이 : ");
			double height = sc.nextInt();
			System.out.print("너비 : ");
			double width = sc.nextInt();
			System.out.println("사각형 면적 : " + scr.calcArea(height, width));
			squareMenu();
		}
		if (type == 4 && menuNum == 3) {
			System.out.println("색깔을 입력하세요 : ");
			String color = sc.nextLine();
			scr.paintColor(color);
			System.out.println("색이 수정되었습니다.");
			squareMenu();

		}

	}

	void printInformation(int type) {
		if (type == 3) {
			System.out.println(tc.print());
		} else if (type == 4) {
			System.out.println(scr.print());
		}
	}

}
