
public class PrintlnTest {

	public static void main(String[] args) {
		// 1. Hello World! 출력
		System.out.println("Hello World!");
		
		// 2. Println() 이용 하여 이름, 나이, 사는 곳 출력
		System.out.println("이름 : 배교훈");
		System.out.println("나이 : 24");
		System.out.println("사는 곳 : 경기도 시흥시");
		
		// 3. 보너스
		int i = 1; // 메모리 공간에 정수 1을 저장, 문자로 출력하기
		System.out.println(i);
		
		// 4. 개 출력
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		
		// 문자 여러개를 표현할 때 String
		// 이스케이프 시퀀스 문자 (제어문자)
		// 문자열 특정한 행동을 하는 시작 기호(\영문자) \t : tab만큼 띄우기, \n : 줄바꿈
		// \를 단순히 문자로 출력하고 싶으면 \\, 따옴표도 똑같음 \", \'
		System.out.println("java \t python \n aws html");
	}

}
