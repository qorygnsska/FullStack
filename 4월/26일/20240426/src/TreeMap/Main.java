package TreeMap;

import java.util.Map;
import java.util.TreeMap;

import Map.Member;

class Vip extends Member {
	int couponCount;
	boolean privateParking;

	public Vip() {
		couponCount = 5;
		privateParking = true;
	}

	@Override
	public void print() {
		System.out.println();
		System.out.println("이름:" + name);
		System.out.println("비번:" + password);
		System.out.println("쿠폰: " + couponCount);
		System.out.println("전용주차:" + privateParking);

	}
}

public class Main {

	public static void main(String[] args) {

		// TreeMap
		// - 알고리즘의 트리구조를 가지고 key와
		// value을 이용해서 데이터를 저장한다.

		// - key값을 기준으로 정렬되는 특징을
		// 가지고 있다.

		// - 정렬된 순서로 키/값을 쌍으로 저장
		// 하므로 빠른 검색

		// - 키와 값을 저장하는 동시에 정렬을 행하기
		// 때문에 저장 시간이 다소 오래 걸린다.

		// - 정렬되는 순서는
		// 숫자 -> 알파벳 대문자 -> 알파벳 소문자
		// -> 한글 순서

		Map<Integer, String> treeMap = new TreeMap<Integer, String>();

		treeMap.put(2, "Ruth");
		treeMap.put(6, "Gail");
		treeMap.put(3, "jennifer");
		treeMap.put(1, "Toby");
		treeMap.put(5, "Dan");
		treeMap.put(4, "Mark");

		System.out.println(treeMap);

		for (Integer key : treeMap.keySet()) {
			System.out.println(key + " --> " + treeMap.get(key));
		}

		TreeMap<String, Member> list = new TreeMap<String, Member>();

		// 임의의 멤버 5명 추가
		list.put("홍길동", new Member("홍길동", "1234"));
		list.put("이순신", new Member("이순신", "abcd"));
		list.put("김철수", new Vip());
		list.get("김철수").name = "김철수";
		list.get("김철수").password = "qwer";

		list.put("박영희", new Member("박영희", "abcd1234"));
		list.put("정대만", new Vip());
		list.get("정대만").name = "정대만";
		list.get("정대만").password = "1234qwer";
		
		System.out.println(list);
		
		/*
		 * set 구조는 순서가 없는 자료형
		 * - 중복을 제거하는 컬렉션
		 * 
		 * HashSet, TreeSet 구조
		 * 
		 * TreeSet 구조는 단점이 하나 있다.
		 * 객체들은 정렬을 해주지 않는다.
		 */
		
		

	}
}