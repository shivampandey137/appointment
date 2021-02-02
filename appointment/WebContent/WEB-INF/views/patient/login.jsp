<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<h4 style="color: red;">${requestScope.mesg}</h4>
	<form  method="post">
	<h2 align="Center">Patient Login Form</h2>
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter Patient Mail</td>
				<td><input type="text" name="em" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" />
				<a href='<sf:url value="/patient/register"></sf:url>' >register</a></td>
			</tr>
		</table>
	</form>

</body>
</html>