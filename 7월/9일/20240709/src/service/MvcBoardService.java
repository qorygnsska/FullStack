package service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MvcBoardDAO;
import dto.MvcBoardDTO;

// 컨트롤러에서 넘어오는 request 객체와
// response객체를 매개변수로 받아서 데이터를
// 꺼내거나 데이터를 jsp로 전달할 때 
//  서비스가 전처리 역할을 한다.
public class MvcBoardService {

	private static MvcBoardService instance = new MvcBoardService();

	private MvcBoardService() {
	}

	public static MvcBoardService getInstance() {
		return instance;
	}

	// DAO 클래스 객체에 접근하기 위해서 객체 주소
	// 저장하기
	private MvcBoardDAO dao = MvcBoardDAO.getInstance();

	// 컨트롤러에서 넘겨받은 요청,응답 객체를 매개변수로
	// 받아서 dao로 넘기기 전에 전처리!
	public void insert(HttpServletRequest request, HttpServletResponse response) {

		// 1. form태그에서 넘어온 데이터 꺼내기
		MvcBoardDTO dto = new MvcBoardDTO();

		dto.setName(request.getParameter("name"));
		dto.setName(request.getParameter("subject"));
		dto.setName(request.getParameter("content"));

		// 2. 디비로 전송(dao)
		dao.insert(dto);

	}
	// 컨트롤러에서 게시글 전부를 가져오는 메서드

	public void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<MvcBoardDTO> boardList = dao.selectList();

		// 서버 내부에서 데이터를 전달할 수있도록
		// 내장 객체에 접근이 가능하다.
		request.setAttribute("boardList", boardList);

	}

	// 컨트롤러에서 넘어온 요청 객체에서 idx를
	// 꺼내서 dao로 보내주는 메서드
	public void selectByIdx(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("service 안에 selectByIdx()실행");
		// 1. url에 온 idx를 꺼낸다.
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 조회수를 증가하는 코드를 추가하기
		increment(idx);
		// 2. dao로 전송
		MvcBoardDTO dto = dao.selectByIdx(idx);

		// 3. jsp파일들 끼리 데이터를 공유하기 (전달)
		request.setAttribute("dto", dto);

	}

	
	// 글을 조회할 때 조회수가 하나 올라가는 메소드
	public void increment(int idx) {
		dao.increment(idx);
	}

	// 컨트롤러에서 받은 객체를 이용해서
	// update를 할 객체를 저장하고 dao로 보내준다
	public void update(HttpServletRequest request, HttpServletResponse response) {

		// 1. url에서 글 번호 꺼내기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 2. form 태그에서 넘어온 데이터 저장
		MvcBoardDTO dto = new MvcBoardDTO();
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setIdx(idx);
				
		// 2. dao로 전송하기
		dao.update(dto);
	
		
	}
}