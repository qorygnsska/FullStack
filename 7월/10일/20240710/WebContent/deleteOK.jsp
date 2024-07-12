<%@page import="service.DeleteService"%>
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
	// 삭제 할 글의 비밀번호와 삭제하기 위해 입력한 비밀
	// 번호 맞는지 비교!
	// 1. 기존 글 얻어오기
	GuestbookDTO original = SelectService.getInstance().selectByIdx(vo.getIdx());

	System.out.println(original);

	// 2. 비밀번호 비교	
	// 3. 비밀번호가 맞으면 DeleteService
	//    호출 
	// 4. 삭제가 되면 alert() 정상 삭제됨!
	//    삭제 안됬으면 alert() 삭제 안됨!에러!	
	// 5. listPro.jsp 
	//    게시글 전체를 조회해서 list.jsp에 출력

	out.println("<script>");
	if (original.getPassword().trim().equals(vo.getPassword())) {
		// 1. 비밀번호 확인 후 일치하면 
		//    Service보내기 
		DeleteService.getInstance().delete(vo.getIdx());

		// 2. 정상적으로 서비스 실행됬다면 
		//    alert()창으로 수정이 완료 되었습니다.
		//    출력하기
		out.println("alert('" + original.getIdx() + "번 글 삭제되었습니다!')");
	} else {
		// 비밀번호가 오류 이면 오류 메시지를 출력한다.
		out.println("alert('비밀번호가 일치하지 않습니다.')");
	}
	out.println("location.href='listPro.jsp'");
	out.println("</script>");
%>