<%@page import="bookstore.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request
		.setCharacterEncoding("UTF-8");

	// 1. 아이디와 비밀번호를 form태그로 전송
	//  되었기 때문에 
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");

	// 2. 데이터베이스에 접근 하기 위해서 
	//   DAO 클래스가 필요하다 
	
	int result = CustomerDAO
				.getInstance()
				.userCheck(id, passwd);
	
	if(result == 1){
		// 여러 페이지가 로그인한 id를 공유할 수있도록
		session.setAttribute("id", id);
		response.sendRedirect("shopMain.jsp");
%>
<%}else{ %>
	<!--  자바스크립트 코드로 팝업 창 보이기 -->
	<script>
		alert("아이디 또는 비밀번호를 확인하세요!");
		history.go(-1); //이전 페이지 돌아가기!
	</script>
	
<%}%>	
	
	

