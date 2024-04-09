package Switch;

public class SwitchEx {

	public static void main(String[] args) {
		
		// if문과 다르게 비교문을 이용해서 참 거짓으로 실행하는 것이 아니라 숫자, 문자를 이용해서 바로 찾아가는 것
		// 어떤 key를 가지고 value를 찾는다.
		int key = 0;
		switch(key) {
		case 0:
			System.out.println("0이다!");
			System.out.println("0의 범위!");
			break;
		case 1:
			System.out.println("1이다!");
			System.out.println("1의 범위!");
			break;
	
		}// switch끝 밖으로 나간다.
		
		// key로 사용할 수 있는 타입
		// 정수, 문자, 문자열 
		// 대소문자 구별함!
		// switch문 실행하고 break를 주지 않으면 모든 내용이 나옴
		char chKey = 'a';
		
		switch(chKey) {
		case 'A':
		case 'a': // 케이스 두개를 묶을수도 있음
			System.out.println("대문자 A");
			// 한 문자를 강제적으로 정수로 표현
			System.out.println((int)chKey);
			// 'A' + '1'
			System.out.println('A' + '1');
			break;
			
		case 'B':
			System.out.println("대문자 B");
			System.out.println((int)chKey);
			System.out.println('B' + '1');
		}
		System.out.println("switch문 끝!");
		
		
		// 메뉴를 입력하는 switch
		// 문자열도 사용할 수 있다.
		// 문자 + 문자 = 연결됨
		
		// 실수는 key로 사용할 수 없다.
		// 실수는 기본적으로 float일 경우 4byte .6자리 출력, double일 경우 8byte .16자리 출력
		String strKey = "입력";
		
		switch(strKey) {
		case "입력":
			System.out.println(strKey + " 메뉴");
			break;
		case "수정":
			System.out.println(strKey + " 메뉴");
			break;
		case "조회":
			System.out.println(strKey + " 메뉴");
			break;
		case "삭제":
			System.out.println(strKey + " 메뉴");
			break;
		// 위에 어떤 case에도 속하지 않으면
		default:
			System.out.println("메뉴에 없는 key입니다.");
			break;
		}
		
		
		/*
		 * 수학 점수를 90점 이상 A
		 * 		   80점 이상 B 81 82 83 ~ 89
		 *         70점 이상 C 71 72 73 ~ 79
		 *         60점 이상 D 
		 *         60점 미만 F
		 */
		int score = 95;
		
		switch(score) {
		case 90:
			System.out.println("A");
			break;
		}
		
		String str = "abcd";
		// 문자열 길이를 확인하는 기능
		// length() 문자 여러 개 갯수 확인
		System.out.println(str.length());
		
		
		
	}

}
