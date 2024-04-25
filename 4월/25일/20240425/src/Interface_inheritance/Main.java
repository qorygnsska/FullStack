package Interface_inheritance;

class A {
	// 변수
	// 함수
	// 실행을 하는 문장들은 함수 중괄호 안에 작성

}

public class Main {
	public static void main(String[] args) {
		
		SamsungPrinter s1 = new SamsungPrinter();
		s1.printBlack("교훈의 ppt파일");
		
		LgPrinter l1 = new LgPrinter();
		l1.printBlack("교훈의 엑셀파일");
		
		/*
		 * 인터페이스 상속
		 *  클래스들끼리 상속을 통해 확장 하듯이,
		 *  인터페이스들끼리 자체적으로 확장을 시키고 싶다면
		 *  extends를 이용해서 상속한다.
		 *  
		 *  클래스는 다중상속 x
		 *  인터페이스는 다중상속 O
		 *  
		 *  상수(필드) static이기 때문에 구현체를 따라가지 않는다.
		 *  독립적인 상수
		 *  
		 *  인터페이스에 클래스를 상속하는건 안된다.
		 *  클래스에 인터페이스를 상속 extends
		 * 
		 */
		
		ColorPinter[] list = {new ColorPrintSamsung(),
							  new ColorPrintLg(),
							  new HpPrinter()};
		// 어떤 타입이 와도 다 저장할 수 있도록 Object 사용
		// 업 캐스팅
		// 문제가 발생했다. Object가 물려준 메서드밖에 사용이 안된다. -> ColorPrinter로 선언
		for(ColorPinter temp : list) {
			temp.printBlack("교훈 ppt");
			temp.printColor("교훈 엑셀");
			
			if(temp instanceof ColorPinter) {
				System.out.println("가능");
			}else {
				System.out.println("불가능");
			}
		}
		
	}
}
