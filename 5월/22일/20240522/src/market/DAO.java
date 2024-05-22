package market;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement st;

	public void join1() throws Exception {
		con = DBUtil.getConnection();
		String sql = "SELECT\r\n" + 
				"    u.nickname   AS 주문자,\r\n" + 
				"    o.id         AS 주문번호,\r\n" + 
				"    o.status     AS 주문상태,\r\n" + 
				"    o.created_at AS 주문일시\r\n" + 
				"FROM\r\n" + 
				"         orders o\r\n" + 
				"    JOIN users u ON o.user_id = u.id\r\n" + 
				"WHERE\r\n" + 
				"    u.nickname = '서희'";
		
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			do {
				System.out.println(rs.getString("주문자"));
				System.out.println(rs.getString("주문번호"));
				System.out.println(rs.getString("주문상태"));
				System.out.println(rs.getString("주문일시"));
				System.out.println();
			}while(rs.next());
		}
		
	}

	// 2번 문제
	public void join2() throws Exception {
		
	}

	public void join3() throws Exception {
		

	}

	public void join4() throws Exception {
	
	}
	
		
	
	public void join5() throws Exception {
		
	
	}
	
}