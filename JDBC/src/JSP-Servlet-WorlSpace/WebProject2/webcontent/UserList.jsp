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
	String smsg = (String) request.getAttribute("successMsg");
	String emsg = (String) request.getAttribute("errorMsg");
	int index = 1;
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1 style="color: red">User List</h1>
             
             <h3 style = "color: green"><%=smsg != null ? smsg : ""%></h3>
             <h3 style = "color: red"><%=emsg != null ? emsg : ""%></h3>

		<form action = "UserListCtl.do" method = "post">
		
		<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstname" value=""
						placeholder="search by firstName"></td>
					<th>Last Name</th>
					<td><input type="text" name="lastname" value=""
						placeholder="search by lastName"></td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
			
			<table border="1px" width="100%">

				<tr style="background-color: skyblue">
				     <th>Select</th>
					<th>S.No.</th>
					<th>First</th>
					<th>Last</th>
					<th>Login</th>
					<th>Password</th>
					<th>Dob</th>
					<th>Edit</th>
				</tr>

				<%
				Iterator<UserBean> it = list.iterator();

				while (it.hasNext()) {
					UserBean bean = it.next();
				%>

				<tr align="center">
				     <td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getFirstname()%></td>
					<td><%=bean.getLastname()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getDob()%></td>
					<td><a href="UserCtl.do?id=<%=bean.getId()%>">Edit</a></td>
					
				</tr>


				<%
				}
				%>
			</table>
			
			<br>
			<table width="100%">
				<tr>
					<td align="center"><input type="submit" name="operation"
						value="delete"></td>
				</tr>
			</table>
			
		</form>

	</div>

</body>
</html>