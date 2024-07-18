package com.ss.spring.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.spring.member.dao.MemberDAO;
import com.ss.spring.member.dto.Member;

@Service  // 서비스임을 알리고 MemberService 객체를 
		  // 생성 하는 어노테이션 
		  // 자동으로 생성되는 객체!
public class MemberService implements
				    MemberServiceImp{

	@Autowired
	private MemberDAO dao;
	
	// sql접근을 위해서 mapper 정보를 가지고 온다.
	@Autowired
	private SqlSessionTemplate session;
	
	
	@Override
	public Member login(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int joinMember(Member member) {
		
		return dao.insertMember(session, member);
	}

	// 회원 가입한 사람의 모든 내용을 
	// 조회하는 메서드 
	@Override
	public List<Member> getAllList() {
		return dao.selectAll();
		
	}
}
