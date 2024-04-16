package Function;

import org.w3c.dom.NameList;

public class FunctionEx5 {
	
	// 정수형 배열을 출력하는 함수
	public static void arrIntprint(int[] list) {
		// list 배열 츨력
		System.out.print("배열 출력 : ");
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		// 배열을 출력하는 함수
		int[] arr = {1,2,3,4,5,6,4};
		int[] arr2 = {10,20,30,54,50};
		int[] arr3 = {100,200,300,540,500};
		
		// arr 배열 출력
		arrIntprint(arr);
		
		// arr2 배열 출력
		arrIntprint(arr2);
		
		// arr3 배열 출력
		arrIntprint(arr3);
		
		int num = 10;
		show(num);
		// 매개변수
		// 함수에서 다른 함수로 데이터를 이동시키는 변수
		// 이동하는 변수는 함수명(값)
		// 타입을 정확하게 써야한다
		// 하나의 변수에는 하나의 타입만 저장 가능하다
		// 정수 정수변수
		// 실수 실수변수
		// 정수 배열 정수배열
		
		String[] nameList = {"익준", "준완", "송화"};
		listPrint(nameList);
		
		System.out.println();
		
		String[] idList = {"qwer", "asdf", "zxcv"};
		listPrint(idList);
			
	}
	public static void listPrint(String[] list) {
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
	}
	
	public static void show(int num) {
		System.out.println(num);
	}

}
