package ArrayEx;

public class ArrayEx3 {

	public static void main(String[] args) {
		
		int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

//		1 2 3 4
//		5 6 7 8
//		9 10 11 12
//		13 14 15 16  처럼 출력
		
		// 배열의 요소를 행과 열의 형태로 출력
		int col = 4;
		int i = 0;
		int size = number.length;
		
		while(i < size) {
			int j = 0;
			
			while(j < col && i < size) {
				System.out.print(number[i]);
				j++;
				i++;
			}
			System.out.println();
		}
		
		
//		int i = 0;
//		while (i < number.length) {
//			System.out.print(number[i] + " ");
//			if (i % 4 == 3) {
//				System.out.println();
//			}
//			i++;
//		}

	}

}
