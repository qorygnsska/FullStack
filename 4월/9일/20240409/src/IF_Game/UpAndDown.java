package IF_Game;

import java.util.Random;
import java.util.Scanner;

public class UpAndDown {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		/*
		 * # Up & Down 게임[1단계]
		 * 1. com은 8이다.
		 * 2. me는 숫자를 하나입력받는다.
		 * 3. com 과 me 를 비교해서 다음과 같은 메세지를 출력한다.
		 * 1) me < com	: Up!
		 * 2) me == com : Bingo!
		 * 3) me > com  : Down!
		 */
		// 1부터 10중에서 랜덤으로 하나 뽑기
		int com = rand.nextInt(20) + 1;
		             //nextInt(10) : 0~9까지
		System.out.print("숫자를 입력하세요 : ");
		int me = sc.nextInt();
		
		if(me == com) {
			System.out.println("Bingo!");
		}else if(me > com) {
			System.out.println("Down!");
		}else {
			System.out.println("Up!");
		}

	}

}
