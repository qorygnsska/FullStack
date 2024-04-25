package Map;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		// Map 인터페이스
		// - 키 와 값으로 데이터를 활용한다
		// - 배열이나 list계열 숫자로 방 번호가 자동으로 부여됨
		// - 공간의 이름 내 맘대로 문자로 사용하고 싶을 때 Map을 쓴다
		// - 배열의 공간의 번호가 -> key, 배열의 값 -> value
		// - 순서가 없다는 것은 인덱스가 없다. 즉, 순서대로 데이터에 접근을 할 수 없다!
		
		// Map 종류 2가지
		// 1. HashMap (정렬 x)
		// 2. TreeMap (정렬 o)
		
		// key는 중복되면 안된다.
		// value는 중복돼서 저장할 수 있다.
		
		// key를 중복적으로 작성할 수 있다.
		// map에 key가 존재한다면 데이터를 수정
		
		// map의 공간을 먼저 생성
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		// 순서가 없다
		// 추가, 수정
		// 기존에 key가 있다면 put을 이용해서 다시 수정하는 데이터를 주면 됨
		// 기존에 key가 없다면 put을 이용해서 새로운 데이터를 추가하면 된다.
		map.put("Java", 100);
		map.put("Python", 100);
		map.put("Spring", 95);
		map.put("Java", 80);
		
		// 출력
		System.out.println(map);
		
		// 조회
		// get(key)
		// 데이터가 있으면 value
		// 없으면 null
		System.out.println(map.get("Java"));
		System.out.println(map.get("python"));
		
		// 삭제
		// remove(key)
		map.remove("Python");
		System.out.println(map);
		
		// 전체 조회(검색)
		// for문을 사용할 때 여러개를 저장하는 타입
		// 그 타입에서 key를 기준으로 하나씩 꺼내온다
		for(String key : map.keySet()) {
			System.out.println("key : " + key);
			System.out.println("value : " + map.get(key));
		}
		
		System.out.println("map size : " + map.size());
		
		// 검색
		// key 값이 존재하는 지 여부
		// containsKey(key)
		// 존재하면 true 없으면 false
		String searchKey = "Java";
		if(map.containsKey(searchKey)) {
			System.out.println("존재함");
		}else {
			System.out.println("존재안함");
		}
		
		// value 값이 존재하는 지 여부
		// containsValue(value)
		// 존재하면 true 없으면 false
		Integer searchValue = 80;
		if (map.containsValue(searchValue)) {
			System.out.println("존재함");
		} else {
			System.out.println("존재안함");
		}
	}

}
