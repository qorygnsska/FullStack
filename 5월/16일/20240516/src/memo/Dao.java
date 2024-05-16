package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Dao {
	private static Connection con;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static ArrayList<MemoVO> list;
	private static Scanner sc = new Scanner(System.in);

	public static ArrayList<MemoVO> select() {
		list = new ArrayList<MemoVO>();
		try {

			con = DBUtil.getConnection();
			String sql = "select * from board";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				list.add(new MemoVO(rs.getInt("idx"), 
									rs.getString("name"), 
									rs.getString("password"),
									rs.getString("memo"),
									rs.getTimestamp("writedate").toLocalDateTime()));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	// 데이터 추가하는 메서드
	// 게시글을 하나 추가하는 메서드로 만드시오
	public static void insert(String name, String password, String memo) {
		con = DBUtil.getConnection();
		
		try {
			String sql = "insert into board values(board_idx1.nextval, ?, ?, ?, sysdate)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1,  name);
			ps.setString(2,  password);
			ps.setString(3,  memo);
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Dao 클래스 안에 있는 search 실행해서 아이디를 입력 받아서 검색하고 반환하는 메서드
	public static MemoVO search(String name) {
		
		MemoVO vo = null;
		
		try {
			
			con = DBUtil.getConnection();
			String sql = "select * from board where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				vo = new MemoVO(
						rs.getInt("idx"),
						rs.getString("name"),
						rs.getString("password"),
						rs.getString("memo"),
						rs.getTimestamp("writeDate").toLocalDateTime()
						);
						
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	// service에서 넘어온 수정 된 vo객체를 이용해서 
	// 기존 데이터에 있는 내용을 update하기
	public static int update(MemoVO vo) {
		con = DBUtil.getConnection();
		int result = 0;
		try {
			String sql = "update board set name = ?, password = ?, memo = ? where idx = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getMemo());
			ps.setInt(4, vo.getIdx());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static int delete(MemoVO vo) {
		int result = 0;
		con = DBUtil.getConnection();
		try {
String sql = "delete from board where name = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getName());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
