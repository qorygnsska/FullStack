package network;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// User 정보를 디비에 접근해서 저장, 수정, 조회, 삭제
public class UserDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	// 회원가입
	public boolean signup(User user) {
		System.out.println("userdao의 signup 메서드");
		boolean result = false;
		con = DBUtil.getConnection();
		String sql = "insert into muser values(?, ?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getId());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getBirthdate());
			
			int num = ps.executeUpdate();
			if(num > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}

	public User login(String id, String password) {
		System.out.println("userdao의 login 메서드");	
		User user = null;
		con = DBUtil.getConnection();
		String sql = "select * from muser where id = ? and password = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new User(rs.getString("name"),
								rs.getString("id"),
								rs.getString("password"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getString("birthdate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean check(String id) {
		boolean result = false;
		con = DBUtil.getConnection();
		String sql = "select * from muser where id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
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
