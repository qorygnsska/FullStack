package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.service.MvcService;


public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MvcService service = MvcService.getInstance();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servlet(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servlet(request, response);
	}
	
	
	protected void servlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html; charset=UTF-8");
		 
		 String url = request.getRequestURI();
		 String contextPath = request.getContextPath();
		 String context = url.substring(contextPath.length());
		 
		 String viewpage = "/WEB-INF/";
		 switch (context) {
			
		case "/list.do":
			viewpage += "list";
			break;
			

		default:
			break;
		}
		viewpage += ".jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		dis.forward(request, response);
	}

}
