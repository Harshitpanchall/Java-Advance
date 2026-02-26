<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h1 align="center">Login Form</h1>

	<form action="LoginCtl" method="post">

		<table>

			<tr>
				<th>id</th>
				<td><input type="email" value="" name="id"
					placeholder="enterId"></td>
			</tr>

			<tr>
				<th>password</th>
				<td><input type="password" value="" name="password"
					placeholder="enterpassword"></td>
			</tr>

			<tr>
				<th>newpassword</th>
				<td><input type="password" value="" name="newpassword"
					placeholder="newpassword"></td>
			</tr>
			
			<tr>
				<th>confirmpassword</th>
				<td><input type="password" value="" name="confirmpassword"
					placeholder="confirmpassword"></td>
			</tr>
			
		<tr>
			<th></th>
			<td><input type="submit" value="save"></td>
			</tr>

		</table>
	</form>
	</div>
</body>
</html>