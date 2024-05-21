package network;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 
public class MovieService {
	// movie디비에 접근할 수있는 객체를 생성한다.
	private MovieDAO dao = new MovieDAO();

	// 추가할 때
	// 네트워크 통신으로 가지고 온 문자를 매개변수로
	// 받아서 자바 객체로 역직렬화 하겠다!
	// JSON타입으로 사용하기
	public void insert(String sb)
						throws Exception{
		
		// 어떤 메서드가 실행 중인지 알려주는 로그 
		System.out.println(
			"MovieService클래스의 insert() 실행"
		);
		
		// 1. jsonparser 객체를 먼저 생성
		JSONParser parser = new JSONParser();

		// 2. 문자열 -> JSONObject객체로 변경
		JSONObject object1 = (JSONObject) 
							parser.parse(sb);

		// 3. Object1 객체에서 key 를 이용해서
		// 안에 있는 value의 타입이 jsonobject

		JSONObject object2 = (JSONObject)
			object1.get("boxOfficeResult");

		System.out.println(object2);

		// 4. key 를 이용해서 value을 가져왔는데
		// 그 객체의 타입이 여러개를 저장하는 배열 [] 형태
		JSONArray array = (JSONArray) object2.get("dailyBoxOfficeList");

		// 5. 반복문을 이용해서 데이터를 꺼내기
		
		ArrayList<Movie> list = 
					new ArrayList<Movie>();
		for (Object temp : array) {
			
			JSONObject t = (JSONObject)temp;
			
			Movie movie = new Movie();
			movie.setRnum((String)t.get("rnum"));
			movie.setMovieNm((String)t.get("movieNm"));
			movie.setRank((String)t.get("rank"));
			movie.setRankOldAndNew((String)t.get("rankOldAndNew"));
			movie.setOpenDt((String)t.get("openDt"));
			movie.setAudiAcc((String)t.get("audiAcc"));
			
			
			//dao 안에 있는 insert
			dao.insert(movie);	
			
		}
	}

	public boolean hasMovieData() throws Exception{
		return dao.hasMovieData();
		
	}

	public ArrayList<Movie> select() throws Exception{
		return dao.select();
		
	}
}