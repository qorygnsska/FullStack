package com.ss.mvc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.mvc.member.dto.Member;
import com.ss.mvc.member.mapper.MemberMapper;

@Service
public class MemberService {

	// MemberMapper객체를 생성
	@Autowired
	private MemberMapper mapper;
	
	// 로그인시 실행할 메서드
	public Member login(String id,String pw) {
		
		Member member = mapper
						.selectMember(id);
		if(member == null) {
			return null;
		}
		// 암호화 위해서 위에 내용을 작성한 것!
		
		return member;
	}
	
	
	
	
}
