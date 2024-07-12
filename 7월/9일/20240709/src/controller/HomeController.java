package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MvcBoardDAO;
import dto.MvcBoardDTO;
import service.MvcBoardService;

@WebServlet("*.nhn")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// MvcBoardDAO 객체를 이용해서 데이터베이스
	// 접근 하기
//	public MvcBoardDAO dao = MvcBoardDAO
// .getInstance();
	// 컨트롤러에서 사용할 service 클래스 객체를 생성한다.
	private MvcBoardService service = MvcBoardService.getInstance();

	public HomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HomeController 클래스의 get()실행");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HomeController 클래스의 post()실행");
		actionDo(request, response);
	}

	// 어떤 요청이 들어와도 모두 actionDo메서드 에서
	// 처리하기

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("HomeController 클래스의 actionDo()실행");

		// 한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 요청이 들어온 URL을 보고 어떤 페이지로 연결할
		// 지 처리하는 명령문

		// 1. 클라이언트로 부터 요청이 들어온 정보를 가져오기
		// HttpServletReqeust
		// /20240709/list.nhn 반환됨
// System.out.println(request
// .getRequestURI());
// System.out.println(request
// .getContextPath());

		String url = request.getRequestURI();

		String contextPath = request.getContextPath();

		String context = url.substring(contextPath.length());

		System.out.println(context);

		// 요청받은 viewpage의 경로를 만든다.

		String viewpage = "/WEB-INF/";

		ArrayList<MvcBoardDTO> boardList = null;

		switch (context) {
		
		case "/update.nhn":
			service.update(request,response);
			viewpage += "index";
			break;

		case "/contentView.nhn":

			// 한 건의 데이터를 가져오는 처리를
			// 해야된다.
			service.selectByIdx(request, response);
			viewpage += "contentView";
			break;

		case "/insert.nhn":
			// 입력하는 페이지로 보내기
			viewpage += "insert";
			break;

		case "/insertOK.nhn":
			// insert.jsp에서 테이블에 저장할
			// 데이터를 입력하고 submit 클릭하면
			// 폼 태그의 내용이 컨트롤러의 doPost
			// 메서드의 HttpServletRequest
			// 인터페이스 타입의 객체인 request
			// 에 저장된다.

			service.insert(request, response);

			viewpage += "index";
			break;

		case "/list.nhn":
			// 브라우저에 출력할 1페이지 분량의 글과
			// 페이징 작업을 할 글을 가져오기

			service.selectAll(request, response);

			// url구별 했으니 viewpage에 연결하기
			viewpage += "list";
			break;

		default:
			break;
		}
		viewpage += ".jsp";

		// 요청페이지로 넘기기
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		dis.forward(request, response);

	}

}