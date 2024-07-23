package com.ss.mvc.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.mvc.board.dto.Board;
import com.ss.mvc.board.dto.Reply;
import com.ss.mvc.board.mapper.BoardMapper;
import com.ss.mvc.board.util.PageInfo;

@Service
public class BoardService {
	
//	@Autowired
//	private BoardDAO dao;
//	
//	@Autowired
//	private SqlSessionTemplate sqlSesion;
//	
	
	@Autowired
	private BoardMapper mapper;

	public int getBoardCount(Map<String, String> map) {
		return mapper.selectBoardCount(map);
	}
	// 전체 게시글 중에 첫번째 페이지에서
	// 10개의 게시글을 반환하는 메서드!
	public List<Board> getBoardList(PageInfo info,
			Map<String, String> map	) {
		
		// Mapper호출 시 parameterType
		// 하나의 타입만 가지고 xml로 간다. 
		// 만약 두개의 타입을 사용하고 싶을 경우에는
		// resultMap이용해서 각각의 타입을 매칭
		// 시킨 다음에 resulMap타입의 id를 
		// 이용해서! parameterType 타입을 줘야된다. 
		return mapper.selectBoardList1(map);
	}
	// 글번호를 이용해서 mapper를 이용해서
	// sql.xml파일로 이동해서 sql실행 후 
	// 결과 받아오기!
	public Board findByNo(int no) {
		
		return mapper.selectBoardByNo(no);
	}
	
	public int saveReply(Reply reply) {
		return mapper.insertReply(reply);
	}
	
	public int deleteReply(int replyNo) {
		return mapper.deleteReply(replyNo);
	}
	

}
