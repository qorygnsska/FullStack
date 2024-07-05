package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹 클라이언트의 요청을 처리하는 클래스
// 만들고 싶으면 HttpServlet 클래스를 상속
@WebServlet("/join")
public class joinServlet extends HttpServlet{
	
	// 서블릿 객체를 초기화할 때 자동으로 호출되는 메서드
	// 초기화 메서드는 서버를 실행하고 딱 한번만 실행되는 메서드
	@Override
	public void init() throws ServletException {
		
		// 자바 클래스 파일을 만들고 객체 생성 시
		// 어떤 초기화해야되는 명령문들이 있을 경우
		System.out.println("서블릿 초기화 메서드");
	}
	
	// 실제 클라이언트의 요청을 처리하는 메서드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서비스");
		
		PrintWriter pw = new PrintWriter(resp.getOutputStream());
		pw.println("<!DOCTYYPE html>");
		
		// HttpServletRequest
		// - 클라이언트의 요청 정보를 가지고 있다.
		// HttpServletResponse
		// - 서버가 클라이언트의 요청을 처리하고 응답하는 클래스
		
		// 서블릿
		// 자바코드를 이용해서 html 코드를 작성
		
		// 서블릿 컨테이너
		// 서블릿을 관리하는 컨테이너
		
		 /*
		 *  <servlet> 태그
		 *   - 서블릿을 등록하는 역할 
		 *   - 반드시 하위 태그로 servlet-name
		 *               servlet-class
		 *   - 대소문자 구별함
		 * 
		 * 
		 */
		
	}
	
	// 웹 요청을 JoinServlet 클래스가 처리할 수 있도록 웹 브라우저와
	// JoinServlet을 연결
	// 두 개 연결하는 매개체(web.xml)
}
