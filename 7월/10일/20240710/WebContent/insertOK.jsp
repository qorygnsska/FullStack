<%@page import="service.InsertService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dto" class="dto.GuestbookDTO">
	<jsp:setProperty property="*" name="dto" />
</jsp:useBean>

${dto}

<%
	// Service클래스 
	//  - sql명령을 실행하기  전에 전처리 작업을
	//    수행하는 클래스 
	//    ibatis의 객체를 반환 받는다. 

	// insert.jsp 에서 넘어온 데이터를
	// 객체로 만든고 geustbook테이블에 저장
	// 하기 위해서 service안에 insert메서드를
	// 호출한다.
	InsertService.getInstance().insert(dto);
%>







