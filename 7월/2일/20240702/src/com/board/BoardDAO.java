package com.board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// 데이터베이스는 아직 없지만 
// 저장하는 공간이다! 
// 게시글을 저장하는 클래스로 사용
public class BoardDAO {
	
	// 싱글톤 기법
	// 하나의 객체를 만들어서 여러 인스턴스들이 
	// 공유할 수 있도록 만든다!
	// 생성자는 private으로 선언한다 
	private BoardDAO() {}
	private static BoardDAO instance
					= new BoardDAO();
	
	//BoardDAO 저장소에 접근을 하는 페이지들은
	// 모두 getInstance메서드를 호출해서
	// 저장소에 접근 한다. 
	public static BoardDAO getInstance() {
			return instance;
	}
	
	// 게시글 고유 번호 
	private static int idNum = 0;
	
	// 실제 저장소! 
	private ArrayList<BoardDTO> boardList
						= new ArrayList<>();
	
	// 새 게시글을 저장하는 메서드!
	public void boardWrite(BoardDTO board) {
		
		// board라는 변수에 DTO 키보드로 입력해서
		// 넘어오면 글번호는 0으로 되어있다.
		
		// 데이터베이스가 없기 때문에 직접작성
		int num = ++BoardDAO.idNum;
		String regDate = getDate();
		
		board.setNum(num);
		board.setRegDate(regDate);
		
		// 글이 추가되면 실제 증가시킨다.
		BoardDAO.idNum++;
		boardList.add(board);
	}
	
	// 오늘날짜를 문자열로 리턴해주는 메서드 
	public String getDate() {
		Date date = new Date();
		
		SimpleDateFormat  sdf =
				new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
		
		//응용!
		// 현재 날짜이면 시간만 출력하고 
		// 전날은 날짜만 출력하기 
		
	}
	// 글 개수를 가져오는 메서드
	public int getAllCount() {
		return boardList.size();
	}
	
	// 현재 저장하고 있는 boardList를
	// 데이터를 꺼내가는 메서드
	public ArrayList<BoardDTO> getBoardList(){
		return boardList;
	}
	
	

}
