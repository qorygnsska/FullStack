package service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.MvcBoardDAO;
import dto.MvcBoardDTO;
import mybatis.MySession;

// 데이터베이스 접근할 수 있도록 SqlSession 객체 생성해서 가져오기
// 데이터베이스 가기전 전처리를 하는 클래스! 
public class MvcBoardService {
	
	private static MvcBoardService instance = new MvcBoardService();

	private MvcBoardService() {}

	public static MvcBoardService getInstance() {
		return instance;
	}
	
	private MvcBoardDAO dao = MvcBoardDAO.getInstance();
	
	
	// index.jsp에서 넘어온 수정할 데이터를
	// 매개변수로 받아서 dao로 넘기는 메서드
	public MvcBoardDTO update(int idx, String subject, String content) {
		System.out.println("MvcBoardSerivce 클래스 안 update 메서드");
		
		// 1. idx 글 번호를 이용해서 데이터가 있는 지 확인!
		SqlSession mapper = MySession.getSession();
		
		MvcBoardDTO dto = dao.selectByIdx(mapper, idx);
		
		MvcBoardDTO newDTO = null;
		
		if(dto != null) {
			// 2. 객체를 생성 DTO
			newDTO = new MvcBoardDTO(idx, subject, content);
			
			dao.update(mapper, newDTO);
			
		}
		
		return newDTO;
	}
	
	
	// 게시글 한 건을 조회하는 메서드
	public MvcBoardDTO selectByIdx(int idx) {
		System.out.println("MvcBoardSerivce 클래스 안 selectByIdx 메서드");
		SqlSession mapper = MySession.getSession();
		
		return MvcBoardDAO.getInstance().selectByIdx(mapper, idx);
	}
	
	
	// 전체 글을 조회하는 메서드
	public ArrayList<MvcBoardDTO> selectAll(){
		System.out.println("MvcBoardService 클래스 안 selectAll 메서드");
		
		// 1. 디비 연결 정보 가져오기
		SqlSession mapper = MySession.getSession();
		
		// 2. DAO 호출하기
		
		// 3. 결과 index.jsp로 보내기!
		return MvcBoardDAO.getInstance().selectAll(mapper);
	}
	
	
	// index.jsp에서 데이터의 개수를 반환하는 메서드 호출
	public int count() {
		System.out.println("MvcBoardService 클래스 안 count 메서드");
		
		SqlSession mapper = MySession.getSession();
		
		return MvcBoardDAO.getInstance().count(mapper);
	}
}
