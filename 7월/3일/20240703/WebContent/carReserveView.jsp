<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// 예약확인 페이지 
	// 로그인이 되어있으면 예약 내역을 보여준다.
	// DAO 현재 예약된 아이디를 이용해서 내용 가져오기

	String id = (String) session
 .getAttribute("id");
	if (id == null) {
%>
<script>
	alert("로그인 후 예약이 가능합니다!!");
	location.href = 'carMain.jsp?center=memberLogin.jsp';
</script>
<%	}%>