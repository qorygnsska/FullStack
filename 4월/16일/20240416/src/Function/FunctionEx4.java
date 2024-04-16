package Function;

public class FunctionEx4 {
	public static void binarySearch() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12 , 13, 14, 15, 16};
		int find = 1;
		
		// 기준 인덱스 찾기
		int left = 0;
		int right = arr.length - 1;
		while(true) {
			int mid = (left + right) / 2;
			System.out.println("왼쪽 : " + left);
			System.out.println("오른쪽 : " + right);
			System.out.println("기준점 : " + mid);

			if (arr[mid] == find) {
				System.out.println("찾았다!");
				System.out.println("인덱스 : " + mid);
				break;
			} else if (arr[mid] > find) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
	}
	public static void main(String[] args) {
		// 순차탐색
		// - 순서대로 배열의 0번부터 순서대로 각 방에 접근해서 비교한다
		// - 정렬이 되어있다고 해도 무조건 0부터 검색
		// - 단점 : 검색할 때 시간이 오래 걸린다(데이터가 많으면)
		
		// 이진탐색
		// 1. 기준 인덱스(공간번호) 찾는다.
		// 2. 정렬이 되어있어야 된다 (기본적으로 오름차순)
		// 3. 비교 : 기준 값과 비교해서 기준 값보다 작으면 왼쪽(앞쪽), 크면 오른쪽(뒷쪽)
		// - 장점 : 순차 탐색 보다는 빠르게 데이터 검색
		// - 단점 : 정렬이 안 되어있으면 이분탐색을 할 수 없음
		binarySearch();
	}

}
