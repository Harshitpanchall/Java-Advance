<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<%
	String smsg = (String) request.getAttribute("successMsg");
	String errorMsg = (String) request.getAttribute("errorMsg");
	%>
	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1 style= "color: red">Login</h1>

		<%
		if (smsg != null) {
		%>
		<h3 style="color: green"><%=smsg%></h3>
		<%
		}
		%>

		<%
		if (errorMsg != null) {
		%>
		<h3 style="color: red"><%=errorMsg%></h3>
		<%
		}
		%>

		<form action="LoginCtl" method="post">

			<table>
				<tr>
					<th>Login:</th>
					<td><input type="email" name="Login" value=""
						placeholder="enter your login"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value = "signIn"></td>
				</tr>

			</table>

		</form>

	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>