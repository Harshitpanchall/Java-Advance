<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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
	List<UserBean> list = (List<UserBean>) request.getAttribute("list");
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1 style="color: red">User List</h1>

		<form>
			<table border="1px" width="80%">

				<tr style="color: skyblue">
					<th>Id</th>
					<th>First</th>
					<th>Last</th>
					<th>Login</th>
					<th>Password</th>
					<th>Dob</th>
				</tr>

				<%
				Iterator<UserBean> it = list.iterator();

				while (it.hasNext()) {
					UserBean bean = it.next();
				%>

				<tr align="center">
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstname()%></td>
					<td><%=bean.getLastname()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getDob()%></td>
				</tr>


				<%
				}
				%>


			</table>
		</form>

	</div>

</body>
</html>