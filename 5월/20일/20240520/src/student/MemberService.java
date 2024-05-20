package student;

// 멤버에 관한 준비를 하는 서비스 클래스
public class MemberService {
	MemberDAO memberDAO = new MemberDAO();
	
	public boolean login(String hak, String pass) {
		System.out.println("service에서 로그인 체크중!!");
		boolean result = memberDAO.login(hak, pass);
		return result;
		
	}

}
