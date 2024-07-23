package com.ss.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ss.mvc.board.service.BoardService;
import com.ss.mvc.board.util.PageInfo;
import com.ss.mvc.member.dto.Member;
import com.ss.mvc.member.service.MemberService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
		
	//MemberServic클래스에서 
	//  mapper이용해서 sql을 실행하기 위해서는
	//  객체 (bean) 
	@Autowired
	private MemberService 
						memberService;
	
	// 게시글의 전체 개수를 가져올 때 
	@Autowired
	private BoardService
						service;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale,
					   Model model
					   ,HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		// 로그인이 항상 되어있도록 설정!
		Member loginMember = memberService
						.login("admin","1234");
		session.setAttribute("loginMember"
							, loginMember);
		
		//test();		
		
		return "home";
	}
	
	public void test() {

//		PageInfo info = new PageInfo(1,10
//							,service.getBoardCount(map)
//							,10);
//		logger.info("board List:" +
//					service.getBoardList(info,map));
//		
	}	
}
