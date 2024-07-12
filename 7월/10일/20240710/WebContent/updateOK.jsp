<%@page import="service.UpdateService"%>
<%@page import="service.SelectService"%>
<%@page import="dto.GuestbookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="vo" class="dto.GuestbookDTO">
	<jsp:setProperty name="vo" property="*" />
</jsp:useBean>

<%
	// 수정할 글의 비밀번호와 수정하기 위해 입력한
	// 비밀번호를 비교하기 위해서 수정할 글을 얻어온다.

	GuestbookDTO original = SelectService.getInstance().selectByIdx(vo.getIdx());

	// oracle을 필드 선언시 데이터타입을 char로
	// 선언하면 필등의 크기보다 입력된 문자의 크기가 
	// 적을 때 남는 자리가 모두 공백으로 리턴된다.
	// 테이블 설계시 char 대신 varchar2로 선언
	// 하는것이 좋다!
	out.println("<script>");
	if (original.getPassword().trim().equals(vo.getPassword())) {
		// 1. 비밀번호 확인 후 일치하면 
		//    Service보내기 
		UpdateService.getInstance().update(vo);
		// 2. 정상적으로 서비스 실행됬다면 
		//    alert()창으로 수정이 완료 되었습니다.
		//    출력하기
		out.println("alert('" + original.getIdx() + "번 글 수정완료!')");
	} else {
		// 비밀번호가 오류 이면 오류 메시지를 출력한다.
		out.println("alert('비밀번호가 일치하지 않습니다.')");
	}
	out.println("location.href='listPro.jsp'");
	out.println("</script>");
%>