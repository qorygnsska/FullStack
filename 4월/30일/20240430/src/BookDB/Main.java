package BookDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
	public static ArrayList<Book> bookList = new ArrayList<Book>();

	public static void main(String[] args) {
		/*
		 * 1. 데이터베이스 연결해서 Book 테이블이 가지고 있는 모든 내용을 자바로 가져오기
		 * 
		 * 2. 반복문을 이용해서 Book 클래스 객체 생성해서 ArrayList저장후
		 * 
		 * 콘솔에 출력하기
		 */

		Connection con = null;
		try {
			// 1. 드라이버 포함하기
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. url, id, password
			String url = "jdbc:mysql://localhost:3306/db1_book_store?serverTimezone=UTC";

			// 3. 실제 접속하기 위해 메서드 호출
			con = DriverManager.getConnection(url, "root", "1234");

			// 4. 조회한 내용을 가져오기
			String sql = "select * from book";

			// 5. sql 명령문을 데이터베이스에 전송하려면 전송 기능을 가지고 있는 객체들 사용.
			Statement stmt = con.createStatement();

			// 6. excuteQuery(sql명령문);
			// - 데이터를 조회할 때 사용하는 메서드

			// ResultSet DB에서 테이블의 행과 열의 집합으로 이루어진 결과를 반환한다.
			ResultSet rs = stmt.executeQuery(sql);

			// 7. 위에 결과가 있는지 없는지 확인
			// next() 다음 행으로 이동
			// 데이터가 있으면 true, 없으면 false
			while (rs.next()) {
				bookList.add(new Book(rs.getInt("book_no"), rs.getString("book_kind"), 
									rs.getString("book_title"), rs.getInt("book_price"), 
									rs.getInt("book_count"), rs.getString("book_author"), 
									rs.getString("book_publishing_com"), rs.getString("book_publishing_date"),
									rs.getString("book_image"), rs.getString("book_content"), 
									rs.getInt("book_discount_rate")));
			}
		} catch (ClassNotFoundException e) {
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
		
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println(bookList.get(i));
		}

	}

}
