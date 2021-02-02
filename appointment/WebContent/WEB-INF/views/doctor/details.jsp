<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<table style="background-color: cyan; margin: auto;" border="1">

		<caption>Patient List</caption>
		<c:forEach var="d" items="${sessionScope.p_list}">
			<tr>
					<td>${d.PName}</td>
					<td>${d.gender}</td> 
					<td>${d.PAddress}</td>
					 <td>${d.phoneNumber}</td>
					<td>${d.emailId}</td>
					<td>${d.password}</td>
					<td>${d.PApt.date}</td>
					<td>${d.PApt.time}</td>
		
			</tr>
		</c:forEach>
</table>








<h4>
		<a href="<spring:url value='/patient/logout'/>">Log Me Out</a>
	</h4>
</body>
</html>