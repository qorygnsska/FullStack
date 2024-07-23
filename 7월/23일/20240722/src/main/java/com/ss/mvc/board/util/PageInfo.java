package com.ss.mvc.board.util;

// 게시글을 몇개씩 페이징 처리할 것인지
// 저장하는 클래스 
public class PageInfo {
	//현재 페이지
	private int currentPage;
	
	// 한 페이지에 보여질 페이지 수
	private int pageLimit;
	
	// 총 게시글의 수 
	private int listCount;
	
	// 한 페이지에 보여질 게시글 수
	private int listLimit;

	public PageInfo(int currentPage, int pageLimit, int listCount, int listLimit) {
		
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.listCount = listCount;
		this.listLimit = listLimit;
	}
	
	//전체 페이지 중 가장 마지막 페이지
	public int getMaxPage() {
		
		/*
		 *  listCount = 100 ,listLimit=10
		 *   100   -> 100 / 10 => 10.0 -> 10페이지
		 *   101   -> 101 / 10 => 10.1 -> 11페이지
		 *   103   -> 103 / 10 => 10.3 -> 11페이지
		 *   109   -> 109 / 10 => 10.9 -> 11페이지
		 *   110   -> 110 / 10 => 11.0 -> 11페이지
		 *   111   -> 111 / 10 => 11.1 -> 12페에지
		 * 
		 * 
		 */
		
		return (int)Math.ceil((double)this.listCount
					     /this.listLimit);
	}
	
	// 이전 페이지
	public int getPrevPage() {
		int prevPage = this.currentPage -1;
		
		// 이전페이지로 갈 때 
		// 1페이지 일때 이전 을 누르면 0없다!
		return prevPage < 1 ? 1 : prevPage;
		
	}
	
	// 다음 페이지 
	public int getNextPage() {
		int nextPage = this.currentPage +1;
		
		return nextPage >  getMaxPage() ?  
							getMaxPage()
							:nextPage;
	}	
	
	// 페이징 된 페이지 중 시작 페이지
	/* 
	 *  첫번째 그룹 0
	 *  1   2  3  4  5  6  7  8  9 10
	 *  두번째 그룹 1
	 *  11 12 13 14 15 16 17 18 19 20
	 *  21 22 23 24 25 26 27 28 29 30
	 *  31 32 33 34 35 36 37 38 39 40
	 */
	
	public int getStartPage() {
		//1 11 21 31...=> (10 * 2) +1  (n >= 0)
		// 1 ~ 10 : n = 0
		// 11 ~20 : n = 1
		// 21 ~30 : n = 2
		// n = currentPage -1 / pageLimit
		// this.pageLimit 한 페이지 그룹다
		//       페이지 수를 나타낸다.
				
		// 
		return  (this.pageLimit * (this.currentPage -1) 
								/ (this.pageLimit))	+1;	
		
		
	}	
	// 페이징 된 페이지 중 마지막 페이지
	public int getEndPage() {
		// 10,20,30,40,....
		// 1 + 10 = 11 그룹의 시작페이지가 
		// 되기 때문에 그 앞에 있는 값이 끝 페이지
		// 가 된다. 
		int endPage = getStartPage()
					+ this.pageLimit -1;
		return endPage > getMaxPage() ?
				getMaxPage() : endPage;
	}	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getListLimit() {
		return listLimit;
	}

	public void setListLimit(int listLimit) {
		this.listLimit = listLimit;
	}
	
	// 가장 첫번째 페이지로 이동
	// 100   1~10  11 ~ 20 21~30
	
	// 가장 마지막으로 이동하는 페이지 함수
		
}
