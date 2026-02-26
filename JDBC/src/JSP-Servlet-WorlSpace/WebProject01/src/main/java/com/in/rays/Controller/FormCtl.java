package com.in.rays.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormCtl") // url mapping is define
public class FormCtl extends HttpServlet { // ye ek servlet class haio jo http mathod ko extends karta ha
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("FormVew.jsp"); /// doget is default 
		rd.forward(req, resp);/// formview.jsp forword karne ka kam karta ha
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do in  post......................");

		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		
		System.out.println(firstname);
		System.out.println(lastname);
		RequestDispatcher rd = req.getRequestDispatcher("FormVew.jsp"); /// one page to anotherpage is forward
		rd.forward(req, resp);
		
	}
		
	}


