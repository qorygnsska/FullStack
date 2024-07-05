package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("로그인 서블릿 초기화");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("로그인 서블릿 서비스!");
	}
	
	@Override
	public void destroy() {
		System.out.println("로그인 서블릿 소멸");
	}
	
	// 요청을 jsp가 아니라 서블릿으로 할 것!
	// 서블릿과 웹 브라우저가 데이터 주고 받을려면
	// 매개채 역할을 하는것이 web.xml파일
}
