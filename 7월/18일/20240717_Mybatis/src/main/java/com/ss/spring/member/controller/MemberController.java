package com.ss.spring.member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.spring.member.dto.Member;
import com.ss.spring.member.service.MemberService;



@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/member/index.do")
	public String index() {
		return "member/index";
	}
	
	// 회원가입 버튼을 클릭했을 때 매칭시키는
	// 핸들러 메서드 생성하기
	@RequestMapping("/member/memberEnroll.do")
	public String memberEnroll(Model model, Member m) {
		System.out.println("가입 정보 : " + m);
		int result = service.joinMember(m);
		return "/member/index";
	}
	

}

/*
 *  MyBatis 
 *   Mapper 인터페이스란?
 *    여러 Mapper 인터페이스를 작성할 수있는 설정
 *    
 *   Mapper 인터페이스란?
 *    - 매핑파일에 기재된 sql을 호출하기 위해서
 *      만들어진 인터페이스!
 *    - Mybatis 3.0부터 생성
 *    - 매핑 파일을 sql을 실행할 수있도록 호출
 *      하는 기능
 *      
 *    Mapper인터페이스를 구현하지 않으면
 *     DAO클래스를 만들어서 메서드를 만들어서
 *     그 안에 mapper.selectOnt(아이디,파라미터)
 *     문자열로 작성을 하다보니깐 예외(오타,경로)
 *     버그가 생길 수있다.
 *
 *
 *		 Mapper 인터페이스를 사용했을 때 
 *       개발자가 직접 메서드명과 id값을 
 *       일치 시켜서 작성을 하면 불필요한 
 *       문자열 예외를 피할 수있고 불필요한
 *       클래스 만들어서 메서드를 중복해서
 *       만들 필요가 없다!
 */
