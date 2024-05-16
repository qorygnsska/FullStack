package memo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemoVO {
	private int idx;
	private String name;
	private String password;
	private String memo;
	private LocalDateTime writeDate;
	
	public MemoVO(int idx, String name, String password, String memo, LocalDateTime writeDate) {
		this.idx = idx;
		this.name = name;
		this.password = password;
		this.memo = memo;
		this.writeDate = writeDate;
	}

	public MemoVO() {}

	public MemoVO(String name, String password, String memo) {
		this.name = name;
		this.password = password;
		this.memo = memo;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public LocalDateTime getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		
		// 오늘 입력된 메모는 시간만 표시
		// 전날에 입력한 메모는 날짜만 표시
		LocalDate today = LocalDate.now();

		LocalDate memoDate = writeDate.toLocalDate();
	
		
		// 오늘
		DateTimeFormatter sdf1 = DateTimeFormatter.ofPattern("HH:mm");
		// 어제 이전
		DateTimeFormatter sdf2 = DateTimeFormatter.ofPattern("yyyy.MM.dd(E)"); 
		
		boolean isToday = memoDate.equals(today);
		return String.format("%d. %s %s %s", idx, name, memo, isToday ? writeDate.format(sdf1) : writeDate.format(sdf2));
	}
	
	
	
	
	
	
}
