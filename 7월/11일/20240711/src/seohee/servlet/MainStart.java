package seohee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class MainStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public MainStart() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		home(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		home(request,response);
	}

	
	protected void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// main.jsp로 이동할 수 있도록
		
		// 1. view 페이지 이름 작성
		String view = "/WEB-INF/main.jsp";
		
		// 2. Dispatcher 클래스 객체 이용해서 경로 저장하기
		RequestDispatcher dis = request.getRequestDispatcher(view);
		// 3. 메소드 호출 forward()
		dis.forward(request, response);
	}
	
}
