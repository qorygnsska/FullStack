package com.project.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.project.dao.MemberDAO;
import com.project.mybatis.MySqlSession;

public class MemberService {
	private static MemberService instance = new MemberService();
    private MemberDAO dao = MemberDAO.getInstance();

    private MemberService() {}

    public static MemberService getInstance() {
        return instance;
    }
    // insertForm.jsp페이지 에서 ajax를 통해서
    // 요청이 들어오면 요청받은 객체와 응답하는 객체를
    // 컨트롤러한테 넘겨 받아서 꺼내는 작업을 한다. 
    
    // Http문서가 서버에서 요청이 들어오면 (Ajax)
    // success 콜백함수로 응답의 결과를 보내야된다.
    // jsp 페이지를 포워딩 하기 때문에 
    // Ajax의 요청은 Json형식이나 단순 텍스트로 
    // 응답 반환해야된다. 
    
    // Ajax로 요청이 들어오는 서블릿들은 
    // jsp 로 포워딩되지 않도록 viewPage 변수를
    // 작성하지 말고 service가 끝나면 바로 
    // 함수를 (컨트롤러)를 종료할 수 있도록 설정!
    
    public void emailCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. ajax에서 꺼내오기 
    	req.setCharacterEncoding("UTF-8");
    	String email = req.getParameter("email");
        System.out.println("service post : " + email);
         
        
        // 2. DAO클래스 호출하기 
        //   sql연결 정보가 없다
        SqlSession mapper = MySqlSession.
        					getSqlSession();
        
        boolean result = dao.emailCheck(email, mapper);
        System.out.println(result);
        // Ajax()메서드에게 응답할 문장을 보낸다.
        // json타입으로 ajax()통신을 한다.
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        String jsonResp = "{\"result\" : "
        				     +result + "}";
        // 서블릿이 클라이언트에게 응답한다. 
        resp.getWriter().write(jsonResp);
        
       
    }
}
