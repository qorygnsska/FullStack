package Map;

// 클래스 기능을 포함해야된다.
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// key와 value를 이용하는 HashMap
		// 1. 공간 생성
		HashMap<String, Member> list = new HashMap<String, Member>();
		
		Scanner sc = new Scanner(System.in);
		// 2. 회원가입
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		
		// 추가적인 스캐너 활용방법
//		String[] info = sc.nextLine().split(" ");
//		
//		System.out.println(info[0]);
//		System.out.println(info[1]);
		
		
		// 3. Map 저장 Value로 저장하기
		Member mem = new Member(name, password);
		
		// 4. key를 이용해서 추가
		list.put(name, mem);
		
		// 5. vip변수를 만들어 hashMap에 저장
		Vip vip = new Vip();
		System.out.print("vip이름과 비밀번호 입력 : ");
		String[] info = sc.nextLine().split(" ");
		vip.name = info[0];
		vip.password = info[1];
		// 6. 저장
		list.put(info[0], vip);
		
		// 7. 출력
		// 업그레이드 된 for문을 이용해서 먼저 key 값들만 뽑아서 반복
		for(String key : list.keySet()) {
			System.out.println(key);
			list.get(key).print();
			System.out.println();
		}
		
		
	}

}
