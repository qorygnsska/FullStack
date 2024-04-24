package Sort;

import java.util.ArrayList;

public class SortMain {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("이익준");
		names.add("김준완");
		names.add("채송화");
		names.add("양석형");
		names.add("안정원");

		
		System.out.println("정렬 전:");
		System.out.println(names);
		
		// 오름차순으로 정렬
		bubbleSortAsc(names);
		System.out.println("오름차순 정렬 후:");
		System.out.println(names);
		
		// 내림차순으로 정렬

	}

	public static void bubbleSortAsc(ArrayList<String> names) {

		// 몇번 반복을 할 지 결정
		int n = names.size();

		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < n - 1; j++) {

				if (names.get(j)
					.compareTo(names.get(j + 1)) > 0) {
					String temp = names.get(j);
					names.set(j, names.get(j + 1));
					names.set(j + 1, temp);
				}
			}
		}
	}

}