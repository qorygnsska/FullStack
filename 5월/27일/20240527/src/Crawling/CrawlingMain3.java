package Crawling;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingMain3 {

	public static void main(String[] args) {
		
		//영화 url을 저장하는 타입으로 ArrayList
		ArrayList<Movie> movieList =
					new ArrayList<Movie>();
		
		
		try {
			// 1. url 
			String url = "https://www.cgv.co.kr/";
			
			// 2. 연결 
			Document doc = Jsoup
						   .connect(url)
						   .get();
			
			// 3. 정보 단락에서 데이터 뽑기 
			Elements movieEle 
				=doc.getElementsByClass
						("movie_info_wrap");
			
			// 각 영화 정보를꺼내기 
			for(Element temp : movieEle) {
				//영화제목 
				String title = temp
					.selectFirst("strong.movieName")
					.text();
				
				// 예매율
				String res = temp.select("span")
							 .last().text();
				
				System.out.println("영화이름:" + title);
				System.out.println(res);
				System.out.println();				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}

//이미지랑 영화 제목이랑 한꺼번에 저장하는 클래스
class Movie{
	
	private String title;
	private String imageURL;
	
	public Movie(String title, String imageURL) {
		this.title = title;
		this.imageURL = imageURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", imageURL=" + imageURL + "]";
	}	
}