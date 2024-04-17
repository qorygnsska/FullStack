package Sort;

import java.util.Arrays;
import java.util.Scanner;
// 이름 입력 받으면 오름차순으로 출력
public class SelectionSortTest {
	public static void SortName() {
		Scanner sc = new Scanner(System.in);
		// nameList
		// 배열을 생성해서 키보드로 이름을 5개 입력 받아서 저장
		String[] nameList = new String[5];
		System.out.println("이름 입력 : ");
		for(int i = 0; i < nameList.length; i++) {
			nameList[i] = sc.nextLine();
		}
		
		// 선택정렬 이용해서 nameList 정렬!
		for(int i = 0; i < nameList.length; i++) {
			for(int j = i + 1; j < nameList.length; j++) {
				if(nameList[i].compareTo(nameList[j]) > 0) {
					String temp = nameList[i];
					nameList[i] = nameList[j];
					nameList[j] = temp;
				}
			}
		}System.out.println(Arrays.toString(nameList));
		
	}
		
	public static void main(String[] args) {
		SortName();
	}
}
