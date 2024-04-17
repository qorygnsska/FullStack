package Sort;

import java.util.Arrays;

public class SelectionSort {
	// 선택정렬
	// - 한 번 배열 탐색에서 가장 작은 값을 찾아서 위치를 찾고
	//   그 위치랑 배열의 첫번째 값이랑 교체
	// - 기본적으로 오름차순
	
	// 내림차순으로 선택정렬
	// - 가장 큰 값의 위치를 찾는다
	
	
	// 선택정렬 오름차순
	public static void Up(int[] arr){
		for(int i = 0; i < arr.length; i++) {
			// 선택 위치의 데이터와 비교할 대상이 되는 데이터 위치
			// 오름차순 정렬
			for(int j = i + 1; j < arr.length; j++) {
				// 최소값 찾기
				// 오름차순 정렬
				// 앞(i번째의) 데이터가 뒤(j번째)의 데이터보다 크면 값 교환
				
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	// 선택정렬 내림차순
	public static void Down(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			// 선택 위치의 데이터와 비교할 대상이 되는 데이터 위치
			// 내림차순 정렬
			for(int j = i + 1; j < arr.length; j++) {
				// 최대값 찾기
				// 내림차순 정렬
				// 앞(i번째의) 데이터가 뒤(j번째)의 데이터보다 작으면 값 교환
				
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		
		int[] arr = {1, 8, 3, 4, 9, 1};
		
		Up(arr);
		Down(arr);
		
		/*
		 * 컬렉션프레임워크
		 * 
		 */

	}

}
