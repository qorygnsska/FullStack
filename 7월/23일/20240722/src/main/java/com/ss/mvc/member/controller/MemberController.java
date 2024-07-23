package com.ss.mvc.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ss.mvc.member.service.MemberService;

// 훈련 과목 
//  - Web Application 개발을 위한 풀스택 개발
//    기술
// 훈련 내용
//  - Spring Framework기반 백엔드 개발 기술


// Model에서 저장을 할 때 loginMember
// 단어로 저장을 하면 세션으로 자동 저장될 수
// 있도록 처리해주는 어노테이션
@SessionAttributes("loginMember")
@Controller
public class MemberController {

	// Member들을 관리하는 Servie
	@Autowired
	private MemberService service;
	

	
}
