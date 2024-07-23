package com.ss.mvc.member.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	// 1. HomeController로 에서 
	//   MemberSerivce 클래스의 login
	///  메서드 호출하기 
	
	// 2. login호출시 매개변수는 
	//    admin,1234 넘겨주기 
	
	// 3. MemberService 클래스의 login
	//  메서드가 DAO클래스를 호출해서 member
	// -mapper.xml파일에 sql 실행 후 
	
	// 4.리턴 값을 HomeController로
	//  보내면 session내장객체에 직접
	// 저장해서 home.jsp로 갈 수있도록 설정
	// 세션 저장 변수이름: loginMember
	
	
}
