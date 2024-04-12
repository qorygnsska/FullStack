package ArrayEx;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {
		
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		
		Scanner sc = new Scanner(System.in);
		// 문제) 학번을 입력받아 성적 출력
		// 		단, 없는학번 입력 시 예외처리
		// 예)
		// 학번 입력 : 1002		성적 : 11점
		// 학번 입력 : 1000		해당학번은 존재하지 않습니다.
		
		System.out.print("학번 입력 : ");
		int find = sc.nextInt();
		
		if(find < 1001 || find > 1005) {
			System.out.println("해당학번은 존재하지 않습니다.");
		}
		
		for(int i = 0; i < hakbuns.length; i++) {
			if(find == hakbuns[i]) {
				System.out.println("성적 : " + scores[i] + "점");
			}
		}
		
		// not 연산자 
		// ~ 이 아니다!
		// 결과를 뒤집어주는 연산자  !
		// true -> false
		// false -> true
		System.out.println(!true);
		System.out.println(!false);
		
		// Arrays 클래스
		// - 배열들을 다루기 위한 기능(메서드)이 포함되어 있다.
		
		// Arrays.binarySearch(배열명, 찾는 값)
		// 만야 데이터가 있으면 공간번호(index) 반환
		// 없으면 음수를 반환
		// 이진탐색 기법 사용 : 배열의 숫자가 정렬이 되어 있어야 찾을 수 있음 
		// ex){1, 2, 3, 4} 이런 식으로 정렬이 되어 있어야 함
		// Arrays.sort() : 오름차순 정렬
		
		// 암묵적인 규칙으로 index를 반환할 떄 -1이 나오면 인덱스번호를 찾지 못했다는 뜻!!
		int index = Arrays.binarySearch(hakbuns, find);
		System.out.println("결과 : " + index);
		
		if(index >= 0) {
			System.out.println(scores[index]);
		}else {
			System.out.println("찾는 학번이 없습니다.");
		}

	}

}
