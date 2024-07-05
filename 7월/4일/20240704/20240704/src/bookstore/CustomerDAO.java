package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 고객이든 관리자든 로그인을 할 경우 
// 데이터베이스 접속시 사용할 DAO클래스!
public class CustomerDAO {
	// 싱글톤 : 하나의 객체를 생성해서 여러 개의
	// jsp 페이지들이 공유하면서 쓸 수 있도록 만든 기법

	// 기본생성자는 private
	// 클래스 생성도 내부에서 해야된다
	private CustomerDAO() {
	}

	private static CustomerDAO instance = new CustomerDAO();

	public static CustomerDAO getInstance() {
		return instance;
	}

	// 데이터베이스 접근시 사용하는 클래스변수들 선언
	private Connection conn = null;
	private PreparedStatement pt = null;
	private ResultSet rs = null;

	// 데이터베이스 연결 정보 생성하는 메서드
	private Connection getConnection() {

		// 1. url, user, password 가져오기
		// 2. mysql 드라이버 가져오기
		// 3. DriverManager 클래스 이용해서
		// 디비 연결 Connection 객체 생성하기
		// 예외가 발생한다! 처리하기

		String dbURL = "jdbc:mysql://localhost:3306/bookstoredb05";
		String dbID = "root";
		String dbPassword = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("연결됨" + conn);

		return conn;

	}
	
	// 로그인시 사용자 인증 처리를 하는 메서드 
	public int userCheck(String id, 
						String passwd) {
		System.out.println("CustomerDAO 안에 userCheck() 실행");
		int result = -1;   
		
		try {
			//1. 디비 연결
			conn = getConnection();
			
			// 2. sql 작성
			String sql = "select count(*) from member ";
					sql += " where id = ? and passwd = ? ";
			
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);
			pt.setString(2, passwd);
			
			rs = pt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
						
		}catch(Exception e) {
			e.printStackTrace();
			// 새로운 페이지나 이전 페이지로 이동
			// 하는 코드도 작성할 수 있다. 
		}	
		
		return result;
	}
	
	
	
	
	
	

}
