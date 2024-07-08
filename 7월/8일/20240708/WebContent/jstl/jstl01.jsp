<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dto.Person"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>JSTL core 태그 여제</h2>
	<c:set var="dirVar" value="100" />
	<c:set var="dirVar2" value="${ dirVar mod 5 }" />
	<c:set var="dirVar3" value="<%=new Date()%>" />
	<c:set var="dirVar4">
 		변수 값 요렇게 설정
	</c:set>

	<h4>자바 빈즈 생성 1 - 생성자를 이용</h4>
	<c:set value='<%=new Person("홍길동", 20)%>' var="personVar1"
		scope="request" />
	<!-- 
		jstl에서 변수를 저장할 때 각각의 영역이
		다르면 중복되는 변수명을 쓸 수 있다. 
		변수를 검색할 때
		pageContext 검색 personVar1 있으면 그 값을 출력
		
		만약 pageContext에 값이 없으면
		request로 가서 검색 있으면 출력!
		없으면 session에서 변수 검색
		
		session에 있으면 출력
		없으면 Application 영역
	-->
	<c:set value='<%=new Person("김준완", 30)%>' var="personVar1" />

	<ul>
		<li>dirVar : ${ dirVar }</li>
		<li>dirVar2 : ${ dirVar2 }</li>
		<li>dirVar3 : ${ dirVar3 }</li>
		<li>dirVar4 : ${ dirVar4 }</li>

		<li>이름: ${ personVar1.name }</li>
		<li>나이: ${ personVar1.age }</li>

		<li>request 이름 : ${ requestScope.personVar1.name }</li>

	</ul>

	<%  
		ArrayList<Person> pList = new ArrayList<>();
		pList.add(new Person("채송화", 30));
		pList.add(new Person("양석형", 25));
	%>
	<c:set var="personList" value='<%= pList %>' scope="request" />

	<p>이름 : ${ personList[0].name }</p>
	<p>나이 : ${ personList[1].age }</p>


	<h4>Map 구조 이용하기</h4>
	<%
		Map<String, Person> pMap = new HashMap<>();
		pMap.put("person1", new Person("지용", 35));
		pMap.put("person2", new Person("지우", 55));
	%>
	<c:set var="personMap" value="<%= pMap %>" scope="session" />
	<p>이름 : ${ personMap.person1.name }</p>
	<p>나이 : ${ personMap.person1.age }</p>

	<!--  변수를 삭제  -->
	<c:remove var="personMap" />

	<h4>personMap 삭제 후 출력</h4>
	<p>이름: ${ personMap.person1.name }</p>
	<p>나이: ${ personMap.person1.age }</p>

	<!--  중복 되는 변수명들이 내장 객체 안에 있다.
 			personVar1  page,request 삭제
 	 -->

	<c:remove var="personVar1" />

	<h4>중복되는 변수를 삭제했을 때 출력</h4>
	<ul>
		<!--  pageContext 영역 -->
		<li>이름: ${ personVar1.name }</li>
		<li>나이: ${ personVar1.age }</li>

		<!--  request 영역 -->
		<li>request 이름: ${ requestScope.personVar1.name }</li>
	</ul>

</body>
</html>