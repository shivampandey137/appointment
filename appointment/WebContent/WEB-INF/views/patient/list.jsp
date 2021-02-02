<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Last Action Status : ${requestScope.mesg}</h3>
	<table style="background-color: cyan; margin: auto;" border="1">

		<caption>Patient List</caption>
		<c:forEach var="p" items="${requestScope.Patient_list}">
			<tr>
				<td>${p.PName}</td>
			 	<td>${p.emailId}</td> 
				<td>${p.PAddress}</td>
				<td>${p.phoneNumber}</td>
				<td>${p.gender}</td>
				<td><a href="<spring:url value='/patient/update?vid=${P.PId}'/>">Update</a></td>
				<td><a href="<spring:url value='/patient/delete?vid=${P.PId}'/>">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<a href="<spring:url value='/patient/register'/>">Add New Patient</a>
	<h4>
		<a href="<spring:url value='/patient/logout'/>">Log Me Out</a>
	</h4>
</body>
</html>