package service;

import com.ibatis.sqlmap.client.SqlMapClient;

import dto.GuestbookDAO;
import ibatis.MyAppSqlConfig;

public class DeleteService {

	private static DeleteService instance = new DeleteService();

	private DeleteService() {
	}

	public static DeleteService getInstance() {
		return instance;
	}
	
	public void delete(int idx) {
		SqlMapClient mapper = MyAppSqlConfig.getSqlMap();
		
		try {
			GuestbookDAO.getInstance().delete(mapper,idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
