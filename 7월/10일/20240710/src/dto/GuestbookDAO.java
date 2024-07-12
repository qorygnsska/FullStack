package dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

public class GuestbookDAO {
	private static GuestbookDAO instance =
 new GuestbookDAO();
	private GuestbookDAO() {}
	public static GuestbookDAO getInstance() {
 return instance;
	}
	
	// InsertService클래스에서 호출되는 mapper와
	// 테이블에 저장할 데이터가 저장된 객체를 넘겨받고
	// guestbook.xml 파일의 sql문을 실행할 수있도록
	// 연결하는 메서드를 만든다.
	public void insert(SqlMapClient mapper,
   GuestbookDTO dto) throws SQLException {
 System.out.println("GuestbookDAO의 insert()실행");
 
 // 실제 ibatis가 제공하는 추가하는 메서드인
 // insert("실행할 sql 명령의 id",sql명령으로 전달할 데이터)
 mapper.insert("insert",dto);
	}
	
	
	public ArrayList<GuestbookDTO> selectList(SqlMapClient mapper
 ,Map<String, Integer> hmap) throws SQLException {
 System.out.println("GuestbookDAO의 selectList()실행");
 
 // 아이바티스에서 데이터를 조회할 때 사용하는 메서드 
 // 1.   sql 한 건을 조회할 때 select결과가 한개!
 //      mapper.queryForObject()
 //      결과가 Object타입이기 때문에 casting
 //      형변환 하기 
 
 // 2.  sql을 실행했을 때 여러개의 결과값이 올때는
// mapper.queryForList()
 //     결과 타입이 List 인터페이스로 되어있음
	
 return (ArrayList<GuestbookDTO>)mapper
 .queryForList("selectAll",hmap);
 // queryForList() 매개변수를 여러개 넘기면
 // 첫번째 매개변수는 id 빠지고 나머지2개의 매개변
 // 수 값을 이용해서 데이터를 찾는다.
 // parameterClass 하나의 타입만 지정이
 //               가능하다.
 // resultClass 하나의 타입만 지정가능하다.
 
 // startNo,endNo 하나의 클래스로 묶는다.
 
 
 
 // 오라클에서는 rownum 
 //  오라클에서 생성된 모든 테이블에서 사용할 수 있는 가상 컬럼
 //  select쿼리문으로 추출 하는데 (row)에 
 //  순차적으로 부여되는 순번!
 
 // 서브쿼리를 이용해서 순서대로 명령문을 실행한다.
 // 1. select * from guestbook order by idx desc;
 //    위에 명령문을 이용해서 게시글의 번호를 이용해서 내림차순으로 정렬!
 
 // 2. 정렬된 상태에서 rownum을 부여한다. 
 // 3. 순차적으로 rownum을 통해 1~10까지의 게시물의
 //   구간을 정해서 가져올 수 있다!
 
	}
	// 데이터베이스에서 데이터의 개수를 반환하는 메서드
	// mapper정보를 매개변수로 받아서 xml로 연결
	
	public int count(SqlMapClient mapper) throws SQLException {
 
 return (int)mapper.queryForObject("count");
	}
	
	// 실제 sql.xml파일에서 sql문 실행하기
	public ArrayList<GuestbookDTO> selectListMemo(SqlMapClient mapper
 ,Param param) throws SQLException {
 System.out.println("GuestbookDAO의 selectListMemo()실행");
 
 return (ArrayList<GuestbookDTO>)
 mapper.queryForList("selectListMemo",param);
	}
	
	//이름으로 검색
	public ArrayList<GuestbookDTO> selectListName(SqlMapClient mapper, String item) throws SQLException {
 System.out.println("GuestbookDAO의 selectListName()실행");
 
 return (ArrayList<GuestbookDTO>)
 mapper.queryForList("selectListName",item);
	}
	// 이름 + 내용 으로 검색
	public ArrayList<GuestbookDTO> selectListMemoName(SqlMapClient mapper, String item) throws SQLException {
 System.out.println("GuestbookDAO의 selectListMemoName()실행");
 
 return (ArrayList<GuestbookDTO>)
 mapper.queryForList("selectListMemoName",item);
	}
	// 글 한건을 검색하는 메서드 
	public GuestbookDTO selectByIdx(SqlMapClient mapper, int idx) throws SQLException {
 
 return (GuestbookDTO)
 mapper
 .queryForObject("selectByIdx",idx);
	}
	
	public void update(SqlMapClient mapper, GuestbookDTO vo) throws SQLException {
 System.out.println("GuestbookDAO의 update()실행");
 
 mapper.update("update",vo);
 
	}
	
	public void delete(SqlMapClient mapper, int idx) throws SQLException {
 mapper.delete("delete",idx);
	}
	
	
	/*
 * 1. insert.jsp 실행!
 * 2. insert.jsp 입력후 버튼 클릭
 *    insertOK.jsp 로 간다.
 * 3. insertOK에서 데이터베이스로 가는
 *     전처리 기능 InsertService로 
 *     객체로 들어간다. insert()메서드 실행
 * 4. 데이터베이스 정보를 가지고 있는 mapper
 *    객체를 저장하고 DAO로 전송(메서드 이용)
 * 5. DAO클래스로 들어가서 insert()메서드 
 *    실행 후 실제 sql을 처리하는 xml파일로
 *    간다.
 * 6. xml파일로 전송(메서드) id값을 이용해서
 *    (첫번째 매개변수인 id) 태그를 찾는다.
 * 7. 태그를 찾으면 그 안에 명령문을 실행한다.
 * 8. 실행이 끝나면 DAO로 돌아온다.
 * 9. Service클래스로 돌아온다.
 * 10. insertOK.jsp로 돌아간다.
 * 11. 새로운 페이지 요청이 있으면 새로운 페이지로
 *     이동하고 없으면 실행 종료!  
 *
 *     
 *    
 * 
 * 
 * 
 * 
 */
	
	
	
}