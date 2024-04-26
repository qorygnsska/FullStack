package WrapperClass;

public class Main {

	public static void main(String[] args) {

		// 자바의 자료형
		// 기본자료형 (primitive type)
		// 참조자료형 (reference type)

		// 기본 타입의 데이터를 객체로 표현해야 되는
		// 경우가 종종 있다.

		// 기본타입을 객체로 다루기 위해서 사용하는
		// 클래스 (래퍼클래스)

		// java.lang패키지에 포함되어 제공
		// 별다른 패키지를 불러오지 않아도 곧바로
		// 소스 단에서 사용 가능

		int a = 5;

		// Integer 클래스
		// boxing
		// Integer num1 = new Integer(a);

		// auto boxing
		// 컴파일이 알아서 기본자료형을 자동으로
		// 객체화 시킨다 . new 키워드를 쓰지 않아도
		// 자동으로 만들어 진다.

		// 래퍼클래스들은 산술 연산을 못한다.

		Integer num2 = a + 10;
		

		System.out.println(num2);
		System.out.println(a);

		Integer num4 = 10 + 20;

		// 언박싱
		// 래퍼클래스에서 기본자료형으로 변경
		// 값을 꺼내온다.
		int n = num4.intValue();
		// 계산
		n = n + 100;

		// 다시 포장 (객체화 boxing)
		num4 = n;

		// 저장 후 추가적으로 100 더하고 싶다.
		num4 += 100;

		// 실수를 객체화
		Double num3 = 1.11;

		// 타입Value() 생략이 가능해졌다.
//				double n2 = num3.doubleValue();
//				
//				n2 += 110.12345;
//				
//				// 재포장!
//				num3  = n2;

		// 자동계산이 된다.
		num3 += 110.12345;

		// 에러를 유발한다.
//				Integer aa = null;
//				int b = 100;
//				System.out.println(aa + b);

		// 눈에 보이는 연산이 된 것 처럼 보이지만
		// 안에서는 오토언박싱을 해서 데이터를 꺼내서
		// 비교를 한 것이다.
		Integer aa = 200;
		int b = 200;
		System.out.println(aa == b);

		// 객체랑 객체끼리 비교하면 값을 비교하는 것이 아니라
		// 각각의 주소를 비교하는 것
		// 결코 같은 값이다 true가 나오지 않는다.

		Integer bb = 200;
		Integer cc = 200;
		System.out.println(bb == cc);
		// System.out.println(bb.intValue() == cc.intValue());
		// 값이 같은지 비교하는 것은 메소드 사용
		System.out.println(bb.equals(cc));
		// 비교 연산자 빼고는 다 그대로 사용 가능
		System.out.println(bb < cc);
		System.out.println(bb + cc);

		/*
		 * 자료형 변환 메소드 객체를 포장하는 기능 외에도 래퍼클래스에서 자체적으로 지원하는 parse() 데이터 통신이나 데이터베이스 전송
		 * html로 입력받거나 문자로 들어온다.
		 */

		String str = "10";
		int i = Integer.parseInt(str);

		// 문자 -> double 타입으로 변경
		String str1 = "10.5";
		double d = Double.parseDouble(str1);

		// 문자 -> int 타입으로 변경
		// 코드에 빨간 줄은 없지만 실행했을 때
		// 에러가 발생할 수 있다.
		// 그걸 처리하기 위해서 사용하는 것이 바로 예외처리!
//				int i2 = Integer.parseInt(str1);
//				System.out.println(i2);
		
		String str3 = "true";
		boolean bool = Boolean.parseBoolean(str);

	}
}