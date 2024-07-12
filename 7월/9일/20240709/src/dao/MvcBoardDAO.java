package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import dto.MvcBoardDTO;

public class MvcBoardDAO {

	private static MvcBoardDAO instance = new MvcBoardDAO();

	private MvcBoardDAO() {
	}

	public static MvcBoardDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet rs = null;

	// 연결 정보 가져오기
	public Connection getConnect() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JH", "JH");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	// list.jsp 페이지에 글을 가져가는 메서드

	public ArrayList<MvcBoardDTO> selectList() {

		ArrayList<MvcBoardDTO> list = null;

		try {
			// 1. 연결
			conn = getConnect();

			// 2. sql문 작성
			String sql = "select * from MVCBOARD";

			// 3. sql 검사
			pt = conn.prepareStatement(sql);
			// 4. sql 실행
			// 5. 결과 ArrayList 담기!
			rs = pt.executeQuery();

			if (rs.next()) {
				// 만약 데이터가 있다면 list생성
				list = new ArrayList<>();

				do {
					// 1. DTO객체 생성
					// 2. 기본,매개변수받는 생성
					// 3. ArrayList추가하기

					int idx = rs.getInt("IDX");
					String name = rs.getString("NAME");
					String subject = rs.getString("SUBJECT");
					String content = rs.getString("CONTENT");
					int gup = rs.getInt("GUP");
					int lev = rs.getInt("LEV");
					int seq = rs.getInt("SEQ");
					int hit = rs.getInt("HIT");
					Date writeDate = rs.getTimestamp("WRITEDATE");

					MvcBoardDTO board = new MvcBoardDTO(idx, name, subject, content, gup, lev, seq, hit, writeDate);
					list.add(board);

				} while (rs.next());

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 6. 리턴
		return list;
	}

	public void insert(MvcBoardDTO dto) {

		// jdbc에 추가하는 명령문 작성하기!
	}
	// service에서 넘어온 idx값을 이용해서
	// 상세 글을 한건 조회해서 service로 보내기

	public MvcBoardDTO selectByIdx(int idx) {
		System.out.println("DAO 안에 selectByIdx()실행");
		MvcBoardDTO dto = null;

		try {
			// 1. 연결
			conn = getConnect();

			// 2. sql문 작성
			String sql = "select * from MVCBOARD ";
			sql += " where idx = ? ";

			// 3. sql 검사
			pt = conn.prepareStatement(sql);
			pt.setInt(1, idx);
			// 4. sql 실행
			// 5. 결과 ArrayList 담기!
			rs = pt.executeQuery();

			if (rs.next()) {

				int idx2 = rs.getInt("IDX");
				String name = rs.getString("NAME");
				String subject = rs.getString("SUBJECT");
				String content = rs.getString("CONTENT");
				int gup = rs.getInt("GUP");
				int lev = rs.getInt("LEV");
				int seq = rs.getInt("SEQ");
				int hit = rs.getInt("HIT");
				Date writeDate = rs.getTimestamp("WRITEDATE");

				dto = new MvcBoardDTO(idx2, name, subject, content, gup, lev, seq, hit, writeDate);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dto);

		return dto;

	}

	// 조회수를 증가시키는 메소드
	public void increment(int idx) {

		try {
			// 1. 연결
			conn = getConnect();

			// 2. sql문 작성
			String sql = "update MVCBOARD set hit = hit + 1 where idx = ?";

			// 3. sql 검사
			pt = conn.prepareStatement(sql);
			pt.setInt(1, idx);
			// 4. sql 실행
			// 5. 결과 ArrayList 담기!
			rs = pt.executeQuery();

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// service에서 넘겨받은 dto를 수정하는 메소드
	
		public void update(MvcBoardDTO dto) {
	 
	 try {
	 // 1. 연결
	 conn = getConnect();

	 String sql = "UPDATE mvcboard SET  subject = ?, content = ? WHERE idx = ?";

	            // 3. sql 준비
	            pt = conn.prepareStatement(sql);
	 
	            pt.setString(1, dto.getSubject());
	            pt.setString(2, dto.getContent());
	            pt.setInt(3, dto.getIdx());
	            
	            pt.executeUpdate();
	 
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
		
	}

}