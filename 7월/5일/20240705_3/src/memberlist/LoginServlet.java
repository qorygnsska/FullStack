package memberlist;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 서블렛");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String[] arr = request.getParameterValues("hobby");
		
		Member bean = new Member(id, pw, name, email, Arrays.toString(arr));
		
		// 내장 객체 영역에 저장할 수 있다.
		request.setAttribute("dto", bean);
		
		// HttpSession 세션 객체를 통해서
		// jsp 페이지로 전달할 데이터를 저장
		HttpSession session = request.getSession();
		session.setAttribute("login", bean);
		
		// request 객체는 sendRedirect() 메서드 시
		// request 객체를 포함하지 않는다.
		// 공유하지 않고 새로운 페이지를 요청한다.
		// response.sendRedirect(request.getContextPath() + "/joinView.jsp");
		
		// 페이지 연결을 도와주는 forward()
		
		request.getRequestDispatcher("/joinView.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
