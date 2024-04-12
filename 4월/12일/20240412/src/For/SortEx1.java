package For;

public class SortEx1 {

	public static void main(String[] args) {
		// 버블 정렬
		// - 인접한 값을 비교해서 필요에 따라서 서로 위치를 교환한다.
		// - 정렬 과정에서 큰 값이 올라가는(bubble up) 현상이 일어나서 버블정렬이라고 함
		// 오름차순으로 정렬이 된다.
		
		int[] numList = {6, 7, 5, 2, 1, 4, 3};
		
		//원래 배열을 출력
		for(int i = 0; i < numList.length; i++) {
			System.out.print(numList[i] + " ");
		}
		
		System.out.println();
		
		int size = numList.length;
		System.out.println("현재 배열사이즈 : " + size);
		for(int i = 0; i < size - 1; i++) {
			//현재 요소와 다음 요소 비교하여 큰 값을 뒤로 교체하는 코드
			for(int j = 0; j < size - i - 1; j++) {
				if(numList[j] > numList[j + 1]) {
					int temp = numList[j];
					numList[j] = numList[j + 1];
					numList[j + 1] = temp;
				}
			}
			
		}
		System.out.println("정렬 후");
		for(int i = 0; i < numList.length; i++) {
			System.out.print(numList[i] + " ");
		}
	}

}
