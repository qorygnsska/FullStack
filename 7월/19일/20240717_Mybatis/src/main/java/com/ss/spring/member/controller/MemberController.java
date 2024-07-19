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
		System.out.println("가입 정보: " + m);
		int result = service.joinMember(m);
		
		if(result > 0) {
			model.addAttribute("msg","가입이 완료되었습니다.");
		}

		return "/member/index";
	}

	// 단일 검색 (조회하기)
	// 메서드의 반환 타입이 문자열이면
	// return 했을 때 리턴문자가 jsp 페이지의
	// 파일명이 된다.
	@RequestMapping("/member/memberSearch.do")
	public String memberSearch(Model model, String id) {

		// 위에서 넘어온 id가 정상적으로 들어왔는
		// 로그
		System.out.println("id:" + id);

		// 1. 멤버 정보를 반환
		Member member = service.serachMember(id);

		// 2. view페이지 출력
		if (member != null) {
			model.addAttribute("member", member);
			return "member/memberView";
		} else {
			return "redirect:/member/error.do";
			
			// redirect: 상대경로로 해석
			// /member/searchMember.do
			// 위에 있는 메서드에서 redirect를
			// 하게 되면 현재 경로를 /member/
			// 기준으로 잡는다. 그래서 error.do
			// 앞에 자동으로 현재 컨텍스트 경로로
			// 된다.
			
		}
	}

	// error.do url 요청이 들어오면
	// 핸들러메서드로 연결하기
	// 뷰페이지 error.jsp 페이지 이동하기

	// 1. request 매핑
	// 2. 메서드 작성
	// 3. 뷰페이지 설정
	// 에러 페이지
	@RequestMapping("/member/error.do")
	public String error() {
		return "common/error";
	}
	
	// index.jsp에서 요청이 들어오면 
	// 요청 들어온 url이랑 요청을 처리할 
	// 메서드(핸들러메서드)를 실행한다.
	@RequestMapping("/member/memberDel.do")
	public String memberDel(Model model,
							String id) {
		
		 int result = service.deleteMember(id);
		 
		 if(result > 0) { // 실행되는 쿼리문의 갯수가 반환되는 result - 삭제되면 0보다 큰 수가 반환된다.
		 System.out.println("정상적으로 탈퇴되었습니다.");
		 System.out.println(" '" + id + "'님의 회원 탈퇴가 정상적으로 완료되었습니다.");
		// model.addAttribute("id", id);
		 model.addAttribute("msg", " '" + id + "'님의 회원 탈퇴가 정상적으로 완료되었습니다.");
		 } else {
		 System.out.println("탈퇴에 실패하였습니다.");
		 System.out.println(" '" + id + "'님의 회원 탈퇴가 실패되었습니다.");
		 model.addAttribute("msg", " '" + id + "'님의 회원 탈퇴에 실패하였습니다.");
		// model.addAttribute("msg","탈퇴 실패!");
		 }
		 
		 return "member/index";
	
	}
	
	// 회원을 조회했을 때 웹 요청을 처리하는
	// 핸들러메서드를 매핑시켜야된다.
	@RequestMapping("/member/memberList.do")
	public String memberList(Model model) {
		
		//1. servie 호출하기
		List<Member> list = service.
						getMemberLsit();
		//2. dao 호출하기 
		//3. xml 호출해서 sql실행
		//4. 리턴 값 모델에 저장하기
		model.addAttribute("list", list);
		//5. 웹페이지로 전송!
		return "member/memberList";
		
	}
	
	//회원 로그인을 클릭했을 때 웹에서
	//요청이 들어오면 매핑시킬 핸들러 메서드
	//생성하기
	@RequestMapping("/member/login.do")
	public String login() {
		return "member/login";
	}
	
	// login.jsp페이지에서 입력하면 
	// 처리하는 핸들러메서드 실행
	@RequestMapping("/member/loginPro.do")
	public String loginPro(Model model,
							Member member) {
		// 1. service 클래스
		Member mem = service.login(member);
		// 2. dao 클래스 호출
		// 3. xml 파일 실행후 sql 실행
		// 4. 리턴값 확인 후 조건문생성
		// 5. 조건문에 의해서 웹페이지 return하기
		if(mem != null) {
			model.addAttribute("msg", mem.getId()+"님 환영합니다.");
			
			return "member/index"; //jsp페이지 명
		}else {
			model.addAttribute("msg", 
					 "아이디 또는 비밀번호를 확인하세요");
			return "member/login";
		}
		
	}
	
	
	
	
	

}
/*
 * MyBatis Mapper 인터페이스란? 여러 Mapper 인터페이스를 작성할 수있는 설정
 * 
 * Mapper 인터페이스란? - 매핑파일에 기재된 sql을 호출하기 위해서 만들어진 인터페이스! - Mybatis 3.0부터 생성 - 매핑
 * 파일을 sql을 실행할 수있도록 호출 하는 기능
 * 
 * Mapper인터페이스를 구현하지 않으면 DAO클래스를 만들어서 메서드를 만들어서 그 안에 mapper.selectOnt(아이디,파라미터)
 * 문자열로 작성을 하다보니깐 예외(오타,경로) 버그가 생길 수있다.
 * 
 * Mapper 인터페이스를 사용했을 때 - 개발자가 직접 메서드명과 id값을 일치 시켜서 작성을 하면 불필요한 문자열 예외를 피할 수있고
 * 불필요한 클래스 만들어서 메서드를 중복해서 만들 필요가 없다!
 * 
 * MyBatis 연결 1. sql 명령문을 실행하는 mapper폴더 만들어서 mapper.xml 파일 생성하기 classpath: -->
 * src/main/resources/mapper/*.xml
 * 
 * 
 * 
 */
