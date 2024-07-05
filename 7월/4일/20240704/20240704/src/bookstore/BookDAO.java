package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//데이터베이스에 접근하는 클래스!북테이블!
public class BookDAO {
	private BookDAO() {
	}

	private static BookDAO instance = new BookDAO();

	public static BookDAO getInstance() {
		return instance;
	}

	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet rs = null;

	// DB연동
	private Connection getConnection() {
		String dbURL = "jdbc:mysql://localhost:3306/bookstoredb05?serverTimezone=UTC&useSSL=false";
		String dbID = "root";
		String dbPassword = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 더보기를 클릭했을 때 책의 정보를 가져가는
	// 메서드 
	public ArrayList<BookDTO>
				getBookMore(String book_kind){
		ArrayList<BookDTO> list = null;
		
		try {
		// 1. 디비연결
		conn = getConnection();
		// 2. sql 작성
		String sql = "select * from book ";
		
		// 3. sql 검사 후 메서드 가져오기
		if(book_kind.equals("all")) {
			pt = conn.prepareStatement(sql);
		}else {
			sql += " where book_kind = ? ";
			sql += " order by reg_date DESC ";
			
			pt = conn.prepareStatement(sql);
			pt.setString(1, book_kind);
			
		}
		// 4. 디비 전송( sql 문 실행)
		rs = pt.executeQuery();
		// 5. 결과  확인 (데이터가 있으면 저장,없으면
		//    함수 종료!
		
		if(rs.next()) {
			
			list = new ArrayList<>();
			
			do {
				BookDTO dto = new BookDTO();		
				
				 dto.setBook_id(rs.getInt("book_id"));
                 dto.setBook_kind(rs.getString("book_kind"));
                 dto.setBook_title(rs.getString("book_title"));
                 dto.setBook_price(rs.getInt("book_price"));
                 dto.setBook_count(rs.getInt("book_count"));
                 dto.setAuthor(rs.getString("author"));
                 dto.setPublishing_com(rs.getString("publishing_com"));
                 dto.setPublishing_date(rs.getString("publishing_date"));
                 dto.setBook_image(rs.getString("book_image"));
                 dto.setDiscount_rate(rs.getInt("discount_rate"));
                 dto.setReg_date(rs.getString("reg_date"));
				
                 // 리스트에 추가하기 
                 list.add(dto);
                 
			}while(rs.next());						
		}	
		
		// 지금은 문학, 외국어, it서적 분류 
		// 만약에 전체 보기! all 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	
	// 책의 정보를 반환하는 메서드 
	//  책의 분류에 따라서 값을 리턴한다. 
	public ArrayList<BookDTO> getBooks
					(String book_kind){
		
		ArrayList<BookDTO> bookList = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from book ";
			sql += " where book_kind =? order by reg_date DESC limit 3";
			
			pt = conn.prepareStatement(sql);
			pt.setString(1, book_kind);
			
			rs = pt.executeQuery();
			if(rs.next()) {
				
				bookList = new ArrayList<>();
				
				do {
					BookDTO dto = new BookDTO();		
					
					 dto.setBook_id(rs.getInt("book_id"));
                     dto.setBook_kind(rs.getString("book_kind"));
                     dto.setBook_title(rs.getString("book_title"));
                     dto.setBook_price(rs.getInt("book_price"));
                     dto.setBook_count(rs.getInt("book_count"));
                     dto.setAuthor(rs.getString("author"));
                     dto.setPublishing_com(rs.getString("publishing_com"));
                     dto.setPublishing_date(rs.getString("publishing_date"));
                     dto.setBook_image(rs.getString("book_image"));
                     dto.setDiscount_rate(rs.getInt("discount_rate"));
                     dto.setReg_date(rs.getString("reg_date"));
					
                     // 리스트에 추가하기 
                     bookList.add(dto);
                     
				}while(rs.next());						
			}		
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		
		return bookList;
	}
	
	// book_id를 전달받아서 한 개의 책 정보를
	// 가져가는 메서드 
	public BookDTO getBook(int book_id) {
		
		BookDTO dto = null;
		try {
			
			conn = getConnection();
			
			String sql = "SELECT * FROM book WHERE book_id=?";
			pt = conn.prepareStatement(sql);
			pt.setInt(1, book_id);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				dto = new BookDTO();
				
				dto.setBook_kind(rs.getString("book_kind"));
				dto.setBook_title(rs.getString("book_title"));
				dto.setBook_price(rs.getInt("book_price"));
				dto.setBook_count(rs.getInt("book_count"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublishing_com(rs.getString("publishing_com"));
				dto.setPublishing_date(rs.getString("publishing_date"));
				dto.setBook_image(rs.getString("book_image"));
				dto.setBook_content(rs.getString("book_content"));
				dto.setDiscount_rate(rs.getInt("discount_rate"));				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
	
	

}
