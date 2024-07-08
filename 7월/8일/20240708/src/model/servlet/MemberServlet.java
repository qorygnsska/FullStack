package model.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get() 실행!");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post() 실행!");
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");
		String[] inter = request.getParameterValues("inter");
		
		// 저장 객체 생성
		Member member = new Member(name, gender, grade, inter);
		
		// 위에 인코딩 설정을 했는데도 데이터가 깨지면
		// 응답하는 페이지의 인코딩 설정
		 response.setContentType("text/html;charset=UTF-8");
		
		// 내장 객체에 저장
		request.setAttribute("member", member);
		
		// 페이지 넘기기
		request.getRequestDispatcher("/EL/FormResult.jsp").forward(request, response);
	}

}
