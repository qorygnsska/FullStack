package coffee;

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
		System.out.println("다오의 join1() 실행");
		String sql = "SELECT\r\n" + 
				"    name  AS \"음료명\",\r\n" + 
				"    price AS \"가격\",\r\n" + 
				"    price - (\r\n" + 
				"        SELECT\r\n" + 
				"            MAX(price)\r\n" + 
				"        FROM\r\n" + 
				"            beverages\r\n" + 
				"    )     AS \"최대 가격과의 차이\"\r\n" + 
				"FROM\r\n" + 
				"    beverages";
		// 디비 접속
		con = DBUtil.getConnection();

		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		// 결과반환
		while (rs.next()) {

			System.out.println(rs.getString("음료명"));
			System.out.println(rs.getString("가격"));
			System.out.println(rs.getString("최대 가격과의 차이"));
			System.out.println();
		}
		
	}

	// 2번 문제
	public void join2() throws Exception {
		
	}

	public void join3() throws Exception {
		

	}

	public void join4() throws Exception {
	
	}
	
		
	
	
	
}
