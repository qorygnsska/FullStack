package seohee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;

import seohee.dto.MvcDTO;

// ibatis xml 파일과 자바를 연결해주는 클래스!
// sql 실행(데이터베이스 접근)
public class MvcDAO {
	
	private static MvcDAO instance = new MvcDAO();

	private MvcDAO() {}

	public static MvcDAO getInstance() {
		return instance;
	}
	
	// MvcService 클래스가 mapper와 글 정보를 
	// 넘겨주면 board.xml 파일로 insert sql
	// 실행할 수 있도록 메서드 선언
	public void insert(SqlMapClient mapper, MvcDTO dto) throws SQLException{
		
		mapper.insert("insert", dto);
	}
	
	public ArrayList<MvcDTO> selectAll(SqlMapClient mapper, HashMap<String, Integer> hmap) throws SQLException{
		
		return (ArrayList<MvcDTO>)mapper.queryForList("selectAll", hmap);
	}

	// 게시글의 총 개수를 반환하는 sql 실행
	// dao에 메서드
	public int selectCount(SqlMapClient mapper) throws SQLException {
		
		return (int)mapper.queryForObject("selectCount");
	}
}
