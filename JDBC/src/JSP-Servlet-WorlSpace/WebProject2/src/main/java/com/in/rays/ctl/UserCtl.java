package com.in.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in.rays.bean.UserBean;
import com.in.rays.model.UserModel;


@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		String id = req.getParameter("id");
		if(id != null) {
			
			try {
				bean = model.findByPK(Integer.parseInt(id));
				req.setAttribute("bean", bean);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rb = req.getRequestDispatcher("User.jsp");
		rb.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserBean bean = new UserBean();
	UserModel model = new UserModel();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String op = req.getParameter("operation");
	
	String firstname = req.getParameter("firstname");
	String lastname = req.getParameter("lastname");
	String login = req.getParameter("login");
	String password = req.getParameter("password");
	String Dob = req.getParameter("Dob");
	
	
	try {
		
		bean.setFirstname(firstname);
		bean.setLastname(lastname);
		bean.setLogin(login);
		bean.setPassword(password);
		bean.setDob(sdf.parse(Dob));
		req.setAttribute("sucessMsg", "Saved UserList");
		
		if (op.equals("update")) {
			bean.setId(Integer.parseInt(req.getParameter("id")));
			model.update(bean);
			req.setAttribute("successMsg", "user updated successfully");
		} else {
			model.add(bean);
			req.setAttribute("successMsg", "user added successfully");
		}
	} catch (Exception e) {
		req.setAttribute("errorMsg", e.getMessage());
		e.printStackTrace();
	}
	
	RequestDispatcher rb = req.getRequestDispatcher("User.jsp");
	rb.forward(req, resp);

}
}
