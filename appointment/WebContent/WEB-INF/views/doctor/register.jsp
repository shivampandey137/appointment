<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{
background-image:url('img_girl.jpg');
}
</style>
<body>
	<sf:form method="post" modelAttribute="docter">

		<table style="background-color: cyan; margin: auto;">
			
			<tr>
				<td>Enter Doctor Name</td>
				<td><sf:input path="Dname" /></td>
				<td><sf:errors path="Dname" /></td>
			</tr>
			<br>
			</br>
			<tr>
				<td>Enter Doctor Gender</td>
				<td><sf:input path="Gender" /></td>
				<td><sf:errors path="Gender" /></td>
			</tr>
			<br>
			</br>
			<tr>
				<td>Enter Qualification</td>
				
				<td><sf:input path="Qualification" /></td>
				<td><sf:errors path="Qualification" /></td>
			</tr>
			<br>
			</br>
			
			<tr>
				<td>Enter Specialization</td>
				
				<td><sf:input path="Specialization" /></td>
				<td><sf:errors path="Specialization" /></td>
			</tr>
			<br>
			</br>
			
			<tr>
				<td>Enter Doctor address</td>
			
				<td><sf:input path="Daddress" /></td>
				<td><sf:errors path="Daddress" /></td>
				
			</tr>
			<br>
			</br>
			<tr>
				<td>Enter PhoneNumber </td>
				<td><sf:input path="PhoneNumber" /></td>
				<td><sf:errors path="PhoneNumber" /></td>
				
			</tr>
			<br>
			</br>
			
			<tr>
				<td>Enter EmailId </td>
				<td><sf:input path="EmailId" /></td>
				<td><sf:errors path="EmailId" /></td>
				
			</tr>
			<br>
			</br>
			
			
			<tr>
				<td>Enter password </td>
				<td><sf:input path="password" /></td>
				<td><sf:errors path="password" /></td>
				
				
			</tr>
			<br>
			</br>
			

			<tr>
				<td><input type="submit" value="Register New docter" /></td>


			</tr>
			</br>
			<br>
		</table>
	
</sf:form>
</body>
</html>