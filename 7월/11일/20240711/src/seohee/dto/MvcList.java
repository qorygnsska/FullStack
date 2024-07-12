package seohee.dto;

import java.util.ArrayList;

// 게시글의 개수가 많으면 한 페이지에 보여줄 수 없기 때문에
// 페이징 처리를 한다!
// 페이징 처리의 정보를 저장하는 8개 변수
// ArrayList
public class MvcList {
	
	private ArrayList<MvcDTO> list = new ArrayList<MvcDTO>();
	
	private int pageSize;   //한 페이지에 보여줄 게시글 수
	private int totalCount; //전체 게시글 수 
	private int totalPage;  //전체 페이지 수
	private int currentPage;// 현재 페이지 번호
	private int startNo;    // 현재 페이지의 첫번째 게시글 번호
	private int endNo;      // 현재 페이지의 마지막 게시글 번호
	private int startPage;  // 시작 페이지
	private int endPage;    // 끝 페이지
	
	public MvcList(int pageSize, int totalCount, int currentPage) {
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		
		init();
	}
	
	// 실제 매개변수 받아온 데이터를 이용해서
	// 총 페이지, 게시글의 시작 번호, 끝번호를 계산한다.
	private void init() {
		
		// 총 페이지
		// 무조건 올림 처리 된다.
		totalPage = (totalCount / pageSize) + 1;
		
		// 현재 페이지
		// 위에 무조건 1을 증가하면 총 페이지 수를 넘길 수 있다.
		// 시작 글의 번호와 끝 번호는 없다!
		currentPage = currentPage > totalCount ? totalPage : currentPage;
		
		// 첫번째 글과 마지막을 계산
		startNo = (currentPage - 1) * pageSize + 1;
		endNo = startNo + pageSize - 1;
		
		// 마지막 글 번호가 없을수도 있다.
		endNo = endNo > totalCount ? totalCount : endNo;
	}
	
	public MvcList() {}

	public ArrayList<MvcDTO> getList() {
		return list;
	}

	public void setList(ArrayList<MvcDTO> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "MvcList [list=" + list + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", currentPage=" + currentPage + ", startNo=" + startNo + ", endNo=" + endNo
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
	
}
