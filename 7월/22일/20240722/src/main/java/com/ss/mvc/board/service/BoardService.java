package com.ss.mvc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.mvc.board.dto.Board;
import com.ss.mvc.board.mapper.BoardMapper;
import com.ss.mvc.board.util.PageInfo;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper mapper;

	public int getBoardCount() {
		
		return mapper.selectBoardCount();
	}
	
	// 전체 게시글 중에 첫번째 페이지에서 10개 게시글 반환
	public List<Board> getBoardList(PageInfo info) {
		
		return mapper.selectBoardList1();
	}

}
