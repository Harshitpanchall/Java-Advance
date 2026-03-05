<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signin</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
	String smsg = (String) request.getAttribute("SuccessMsg");
	String emsg = (String) request.getAttribute("errorMsg");
	%>


	<div align="center">
		<h1 style="color: red">User Registration</h1>
		
		<h3 style="color: green"><%=smsg != null ? smsg : ""%></h3>
		<h3 style="color: red"><%=emsg != null ? emsg : ""%></h3>
		
		<form action="UserRegistrationCtl" method="post">

			<table>

				<tr>
					<th>firstname</th>
					<td><input type="text" value="" name="firstname"
						placeholder="enter firstname"></td>
				</tr>

				<tr>
					<th>lastname</th>
					<td><input type="text" value="" name="lastname"
						placeholder="enter lastname"></td>
				</tr>

				<tr>
					<th>login</th>
					<td><input type="email" value="" name="login"
						placeholder="login id"></td>
				</tr>

				<tr>
					<th>password</th>
					<td><input type="password" value="" name="password"
						placeholder="password"></td>
				</tr>

				<tr>
					<th>dob</th>
					<td><input type="date" value="" name="dob" style="width: 97%;"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="save" name="signUp"></td>
				</tr>

			</table>
		</form>
	</div>

	<div>
		<%@ include file="Footer.jsp"%>
	</div>
</body>
</html>