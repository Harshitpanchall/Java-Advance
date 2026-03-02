<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notification</title>

<style>
.footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: black;
	text align: color;
	padding: 10px;
}
</style>
</head>
<body>

	<%@ include file="Header.jsp"%>
	<%
	String smsg = (String) request.getAttribute("sucessMsg");
	String emsg = (String) request.getAttribute("errorMsg");
	%>
	 

	<div align="center">
		<h1 style="color: red" align="center">Notification</h1>
		
		<h3 style="color: green"><%= smsg != null ? smsg : ""%></h3>
		<h3 style="color: red"><%= emsg != null ? emsg : ""%></h3>

		<form action="NotificationCtl" method="post">

			<table>

				<tr>
					<th>NotificationCode</th>
					<td><input type="text" value="" name="NotificationCode"
						placeholder=" enter code"></td>
				</tr>


				<tr>
					<th>Message</th>
					<td><input type="text" value="" name="Message"
						placeholder=" enter message"></td>
				</tr>


				<tr>
					<th>Sent</th>
					<td><input type="text" value="" name="Sent"
						placeholder="enter send"></td>
				</tr>


				<tr>
					<th>Date</th>
					<td><input type="date" value="" name="Date"
						style="width: 97%;"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="save" name="sumbit"></td>
				</tr>

			</table>
		</form>

	</div>

	<div class="footer">
		<%@ include file="Footer.jsp"%>
	</div>

</body>
</html>