package naver;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main2 {
	public static void main(String[] args) {

		// JSON
		// - JavaScript Object Notation

		// - 데이터를 교환하고 저장하기 위하여
		// 만들어진 텍스트 기반의 데이터 교환 표준

		// JSON 데이터를 구별해서 저장하려면
		// 외부 라이브러리가 필요하다.

		// JSON 객체
		// {} 둘러 쌓아 표현한다.
		// 여러개의 데이터를 줄 때는 ,콤마로 구별

		String json = "{" + "  \"name\" : \"댕댕이\"," + "  \"age\" : 1," + "  \"weight\" : 2.14" + "}";

		// json타입의 문자열을 구분할 수있는 객체를
		// 먼저 생성
		JSONParser parser = new JSONParser();

		try {
			// 문자열을 Json타입의 객체로 변경하기
			// key와 value 형태로 변경하기
			// ParseException 예외가 발생할 수있다.
			// 그래서 예외처리 해준다.
			JSONObject jsonObj = (JSONObject) parser.parse(json);

			// json객체의 필드를 읽기
			String name = (String) jsonObj.get("name");
			// 문자열을 숫자로 래퍼(클래스)하는 방법
			//
			int age = Integer.parseInt(jsonObj.get("age").toString());
			double weight = (double) jsonObj.get("weight");

			System.out.println("이름:" + name);
			System.out.println("나이:" + age);
			System.out.println("몸무게:" + weight);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
