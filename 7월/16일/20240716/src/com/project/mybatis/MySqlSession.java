package com.project.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 실제 가장 먼저 데이터베이스의 정보를 
// 읽어와서 데이터를 객체 화 시켜서 공유하는 역할로
// 사용한다. 

// SqlSessionFactory (데이터베이스를 관리하는
//                    공장)
public class MySqlSession {
	static SqlSessionFactory f;
	
	static {//초기화 블록을 사용해서 공장을 만들고
		// 공장에서 데이터베이스를 관리할 수있도록
		// xml파일의 내용을 전부 읽어서 설정한다.
		try {
			// 1. xml파일 읽기
			Reader r = Resources
					   .getResourceAsReader
					   ("com/project/mybatis/config.xml");
			// 2. SqlSessionFactoryBuilder 객체 생성
			SqlSessionFactoryBuilder bu 
				= new SqlSessionFactoryBuilder();
			// 3. 공장에 어떤 데이터베이스를 관리할 지 설정
			f = bu.build(r);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
	}
	// 데이터베이스가 필요할 때 마다 실제 
	// 마이바티스에 접근하는 SqlSession객체 
	// 필요하다 . 
	public static SqlSession getSqlSession() {
		// 커밋기능이 비활성화 되어있다. 
		// 명령문을 작성할 때 마다 commit()호출
		return f.openSession(true);
	}	
}
