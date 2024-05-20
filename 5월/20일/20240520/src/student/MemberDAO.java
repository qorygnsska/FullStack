package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 멤버 디비에 접근할 수 있는 클래스!
public class MemberDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean result = false;
	
	public boolean login(String hak, String pass) {
		System.out.println("DAO에서 로그인 체크중!!");
		con = DBUtil.getConnection();
		String sql = "select * from member where hakbun = '" + hak + "' and passwd = '" + pass + "'";
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
