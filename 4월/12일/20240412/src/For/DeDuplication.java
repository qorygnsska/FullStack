package For;

import java.util.Random;

public class DeDuplication {

	public static void main(String[] args) {
		
		// 배열의 랜덤값을 이용해서 6개 출력 단. 중복 숫자 없이 출력
		Random random = new Random();
		
		// 저장 공간
		int[] array = new int[6];
		
		// index (공간 번호)
		int index = 0;
		
		while(index < array.length) {
			//1~100까지 랜덤값을 뽑는다.
			int rand = random.nextInt(100) + 1 ;
			
			// 중복되지 않았다는 체크 변수를 만든다.
			boolean check = false;
			
			// 생성된 랜덤 숫자가 배열에 이미 존재하는 지 확인
			for(int i = 0; i < index; i++) {
				if(array[i] == rand) {
					// 중복된 값을 발견했기 떄문에 굳이 뒤에 반복을 더 할 필요가 없다
					check = true;
					break;
				}
			}
			
			// 중복이 아니면 배열에 저장
			// 중복이면 저장 안 하고 현재 index값도 증가시키지 않는다
			if(check == false) {
				// 중복되지 않아서 배열에 저장하고 현재 index값을 하나 증가시킨다.
				array[index] = rand;
				index++;
			}
		}
		
		for(int num : array) {
			System.out.print(num + " ");
		}

// 		위 코드와 동일
//		for(int i = 0; i < array.length; i++) {
//			System.out.print(array[i] + " ");
//		}
		

	}

}
