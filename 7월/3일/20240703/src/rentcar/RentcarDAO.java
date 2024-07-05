package rentcar;

import java.sql.*;
import java.util.ArrayList;

// 데이터베이스로 접근하기 위해서 사용하는 사용 클래스!
public class RentcarDAO {

	private RentcarDAO() {
	}

	private static RentcarDAO instance = new RentcarDAO();

	public static RentcarDAO getInstance() {
		return instance;

	}

	// 데이터베이스 접근시 사용하는 클래스들을
	// 전역변수로 생성한다.
	// 클래스 안에 어떤 함수에서든 사용할 수 있도록
	// 클래스 멤버 변수를 선언한다.

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

		String dbURL = "jdbc:mysql://localhost:3306/rentcardb04";
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
	
	// 로그인을 확인하는 메서드
	public int getMember(String id, String pw) {
		
		int result = 0;
		
		try {
			conn = getConnection();
			
			String sql = "select count(*) from member where id = ? and pw1 = ?";
			
			pt = conn.prepareStatement(sql);
			
			pt.setString(1, id);
			pt.setString(2, pw);
			
			rs = pt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 자동차 정보 3개를 꺼내가는 메서드
	public ArrayList<RentcarDTO> getSelectCar() {
		System.out.println("getSelectCar() 실행");

		ArrayList<RentcarDTO> list = null;
		try {

			// 1. 디비 연결
			conn = getConnection();
			// 2. ArrayList 생성
			// 3. sql 명령문 + 전송해서 데이터 가져오기
			// 최신 순으로 가져올 수 있다.
			// "select * from rentcar order by no desc"
			String sql = "select * from rentcar order by no desc limit 3";

			pt = conn.prepareStatement(sql);

			rs = pt.executeQuery();

			// 4. ArrayList 담기

			if (rs.next()) {
				list = new ArrayList<RentcarDTO>();

				do {
					RentcarDTO bean = new RentcarDTO(rs.getInt("no"), rs.getString("name"), rs.getInt("category"),
							rs.getInt("price"), rs.getInt("use_people"), rs.getString("company"), rs.getString("img"),
							rs.getString("info"));
					list.add(bean);

				} while (rs.next());
			}

			// 5. 리턴( jsp파일로 전송 )
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("리턴 전:" + list.size());

		return list;
	}

	// no를 이용해서 데이터베이스에서 한건의
	// 차량정보를 저장하는 메소드 생성
	public RentcarDTO getSelectByNo(int no) {
		System.out.println("getSelectByNo() 실행");

		RentcarDTO dto = null;
		// 1. 디비연결

		try {
			conn = getConnection();
			// 2. sql명령문 작성
			String sql = "select * from rentcar where no = ? ";
			// 3. sql문 전송
			pt = conn.prepareStatement(sql);
			pt.setInt(1, no);
			rs = pt.executeQuery();
			// 4. 결과받아오면 RentcarDTO 저장하기
			if (rs.next()) {
				dto = new RentcarDTO(rs.getInt("no"), rs.getString("name"), rs.getInt("category"), rs.getInt("price"),
						rs.getInt("use_people"), rs.getString("company"), rs.getString("img"), rs.getString("info"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 5. 리턴하기
		return dto;
	}
	
	
	public ArrayList<RentcarDTO> getCategoryCar(int category) {
	
		ArrayList<RentcarDTO> list = new ArrayList<RentcarDTO>();
		
		try {
			conn = getConnection();
			// 2. sql명령문 작성
			String sql = "select * from rentcar where category = ? ";
			// 3. sql문 전송
			pt = conn.prepareStatement(sql);
			pt.setInt(1, category);
			rs = pt.executeQuery();
			// 4. 결과받아오면 RentcarDTO 저장하기
			while (rs.next()) {
				RentcarDTO dto = new RentcarDTO(
						rs.getInt("no"), 
						rs.getString("name"), 
						rs.getInt("category"), 
						rs.getInt("price"),
						rs.getInt("use_people"),
						rs.getString("company"), 
						rs.getString("img"), 
						rs.getString("info"));
				list.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// 예약한 정보를 디비에 저장하는 메서드
	public void setReserveCar(CarReserveDTO rbean) {
		try {
			conn = getConnection();
			int num = 0;
			
			String sql = "select MAX(reserve_seq) from car_reserve";
			
			pt = conn.prepareStatement(sql);
			
			rs = pt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1) + 1;
			}
			
			sql = "INSERT INTO car_reserve (reserve_seq , no, id, qty, d_day, r_day, "
					 + "use_in, use_wifi, use_navi, use_seat)" + " VALUES(?, ?,?,?,?,?,?,?,?,?)";
			pt = conn.prepareStatement(sql);
			
			pt.setInt(1, num);
			pt.setInt(2, rbean.getNo());
			pt.setString(3, rbean.getId());
			pt.setInt(4, rbean.getQty());
			pt.setInt(5, rbean.getDday());
			pt.setString(6, rbean.getRday());
			pt.setInt(7, rbean.getUsein());
			pt.setInt(8, rbean.getUsewifi());
			pt.setInt(9, rbean.getUsenavi());
			pt.setInt(10, rbean.getUseseat());
			
			pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



/*
 *  MVC 디자인 설계 패턴 
 *   Model : 데이터 조회 결과값을 저장할 객체 (vo,dto)
 *   View  : 화면 구현(html, css,jsp,js,..)
 *   Controller : 데이터베이스에 접근할 수있는 코드가
 *     담긴 객체(DAO)
 *  
 * 
 *  [jsp 방식]
 *   [model1 방식]
 *   main.jsp -> add.jsp -> info.jsp
 *                  ^
 *                  ㅣ
 *               dao.jsp
 *               
 *   각 페이지 마다 필요시 자바 코드가 작성되며
 *   DB와 연결하는 코드도 jsp 파일 안에서 모두 작성된다.
 *   분리되어 있지 않기 때문에 규모가 작은 프로젝트에는 
 *   나쁘지 않은 방식 ,코드가 확장 될 수록 가독성 떨어지고
 *   분업과 유지보수가 좋지 않다.
 *   
 * 
 * 
 * 
 */