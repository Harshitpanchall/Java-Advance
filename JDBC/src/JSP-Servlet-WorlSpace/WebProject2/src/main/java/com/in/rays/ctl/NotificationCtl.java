package com.in.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in.rays.bean.NotificationBean;
import com.in.rays.model.NotificationModel;

@WebServlet("/NotificationCtl")
public class NotificationCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rb = req.getRequestDispatcher("Notification.jsp");
		rb.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		NotificationBean bean = new NotificationBean();
		NotificationModel model = new NotificationModel();
		
		String NotifiactionCode = req.getParameter("NotificationCode");
		String Message = req.getParameter("Message");
		String Sent = req.getParameter("Sent");
		String Date = req.getParameter("Date");
		
		try {
			bean.setNotificationCode(NotifiactionCode);
			bean.setMessage(Message);
			bean.setSentTo(Sent);
			bean.setDob(sdf.parse(Date));
			
			model.add(bean);
			req.setAttribute("sucessMsg",  "notification is send");
		}catch(Exception e) {
			req.setAttribute("errorMsg", e.getMessage());
		}
		
		RequestDispatcher rb = req.getRequestDispatcher("Notification.jsp");
		rb.forward(req, resp);
	}

}
