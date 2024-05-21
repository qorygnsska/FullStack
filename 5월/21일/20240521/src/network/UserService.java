package network;

import java.util.Scanner;

// 데이터베이스로 가기 전에 user들의 정보를 전처리하는 클래스
public class UserService {
	Scanner sc = new Scanner(System.in);
	UserDAO udao = new UserDAO();
	
	// 회원가입
	public void signup() {
		System.out.println("userservice의 signup 메서드");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		if(udao.check(id)) {
			System.out.println("중복된 아이디 입니다!!!!");
			signup();
			return;
		}
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("핸드폰 번호 : ");
		String phone = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("생년월일 : ");
		String birthdate = sc.nextLine();
		
		User user = new User(name, id, password, phone, email, birthdate);
		if(udao.signup(user)) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패 ㅠㅠ");
		}
		
	}

	// 로그인
	public User login() {
		System.out.println("userservice의 login 메서드");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		User user = udao.login(id, password); 
		if(user != null) {
			System.out.println("로그인 완료");
		}else {
			System.out.println("아이디 또는 비밀번호가 다릅니다.");
		}
		return user;
		
	}

}
