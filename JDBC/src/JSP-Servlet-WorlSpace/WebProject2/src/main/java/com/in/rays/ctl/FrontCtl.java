package com.in.rays.ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "*.do")
public class FrontCtl implements Filter  {


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response; 

		HttpSession session = req.getSession();
//		session.setMaxInactiveInterval(20);
		
		if(session.getAttribute("user") == null) {
			req.setAttribute("errorMsg", "your session is expire, please login agin");
			
			RequestDispatcher rb = req.getRequestDispatcher("LoginView.jsp");
			rb.forward(req, resp);
				
		}else {
		chain.doFilter(req, resp);
		}
	}

	@Override 
	public void destroy() {
		
	}
	

	


	

}
