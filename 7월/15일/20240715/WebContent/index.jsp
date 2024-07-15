<%@page import="service.MvcBoardService"%>
<%@page import="dto.MvcBoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스 세팅!</title>
</head>
<body>
	<%
		// MvcBoardService 클래스 호출
		ArrayList<MvcBoardDTO> list = MvcBoardService.getInstance().selectAll();
	
		// EL 태그 사용하려면 내장객체에 저장해야됨
		request.setAttribute("list", list);
		
		
		// 데이터의 개수를 반환해서 출력하는 명령문
		// 1. 데이터베이스 접근을 위해서 연결정보 가져오기 MvcBoardService
		// 2. count 메서드를 생성
		// 3. mapper 가져오고 dao 호출하기
		// 4. xml 파일과 연결할 id값 생성
		// 5. xml에 있는 sql 실행하고
		// 6. 결과를 리턴 받아서 EL 태그 사용하려면 내장객체 저장!!
		int count = MvcBoardService.getInstance().count();
		
		request.setAttribute("count", count);
		
		
		// 한 건 조회
		// 1. 글 번호를 알아야된다.
		// 2. Service클래스로 넘긴다
		// 3. 디비 연결 정보 가져오고, dao 호출
		// 4. dao, xml 파일을 호출
		// 5. sql문이 실행
		// 6. dao한테 결과 전송
		// 7. index.jsp로 리턴
		// 8. 내장객체에 저장해서 출력
		MvcBoardDTO dto = MvcBoardService.getInstance().selectByIdx(26);
		
		request.setAttribute("dto", dto);
		
		
		// 한 건 수정하기
		// 1. 수정할 subject 제목, content 내용 저장하기
		// 2. Service클래스로 제목과 내용 보내기
		// 3. 디비 정보 가져오고 dao 호출
		// 4. dao에서 sql호출(id값 생성)
		// 5. sql 실행하면 결과
		// 6. service 수정된 dto 가져오기
		// 7. index.jsp 로 리턴
		// 8. 결과를 내장객체에 저장하기
		
		// 마이바티스에서 변수값을 사용하려면
		// #{변수명}
		MvcBoardDTO updateDTO = MvcBoardService.getInstance().update(25, "이제 점심", "집에 가고싶다");
		
		request.setAttribute("updateDTO", updateDTO);
		
		// 1. update시 기존 내용이 사라짐
		//    기존에 내용은 있고 새로운 내용만 추가하기
		//    객체를 복사! setter/getter 이용해서
		// 2. 삭제
		// 3. 페이징처리!
	%>
	
	<h2>한 건 수정하기</h2>
	<p>${updateDTO}</p>
	
	
	<h2>한 건 조회</h2>
	<p>${dto}</p><br><br>
	
	
	<%-- ${list} --%>
	<p>데이터의 총 개수 : ${count}</p>
	
	<%--
		마이바티스(Mybatis)
		 - 자바객체 간의 매핑 지원한다.
		 - sql 쿼리를 좀 더 쉽게 관리할 수 있도록
		   분리시키고 자동으로 매칭시켜주는 것!
		 
		 - 동적 쿼리문 지원
		   쿼리문 자체에 if, foreach 지원 
		   
		 - 마이바티스 설정
		   1. DB 연결 정보 파일!
		   2. sql문 저장하는 파일!
		   3. config 파일
		   4. 위에 내용을 객체로 생성하는 자바파일!
	 --%>
</body>
</html>