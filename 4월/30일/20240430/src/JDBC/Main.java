package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;
		// 데이터베이스란?
		// - 데이터의 저장소
		// - 여러 사람들이 공유하고 사용할 목적으로 통합 관리되는 데이터들의 모임

		// DBMS(Database Management System)
		// - 데이터를 관리하기 위해서 사용하는 형태

		// SQL
		// - 데이터베이스에 추가하고 죄회 삭제하는 명령어
		// - 오라클, Mysql

		// 데이터베이스랑 자바랑 호환이 아노딘다
		// 그래서 호환을 할 수 있도록 연결하는 기술
		// JDBC(Java Database Connection)
		// mysql 서버(데이터를 제공하는 컴퓨터)

		// 외부에서 추가된 JDBC안에 연결을 하려면
		// Driver.class 파일을 Main.java에 추가해야함
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 연결하는 클래스를 읽어왔다.
			// Mysql을 연결하는 getConnection() 메서드
			String url = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC";
			// localhost는 접속할 mysql이 설치된 컴퓨터가 현재 사용중인 컴퓨터임을 의미한다.
			// localhost대신 127.0.0.1을 사용해도 된다
			// 3306 mysql 포트번호
			// 1521 오라클 포트번호

			// 위에 정보를 저장했으면 실제 데이터베이스로 연결하는
			// getConnection(url, id, password)
			// 연결된 객체를 반환한다. Connection 객체를 반환
			conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println(conn);
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없다!");
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속 정보가 올바르지 않습니다.");
		}finally {
			// 데이터베이스 작업이 완료되면 사용한 모든 객체를 닫는다.
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
				}
			}
		}
	}

}
