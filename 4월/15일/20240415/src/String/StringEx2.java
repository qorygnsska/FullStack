package String;

import java.util.Arrays;

public class StringEx2 {

	public static void main(String[] args) {

		String str = "java spring html jsp";
		
		// 기본적으로 문자를 대문자, 소문자로 모두 변경하는 기능
		// 이미 소문자나 대문자로 변경이 완료 되었다면 변경되지 않고 그대로 있는다!
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		
		// 검색
		// indexOf()
		// 문자열에서 특정 문자가 시작되는 인덱스를 반환
		// 검색을 0번부터 찾는다. 결과 중 가장 첫번째 값을 반환
		// 검색 결과가 없을 시 -1 반환함
		System.out.println(str.indexOf('p'));
		// 인덱스 번호 이후로 찾는다.
		System.out.println(str.indexOf('p', 7));
		
		// 문자가 포함되어 있니?
		// 조회했을 때 true, false
		// contains()
		System.out.println(str.contains("jsp"));
		System.out.println(str.contains("boots"));
		
		// 특정 문자를 이용해서 문자열을 구분, 배열로 반환
		System.out.println(str);
		String[] result = str.split(" "); // 공백을 기준으로 자른다
		// 배열의 값을 문자형태로 반환한다 : Arrays.toString()
		System.out.println(Arrays.toString(result));
		
		str = "java!spring!html!jsp spring";
		result = str.split("!"); // !를 기준으로 자른다
		System.out.println(Arrays.toString(result));
		
		// replace(이전문자열, 변경문자열)
		// 특정 문자를 원하는 문자로 변경하고 싶을때 사용
		// 위에 !를 공백으로 변경해보자
		// 변경된 내용을 다시 저장해야함
		str = str.replace("!", " ");
		System.out.println(str);
		
		str = str.replace("spring", "boot");
		System.out.println(str);
		
		
		// 문자열을 비교할 때 사전 순서에 따라서 비교할 수 있다(아스키코드 기준)
		// 첫번째 문자열이 두번째 문자열보다 앞에 위치하면 음수, 같으면 0, 뒤에 위치하면 양수
		
		//  각각 문자열을 비교해서 위치값을 반환, 문자열의 차 만큼 반환
		str = "abc";
		int res = str.compareTo("c");
		System.out.println(res);
		
		// if문은 결과가 무조건 true, false
		if(str.compareTo("abc") == 0) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		

	}

}
