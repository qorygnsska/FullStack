package Instagram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public void join1() throws Exception {
		con = DBUtil.getConnection();
		String sql = "select count(distinct user_id) as user_count from photo";

		ps = con.prepareStatement(sql);

		rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println("사진 게시 유저 수 : " + rs.getString("user_count") + "명");
		}

	}

	public void join2() throws Exception {
		con = DBUtil.getConnection();
		String sql = "select p.filename\r\n" + "from comments c\r\n" + "join photo p on c.photo_id = p.id\r\n"
				+ "where c.id = 3";

		ps = con.prepareStatement(sql);

		rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println(rs.getString("filename"));
			System.out.println();
		}

	}

	public void join3() throws Exception {
		con = DBUtil.getConnection();
		String sql = "select u.nickname, c.body\r\n" + "from comments c\r\n" + "join photo p on c.photo_id = p.id\r\n"
				+ "join user1 u on u.id = c.user_id\r\n" + "where c.photo_id = 1";

		ps = con.prepareStatement(sql);

		rs = ps.executeQuery();

		if (rs.next()) {
			do {
				System.out.println(rs.getString("nickname"));
				System.out.println(rs.getString("body"));
				System.out.println();
			} while (rs.next());
		}

	}

	public void join4() throws Exception {
		con = DBUtil.getConnection();
		String sql = "select p.filename, u.nickname\r\n" + "from photo p\r\n" + "join user1 u on u.id = p.user_id\r\n"
				+ "where p.id = 5";

		ps = con.prepareStatement(sql);

		rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println(rs.getString("filename"));
			System.out.println(rs.getString("nickname"));
			System.out.println();
		}

	}
	
	public void join5() throws Exception {
		con = DBUtil.getConnection();
		String sql = "select u.nickname, p.filename\r\n" + 
				"from like3 l\r\n" + 
				"join user1 u on u.id = l.user_id\r\n" + 
				"join photo p on p.id = l.photo_id\r\n" + 
				"where p.id = 2";

		ps = con.prepareStatement(sql);

		rs = ps.executeQuery();

		while (rs.next()){
			System.out.println(rs.getString("nickname"));
			System.out.println(rs.getString("filename"));
			System.out.println();
		} 

	}

}
