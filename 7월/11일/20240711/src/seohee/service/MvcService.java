package seohee.service;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;

import seohee.dao.MvcDAO;
import seohee.dto.MvcDTO;
import seohee.dto.MvcList;
import seohee.ibatis.SqlConfig;

// mvc 게시판에서 데이터를 넘겨받아서 
// 처리하는 클래스(내장 객체 접근,sqlMap 데이터베이스
// 객체도 접근, 객체 생성)
public class MvcService {

	private static MvcService instance = new MvcService();

	private MvcService() {
	}

	public static MvcService getInstance() {
		return instance;
	}
	
	//MvcDAO객체 생성 
		private MvcDAO dao = MvcDAO.getInstance();
		
	// insertOK.nhn 들어오는 요청을 처리하는
	// 메서드
	public void insert(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MvcService 안에 insert 실행");
		
		// 1. form에서 넘어온 데이터 저장하기
		MvcDTO dto = new MvcDTO();
		dto.setName(req.getParameter("name"));
		dto.setSubject(req.getParameter("subject"));
		dto.setContent(req.getParameter("content"));
		
		System.out.println("insert dto :" + dto);
		
		// 2. 데이터베이스 정보 가져오기
		SqlMapClient mapper = SqlConfig.getSqlMap();
		
		// 3. dao 호출하기
		try {
			dao.insert(mapper, dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// MainController에서 요청객체와 응답객체 전달 받기
	public void selectAll(HttpServletRequest request, HttpServletResponse response) {
		// 1. 디비 정보 가져오기
		SqlMapClient mapper = SqlConfig.getSqlMap();
		
		// ArrayList<MvcDTO> list = null;
		// 페이징 처리까지 같이 할 수 있는 MvcList 객체를 생성
		MvcList list = null;
		
		// list.nhn 주소를 작성해서 들어가면
		// currentPage 정보가 없다!
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		} catch (NumberFormatException e) {}
	
		// 2. dao 호출
		try {
			// 1. 페이지당 표시할 글의 개수
			// select에서 선택한 값을 가지고 온다.
			String page = request.getParameter("pageSize");
			int pageSize = page == null ? 5 : Integer.parseInt(page);
			
			// 2. 테이블의 전체 개수를 가져오는 sql
			int totalCount = dao.selectCount(mapper);
			
			// 3. MvcList 객체를 생성하면
			//    그 안에 init() 메서드가 자동으로
			//    호출되면서 페이지 계산과 시작, 끝
			//    번호를 저장한다.
			list = new MvcList(pageSize, totalCount, currentPage);
			
			// parameterClass
			// resultClass 속성은 데이터타입을 반드시 1개만 적어야함!
			
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			
			hmap.put("startNo", list.getStartNo());
			hmap.put("endNo", list.getEndNo());
			
			list.setList(dao.selectAll(mapper, hmap));
		}catch(Exception e) {
			e.printStackTrace();
		}
		// 3. 서버 메모리(내장 객체에 저장하기)
		request.setAttribute("mvclist", list);
	}

}