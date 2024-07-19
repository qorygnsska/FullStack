package com.ss.spring.member.service;

import java.util.HashMap;
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
	
	// sql접근을 위해서 mapper 정보를 가지고
	// 온다. 
	@Autowired
	private SqlSessionTemplate session;
	
	
	@Override
	public Member login(Member member) {
		HashMap<String, String> hmap
		   = new HashMap<String, String>();
		
		hmap.put("id", member.getId());
		
		if(member.getPassword() != null) {
			hmap.put("password",
						member.getPassword());
		}
		return dao.selectMemberById
							(session,hmap);
	}

	@Override
	public int joinMember(Member member) {
		
		return dao.insertMember(session,member);
	}

	

	@Override
	public Member serachMember(String id) {
		// 데이터베이스의 정보를 가지고 있는
		// 메퍼(sqlSession) , id
		HashMap<String, String> hmap
		  = new HashMap<String, String>();
		hmap.put("id", id);
		
		return dao.selectMemberById(session,hmap);
	}

	@Override
	public int deleteMember(String id) {
		System.out.println("MemberService 안에 deleteMember()");
		return dao.deleteMember(session,id);
	}

	// 전체 조회를 실행하는 dao를 호출하는 메서드
	public List<Member> getMemberLsit() {
		return dao.selectAll(session);
	}

	@Override
	public List<Member> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}
}



