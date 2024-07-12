package service;

import com.ibatis.sqlmap.client.SqlMapClient;

import dto.GuestbookDAO;
import dto.GuestbookDTO;
import ibatis.MyAppSqlConfig;

public class UpdateService {

	private static UpdateService instance = new UpdateService();

	private UpdateService() {
	}

	public static UpdateService getInstance() {
		return instance;
	}

	// updateOK.jsp에서 호출되는 수정할
	// 정보가 저장된 객체를 매개변수로 받고
	// 데이터베이스 연결 정도인 mapper 객체
	// 얻어오기 dao호출하기

	public void update(GuestbookDTO vo) {
		System.out.println("UpdateService의 update()실행");

		SqlMapClient mapper = MyAppSqlConfig.getSqlMap();

		try {
			GuestbookDAO.getInstance().update(mapper, vo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
