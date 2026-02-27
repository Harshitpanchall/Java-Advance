package com.in.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SQLOutputImpl;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rb = req.getRequestDispatcher("LoginView.jsp");
		rb.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
				
	      System.out.println(id);
		System.out.println(password);
		System.out.println("login page is run");
		
		RequestDispatcher rb = req.getRequestDispatcher("LoginView.jsp");
		rb.forward(req, resp);
	}

}
