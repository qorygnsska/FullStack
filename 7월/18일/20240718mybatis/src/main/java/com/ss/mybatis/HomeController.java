package com.ss.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ss.mybatis.board.dao.MyBatisDAO;
import com.ss.mybatis.board.dto.MvcBoardDTO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// root-context.xml 파일에서 생성한
	// mybatis bean(sqlSession)을 사용하기 위해서
	// Sqlsession 인터페이스 타입의 객체를 생성한다
	// 생성한 객체를 @Autowired 이용해서
	// sqlSession 변수에 저장한다.
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("home()");
		
		return "list";
	}
	
	// insertOK 들어오면 데이터베이스로
	// 바로 저장할 수 있도록 설정하는 메서드
	// form태그로 넘어오는 값을
	// MvcBoardDTO로 매칭시켜 자동 저장해준다.
	@RequestMapping("/insertOK")
	public String insertOK(Model model, MvcBoardDTO dto) {
		
		logger.info("insertOK() : {}", dto);
		System.out.println(dto);
		
		// mapper로 사용할 인터페이스의 객체에
		// mybatis mapper를 얻어와서 넣어준다.
		
		MyBatisDAO mapper =  sqlSession.getMapper(MyBatisDAO.class);
		
		// 메인글을 저장하는 insert sql 명령을 실행한다.
		mapper.insert(dto);
		
		return "list";
	} 
	
}

// 프로젝트 생성 시
// 1. 외부라이브러리 다운받기
// 2. db정보 가져오는 파일
// 3. sql을 저장하는 파일
// 4. 2, 3번 가지고 가서 경로 설정 및 디비 정보 저장
//    디비정보저장
