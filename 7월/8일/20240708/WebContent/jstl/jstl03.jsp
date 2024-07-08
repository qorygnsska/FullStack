<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl03.jsp</title>
</head>
<body>
	<c:set var="num" value="10" />

	<h1>JSTL 반복문</h1>
	<h5>문제 1~ 10출력</h5>

	<!--  for (int i = 0; i < 100; i++) 
	 var     변수명  == int i;	
	 begin 시작값
	 end     종료값
	 step    증가할 값 
	 step을 지정하지 않으면 1씩 증가
	 기본값으로 설정 되어있다. 
	-->

	<c:forEach var="i" begin="1" end="10">
 		${ i } <br>
	</c:forEach>

	<h4>1~10출력 홀수만 출력</h4>
	<c:forEach var="i2" begin="1" end="10" step="${i2 = i2 +2 }">
		 ${ i2 } <br>
	</c:forEach>

	<!--  for문 안에 if문 작성 가능 -->
	<h4>1~10R까지 짝수 출력!</h4>
	<c:forEach var="i3" begin="1" end="10">
		<c:if test="${ i3 % 2 == 0 }">
		 	${ i3 } 
		 </c:if>
	</c:forEach>


	<!--  1~ 10까지 합을 구하시오! -->
	<c:forEach var="i4" begin="1" end="10">
		<c:set var="sum" value="${ sum = sum + i4}" />
	</c:forEach>

	<p>1 ~ 10까지 합: ${sum }</p>

	<!--  1~ 10까지 합을 구하시오! 
	 홀수의 개수를 출력!
	 복합 연산자랑 증감연산자는 jstl에서 이상하게
 	 동작하거나 아에 증감 연산자는 사용 안됨(에러발생) 
	-->
	<c:forEach var="i" begin="1" end="10">
		<c:if test="${ i % 2 == 1 }">
			<c:set var="cnt" value="${ cnt = cnt +1 }" />
		</c:if>
	</c:forEach>

	<p>홀수의 개수: ${ cnt }</p>
	

	<!--  구구단 출력하기  3단! 1~9까지 곱하기 -->
	<c:forEach var="i" begin="1" end="10">
 		${ i } <br>
	</c:forEach>

</body>
</html>