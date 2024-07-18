package com.ss.spring.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ss.spring.member.dto.Member;

@Repository // 실제 동작은 dao를 알리는
			// 어노테이션이다! 데이터베이스 접근
			// 클래스, 자동으로 객체를
			// 생성
public class MemberDAO implements MemberDAOImp {



	@Override
	public List<Member> selectAll() {

		return null;
	}

	@Override
	public Member selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(SqlSessionTemplate mapper, Member member) {
		
		return mapper.insert("memberMapper.insertMember", member);
	}

}
