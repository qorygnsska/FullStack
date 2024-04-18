package Class;

import java.util.Random;

class Lotto{
	int[] lotto;
}
public class ClassTest2 {

	public static void main(String[] args) {
		// 클래스 멤버 변수로 배열을 저장할 수 있다.
		
		Lotto lo = new Lotto();
		lo.lotto = new int[6];
		Random rand = new Random();
		
		// 배열에 로또 저장
		for(int i = 0; i < lo.lotto.length; i++) {
			int num;
			boolean isDu;
			
			// do~while문
			// 실행 -> 반복
			// 무조건 1번 실행하고 그 이후에 조건을 보고 반복한다.
			// 중복검사
			do {
				num = rand.nextInt(45) + 1;
				isDu = false;
				
				// 중복확인
				for(int j = 0; j < i; j++) {
					if(lo.lotto[j] == num) {
						isDu = true;
						break;
					}
				}
			// 참일 경우 중복이기 때문에 실행하는 do로 올라가서 다시 랜덤값을 뽑게한다.
			// 거짓일 경우는 중복되지 않았다는 것이기 때문에 반복문을 빠져나와야한다.
			}while(isDu);
			
			lo.lotto[i] = num;
			System.out.print(lo.lotto[i] + " ");
		}
		System.out.println();
		
		int size = lo.lotto.length;
		
//		// 버블정렬 코드
//		for (int i = 0; i < size - 1; i++) {
//			for (int j = 0; j < size - i - 1; j++) {
//				if (lo.lotto[j] > lo.lotto[j + 1]) {
//					int temp = lo.lotto[j];
//					lo.lotto[j] = lo.lotto[j + 1];
//					lo.lotto[j + 1] = temp;
//				}
//				
//			}
//		}
//		for(int n : lo.lotto) {
//			System.out.print(n + " ");
//		}
		
		
		// 선택정렬 코드
		for (int i = 0; i < size - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (lo.lotto[minIndex] > lo.lotto[j]) {
					minIndex = j;
				}
			}
			int arr;
			arr = lo.lotto[i];
			lo.lotto[i] = lo.lotto[minIndex];
			lo.lotto[minIndex] = arr;

		}
		for(int n : lo.lotto) {
			System.out.print(n + " ");
		}
		
	}

}
