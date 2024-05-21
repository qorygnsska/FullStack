package network;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// db에 접근해서 자장하는 내용
public class MovieDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void insert(Movie movie) {
		System.out.println("dao의 insert메서드 실행");
		con = DBUtil.getConnection();
		String sql = "insert into movie values(?, ?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, movie.getRnum());
			ps.setString(2, movie.getRank());
			ps.setString(3, movie.getRankOldAndNew());
			ps.setString(4, movie.getMovieNm());
			ps.setString(5, movie.getOpenDt());
			ps.setString(6, movie.getAudiAcc());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public boolean hasMovieData() throws Exception{
		
		// 결과를 저장할 변수 생성
		boolean result = false;
		
		// 디비 접속
		con = DBUtil.getConnection();
		
		// sql 명령문 접속
		String sql = "select count(*) from movie";
		
		// 명령문 실행
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			// 조회한 결과를 가져온다
			// 컬럼이 하나 반환되는데 그 안에 값을 꺼낼 때 정수값으로 반환해서 0과 비교
			if(rs.getInt(1) > 0) {
				result = true;
			}
		}
		rs.close();
		ps.close();
		con.close();
		
		return result;
		
	}

	public ArrayList<Movie> select() throws Exception{
		
		ArrayList<Movie> list = null;
		
		// 디비 접속
				con = DBUtil.getConnection();
				
				// sql 명령문 접속
				String sql = "select * from movie";
				
				// 명령문 실행
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					list = new ArrayList<Movie>();
					
					do {
						list.add(new Movie(
								rs.getString("rnum"),
								rs.getString("rank"),
								rs.getString("rankoldandnew"),
								rs.getString("movienm"),
								rs.getString("opendt"),
								rs.getString("audiacc")
								));
					}while(rs.next());
				}
				
				rs.close();
				ps.close();
				con.close();
		return list;
	}

}
