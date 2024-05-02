package JDBC_Test;

import java.time.LocalDateTime;

public class MemoVO {
	private static int num = 1;
	private int  memNo ;
	private String memTitle ;
	private String memContent;
	private LocalDateTime memoDate;
	
	
	
	public MemoVO() {
	}

	public MemoVO(int memNo, String memTitle, String memContent, LocalDateTime memoDate) {
		super();
		this.memNo = memNo;
		this.memTitle = memTitle;
		this.memContent = memContent;
		this.memoDate = memoDate;
	}

	public MemoVO(String memTitle, String memContent) {
		this.memNo = num++;
		this.memTitle = memTitle;
		this.memContent = memContent;
		this.memoDate = LocalDateTime.now();
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemTitle() {
		return memTitle;
	}

	public void setMemTitle(String memTitle) {
		this.memTitle = memTitle;
	}

	public String getMemContent() {
		return memContent;
	}

	public void setMemContent(String memContent) {
		this.memContent = memContent;
	}

	public LocalDateTime getMemoDate() {
		return memoDate;
	}

	public void setMemoDate(LocalDateTime memoDate) {
		this.memoDate = memoDate;
	}

	@Override
	public String toString() {
		return "[memNo=" + memNo + ", memTitle=" + memTitle + ", memContent=" + memContent + ", memoDate="
				+ memoDate + "]";
	}
	
}
