<%@page import="service.SelectService"%>
<%@page import="dto.GuestbookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// list.jsp에서 버튼을 클릭했을 때
	// 수정이든 삭제든 selectByIdx.jsp에서
	// 데이터를 받는다. 
	
	request.setCharacterEncoding("UTF-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	String job = request.getParameter("job");
	
	// 수정 또는 삭제할 글 1건을 얻어온다.
	GuestbookDTO vo = SelectService
					 .getInstance()
					 .selectByIdx(idx);
	
	out.println(vo);
	if( vo == null){
		//데이터가 없기 때문에 수정 또는 삭제할 
		// 글이 테이블에 존재하지 않으면 에러메시지를
		// 출력하고 listPro.jsp 페이지 이동
	}else{
		//데이터 있으면!
		request.setAttribute("vo", vo);
		pageContext.forward(job + ".jsp");
	}
					
	
%>





