<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<%--
		내장 객체
		 - 기본적인 요청, 응답, 화면 출력을 담당
		 - 톰캣 컨테이너가 미리 선언하여 별도의
		   생성 없이 사용할 수 있다.
	 --%>
	<h2>main.jsp 페이지 입니다.</h2>

	<!--  myInfo.jsp에서 넘어온 데이터 출력하기
	  -->
	<%
	  	// 한글 깨짐 방지
	  	request.setCharacterEncoding("UTF-8");
	  
	  	// request로 넘어온 데이터들을 출력 하려면
	  	// request객체 안에서 꺼내와야함
	  	// getParameter(html의 name속성명)
		// 이전 페이지에서 넘어오는 데이터는 무조건 
		// 문자열 형태로 넘어온다. 
	  	String name = request.getParameter("name");
	  	String id = request.getParameter("id");
	  	
	  	// 나이 출력
	  	// 현재 나이는 **세 입니다.
	  	// 내년 나이는 **+1세 입니다.
	  	
	  	// 문자 -> 숫자 변경 X
	  	// String 객체! 기본 자료형으로 변경 X
	  	int age = Integer.parseInt(request.getParameter("age"));
	  	
	  /* out.println(name + "님 안녕하세요<br>");
	  	out.println(id + "님<br>");
	  	out.println("<p>" + id + "</p>");
	  	
	  	getParameter() : 하나의 데이터만 가져옴
	  	
	  	 */
	  	 String[] hobbies = request.getParameterValues("hobbies");
	  	
	  	// Arrays배열을 이용해서 하나의 문자로 리턴!
	  	// 인덱스 이용해서 출력
	  	
	  	// 만약 데이터가 없으면 null
	  	if(hobbies != null){
	  		out.println(Arrays.toString(hobbies));
	  	}else{
	  		out.println("취미가 선택되지 않았습니다!");
	  	}
	  	
	  	String trip = request.getParameter("trip");
	  	out.println(trip + "가고 싶은 곳 입니다!");
	  %>
	  <p>jsp 문법 이름 : <%= name %></p>
	  <p>jsp 문법 아이디 : <%= id %></p>
	  
	  <%-- 숫자를 입력안하고 문자를 입력하면 에러가 발생
	  	   문자에 +1도 안된다. try~catch로 처리 --%>
	  <p>jsp 문법 나이 : <%= age %></p>
	  <p>1년 후 나이 : <%= age + 1 %></p>
	  
	  <%
	  if(hobbies != null){
	  %>
	  <p>jsp 문법 취미 : <%= Arrays.toString(hobbies) %></p>
	  <%
	  }else{
	  %>
	  <p>취미가 선택되지 않았습니다.</p>
	  <%}%>
	  
	  <%
	  	boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
	  	out.println(name + "님은" + ( gender ? " 남자입니다." : " 여자입니다."));
	  %>
	  
	  <p>jsp 문법 성별 : <%= gender ? " 남자입니다." : " 여자입니다."%></p>
	  
	  <h2> 클라이언트와 서버의 환경 정보 읽기</h2>
	  <ul>
	  	<li>데이터 전송 방식 : <%= request.getMethod() %></li>
	  	<li>URL : <%= request.getRequestURL() %></li>
	  	<li>URI : <%= request.getRequestURI() %></li>
	  	<li>클라이언트 ip주소 : <%= request.getRemoteAddr() %></li>
	  	<!-- 서버명 getServerName()
	  	     서버포트 getSeverPort() -->
	  </ul>
	  
	
	
</body>
</html>