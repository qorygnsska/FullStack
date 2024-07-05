<%@page import="rentcar.RentcarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id"); 
	String pw = request.getParameter("pw");
	
	// 회원 아이디와 패스워드가 일치하는 지 비교
	RentcarDAO dao = RentcarDAO.getInstance();
	
	// 해당 회원이 있는 지 여부를 숫자로 표현
	int result = dao.getMember(id, pw);
	
	// 결과를 받아서 alert()창을 띄울 것!
	if(result == 0){
%>
<script>
	alert("회원 아이디 또는 비밀번호를 확인하세요!");
	location.href="carMain.jsp?center=memberLogin.jsp";
</script>
<%}else{
	// 로그인이 되었다면 다른 여러 페이지가
	// 로그인 한 아이디값을 공유해서 사용
	session.setAttribute("id", id);
	response.sendRedirect("carMain.jsp");
%>
<script>
	alert("로그인이 성공적으로 되었습니다.");
	location.href="carMain.jsp?center=center.jsp";
</script>
<%}%>
<%-- <jsp:useBean id="memberDTO" class="rentcar.memberDTO">
	<jsp:setProperty name="memberDTO" property="*"/>
</jsp:useBean> --%>
