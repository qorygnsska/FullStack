package GUI_Table_Test_Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 테이블에서 읽어나는 데이터베이스 접근 
// 클래스! 추가,삭제
public class TableDAO {

	// 전역변수기 때문에 여러 메서드에 들어가서
	// 사용할 수 있다.
	private Connection conn;
	private PreparedStatement pt;
	private ResultSet rs;

	public int insert(Board board) {

		int result = 0;

		try {

			// 3. 연결
			Connection conn = DBUtil.getMysqlConn();
			// 4. sql
			String sql = "insert into memo";
			sql += "(title,writer,content,readCount) ";
			sql += " values(?,?,?,?) ";

			PreparedStatement pt = conn.prepareStatement(sql);

			// 5. ? 물음표 채움
			pt.setString(1, board.getTitle());
			pt.setString(2, board.getWriter());
			pt.setString(3, board.getContent());
			pt.setInt(4, board.getReadCount());

			// 6. 디비로 전송
			result = pt.executeUpdate();

			// 7. 닫기
			pt.close();
			conn.close();

		} catch (Exception es) {
			es.printStackTrace();
		}

		return result;
	}

	public String[][] select() {
		String[][] result = null;

		try {
			
			conn = DBUtil.getMysqlConn();
			
			String countSql = "select count(*) from memo";
			
			pt = conn.prepareStatement(countSql);
			rs = pt.executeQuery();
			
			int row = 0;
			
			if(rs.next()) {
				row = rs.getInt(1);
				System.out.println(row);
			}else {
				return result;
			}
						
			// 조회하는 sql문 작성
			String sql = "select * from memo";

			pt = conn.prepareStatement(sql);

			ResultSet rs = pt.executeQuery();
			
			// 2차원 배열을 선언 
			result = new String[row][3];
			
			// 2차원 배열의 index를 (공간의 번호)
			// 저장하는 변수 
			int index = 0;
			
			while (rs.next()) {
				// 결과를 받아와서 테이블에 추가하는
				// 명령문!
				result[index][0] = 	rs.getString("title");
				result[index][1] = 	rs.getString("writer");
				result[index][2] = 	rs.getString("content");
				index++;				
			}
			// 닫기 
			rs.close();
			pt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

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

/*

	// 결과 개수를 파악하기 위해서 count()
			// 하기 불편왜? sql구문 도 실행!
			// ResultSet의 커서를 가장 마지막행으로
			// 이동시키는 메서드 
			rs.last();			
			System.out.println(rs.getRow());
			int rowCount = rs.getRow();
			rs.beforeFirst();

*/