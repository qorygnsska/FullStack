package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.service.MemberService;

public class MainController extends
						HttpServlet{
	

	private MemberService service = 
			MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestPro(req,resp);
	}
	
	protected void requestPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String context = url.substring(contextPath.length());	
		
		String viewPage = "/WEB-INF/";
		
		System.out.println(context);
		switch (context) {
		case "/insertForm.do":
			viewPage += "InsertForm";
			break;
		case "/emailCheck.do":
			service.emailCheck(req, resp);
			return;
	
		default:
			break;
		}
		viewPage += ".jsp";
		
		req.getRequestDispatcher(viewPage)
		   .forward(req, resp);
		
	}
}




