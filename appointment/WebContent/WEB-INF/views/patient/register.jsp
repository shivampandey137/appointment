<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sf:form method="post" modelAttribute="patient">

		<table style="background-color: cyan; margin: auto;">
			
			<tr>
				<td>Enter Patient Name</td>
				<td><sf:input path="PName" /></td>
				<td><sf:errors path="PName" /></td>
				
			</tr>
			
			<tr>
				<td>Enter Gender</td>
				<td><sf:input path="Gender" /></td>
				<td><sf:errors path="Gender" /></td>
				
				
			</tr>
			
			<tr>
				<td>Enter Patient Address</td>
				<td><sf:input path="PAddress" /></td>
				<td><sf:errors path="PAddress" /></td>
				
				
				
			</tr>
			
			
			<tr>
				<td>Enter PhoneNumber </td>
				<td><sf:input path="PhoneNumber" /></td>
				<td><sf:errors path="PhoneNumber" /></td>
				
				
			</tr>
			<tr>
				<td>Enter EmailId </td>
				<td><sf:input path="EmailId" /></td>
				<td><sf:errors path="EmailId" /></td>
				
			</tr>
			
			<tr>
				<td>Enter password </td>
				<td><sf:input path="password" /></td>
				<td><sf:errors path="password" /></td>
				
				
			</tr>

			<tr>
				<td><input type="submit" value="Register New patient" /></td>


			</tr>
		</table>
		</sf:form>
	



</body>
</html>