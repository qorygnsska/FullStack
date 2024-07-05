<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");

	if (userid.equals(userpw)) {
		response.sendRedirect("main.jsp");
	} else {
		response.sendRedirect("login.jsp");
	}

	// 우리가 하고 있는 방식
	// 브라우저가 웹 애플리케이션 서버간의 
	// 통신을 할 때 jsp파일 매개체 역할!

	// 서블릿 
	//  - 웹 클라이언트의 요청을 처리하는 클래스

	// jsp 파일이 서블릿 
	// 기존 방식 
	// 클라이언트의 요청이 들어오면 jsp 파일받음

	// 서블릿
	//  클라이언트가 요청을 하면 servlet 자바 파일
	//  직접 호출할 수 있도록 설계!

	// 클라이언트 (웹 브라우저 입장에서는 )
	// jsp 파일, 자바파일 직접!

	// MVC 패턴 
	//  View 는 사용자에게 보여지는 부분만 담당 (jsp)
	//  Controller 클라이언트가 요청을 하면 요청한 내용을 구분해서
	//  분석하고 어떻게 처리할 지 구분
	//  Model 처리

	// servlet 특징
	//  클라이언트의 요청에 대해 동적으로 작동하는
	//  웹 애플리케이션 컴포넌트
	//  html을 사용하여 요청에 응답한다.
	//  java Thread 동작한다.
	//  MVC 패턴에서 Controller 요청구분
	//  HTTP 프로토콜 서비스를 지원하는 것!
	//  javax.servlet.http.HttpServlet
	//   를 상속 받는다.

	// HTTP 프로토콜 
	//  하이퍼텍스트 전송 프로토콜(규칙)
	//  웹브라우저와 웹 서버간의 데이터를 전송하는
	//  규칙!
%>