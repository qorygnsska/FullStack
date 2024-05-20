package naver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main3 {

	public static void main(String[] args) {
		String jsonString = "{" +

				"  \"dog\":[" + "  	{\"name\" : \"댕댕이\", \"age\" : 1,\"weight\" : 2.14},"
				+ "  	{\"name\" : \"식빵이\", \"age\" : 2,\"weight\" : 2.14},"
				+ "  	{\"name\" : \"뽀삐\", \"age\" : 3,\"weight\" : 2.14}" +

				"  ]" + "}";
		// 문자를 구별할 수 있는 jsonparser 생성
		JSONParser parser = new JSONParser();

		// 문자 -> 객체로 변경
		try {
			JSONObject obj = (JSONObject) parser.parse(jsonString);

			// 기본적으로 dog 키를 이용해서 꺼내면
			// 배열형태로 여라개가 저장 되어있다.
			JSONArray dogArray = (JSONArray) obj.get("dog");

			// 배열 내 각 객체를 반복하면서 출력
			for (Object temp : dogArray) {
				JSONObject t = (JSONObject) temp;

				System.out.println("이름 : " + t.get("name"));
				System.out.println("나이 : " + t.get("age"));
				System.out.println("몸무게 : " + t.get("weight"));
				System.out.println();
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

}
