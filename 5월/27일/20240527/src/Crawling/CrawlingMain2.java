package Crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingMain2 {

	public static void main(String[] args) {
		// 1. url 저장
		// 실제 url을 가져오면 query 부분이 실제 검색하는 부분이다
		// 검색어를 입력해야되는 인코딩 되어있는 부분이기 때문에
		// 이 부분을 변수로만 변경한다
		
		String query = "서현 맛집";
		String url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query="+query;
		
		try {
			// 2. 연결
			Document doc = Jsoup.connect(url).get();
			
			// 3. 출력
			//System.out.println(doc);
			
			// html에서 태그를 가져올 때
			// 태그명으로 가져올 수도 있고 그룹을 지어서
			// 그룹마다 가져올 수 있는 키워드
			// class - 요소값 여러개를 그룹지어서 가져올 수 있다.
			
			// 3. 요소값들을 찾을 때 사용하는 메서드
			// getElementsByClass("그룹명")
			// class 이름으로 검색한다
			
			// Elements 클래스에 위에서 가져온 메서드의 모든 요소를 저장
			Elements ele = doc.getElementsByClass("TYaxT");
			System.out.println(ele);
			
			// 위에 내용은 요소, 즉 태그값들이 들어있다.
			// 그래서 그 안에 있는 내용을 꺼내오고 싶을 겅우(content)
			// text()에 검색한 모든 내용이 한 줄의 텍스트로 변환한다.
			
			// 요소들이 몇개인 지 알 수 없다!
			// 그러기때문에 반복의 조건을 줄 수가 없다!
			for(Element temp : ele) {
				String name = temp.text();
				System.out.println(name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
