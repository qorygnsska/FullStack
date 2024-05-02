package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// select();
		// selectPrice();
		// selectPrice2();
		// selectDate();
		// selectMember();
		//checkId();
		findBookTitle();

	}

	// 책을 검색할 때 책 제목에 내가 키보드로 입력
	// 해서 입력한 단어가 포함된 책의 정보를 모두
	// 출력하는 메서드
	public static void findBookTitle() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("검색할 제목 : ");
			String title = sc.nextLine();

			// DB에서 입력한 가격 이상인 책의 결과
			Connection conn = DBUtil.getMysqlConn();

			// sql 문장
			String sql = "select * from book ";
			sql += "where book_title Like '%" + title + "%'";

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			boolean check = false;
			while (rs.next()) {
				System.out.println("책 번호 : " + rs.getInt("book_no"));
				System.out.println("책 종류 : " + rs.getString("book_kind"));
				System.out.println("책 제목 : " + rs.getString("book_title"));
				System.out.println("책 내용 : " + rs.getString("book_content"));
				System.out.println("책 등록일 : " + rs.getTimestamp("book_reg_date"));
				System.out.println();
				check = true;
			}
			if(check == false) {
				System.out.println("검색 결과가 없습니다.");
			}

			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원가입 시 아이디가 중복인 지 확인하는 메서드
	public static void checkId() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("검색할 id : ");
			String id = sc.nextLine();

			// DB에서 입력한 가격 이상인 책의 결과
			Connection conn = DBUtil.getMysqlConn();

			// sql 문장
			String sql = "select count(*) as 중복 from member ";
			sql += "where member_id = '" + id + "'";

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				// mysql은 1번부터 인덱스가 시작
				// oracle은 0번부터 인덱스가 시작
				int count = rs.getInt(1);
				if (count > 0) {
					System.out.println("중복된 아이디 입니다.");
				} else {
					System.out.println("중복되지 않은 아이디 입니다.");
				}
			}

			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 멤버를 검색하는 메서드
	public static void selectMember() {
		// 멤버id 검색후 있으면 id, 이름 출력 없으면 찾을 수 없습니다.
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("검색할 id : ");
			String id = sc.nextLine();

			// DB에서 입력한 가격 이상인 책의 결과
			Connection conn = DBUtil.getMysqlConn();

			// sql 문장
			String sql = "select member_id, member_name from member ";
			sql += "where member_id = '" + id + "'";

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				System.out.println("id : " + rs.getString("member_id"));
				System.out.println("이름 : " + rs.getString("member_name"));
				System.out.println();

			} else {
				System.out.println("찾을 수 없습니다.");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// book 테이블에서 2020년 이전에 등록된 책 이름, 등록일
	public static void selectDate() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("조회할 날짜 : ");
			String date = sc.nextLine();

			// DB에서 입력한 가격 이상인 책의 결과
			Connection conn = DBUtil.getMysqlConn();

			// sql 문장
			String sql = "select book_title, book_reg_date from book ";
			sql += "where book_reg_date <= '" + date + "'";

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("책 제목 : " + rs.getString("book_title"));
				System.out.println("책 등록일 : " + rs.getTimestamp("book_reg_date"));
				System.out.println();
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 입력받은 가격보다 비싼 책 조회
	public static void selectPrice2() {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("가격 : ");
			int price = sc.nextInt();

			// DB에서 입력한 가격 이상인 책의 결과
			Connection conn = DBUtil.getMysqlConn();

			// sql 문장
			String sql = "select * from book ";
			sql += "where book_price >= " + price;

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				System.out.println("책 제목 : " + rs.getString("book_title"));
				System.out.println();
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 책의 가격을 10% 인상 후 출력하는 메서드
	public static void selectPrice() {
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/db1_book_store?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";
//
//			Connection conn = DriverManager.getConnection(url, user, password);
			Connection conn = DBUtil.getMysqlConn(); // DBUtil 클래스에 연결하는 메서드 구현해서 호출

			Statement st = conn.createStatement();

			String sql = "select book_title, book_price, book_price * 1.1 AS 인상 from book";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String title = rs.getString("book_title");
				int price = rs.getInt("book_price");
				int price2 = rs.getInt("인상");
				System.out.println("제목 : " + title);
				System.out.println("원래 가격 : " + price);
				System.out.println("인상된 가격 : " + price2);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 조회를 하는 메서드
	public static void select() {
		// JDBC
		// - 자바 언어로 다양한 종류의 관계형 데이터베이스에 접속하고 SQL문을 수행하여 처리하는 표준 SQL 인터페이스 API

		// - java.sql 패키지 안에 있는 내용들
		// 메서드 몸체를 구현한 클래스 파일들이 필요하다

		// JDBC 드라이버 로딩
		// - 압축 푼 JDBC 드라이버 파일을 사용할 수 있도록 메모리에 로딩해야됨

		// Class.forName(드라이버명)
		// Mysql : com.mysql.cj.jdbc.Driver
		// Oracle : oracle.jdbc.driver.OracleDriver

		// DB와 연결
		// java.sql.DriverManager 클래스의 getConnection() 메서드 이용해서
		// 실제 자바 프로그램과 데이터베이스를 네트워크상에서 연결 해주는 메서드이며 연결 성공하면
		// Connection 객체로 표현하여 반환한다.

		// getConnection(1, 2, 3);
		// 1) url : 접속할 서버의 url, 프로토콜, 서버주소, DB이름으로 구성
		// jdbc:[DBMS]
		// mysql jdbc:mysql://서버주소/DB이름
		// oracle jdbc:oracle:thin@서버주소,서비스번호

		// 2) user : DB서버에 로그인할 계정
		// mysql : root 최고 관리자
		// oracle : system, sys

		// 3) password : DB서버에 로그인 할 비밀번호

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/db1_book_store?serverTimezone=UTC";
//			String user = "root";
//			String password = "1234";
//
//			Connection conn = DriverManager.getConnection(url, user, password);
			Connection conn = DBUtil.getMysqlConn();

			// 조회를 하기 위해서 자바 프로그램에서 DB쪽으로 SQL문을 전송하고
			// DB는 처리된 결과를 다시 자바프로그램으로 전달해야된다.
			// 이 역할을 하는것이 Statement

			// Connection객체가 제공하는 createStatement()
			Statement st = conn.createStatement();

			// 실제 전송을 위한 sql문을 문자열로 작성
			String sql = "select * from member";

			// 전송을 할 때 sql문에 따라서 메서드가 제공된다.
			// select로 조회만 할 것이다!
			// st.executeQuery(sql);
			// 조회의 결과가 ResultSet 객체로 한꺼번에 반환된다.
			// 내부적으로 커서가 동작한다.
			// next()를 이용해서 데이터가 있는지 없는지 파악
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Member> list = new ArrayList<Member>();
			Member m = null;
			while (rs.next()) {
				m = new Member(rs.getInt("member_no"), rs.getString("member_id"), rs.getString("member_pw"),
						rs.getString("member_name"), rs.getString("member_gender"), rs.getInt("member_point"),
						// 실제 시간을 꺼내오는 메서드를 사용해서
						// 자바가 가지고 있는 LocalDateTime으로 변경 가능
						// 문자열로 바꾸고 싶다면 toString()
						rs.getTimestamp("member_reg_date").toLocalDateTime() // 날짜를 꺼내올때는 getTimestamp
				);
				list.add(m);
			}
			System.out.println(list);
			// 추가, 수정, 삭제 뭔가 sql을 변경
			// executeUpdate(sql)
			// 실행된 행의 개수를 반환, 반환 타입이 int

			// 작업을 끝냈으면 DB와 관련처리 작업을 하는 객체들은 모두 메모리에서 해제시켜야된다.
			// 메모리 해제 시에는 최근 사용했던 객체부터 거꾸로 올라가면서 해제한다.
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
