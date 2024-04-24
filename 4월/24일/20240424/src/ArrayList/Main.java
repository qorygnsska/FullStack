package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		/*
		 * ArrayList 특징
		 *  연속적인 데이터의 리스트
		 *  (데이터는 연속적으로 리스트에 들어있어야하며 중간에 빈 공간이 있으면 안된다)
		 *  
		 *  Object 클래스 배열
		 *  배열을 이용하기 때문에 인덱스(공간번호)를 이용해 요소해 빠르게 접근할 수 있다.
		 *  
		 *  배열은 크기가 고정이지만 ArrayList는 가변적으로 공간을 늘리거나 줄인다
		 *  
		 *  배열은 공간이 꽉 찰 때마다 배열은 복사하는 방식으로 늘림(지연)
		 *  
		 *  ArrayList는
		 *  중간에 빈 공간이 생기면 안되므로 요소를 뒤로 밀거나 앞으로 가지고 오는 동작에서 지연
		 */
		Number[] r = new Number[5];
		r[0] = 10;
		r[1] = 20;
		r[2] = 30;
		r[3] = 40;
		r[4] = 50;
		r[3] = null;
		System.out.println(Arrays.toString(r));
		// 위에는 배열이기 때문에 빈 공간이 생긴다.
		// 연속적인 리스트 할 수가 없다.
		
		
		// <> 제네릭
		// 기본 자료형을 제네릭 타입으로 사용하지 않는다.
		// 무조건 class객체들만 사용이 가능하다
		// 기본 자료형을 객체화 시킨 클래스 : 래퍼 클래스(Wrapper class)
		// int : Integer
		// 
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println(list);
		
		// 삭제는 remover(인덱스)
		list.remove(3);
		System.out.println(list);
		
		// 초기 공간 10 설정
		ArrayList<Integer> numlist1 = new ArrayList<Integer>(10);
		
		// 기존에 만들었던 리스트를 복사하는 개념
		ArrayList<Integer> numlist2 = new ArrayList<Integer>(numlist1);
		
		ArrayList<String> strlist1 = new ArrayList<String>(10);
		strlist1.add("a");
		strlist1.add("b");
		strlist1.add("c");
		strlist1.add("d");
		strlist1.add("e");
		
		// 리스트 사이즈 size()
		System.out.println(strlist1.size());
		
		// 리스트 자체로 저장
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		
		
		ArrayList<String> list2 = new ArrayList<String>();
		list1.add("3");
		list1.add("4");
		list1.add("5");
		list1.add("6");
		list1.add("7");
		list1.add("8");
		// 전체 리스트를 어떤 리스트변수에 추가할 지
		// list1 변수에 list2 내용을 추가한다
		// add()    맨 뒤에 추가한다
		// addAll() 맨 뒤에 추가한다
		list2.addAll(list1);
		System.out.println(list2);
		
		// IndexOutOfBoundsException
		// 1. 리스트에 선언된 공간을 내가 호출한 인덱스 공간이 넘었기 떄문에(공간초과)
		// list1.add(100, "100");
		
		// 전체 리스트 비우기
		// list1.clear();
		
		
		// 검색
		// contains(값)
		// 포함되어 있으면 true
		// 포함되어 있지 않으면 false
		System.out.println(list1.contains("aa"));
		
		// 데이터 얻기
		// get(인덱스)
		System.out.println(list1.get(0));
		
		// 범위를 지정해 여러개 가져오기
		// subList(시작 인덱스, 끝 인덱스)
		// 시작번호는 데이터를 포함
		// 끝번호는 데이터를 포함하지 않는다
		System.out.println(list1.subList(1, 5));
		System.out.println(list1.subList(2, 6));
		
		// 수정
		// set(인덱스, 값)
		list1.set(0, "one");
		System.out.println(list1);
		
		// ArrayList를 고정된 배열로 변경
		Object[] arr1 = list1.toArray();
		System.out.println(arr1);
	}

}
