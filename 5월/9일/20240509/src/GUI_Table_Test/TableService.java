package GUI_Table_Test;

import javax.swing.table.DefaultTableModel;

public class TableService {
	
	private TableDAO dao = new TableDAO();

	// 추가하는 메서드!
	public boolean insert(Board board) {
		System.out.println("TableService insert()메서드 ");

		return dao.insert(board);

	}
	
	public void select(DefaultTableModel tableModel) {
		System.out.println("TableService select()메서드 ");
		try {
			dao.select(tableModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int delete(int num) {
		return dao.delete(num);
	}

	// 조회수를 증가하는 메서드
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
