package com.in.rays.Controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rb = req.getRequestDispatcher("LoginView.jsp");
		rb.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do post is sucessfull");
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String newpassword = req.getParameter("newpassword");
		String confirmpassword = req.getParameter("confirmpassword");
		
		
		System.out.println(id);
		System.out.println(password);
		System.out.println(newpassword);
		System.out.println(confirmpassword);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
	}

}
