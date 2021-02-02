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
	<h3> ${requestScope.mesg}</h3>
	<table style="background-color: cyan; margin: auto;" border="1">

		<caption>Doctor List</caption>
		<c:forEach var="d" items="${sessionScope.Doctor_list}">
			<tr>
			<td>${d.dname}</td>
			<td>${d.qualification}</td> 
			<td>${d.specialization}</td>
			 <td>${d.daddress}</td>
			<td>${d.phoneNumber}</td>
			<td>${d.emailId}</td>
			<td>${d.gender}</td>
			<td><a href="<spring:url value='/patient/appointment?Did=${d.DId}'/>">Take Appointment</a></td>
			</tr>
		</c:forEach>
	</table>
	<%-- <a href="<spring:url value='/doctor/register'/>">Add New doctor</a>
	<h4>
		<a href="<spring:url value='/doctor/logout'/>">Log Me Out</a>
	</h4> --%>
</body>
</html>