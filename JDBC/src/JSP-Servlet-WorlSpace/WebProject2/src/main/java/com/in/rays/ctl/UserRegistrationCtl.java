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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rb = req.getRequestDispatcher("UserRegistrationView.jsp");
		rb.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post is sucessfully console printed");

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");

		try {
			bean.setId(6);
			bean.setFirstname(firstname);
			bean.setLastname(lastname);
			bean.setLogin(login);
			bean.setPassword(password);
			bean.setDob(sdf.parse(dob));
			
			model.add(bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rb = req.getRequestDispatcher("UserRegistrationView.jsp");
		rb.forward(req, resp);

	}

}
