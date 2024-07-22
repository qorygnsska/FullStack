package com.ss.mvc.board.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 게시글을 몇개씩 페이징 처리할 것인지 저장하는 클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {
	
	private int currentPage; // 현재 페이지
	private int pageLimit; // 한 페이지에 보여질 페이지 수
	private int listCount; // 총 게시글 수
	private int listLimit; // 한 페이지에 보여질 게시글 수
	
	// 전체 페이지 중 가장 마지막 페이지
	public int getMaxPage() {
		
		return (int)Math.ceil((double)this.listCount / this.listLimit);
	}
	
	
	// 이전 페이지
	public int getPrevPage() {
		int prevPage = this.currentPage - 1;
		
		return prevPage < 1 ? 1 : prevPage;
	}
	
	
	// 다음 페이지
	public int getNextPage() {
		int nextPage = this.currentPage + 1;
		
		return nextPage > getMaxPage() ? getMaxPage() : nextPage;
	}
	
	
	// 가장 첫번째 페이지로 이동
	
	
	// 가장 마지막으로 이동하는 페이지 함수
}

