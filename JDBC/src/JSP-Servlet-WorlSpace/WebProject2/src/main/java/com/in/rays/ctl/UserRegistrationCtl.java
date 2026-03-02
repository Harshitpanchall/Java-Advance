package com.in.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in.rays.bean.UserBean;
import com.in.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rb = request.getRequestDispatcher("UserRegistrationView.jsp");
		rb.forward(request, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post is sucessfully console printed");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
        
	
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");

		try {
			bean.setFirstname(firstname);
			bean.setLastname(lastname);
			bean.setLogin(login);
			bean.setPassword(password);
		     bean.setDob(sdf.parse(dob));	
			
			model.add(bean);
			request.setAttribute("SuccessMsg","userRegistration sucessfully");
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}

		RequestDispatcher rb = request.getRequestDispatcher("UserRegistrationView.jsp");
		rb.forward(request, resp);

	}

}
