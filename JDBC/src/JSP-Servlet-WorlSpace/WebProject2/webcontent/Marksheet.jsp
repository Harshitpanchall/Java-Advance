<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marksheet</title>

<style>
.footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: black;
	text align: center;
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
		<h1 style="color: red">Result</h1>
	</div>

	<div align="center">

		<h3 style="color: green"><%=smsg != null ? smsg : ""%></h3>
		<h3 style="color: red"><%=emsg != null ? emsg : ""%></h3>

		<form action="MarksheetCtl" method="post">

			<table>

				<tr>
					<th>Name</th>
					<td><input type="text" value="" name="Name"
						placeholder="enter name"></td>
				</tr>

				<tr>
					<th>Roll</th>
					<td><input type="text" value="" name="Roll"
						placeholder="enter roll"></td>
				</tr>

				<tr>
					<th>Maths</th>
					<td><input type="text" value="" name="Maths"
						placeholder="maths number"></td>
				</tr>

				<tr>
					<th>Phy</th>
					<td><input type="text" value="" name="Phy"
						placeholder="phy number"></td>
				</tr>

				<tr>
					<th>Hin</th>
					<td><input type="text" value="" name="Hin"
						placeholder="hin number"></td>
				</tr>


				<tr>
					<th></th>
					<td><input type="submit" value="save"></td>
				</tr>
			</table>
		</form>
	</div>

	<div class="footer">
		<%@ include file="Footer.jsp"%>
	</div>
</body>
</html>