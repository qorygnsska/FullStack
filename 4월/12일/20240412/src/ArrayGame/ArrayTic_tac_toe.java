package ArrayGame;

import java.util.Scanner;

public class ArrayTic_tac_toe {

	public static void main(String[] args) {
		/*
		 * # 틱택토 === 틱택토 === [X][X][O] [ ][O][ ] [ ][ ][ ] [p1]인덱스 입력 : 6 === 틱택토 ===
		 * [X][X][O] [ ][O][ ] [O][ ][ ] [p1]승리
		 * 
		 */

		// 게임을 위한 배열을 생성한다.
		// 배열의 공간을 생성하면 자동으로 0이 저장됨

		// 만약 0이면 빈 공간 [ ]
		// p1 1이면 p1을 뜻한다. O
		// p2 2이면 p2를 뜻한다. X
		Scanner sc = new Scanner(System.in);
		int[] game = new int[9];
		
		boolean result = true; // p1, p2의 턴을 나누는 용도
		
		// 결과를 저장하는 변수
		int win = 0;
		
		while (true) {
			int i = 0;

			// 현재 배열의 인덱스를 이용해서 3칸씩 출력하기 위하여 나눗셈을 이용해서 공통된 값을 찾는다.

			while (i < game.length) {
				
				// 입력한 인덱스 값을 이용해서
				// 배열의 실제 값을 변경하고
				// 출력!
				if (game[i] == 0) {
					System.out.print("[ ]");
				}
				if(game[i] == 1) {
					System.out.print(" O ");
				}
				if(game[i] == 2) {
					System.out.print(" X ");
				}

				// 만약 칸을 출력했다면 나머지값을 이용해서 공통되는 2가 나왔을 때 줄바꿈
				if (i % 3 == 2) {
					System.out.println();
				}
				i++;
			}
			// 현재 플레이하고 있는 p1 true일 경우
			//				p2 false
			int curPlayer = result ? 1 : 2;
			
			System.out.println("[" + (result ? "p1" : "p2") + "]인덱스 : ");
			int index = sc.nextInt();
			
			System.out.println("현재 플레이어 : " + curPlayer);
			System.out.println("입력 인덱스 :  : " + index);
			// index 변수를 이용해서 game배열의 공간에 값을 가지고 와서 빈 공간인 지 확인
			if(game[index] == 0) {
				// 위의 공간이 비어있다면 값을 저장
				// 현재 플레이의 값을 저장
				game[index] = curPlayer;
			}else {
				// 0이 아니고 1이나 2가 있을 경우 빈 공간이 아니다
				// 데이터를 저장할 수 없음, 다시 입력 받아야함
				System.out.println("이미 선택된 위치 입니다.");
				System.out.println("다시 입력하세요!");
				continue;
			}
			
			// 위에 정상적으로 실행 됐다면
			result = !result;
			
// --------------------- 밑에는 내가 한  방식 ----------------------------------
			
//			if (result == true ) {
//				System.out.println("[p1]인덱스 : ");
//				int p1 = sc.nextInt();
//				if(game[p1] == 0) {
//					game[p1] = 1;
//					result = false;
//				}
//			} else {
//				System.out.println("[p2]인덱스 : ");
//				int p2 = sc.nextInt();
//				if(game[p2] == 0) {
//					game[p2] = 2;
//					result = true;
//				}
//			}
			
			//승패 검사 중 대각선 검사						왼쪽 대각선														오른쪽 대각선
			if(game[0] == curPlayer && game[4] == curPlayer && game[8] == curPlayer || game[2] == curPlayer && game[4] == curPlayer && game[6] == curPlayer) {
				win = curPlayer;
				break;
			}
			
		}
		
		System.out.println(win == 1 ? "p1 플레이어 승리!" : "p2 플레이어 승리!");
		
		
	}

}
