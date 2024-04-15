package String;

public class StringEx {

	public static void main(String[] args) {
		
		// 문자열을 다루는 기능
		// equals(값) 비교하는 문자가 같으면 true 다르면 false
		// 대소문자 구별함
		
		// equalsIgnoreCase(값)
		// 위의 equal과 똑같지만 대소문자 구분 안함
		
		String str = "이서희";
		System.out.println(str.equalsIgnoreCase("비교할 값"));
		
		// 문자열 길이를 확인
		// length()
		System.out.println("길이 : " + str.length());
		
		// 문자열을 저장하면 배열처럼 한칸에 하나씩 문자가 들어간다
		// 문자는 한번 저장하면 변경이 불가능하다
		String str2 = "java spring html jsp";
		
		// substring()
		// 문자열 중에서 특정 부분을 뽑아낼 경우에 사용한다
		// 괄호 안에 작성한 숫자를 기준으로 끝까지 자른다
		// substring은 문자에서만 사용 가능하다! 정수는 사용 불가
		
		// 특정 부분을 자르거나 뽑아올 때
		// substring(시작 번호, 끝 번호)
		// 시작 번호는 값을 포함하지만 끝 번호는 값을 포함하지 않는다, 그래서 그 다음 번호로 끝번호를 입력해야함
		System.out.println(str2.substring(5));
		System.out.println(str2.substring(5, 16));
		
		String str3 = "202404151237";
		System.out.println(str3.substring(0, 4) + "년 " + str3.substring(4, 6) + "월 " +str3.substring(6, 8)+ "일 " +str3.substring(8, 10)+ "시 " + str3.substring(10, 12)+ "분 입니다.");

		
		String year = str3.substring(0, 4);
        String month = str3.substring(4, 6);
        String day = str3.substring(6, 8);
        String hour = str3.substring(8, 10);
        String minute = str3.substring(10);

        System.out.println("연도: " + year);
        System.out.println("월: " + month);
        System.out.println("일: " + day);
        System.out.println("시: " + hour);
        System.out.println("분: " + minute);
		
	}

}
