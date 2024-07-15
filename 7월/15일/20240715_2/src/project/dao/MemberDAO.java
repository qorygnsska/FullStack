package project.dao;

import org.apache.ibatis.session.SqlSession;

import project.dto.MemberDTO;
import project.service.MemberService;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	private MemberDAO() {
	}

		public static MemberDAO getInstance() {
		return instance;
	}
	public MemberDTO login(SqlSession mapper
							, MemberDTO dto) {
		// selectOne() select에서
		// 조회 수 한 건의 데이터만 넘겨준다.
		// 만약 없으면 null을 반환한다. 
		System.out.println("dao: "+ dto);
		MemberDTO dd = (MemberDTO)mapper
				.selectOne("login", dto);
		System.out.println("dao:" + dd);
		return dd;
	}
}
