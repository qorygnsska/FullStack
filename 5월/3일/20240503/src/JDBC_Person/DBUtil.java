package JDBC_Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// Mysql에 연결하는 Connection을 만들어서 리턴하는 메서드
	public static Connection getMysqlConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/PersonList?serverTimezone=UTC";
			String user = "root";
			String password = "1234";

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 읽어올 수 없습니다.");
		} catch (SQLException e) {
			// 문법 오류!(컬럼명이 없거나, 잘못되어 있거나)
			System.out.println("데이터베이스 접속 정보 에러!");
			System.out.println("혹은 문법 에러!");
		}
		return conn;
	}

	// 데이터베이스 작업에 Connection 객체를 닫는 메서드
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
