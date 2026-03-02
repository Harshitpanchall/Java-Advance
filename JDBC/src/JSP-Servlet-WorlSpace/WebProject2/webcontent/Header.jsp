<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@page import="com.in.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	UserBean userBean = (UserBean) session.getAttribute("user");
	%>

	<%
	if (userBean != null) {
	%>

	<h3 style="color: green;"><%="Hii, " + userBean.getFirstname()%></h3>
	<a href="LoginCtl?operation=logout">Logout</a>
	
	<a href="MarksheetCtl">Result</a>
	<hr>

	<%
	} else {
	%>

	<h3 style="color: red;">Hii, guest</h3>

	<a href="index.jsp">Home | </a>
	<a href="LoginCtl">Login | </a>
	<a href="UserRegistrationCtl">SignIn | </a>
	<a href="WelcomeCtl">Welcome </a>
	<hr>
	<%
	}
	%>
</body>
</html>