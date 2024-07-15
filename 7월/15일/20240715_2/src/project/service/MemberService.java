package project.service;

import org.apache.ibatis.session.SqlSession;

import project.dao.MemberDAO;
import project.dto.MemberDTO;
import project.mybatis.MySqlSession;

public class MemberService {

	private static MemberService instance = new MemberService();

	private MemberService() {
	}

		public static MemberService getInstance() {
		return instance;
	}

	public MemberDTO login(MemberDTO dto) {

		System.out.println("service");
		SqlSession mapper = MySqlSession.getSql();

		MemberDTO loginDto = MemberDAO.
							getInstance()
							.login(mapper, dto);
		System.out.println("service:" + loginDto);
		return loginDto;
	}

}
