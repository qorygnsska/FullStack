<%@page import="onLine.PollRead"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pollWrite.jsp</title>
</head>
<body>
	<h2>pollWrite 페이지</h2>
	
	<%
		// 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");
	
		String temp = request.getParameter("poll");
		out.println(temp);
		
		try{
			String filepath = application.getRealPath("/") + "onLine\\poll.txt";
			
			ArrayList<String> poll = PollRead.pollRead(filepath);
			
			// poll.txt 파일에서 팀명만 가져와서 출력하기
			// 개수도 저장하기
			int itemCount = ;
			
			// 넘어온 투표 데이터가 정상적인 투표 범위라면
			// 카운트 올려주기
			if(temp != null && temp.trim().length() != 0){
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		// 에러 체크
		// 투표 데이터가 null 또는 공백이 아닌 지 체크
		
		// <tr></tr> 행이 너무 많다
		// 반복문을 이용해서 줄여보기
		
		// 검사했을 때 null 이면 null 입니다.
		// 제대로 입력하세요! 출력
	%>
</body>
</html>