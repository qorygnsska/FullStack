package fileupload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MainStart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. view 페이지 이름 작성
		String view = "/WEB-INF/fileUploadForm.jsp";

		// 2. Dispatcher 클래스 객체 이용해서 경로 저장하기
		RequestDispatcher dis = req.getRequestDispatcher(view);
		// 3. 메소드 호출 forward()
		dis.forward(req, resp);
	}
}
