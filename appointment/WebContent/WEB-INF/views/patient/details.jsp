<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>details</title>
</head>
<body>
	<h4>Hello</h4>
	<h4>you registered sucessfully....</h4>
	
	
	<h4>
		<a href="<spring:url value='/patient/logout'/>">Log Me Out</a>
	</h4>
</body>

</html>