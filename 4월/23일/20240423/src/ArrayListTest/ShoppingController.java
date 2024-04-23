package ArrayListTest;

import java.util.ArrayList;

// 멤버들을 관리하는 저장하는 객체를 생성
// 물건을 추가하거나 삭제하거나 변경 
// 멤버들의 정보를 추가하거나 삭제하는 실제 저장소!
public class ShoppingController {

	/*
	 * Member[] list = new Member[]; 위에랑 밑에 있는 코드가 비슷함
	 */

	private ArrayList<Member> list = new ArrayList<Member>();

		
	public ArrayList<Member> getList(){
		return list;
	}
	
	
	
	// add(값)
	// - 가장 마지막에 데이터를 추가한다.
	// - 정상적으로 추가가 되면 true를 반환하고
	// 비정상적으로 추가가 안되면 false반환한다.

	// 멤버 추가
	public boolean setAdd(String e, String p, String n, String ph) {
		return list.add(new Member(e, p, n, ph));
	}

	public boolean setAdd(Member member) {
		return list.add(member);
	}

	// 중복확인 하는 메서드
	public boolean checkEmail(String e) {

		// 중복 체크를 하기 위해서 호출
		// ArrayList가 비어있을 수도 있다.
		// size() : 데이터의 개수를 반환

		int size = list.size();
		if (size == 0) {
			return false;

		}
		// 1개 이상의 데이터가 있다

		for (int i = 0; i < size; i++) {
			if (list.get(i).getEmail().equals(e)) {
				// 중복 됬다.
				return true;
			}
		}

		return false;

	}

	public String login(String email,
						String pw) {
		for(int i = 0; i < list.size();
				i++) {
			String dbEmail = list.get(i).getEmail();
			String dbPw = list.get(i).getPass();
						
			if(dbEmail.equals(email) &&
			   dbPw.equals(pw)) {
				// true라는 결과가 오면 로그인 가능하다.
				return dbEmail;
			};			
		}
		return null;// 객체를 찾지 못했다.	
	}
}