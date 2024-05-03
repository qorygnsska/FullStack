package JDBC_Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private ArrayList<Employee> empList = new ArrayList<Employee>();

	// 데이터베이스에 추가하는 함수
	public boolean insert(Employee emp) {
		boolean res = false;
		try {
			// 1. 디비 연결
			conn = DBUtil.getMysqlConn();
			// 2. sql 명령문 작성 -> 임시적으로 실행
			String sql = "insert into employee(name, age, height, weight, salary, dept) values(?, ?, ?, ?, ?, ?)";
			// 3. ?에 데이터 채우기
			ps = conn.prepareStatement(sql);
			// 4. sql로 데이터 전송
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getAge());
			ps.setInt(3, emp.getHeight());
			ps.setInt(4, emp.getWeight());
			ps.setInt(5, emp.getSalary());
			ps.setString(6, emp.getDept());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				res = true;
			}

			// 5. 결과를 가지고 서비스로 보내기
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}

		return res;
	}

	public int count() {
		int res = 0;
		try {
			// 1. 디비 연결
			conn = DBUtil.getMysqlConn();
			// 2. sql 명령문 작성 -> 임시적으로 실행
			String sql = "select count(*) from employee";
			// 4. sql로 데이터 전송
			ps = conn.prepareStatement(sql);

			// 5. 결과를 가지고 서비스로 보내기
			rs = ps.executeQuery();
			if (rs.next()) {
				res = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return res;
	}

	public ArrayList print() {
		try {
			// 1. 디비 연결
			conn = DBUtil.getMysqlConn();
			// 2. sql 명령문 작성 -> 임시적으로 실행
			String sql = "select * from employee";
			// 4. sql로 데이터 전송
			ps = conn.prepareStatement(sql);

			// 5. 결과를 가지고 서비스로 보내기
			rs = ps.executeQuery();
			while (rs.next()) {
				empList.add(new Employee(rs.getInt("empno"), rs.getString("name"), rs.getInt("age"),
						rs.getInt("height"), rs.getInt("weight"), rs.getInt("salary"), rs.getString("dept")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return empList;
	}

	public Employee selectByEmpNo(int empno) {
		Employee emp = null;
		try {
			conn = DBUtil.getMysqlConn();
			String sql = "select * from employee where empno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);

			rs = ps.executeQuery();
			if (rs.next()) {
				emp = new Employee(empno, rs.getString("name"), rs.getInt("age"), rs.getInt("height"),
						rs.getInt("weight"), rs.getInt("salary"), rs.getString("dept"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
			}
		}
		return emp;
	}
}
