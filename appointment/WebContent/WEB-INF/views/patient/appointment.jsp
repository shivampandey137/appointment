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
<h1 align="center">Appointment Form</h1>>
<%-- <sf:form modelAttribute="appointment" method="post">--%>
<form method="post">
<table style="background-color: pink; margin: auto;">
	 <tr>
	<td>Enter Appointment Date</td>
	<td><input type="text" name="date" placeholder="DD-MM-YYYY"></td>
	<%-- <td><sf:input path="date" type="date" /></td>
	<td><sf:errors path="Adate" /></td>  --%>
	</tr>
	 
	
	<tr>
	<td>Enter Appointment Time</td>
	<td><input type="text" name="time" placeholder="hh:mm:ss"></td>
	<%-- <td><sf:input type="time" path="time" /></td>
	<td><sf:errors path="time" /></td>  --%>
	</tr>
	
	<tr>
	<td>
	<input type="submit" value="Take appointment">	</td>
	</tr>
</table>
</form>
</body>
</html>
	
