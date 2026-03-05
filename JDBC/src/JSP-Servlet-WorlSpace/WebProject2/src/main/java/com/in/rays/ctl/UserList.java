package com.in.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in.rays.bean.UserBean;
import com.in.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserList extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<UserBean> list = null;
		
		UserModel model = new UserModel();
		
		try {
			list = model.search(null);
			req.setAttribute("list", list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rb = req.getRequestDispatcher("UserList.jsp");
		rb.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rb = req.getRequestDispatcher("UserList.jsp");
		rb.forward(req, resp);
		
	}
	

}
