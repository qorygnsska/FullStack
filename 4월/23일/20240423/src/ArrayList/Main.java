package ArrayList;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// 우리가 배열을 이용해서 유동적인 배열을 만든 것이 이미 만들어져 있는 것이었다.
		// ArrayList<저장할 타입> 변수명
		ArrayList<String> list = new ArrayList<String>();
		
		// 추가
		list.add("김준완");
		list.add("이익준");
		list.add("양석형");
		list.add("채송화");
		
		// 출력
		System.out.println(list);
		
		// 김준완과 이익준 사이에 안정원을 저장
		// 중간에 끼워넣기
		list.add(1, "안정원");
		System.out.println(list);
		
		// 삭제 remove() -> 인덱스 번호, 값으로 삭제 가능
		list.remove("김준완");
		System.out.println(list);
		
		// 검색
		// list안에 양석형이 포함되어 있니? true / false
		System.out.println(list.contains("양석형"));
		// list안에 양석형이 몇번째 인덱스에 있니? 인덱스번호 / -1
		System.out.println(list.indexOf("양석형"));
		
		
		
		
		
		// 자료구조
		// - 데이터를 추가하고 삭제하고 수정하고 조회할 때 효율적으로 할 수 있도록 미리 만들어놓은 구조
		
		// 컬렉션프레임워크
		// - 자료구조를 이용해서 자바가 미리 만들어 놓은 구조
		
		// list
		// - 순서가 있는 자료형
		//   인덱스(공간번호)를 이용해서 접근 할 수 있다.
		
		// set
		// - 순서가 없는 자료형
		// - 중복을 제거

	}

}
