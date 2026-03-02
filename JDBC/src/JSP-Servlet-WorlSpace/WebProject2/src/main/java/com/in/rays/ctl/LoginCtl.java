package com.in.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.in.rays.bean.UserBean;
import com.in.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");

		if (op != null) {
			HttpSession session = req.getSession();
			session.invalidate();
			req.setAttribute("sucessMsg", "sucessfull login");
		}

		RequestDispatcher rb = req.getRequestDispatcher("LoginView.jsp");
		rb.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String Login = request.getParameter("Login");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		try {
			bean = model.authenticate(Login, password);

			if (bean != null) {
				System.out.println("user login successfully");
				session.setAttribute("user", bean);
				response.sendRedirect("WelcomeCtl");
				return;
			} else {
				request.setAttribute("errorMsg", "invalid login or password");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);

	}

}