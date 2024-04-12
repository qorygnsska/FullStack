package ArrayGame;

import java.util.Scanner;

public class ArrayGameNumber {

	public static void main(String[] args) {
		/*
		 * # 숫자이동[1단계] 1. 숫자2는 캐릭터이다. 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로 숫자2를 입력하면, 캐릭터가 오른쪽으로
		 * 이동한다. 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다. 4. {0, 0, 2, 0, 0, 0, 0}; ==> 왼쪽 ==>
		 * {0, 2, 0, 0, 0, 0, 0};
		 * 
		 */
		Scanner sc = new Scanner(System.in);

		int[] game = { 0, 0, 2, 0, 0, 0, 0 };

		// 게임판 출력
		// 배열의 값을 가지고 와서 0일 경우는 빈공간 출력
		// 2 주인공 출력

		// 2 주인공이 이동을 할 수 있다.
		// 이동하는 주인공의 인덱스를 기억하는 변수가 필요
		int player = 2;

		while (true) {
			int i = 0; // 배열의 공간에 접근하기 위해서 변수 선언

			while (i <= 6) {
				if (game[i] == 0) {
					System.out.print("_ ");
				} else if (game[i] == 2) {
					System.out.print("👀️ ");
				}

				// 다음 공간으로 이동하기
				i++;
			}
			System.out.println("1)왼쪽 / 2)오른쪽");
			int move = sc.nextInt();

			if (move == 1) {
				if (player - 1 >= 0) { // 왼쪽으로 이동할 공간이 있니?
					// 1번을 누르면 왼쪽으로 이동
					// 주인공을 왼쪽으로 한 칸 이동 시킨다.
					game[player - 1] = 2;
					// 주인공이 있던 현재 공간을 빈 공간으로 만든다.
					game[player] = 0;
					// 실제 주인공의 위치를 저장하는 player 하나 감소
					player--;
				}
			} else if (move == 2) { 
				if (player + 1 <= 6) { // 오른쪽으로 이동할 공간이 있니?
					game[player + 1] = 2;
					game[player] = 0;
					player++;
				}
			}
		} // while문 끝
		// 현재까지의 코드를 보면 실행은 되지만 왼쪽끝으로
		// 가거나 오른쪽 끝으로 가면 에러가 발생한다.
		// ArrayIndexOutOfBoundsException
		// 위에 에러가 발생하는 이유는 키보드를 눌렀을 때
		// 공간이 없기 때문에 에러가 발생한다.
		
		// 해결하려는 코드를 작성!
		// 1번 눌렀을 때 왼쪽에 갈 수 있는 공간이 있는지 검사해서 0보다 크거나 같을 경우는 이동을 시키면 된다
		// 만약 마이너스 값이 나오면 이동 x
		
		// 2번 눌렀을때도 마찬가지고 오른쪽의 공간을 검사해서 7보다 작으면 이동하고 7이상이면 이동 x
		
	}

}
