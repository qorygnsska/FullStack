package GUI_Table_Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

//테이블에서 일어나는 데이터베이스 접근 클래스! 추가 삭제
public class TableDAO {

	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;

	public boolean insert(Board board) {
		System.out.println("TableDAO insert()메서드 ");
		boolean check = false;
		try {
			conn = DBUtil.getMysqlConn();
			String sql = "insert into memo(title, writer, content, readCount) values(?, ?, ?, ?)";

			pt = conn.prepareStatement(sql);
			pt.setString(1, board.getTitle());
			pt.setString(2, board.getWriter());
			pt.setString(3, board.getContent());
			pt.setInt(4, board.getReadCount());

			int result = pt.executeUpdate();
			if (result > 0) {
				check = true;
			}
			pt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public void select(DefaultTableModel tableModel) throws Exception {
		System.out.println("TableDAO select()메서드 ");
		conn = DBUtil.getMysqlConn();
		String sql = "select * from memo";

		pt = conn.prepareStatement(sql);
		rs = pt.executeQuery();

		// 결과를 받아와서 테이블에 추가
		while (rs.next()) {
			String[] rowData = { rs.getString("title"), rs.getString("writer"), rs.getString("content") };
			tableModel.addRow(rowData);
		}

	}

	public int delete(int num) {
		int result = 0;
		/*
		 * sql 실행문 작성하고 디비 전송하고 결과 돌려주기
		 */
		return result;
	}

	public Board selectByNum(int selectRow) {
		Board board = null;
		try {
			// 1. 먼저 mysql 접속
			conn = DBUtil.getMysqlConn();

			// 2. sql 명령문
			String sql = "select * from memo where num = ?";
			pt = conn.prepareStatement(sql);
			// 3. ? 값 채우기
			pt.setInt(1, selectRow);
			// 4. 전송하기
			rs = pt.executeQuery();
			if(rs.next()) {
				board = new Board(rs.getInt("num"),
								rs.getString("title"),
								rs.getString("writer"),
								rs.getString("content"),
								rs.getInt("readCount"));
						
			}
			// 5. 결과 리턴!
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	public int update(Board board) {
		int result = 0;
		try {
			conn = DBUtil.getMysqlConn();
			String sql = "update memo set readCount = ? where num = ?";
			
			pt = conn.prepareStatement(sql);
			
			pt.setInt(1, board.getReadCount());
			pt.setInt(2, board.getNum());
			
			result = pt.executeUpdate();
			if(result > 0) {
				result = 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
