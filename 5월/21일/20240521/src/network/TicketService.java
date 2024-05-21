package network;

/*
 * 티켓을 조회할 때 사용하는 전처리 클래스
 */
public class TicketService {
	private TicketDAO dao = new TicketDAO();
	
	// 티켓 구매
	public boolean insert(Ticket ticket) throws Exception{
		
		return dao.insert(ticket);
	}

	public void select() throws Exception{
		return dao.select();
		
	}

}
