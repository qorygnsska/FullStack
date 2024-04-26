package Map_Farm;

import java.util.HashMap;

// 판매자들의 정보 저장
public class AdminController {
	private HashMap<Farm, Integer> hMap = new HashMap<Farm, Integer>();
	// 농작물을 추가 함수
	// 다형성을 이용해서 어떤 객체가 와도 농작물과 관련된 데이터 저장
	
	// 실제 new를 이용해서 객체를 생성하면 new를 쓸때마다새로운 메모리의 주소가 생긴다
	
	// 실질적으로 주소값이 가리키는 객체안에 인스턴스 변수의 값이 중복 될 수 있다.
	
		boolean addNewKind(Farm f, int amount) {
			if(hMap.containsKey(f)) {
				return false;
			}else {
				hMap.put(f, amount);
				System.out.println(hMap);
				return true;
			}
		}
}
