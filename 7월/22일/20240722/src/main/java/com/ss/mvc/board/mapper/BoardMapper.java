package com.ss.mvc.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ss.mvc.board.dto.Board;

@Mapper
public interface BoardMapper {

	int selectBoardCount();
	
	// Mysql Page 기능활용
	List<Board> selectBoardList1();

}
