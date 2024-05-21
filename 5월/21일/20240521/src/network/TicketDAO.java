package network;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 티켓에 관한 디비 접근
public class TicketDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public boolean insert(Ticket ticket) throws Exception{
		boolean result = false;
		con =DBUtil.getConnection();
		String sql = "insert into ticket values(seq_ticket.nextval, ?, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, ticket.getUserId());
		ps.setString(2, ticket.getMovieTitle());
		ps.setString(3, ticket.getMovieDate());
		ps.setInt(4, ticket.getCount());
		ps.setString(5, ticket.getSeat());
		
		result = ps.executeUpdate() > 0 ? true : false;
		
		return result;
	}


	public Object select() throws Exception{
		con = DBUtil.getConnection();
		String sql = "select * from ticket t join muser u on t.user_id = u.id";
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				// 반복내용 작성
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
