package com.in.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in.rays.bean.MarksheetBean;
import com.in.rays.model.MarksheetModel;

@WebServlet("/MarksheetCtl")
public class MarksheetCtl extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher rb = request.getRequestDispatcher("Marksheet.jsp");
	rb.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post is sucessfull");
		
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		
		String Name = request.getParameter("Name");
		String Roll = request.getParameter("Roll");
		String Maths = request.getParameter("Maths");
		String Phy = request.getParameter("Phy");
		String Hin = request.getParameter("Hin");
		
		try {
			bean.setName(Name);
			bean.setRoll(Integer.parseInt(Roll));
			bean.setMaths(Integer.parseInt(Maths));
			bean.setPhy(Integer.parseInt(Phy));
			bean.setHin(Integer.parseInt(Hin));
			
			model.add(bean);
			request.setAttribute("sucessMsg", "result is insert sucessfull");
		}catch(Exception e)  {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
			
		}
		
		RequestDispatcher rb = request.getRequestDispatcher("Marksheet.jsp");
		rb.forward(request, response);

	}
}
