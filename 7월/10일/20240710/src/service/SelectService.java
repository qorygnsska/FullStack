package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import dto.GuestbookDAO;
import dto.GuestbookDTO;
import dto.GuestbookList;
import dto.Param;
import ibatis.MyAppSqlConfig;

public class SelectService {
	private static SelectService instance = new SelectService();

	private SelectService() {
	}

	public static SelectService getInstance() {
 return instance;
	}
	// -----------------------------
	
	// 글 한건을 가져오는 메서드 
	public GuestbookDTO 
 selectByIdx(int idx) {
 System.out.println("SelectService 안 selectByIdx()실행");

 GuestbookDTO vo = null;
 
 // 1. 디비 정보 가져오기 
 SqlMapClient mapper = MyAppSqlConfig.getSqlMap();

 // 2. dao 호출
 try {
 vo = GuestbookDAO.getInstance()
 .selectByIdx(mapper,idx);
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 
 
 return vo;
	}
	
	
	

	// 이름으로 검색하는 메서드
	public ArrayList<GuestbookDTO> selectName(String item) {

 ArrayList<GuestbookDTO> list = null;

 // 1 . 디비 연결 정보 가져오기
 SqlMapClient mapper = MyAppSqlConfig.getSqlMap();

 // 2. dao 호출
 try {
 list = GuestbookDAO.getInstance().selectListName(mapper, item);
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }

 // 3. 리턴
 return list;
	}

	// 이름 + 내용으로 검색하는 메서드
	public ArrayList<GuestbookDTO> selectMemoName(String item) {

 ArrayList<GuestbookDTO> list = null;

 // 1 . 디비 연결 정보 가져오기
 SqlMapClient mapper = MyAppSqlConfig.getSqlMap();

 // 2. dao 호출
 try {
 list = GuestbookDAO.getInstance()
 .selectListMemoName(mapper, item);
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }

 return list;

	}

	// listPro.jsp에서 호출되는 화면에 표시할
	// 페이지와 검색어(내용을 넘겨받고 ) mapper를 얻은후
	// DAO에 글 목록을 얻어오는 select sql명령을
	// 실행하는 메서드를 호출한다.
	public GuestbookList selectListMemo(
 int currentPage,
 String item) {

 System.out.println("SelectService 안 selectListMemo()실행");

 // 1. 데이터베이스 연결 정보 가져오기
 SqlMapClient mapper = MyAppSqlConfig.getSqlMap();

 // 2. dao 호출
 GuestbookDAO dao = GuestbookDAO
 .getInstance();
 
 GuestbookList gusetbookList = null;
 
 
 try {
 // 현재 보여지는 개수는 jsp에서
 // 가지고 넘어온다. 
 int pageSize = 5;
 
 int totalCount = dao.count(mapper);
 
 gusetbookList = new GuestbookList
 (pageSize,
 totalCount,
 currentPage);
 
 Param param = new Param();
 param.setStartNo(gusetbookList.getStartNo());
 param.setEndNo(gusetbookList.getEndNo());
 param.setItem(item);
 
 // dao 메서드를 호출하기
 // selectListMemo()메서드
 // 매개변수 타입이 변경 하기 
 // 데이터 가져오면 gusetbookList
 // list 값을 수정하기
 gusetbookList.setList(
 
 dao.selectListMemo(mapper, param));
 
 
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }

 // 3. 리턴
 return gusetbookList;

	}

	public int count() {
 System.out.println("SelectService 안 count()실행");

 // 1. 데이터베이스 연결 위해서 mapper
 SqlMapClient mapper = MyAppSqlConfig.getSqlMap();

 // 2. DAO호출하기
 int count = 0;

 try {
 count = GuestbookDAO.getInstance().count(mapper);
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }

 // 3. 리턴 반환(jsp)
 return count;

	}

	public GuestbookList selectList(int currentPage) {

 System.out.println("SelectService클래스 selectList()실행");

 // 1. 데이터베이스 정보 가져오기
 SqlMapClient mapper = MyAppSqlConfig.getSqlMap();
 // 2. DAO호출하기
 
 // 1페이지 분량의 글 목록과 페이징 작업에 사용할
 // 변수를 가지고 있는 객체를 선언한다.
 
 GuestbookList guestbookList = null;
 
 GuestbookDAO dao = GuestbookDAO
          .getInstance();
 
 try {
 
 // 1페이지당 표시할 글의 개수를 정한다
 int pageSize = 5;
 
 // 테이블에 저장된 전체 글의 개수를 얻어온다.
 int totalCount = dao.count(mapper);
 
 System.out.println("service size:"+ totalCount);
 guestbookList = new GuestbookList(pageSize,
 totalCount, 
 currentPage);
 
 // 현재 페이지에 따라서 글 시작 번호, 글 끝 번호를
 // 넘겨서 그 개수만큼 list에 저장해야된다. 
 
 Map<String, Integer> hmap =
 new HashMap<String,
 Integer>();
 
 hmap.put("startNo",guestbookList.getStartNo() );
 hmap.put("endNo",guestbookList.getEndNo() );
 
 guestbookList.setList(dao.selectList(mapper, hmap));
 
 
 System.out.println(guestbookList);
 
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }

 
 // 3. 결과 반환
 return guestbookList;
	}

}