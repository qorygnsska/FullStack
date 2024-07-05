<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 로그아웃을 처리하는 페이지
	// 세션 영역에 있는 현재 세션을 지운다
	// 무효화
	session.invalidate();
	response.sendRedirect("carMain.jsp");
%>