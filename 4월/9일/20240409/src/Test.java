import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 문제 1. 정수를 이용하여 4자리 비밀번호 생성, 각 자리에 중복되는 값이 없을 경우 생성 성공
		//       중복 값이 있으면 중복 값 있음, 자리수가 안 맞으면 자리 수 안 맞음 출력
		//       단 제일 앞자리 수의 값을 1~9 사이 정수다
		
		System.out.print("비밀번호 입력(1000~9999) : ");
		String pw2 = sc.nextLine();
		System.out.println();
		
		if(pw2.length() > 4) {
			System.out.println("자릿수 안 맞음");
		}else if(pw2.charAt(0) == '0'){
			System.out.println("첫자리는 0이상으로 입력하세요");
		}else if(  pw2.charAt(0) != pw2.charAt(1) 
				&& pw2.charAt(0) != pw2.charAt(2)
				&& pw2.charAt(0) != pw2.charAt(3)
				&& pw2.charAt(1) != pw2.charAt(2)
				&& pw2.charAt(1) != pw2.charAt(3)
				&& pw2.charAt(2) != pw2.charAt(3)) {
	
			System.out.println("생성 성공");
		}else{
			System.out.println("생성 실패(중복 값 있음)");
		}
		
//======================= 야매 ====================================
		
		// 문제 2. 회원가입 시 id 길이가 10을 넘으면 회원가입 실패, pw길이가 10을 넘으면 실패 메시지 출력
		System.out.print("id입력 : ");
		String id = sc.nextLine();
	
		if(id.length() < 10) {
			System.out.print("pw입력 : ");
			String pw = sc.nextLine();
			if(pw.length() < 10) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패 : password 길이가 10을 초과");
			}
		}else {
			System.out.println("회원가입 실패 : id 길이가 10을 초과");
		}
		
		
		
		
		
		
		
		

	}

}
