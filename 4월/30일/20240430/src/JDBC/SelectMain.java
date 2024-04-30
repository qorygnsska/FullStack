package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectMain {

	public static void main(String[] args) {
		// select를 하기 위해서 mysql 연결
		Connection con = null;
		try {
			// 1. 드라이버 포함하기
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. url, id, password
			String url = "jdbc:mysql://localhost:3306/java?serverTimezone=UTC";
			
			// 3. 실제 접속하기 위해 메서드 호출
			con = DriverManager.getConnection(url, "root", "1234");
			
			// 4. 조회한 내용을 가져오기
			String sql = "select * from memberlist";
			
			// 5. sql 명령문을 데이터베이스에 전송하려면 전송 기능을 가지고 있는 객체들 사용.
			Statement stmt = con.createStatement();
			
			// 6. excuteQuery(sql명령문);
			// - 데이터를 조회할 때 사용하는 메서드
			
			// ResultSet DB에서 테이블의 행과 열의 집합으로 이루어진 결과를 반환한다.
			ResultSet rs = stmt.executeQuery(sql);
			
			// 7. 위에 결과가 있는지 없는지 확인
			// next() 다음 행으로 이동
			// 		데이터가 있으면 true, 없으면 false
			while(rs.next()) {
				System.out.println("id : " + rs.getString("id"));
				System.out.println("pw : " + rs.getString("pw"));
			}
			
		} catch (ClassNotFoundException e) {
			// mysql의 드라이버 정보를 못 가져올 수 있다.
			// 경로가 잘못되거나 오타로 인해 예외가 발생할 수 있음.
			System.out.println("드라이버를 찾지 못했다!!");
		} catch (SQLException e) {
			System.out.println("정보가 잘못됨!!");
		} finally {
			// 데이터베이스 작업이 완료되면 사용한 모든 객체를 닫는다.
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

				}
			}
		}

		/*
		 * DAT(Dataabase Access Object) DB에 접속하여 실제 데이터를 추가하거나 결과를 조회해서 전달받는 클래스
		 * 
		 * DTO(Data Transfer Object) DB에 각 컬럼에 저장하는 클래스로 사용된다.
		 * 
		 * view (클라이언트에게 보여주는 화면담당) Controller view 전달받은 데이터를 처리(데이터변환, 인코딩) 후에 DAO 전달하는
		 * 역할,DAO로 부터 받은 결과를 view로 보내주는 역할
		 * 
		 * Model DB에 접속하고 데이터를 보관하고 결과를 주고 받는 실질적인 클래스 패키지가 있다
		 */

	}

}
