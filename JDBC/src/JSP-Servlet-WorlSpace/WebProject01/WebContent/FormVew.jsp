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
		<h1>Form view</h1>
		<form action="FormCtl" method="Post">
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
					<th></th>

					<td><input type="submit" value="save"></td>
				</tr>
			</table>
		</form>

	</div>



</body>
</html>