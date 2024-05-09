package GUI_Table_Test_Teacher;


//컨트롤러에서 입력된 데이터나
//출력을 해야되는 내용들 정리하는 클래스!
//디비로 전송하기 전에 조작하는 클래스!
public class TableService {
	
	private TableDAO dao = new TableDAO();
	
	//추가하는 메서드!
	public int insert(Board board) {
		System.out.println
		 ("TableService 실행 insert()메서드 ");
		
		return  dao.insert(board);
		
	}
	// 전제 조회를 해서 테이블에 출력!
	public String[][] select() {
		
		return dao.select();		
	}
	
	
	public int readCount(int selectRow) {
		// 디비에 현재 선택한 행이 있는지 한 행을 가져온다.
		Board board = dao.selectByNum(selectRow);
		if(board != null) {
			// 데이터가 있음
			// 기존에 있는 readCount 값을 먼저 꺼내와야한다
			board.setReadCount(board.getReadCount() + 1);
			int temp = dao.update(board);
			if(temp > 0) {
				temp = board.getReadCount();
			}
			return temp;
		}
		return 0;
	}
	
	
	
}
