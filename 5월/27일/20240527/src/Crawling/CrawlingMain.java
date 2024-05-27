package Crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlingMain {

	public static void main(String[] args) {
		// 웹 크롤링
		//  - 웹 상에서 원하는 데이터를 추출한다
		//  - 필요한 데이터를 가져온다
		
		// jsoup 외부 라이브러리
		
		// html
		//  - 웹 페이지를 만들고 디자인하고 싶을때 사용하는 언어
		//  - 세상에 존재하는 모든 웹 페이지는 html로 작성되어 있다
		//  - 마크업 언어(자료의 구조를 표현하기 위한 언어)
		
		// 태그 <>
		// - <열린태그>내용</닫는태크>
		
		// html은 보이는 부분, 안 보이는 부분
		// 보이는 부분 <body> ~ </body>(화면구성)
		// 안 보이는 부분 <head> ~ </head>
		// 설정하는 부분은 대부분 헤더에 들어간다.
		
		// Document 클래스
		// - html 문서를 저장한다.
		// - .html
		
		// Elements 클래스
		// - 요소들이 모인 자료형
		
		// 1. 크롤링 하기 위해서는 url 저장
		String url = "https://www.naver.com/";
		
		// 외부에 있는 데이터와 통신을 하려면 에러가 발생할 수 있다
		try {
			// 2. 연결
			// Document  html 문서 생성 시 저장하는 클래스 타입
			// Connect(url) : 페이지 주소의 문자열 가져온다
			// get() 이용해서 html 문서를 가져온다.
			Document doc = Jsoup.connect(url).get();
			
			// 3. 위에서 연결 됨 확인하는 출력
			// System.out.println(doc);
			
			// 4. 타이틀 꺼내기
			String title = doc.title();
			System.out.println(title);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
