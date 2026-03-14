<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<%
	String smsg = (String) request.getAttribute("sucessMsg");
	String emsg = (String) request.getAttribute("errorMsg");
	UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<div align="center">
		<h1><%=bean != null ? "Update User" : "Add User"%></h1>

		<h3 style="color: green"><%=smsg != null ? smsg : ""%></h3>
		<h3 style="color: red"><%=emsg != null ? emsg : ""%></h3>

		<form action="UserCtl.do" method="post">
			<input type="hidden" value="<%=bean != null ? bean.getId() : ""%>"
				name="id">

			<table>

				<tr>
					<th>firstname</th>
					<td><input type="text"
						value="<%=bean != null ? bean.getFirstname() : ""%>"
						name="firstname" placeholder="enter firstname"></td>
				</tr>

				<tr>
					<th>lastname</th>
					<td><input type="text"
						value="<%=bean != null ? bean.getLastname() : ""%>"
						name="lastname" placeholder="enter lastname"></td>
				</tr>

				<tr>
					<th>login</th>
					<td><input type="email"
						value="<%=bean != null ? bean.getLogin() : ""%>" name="login"
						placeholder="enter id"></td>
				</tr>

				<tr>
					<th>password</th>
					<td><input type="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						name="password" placeholder="password"></td>
				</tr>


				<tr>
					<th>Dob</th>
					<td><input type="date"
						value="<%=bean != null ? bean.getDob() : ""%>" name="Dob"
						style="width: 98%;"></td>
				</tr>
				<tr>


					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>