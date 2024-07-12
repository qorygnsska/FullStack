package seohee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seohee.service.MvcService;

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// MvcService 객체를 생성
	private MvcService service = MvcService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("main get요청!");
		servlet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("main post요청!");
		servlet(request, response);
	}
	
	protected void servlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet 메서드 실행!");
		
		 // 한글 깨짐 방지
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html; charset=UTF-8");
		 
		 // 요청받은 url 나누기!
		 String url = request.getRequestURI();
		 String contextPath = request.getContextPath();
		 String context = url.substring(contextPath.length());
		 
		 // 요청받은 view 페이지로 이동하기 위해서
		 String viewpage = "/WEB-INF/";
		 switch (context) {
		case "/insert.nhn":
			viewpage += "insert";
			break;
			
		case "/insertOK.nhn":
			
			// 1. insert.jsp 테이블에 저장할 데이터를 submit
			// requst 저장됨
			service.insert(request, response);
			viewpage += "index";
			break;
			
		case "/list.nhn":
			
			service.selectAll(request, response);
			viewpage += "list";
			break;
			

		default:
			break;
		}
		viewpage += ".jsp";
		
		// 요청받은 페이지로 연결한다.
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		dis.forward(request, response);
	}
	
}