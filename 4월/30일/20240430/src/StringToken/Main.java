package StringToken;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// StringTokenizer
		// split()

		// 공통점 : 문자열을 구분하는데 사용된다.

		String str = "010-1234-5678";
		// split() 메서드는 인수로 지정된 구분자로 문자열을 분리해서 배열로 리턴
		String[] phone = str.split("-");
		System.out.println(Arrays.toString(phone));

		// split() 메서드는 구분자를 2개 이상 지정할 수 없다
		// 공백과 탭이 섞여있는 데이터에 구분자를 공백만 지정하면 탭(tab)으로 구분된 데이터는 분리할 수 없음
		str = "사과 배 복숭아	밤 대추";
		String[] data = str.split(" ");
		System.out.println(Arrays.toString(data));

		// 밑에 있는 클래스를 사용하기 위해서는 java.util 포함
		// 입출력할 때 한줄 씩 입력을 읽어 들이면 라인 단위로 읽어 들일 수 밖에 없다
		// 사용자가 지정하는 구분자를 경계로 문자열을 분리한다.
		// 구분자를 생략하면 공백과 탭을 기본 구분자로 사용하며 구분자로 분리된 데이터를 토큰이라고 한다
		StringTokenizer st = null;

		// 문자열이 공백이나 탭으로 구분된 경우
		// 띄어쓰기 기준으로 문자열을 분리
		st = new StringTokenizer(str);
		// hasMoreTokens()
		// 클래스 객체에 다음에 읽을 토큰이 있으면 true, 없으면 false
		while (st.hasMoreTokens()) {
			// 다음 데이터가 있다면 반복
			System.out.println(st.nextToken());
		}
		System.out.println("===========================");

		// 문자열이 ","로 구분된 경우
		String str2 = "사과,배,복숭아,밤,대추";
		StringTokenizer st2 = new StringTokenizer(str2, ",");
		while (st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		System.out.println("===========================");

		// 클래스 생성 시 구분자를 2번째 인수로 지정을 하고 구분자를 여러개 지정할 수 있다.
		String str3 = "사과,배,복숭아.밤,대추";
		StringTokenizer st3 = new StringTokenizer(str3, ",.");
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		System.out.println("===========================");

		// StringTokenizer 객체 생성 시 3번째 인수로 구분자를 토큰에 포함시키는 여부를 작성
		// 3번째 인수는 생략 시 false
		// 만약 true를 쓰면 구분자를 토큰에 포함시킴
		String str4 = "사과=1000,배=2000,복숭아=3000,밤=4000,대추=5000";
		StringTokenizer st4 = new StringTokenizer(str4, ",=", true);
//		while(st4.hasMoreTokens()) {
//			System.out.println(st4.nextToken());
//		}
//		System.out.println("===========================");

		// 숫자 형식 지정을 위한 DecimalFormat 객체 생성
		// #은 숫자가 없으면 표시하지 않는다 라는 뜻
		// 0은 숫자가 없으면 0으로 표시됨
		double number = 1234567.89;
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String formatted = df.format(number);
		System.out.println(formatted);
		System.out.println("===========================");

		// 사과(1,000원)
		DecimalFormat df2 = new DecimalFormat("#,##0원");
		while (st4.hasMoreTokens()) {
			String s = st4.nextToken();

			// if문 사용
//			if(s.equals("=")) {
//				System.out.print("(");
//			}else if(s.equals(",")) {
//				System.out.println(")");
//			}else {
//				try {
//					// 콤마랑 "=" 출력을 할 때 괄호로 변경 했는데 사과 배 등 단어랑 숫자만 남았다.
//					// 문자를 숫자로 변경하는데 혹시 반복을 하다가 단어가 오면 예외가 발생할 수 있다
//					System.out.print(df2.format(Integer.parseInt(s)));
//				}catch(Exception e) {
//					System.out.print(s);
//				}
//			}
			
			// switch문 사용
			switch (s) {
			
			case "=":
				System.out.print("(");
				break;
				
			case ",":
				System.out.println(")");
				break;
				
			default:
				try {

					System.out.print(df2.format(Integer.parseInt(s)));
				} catch (Exception e) {
					System.out.print(s);
				}
				break;
			}

		}
		System.out.println(")");

	}

}
