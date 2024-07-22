package com.ss.mvc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 요청 url의 상위 url을 모두 처리할 때 사용
@RequestMapping("/board")
@Controller
public class BoardController {
	
	// Get전송 방식만 처리하는 메서드 생성
	@GetMapping("/list")
	public String list(Model model) {
		
		return "board/list";
	}
}
