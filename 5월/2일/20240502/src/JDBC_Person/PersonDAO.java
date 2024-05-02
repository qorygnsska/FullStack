package JDBC_Person;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PersonDAO {

	public static boolean insertStudent(Student stu) {
		System.out.println("PersonService의 insertStudent() 메서드 실행!!");
		Connection conn = null;
		PreparedStatement ps = null;
		boolean check = false;
		try {
			conn = DBUtil.getMysqlConn();
			String sql = "insert into student values(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, stu.getHakbun());
			ps.setString(2, stu.getName());
			ps.setInt(3, stu.getAge());
			ps.setInt(4, stu.getHeight());
			ps.setInt(5, stu.getWeight());
			ps.setInt(6, stu.getGrade());
			ps.setString(7, stu.getMajor());
			
			int result = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			if(result > 0) {
				check = true;
			}else {
				check = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
		
	}

	public static boolean insertEmployee(Employee emp) {
		System.out.println("PersonService의 insertEmployee() 메서드 실행!!");
		Connection conn = null;
		PreparedStatement ps = null;
		boolean check = false;
		try {
			conn = DBUtil.getMysqlConn();
			String sql = "insert into employee values(?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, emp.getEmpNo());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getAge());
			ps.setInt(4, emp.getHeight());
			ps.setInt(5, emp.getWeight());
			ps.setInt(6, emp.getSalary());
			ps.setString(7, emp.getDept());
			
			int result = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			if(result > 0) {
				check = true;
			}else {
				check = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}

}
