package com.ss.spring.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.ss.spring.member.dto.Member;

public interface MemberDAOImp {
	int insertMember(SqlSessionTemplate mapper, Member member);
	List<Member> selectAll();
	Member selectById(String id);
}





