<%@page import="memberlist.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberOK.jsp</title>
</head>
<body>
	<%
	// request로 넘어오는 데이터를 하나씩 꺼내서
	// 저장 
	// Action Tag (액션태그)
	//  - 자바 코드 형태로 작성할 수있는 태그형식!
	//  - html 코드 형식 처럼 자바가 동작할 수있게
	//   태그를 이용한다.
	//  - jsp코드를 HTML코드와 같은 형태로 간단히
	//    사용할 수있는 태그!
	
	// useBean 액션태그 
	//  자바의 클래스 객체를 자동으로 만들어주고
	//   그 안에 데이터까지 자동으로 매칭해서
	//   객체를 생성해준다. 
	%>
	
	<%--  액션태그를 시작할 때  
		<jsp:태그명 />
		jsp 코드와 마찬가지로 웹 애플리케이션 서버
		에서 처리된 후 결과만 출력!
		
	<jsp:useBean id="">
		요 안에는 주석을 작성하면 에러가 발생한다.
		항상 닫는태그는 필수로! 해야된다.
	</jsp:useBean>
	
	 id 속성 = 객체 이름!
	 class 속성에는 객체를 만들려하는 클래스 이름을
	  반드시 풀 패키지 이름으로 함께 입력해야된다.
	--%>
	<jsp:useBean id="date"
		class="java.util.Date"/>
		
	<p>현재 날짜:<%= date %></p>
	
	<!-- useBean 액션태그를 이용해서 
		 Member 객체를 생성한다. 
		 
	Member vo = new Member(); 
	
	vo.setId(name에서 받아온 id);
		
	setProperty   액션 태그 지정한 필드의 
	setter 메서드를 실행한다. 
	property 속성에는 setter 메서드를 실행할
	필드의 이름을 입력한다. 
	
	name속성에는 setter메서드를 실행할 필드가
	 정의된 객체 이름을 입력한다. 
	 
	 useBean 액션태그 자체가  form에서 넘어오는
	 데이터를 자동으로 매칭 시켜서 별도의 코딩을 하지
	 않아도 자동으로 객체에 저장해 준다.
	 form name속성과 클래스 변수명이 일치해야
	  가능하다.	
		 -->

	<jsp:useBean id="vo" 
	     class="memberlist.Member">
	     
	     <jsp:setProperty  
	     			property="id"
	     			name = "vo"/>
	      <jsp:setProperty  
	     			property="name"
	     			name = "vo"/>
	     <jsp:setProperty  
	     			property="age"
	     			name = "vo"/>	
	     <jsp:setProperty  
	     			property="gender"
	     			name = "vo"/>	
	     			
	     <jsp:setProperty  
	     			property="password"
	     			name = "vo"/>	
	     
	</jsp:useBean>
	
	<p> vo변수 : <%= vo %></p>
	
	<%--
		자바에서 매개변수 받는 생성자 처럼
		선언과 동시에 데이터를 바로 저장하는 
		방법
	 --%>
	<jsp:useBean id="vo2" 
	   class="memberlist.Member">
	   	<jsp:setProperty 
	   			property="*"
	   			name="vo2" />
	</jsp:useBean>
	
	<p> vo2변수 : <%= vo2 %></p>
	
	
	<jsp:useBean id="vo3" 
	   class="memberlist.Member">
	   	<jsp:setProperty 
	   			property="*"
	   			name="vo3"
	   			scope ="request" />
	</jsp:useBean>
	
	
	
	
	<ul>
		<li>아이디: 
		<!--  Member vo2 = new Member();
			  syso(vo2.getId());
			 -->
			<jsp:getProperty 
					name="vo2" 
					property="id"/>					
	    </li>
		
		<li>이름: 
			<jsp:getProperty 
					name="vo2" 
					property="name"/>
		
		</li>
		
	</ul>
	
	<%--
		아이디 하고 이름만 출력
	
	 --%>
	
	<%--
		액션태그 
		  - jsp페이지에서 java 코드 등의
		         스크립트 언어를 사용하지 않고 
		    (html 태그 형태로) 객체를 생성하거나
		    다른 페이지로 이동도 할 수있다. 
		  
	
	 --%>
	
</body>
</html>