package com.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.project.mybatis.MySqlSession;

public class MemberDAO {
	 private static MemberDAO instance = new MemberDAO();
	    
	    private MemberDAO() {}

	    public static MemberDAO getInstance() {
	        return instance;
	    }

	    // DAO클래스 안에 있는 emailCheck()메서드 
	    // 실행해서 xml파일의 sql구문을 실행한다. 
	    // id와 데이터가 매개변수로 넘어가야된다. 
	    public boolean emailCheck(String email,
	    					 SqlSession mapper) {
	    	System.out.println("DAO클래스 emailCheck()");
	    	
	    	// 조회시 하나의 결과를 반환하는 메서드 
	    	// selectOne() 마이바티스가 제공하는 메서드!
	    	int count = (int)mapper
	    				.selectOne("emailCheck"
	    								,email);
	        return count == 0; 
	    }
}




