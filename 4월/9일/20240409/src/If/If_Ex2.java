package If;

import java.util.Scanner;

public class If_Ex2 {

	public static void main(String[] args) {
		
		// 문제 2. 아이디, 비밀번호 정해두고 로그인 성공 시 로그인 성공, 아이디 틀렸을 시 아이디가 틀렸습니다, 비밀번호 틀렸을 시 비밀번호가 틀렸습니다 출력
		Scanner sc = new Scanner(System.in);
		String id = "id123", pw = "pw123";
		
		// 자바에서 문자를 입력받는 기능이 2개
		// next() : 한 단어 입력(공백 허용 X)
		// nextLine() : 한 줄만 입력(공백 허용 O);
		// 스캐너로 키보드로 입력하는 데이터를 입력 받는경우 바로 변수에 저장되는 것이 아니라 키보드 버퍼라는 임시 저장소에 저장된 후 읽어 들이는 메소드가 실행 될때 변수에 저장됨
		// nextLine() 메소드는 키보드 버퍼가 비어있으면 입력을 기다리며 대기하지만 비어있지 않다면 키보드 버퍼의 내용을 끝까지 읽어들인다. 
		System.out.print("아이디를 입력하세요 : ");
		String inputId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String inputPw = sc.nextLine();
		
		// 문자를 비교 할때는 == 으로 비교가 불가능
		// 한 문자는 == 으로 비교 가능
		// 데이터.equals(비교할 데이터)으로 비교할 수 있음 같다면 true, 다르다면 false
		if (id.equals(inputId) && pw.equals(inputPw)) {
			System.out.println("로그인 성공");
		}else if(pw.equals(inputPw)) {
			System.out.println("아이디가 다릅니다.");
		}else if(id.equals(inputId)){
			System.out.println("비밀번호 다릅니다.");
		}else {
			System.out.println("아이디와 비밀번호가 모두 다릅니다.");
		}
		
		//나이, 이름을 입력
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		// nextLine()을 제외한 나머지 메소드는 공백을 경계로 데이터를 읽어들인다.
		// nextLine()을 제외한 나머지 메소드는 자신이 읽어들일 데이터만 읽어들인다.
		
		// 위에 숫자(정수, 실수) 입력을 받고 다음에 문자를 입력받는 nextLine() 나오면 입력을 받을 수 있도록 버퍼를 비워야된다.
		sc.nextLine();// 키보드 버퍼 비우기
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.println(age + " " + name);
		
		// 키보드로 1문자 입력받기
		// 컴퓨터는 순서를 정할 때 0부터 시작한다.
		// 한 문자를 기준으로 한 칸의 공간이 생긴다.
		// CharAt(공간의 번호)
		System.out.println("영문자 하나 입력 : ");
		char ch = "ABC".charAt(2);
		System.out.println(ch);
		

	}

}
