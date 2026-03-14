package com.in.rays.Cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/GetSession")
public class GetCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();
		for (int i = 0; i <= cookies.length; i++) {

			Cookie c = cookies[1];

			String name = req.getParameter("name");
			String value = req.getParameter("value");

			System.out.println("name " + name);
			System.out.println("value" + value);

		}
	}

}
