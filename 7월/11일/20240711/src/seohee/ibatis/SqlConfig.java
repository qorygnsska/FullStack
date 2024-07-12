package seohee.ibatis;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlConfig {

	private static final SqlMapClient sqlMap;
	
	static {
		
		// final로 선언된 변수를 초기화 시키기 위해서 두줄 이상이 필요하다 
		// static{ ~ } 내부에 적어준다.
		
		
		try {
			// xml 파일 읽기
			Reader reader = Resources.getResourceAsReader("seohee/ibatis/config.xml");
			
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	
		
	}
	
	public static SqlMapClient getSqlMap() {
		return sqlMap;
	}
}
