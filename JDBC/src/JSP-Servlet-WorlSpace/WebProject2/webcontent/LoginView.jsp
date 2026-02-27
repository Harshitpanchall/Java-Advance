<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<style>
.footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	text-align: center;
	background-color: black;
	padding: 10px;
}
</style>
</head>

<body>
	<%@include file="Header.jsp"%>

	
	<div align = "center">
	<h1 style="color:red;">Login Id</h1>
	<form action="LoginCtl" method = "post">
	<table>
			<tr>
				<th>id</th>
				<td><input type="email" value="" name="id" placeholder="enter id"></td>
			</tr>

			<tr>
				<th>password</th>
				<td><input type="password" value="" name="password"
					placeholder="enter password"></td>
			</tr>
			
			<tr>
			<th></th>
			<td><input type ="submit" value = "save"></td>
			</tr>

		</table>
		</div>
		</form>

	<div class="footer">
		<%@ include file="Footer.jsp"%>
	</div>

</body>
</html>