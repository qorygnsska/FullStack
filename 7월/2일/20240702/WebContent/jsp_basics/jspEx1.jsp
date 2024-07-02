<%@page import="java.util.Random"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspEx.jsp</title>
</head>
<body>

	<h1>1. 출력 </h1>
	<%
		//자바 코드를 작성할 때 사용!
		String name = "이익준";
	
		// 만약 위에 있는 변수의 값이 이익준이면
		// 이름을 출력하면 된다.
		// 만약 변수의 값이 이익준이 아니라면
		// 이름이 다릅니다. 출력 
		
		if(name.equals("이익준")){	
	%>
		<p><%= name %></p>
	<%} else { %>
		<p>이름이 다릅니다. </p>
	<%} %>


	name
	<p><%= name %></p>

	<h2>import 속성</h2>
	<%
	// Timestamp sql에서 시간 날짜를 관련한
	// 데이터를 조작하기 위해서 사용하는 클래스!
	
		Timestamp now = new Timestamp(
					System.currentTimeMillis());
	
		out.println(now);
		// 2024-07-02
		SimpleDateFormat format = 
				new SimpleDateFormat
					("yyyy-MM-dd");
		
		String strDate = format
						.format(now);
	
	%>
	
	<p>오늘은 <%= strDate %></p>
	
	<h2>Random</h2>
	
	<%
		// 배열을 이용해서 초기화 블럭을 사용하면
		// 새로고침할 때마다 데이터가 변하는 동적
		// 파일을 만들기
		
		String[] strlist = {"JSP","JAVA"
					,"HTML","Android"};
	
		// request객체가 현재페이지에서 
		// 다음 페이지까지 변수의 데이터를 유지한다.
		// Map<String,Object>
		
		//request.setAttribute("strlist"
		// 		              ,strlist);
	
	
		Random ran = new Random();
		
		int i = ran.nextInt(strlist.length);
	
	%>
	
	<%= strlist[i] %> 가(이) 재미있다.


	<%--
		JSP
		 - html코드 안에 자바 코드를 집어넣어서
		   그때 그때마다 변화하는 웹페이지를 만들기
		   위해서 사용하는 것!
		톰캣 
		   -웹서버(정적파일) + 웹 애플리케이션 서버
	 --%>
	 <%
		// forward() :괄호 안에 지정된 페이지로 
		//           넘겨준다.
		// forward() 메서드는 주소창에 표시되는
		//   페이지 이름이 forward() 실행된
		//   페이지 이름으로 그대로 유지된다.
		//   현재페이지와 forward된 페이지를
		//   연결해서 데이터를 공유한다.
		
		// pageContext.forward("jspEx2.jsp");
		
		// 어떤 웹페이지든(어떤 jsp파일이든 )
		// 다 데이터를 공유할 수 있도록 session
		// session 은 클라이언트가 서버에 접속해 
		// 있는 상태 혹은 단위 
		// 웹 브라우저를 최초로 열고 난 후 닫을 때까지 
		// 요청되는 모든 페이지는 session영역을 
		// 공유해서 사용한다. 
		// 주로 회원인증 후 로그인 상태를 유지해서
		// 처리하는데 사용된다.
		
		session.setAttribute("strlist"
				      		, strlist);
		
		
	
	 %>

</body>
</html>