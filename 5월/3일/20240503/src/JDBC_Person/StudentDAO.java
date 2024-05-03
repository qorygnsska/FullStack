package JDBC_Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// 데이터베이스에 접근하는 클래스
// sql에서 전송하면 자바로 변경하고
// 자바에서 sql로 전송하면 결과를 보낸다
public class StudentDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private ArrayList<Student> stuList = new ArrayList<Student>();
	// 데이터베이스에 추가하는 함수
	public boolean insert(Student stu) {
		boolean res = false;
		try {
			// 1. 디비 연결
			conn = DBUtil.getMysqlConn();
			// 2. sql 명령문 작성 -> 임시적으로 실행
			String sql = "insert into student(name, age, height, weight, grade, major) values(?, ?, ?, ?, ?, ?)";
			// 3. ?에 데이터 채우기
			ps = conn.prepareStatement(sql);
			// 4. sql로 데이터 전송
			ps.setString(1, stu.getName());
			ps.setInt(2, stu.getAge());
			ps.setInt(3, stu.getHeight());
			ps.setInt(4, stu.getWeight());
			ps.setInt(5, stu.getGrade());
			ps.setString(6, stu.getMajor());
			int rows = ps.executeUpdate();
			if(rows > 0) {
				res = true;
			}
			
			// 5. 결과를 가지고 서비스로 보내기
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			}catch(Exception e) {}
		}
		
		return res;
	}

	public int count() {
		int res = 0;
		try {
			// 1. 디비 연결
			conn = DBUtil.getMysqlConn();
			// 2. sql 명령문 작성 -> 임시적으로 실행
			String sql = "select count(*) from student";
			// 4. sql로 데이터 전송
			ps = conn.prepareStatement(sql);
			
			// 5. 결과를 가지고 서비스로 보내기
			rs = ps.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e) {}
		}
		return res;
	}

	public ArrayList print() {
		try {
			// 1. 디비 연결
			conn = DBUtil.getMysqlConn();
			// 2. sql 명령문 작성 -> 임시적으로 실행
			String sql = "select * from student";
			// 4. sql로 데이터 전송
			ps = conn.prepareStatement(sql);
			
			// 5. 결과를 가지고 서비스로 보내기
			rs = ps.executeQuery();
			while(rs.next()) {
				stuList.add(new Student(rs.getInt("hakbun"), rs.getString("name"), rs.getInt("age"), rs.getInt("height"), rs.getInt("weight"), rs.getInt("grade"), rs.getString("major")));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e) {}
		}
		return stuList;
	}

	public Student selectByHakbun(int hakbun) {
		Student stu = null;
		try {
			conn = DBUtil.getMysqlConn();
			String sql = "select * from student where hakbun = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hakbun);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				stu = new Student(hakbun, rs.getString("name"), rs.getInt("age"), rs.getInt("height"), rs.getInt("weight"), rs.getInt("grade"), rs.getString("major"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e) {}
		}
		return stu;
		
	}

	public boolean update(int hakbun, int height, int weight) {
		boolean check = false;
		try {
			conn = DBUtil.getMysqlConn();
			String sql = "update student set height = ?, weight = ? where hakbun = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, height);
			ps.setInt(2, weight);
			ps.setInt(3, hakbun);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				check = true;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e) {}
		}
		return check;
	}

	public boolean delete(int hakbun) {
		boolean check = false;
		try {
			conn = DBUtil.getMysqlConn();
			String sql = "delete from student where hakbun = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hakbun);
			
			int res = ps.executeUpdate();
			if(res > 0) {
				check = true;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e) {}
		}
		return check;
		
	}
}
