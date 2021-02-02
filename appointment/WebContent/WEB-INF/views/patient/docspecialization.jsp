<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="background-color: pink; margin: auto;">
<tr>
				<td>${sessionScope.patient_dtls.PName}</td>
			 	<td>${sessionScope.patient_dtls.emailId}</td> 
				<td>${sessionScope.patient_dtls.PAddress}</td>
				<td>${sessionScope.patient_dtls.phoneNumber}</td>
				<td>${sessionScope.patient_dtls.gender}</td> 

</tr>
</table>
<table border="1" style="background-color: cyan; margin: auto;">
<tr>
				<td>${requestScope.Apt_details.date}</td>
				<td>${requestScope.Apt_details.time}</td>
</tr>
</table>
<h4>
		<a href='<spring:url value='/patient/delete?aid=${requestScope.Apt_details.AID}'/>'>Delete Appointment</a>
</h4>
</body>
</html>