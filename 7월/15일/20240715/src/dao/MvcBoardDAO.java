package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dto.MvcBoardDTO;

// 데이터베이스 전송(id값을 기준으로 해서 sql mapper 파일과 매칭)
public class MvcBoardDAO {
	private static MvcBoardDAO instance = new MvcBoardDAO();

	private MvcBoardDAO() {}

	public static MvcBoardDAO getInstance() {
		return instance;
	}
	
	
	// 전체 조회 메서드
	public ArrayList<MvcBoardDTO> selectAll(SqlSession mapper) {
		
		System.out.println("MvcBoardDAO 클래스 안 selectAll 메서드");
		
		return (ArrayList<MvcBoardDTO>)mapper.selectList("selectAll");
	}

	// 게시물 개수 조회 메서드
	public int count(SqlSession mapper) {
		System.out.println("MvcBoardDAO 클래스 안 count 메서드");
		return (int)mapper.selectOne("count");
	}
	
	
	// 게시글 한 건 조회 메서드
	public MvcBoardDTO selectByIdx(SqlSession mapper, int idx) {
		
		System.out.println("MvcBoardDAO 클래스 안 selectByIdx 메서드");
		
		return (MvcBoardDTO)mapper.selectOne("selectByIdx", idx);
		
		/*
		 * 동적 sql문 작성이 가능
		 * xml파일에서 jstl처럼!
		<where>
			<if test="idx >= 1">
				where idx = #{idx}
			</if>
		</where>
		*/ 
	}
	
	
	// service에서 넘어온 매개변수들을 이용해서 xml로 넘김
	public void update(SqlSession mapper, MvcBoardDTO newDTO) {
		System.out.println("MvcBoardDAO 클래스 안 update 메서드");
		mapper.update("update", newDTO);
	}
}
