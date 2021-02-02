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

<form  method="post" align="centre" >
	
	
	<h1 align ="center" style="Bold">Doctor Specialization</h1>	
		<select name ="doc">
		
		<c:forEach var="d" items="${requestScope.Doctor_list}">
		<center><option value='${d.specialization}'>${d.specialization}</option></center>
		</c:forEach>
		</select>
	<input type="submit" value="get Appointment">
	<%-- <a href="<spring:url value='/doctor/register'/>">Add New Patient</a>
	<h4>
		<a href="<spring:url value='/doctor/logout'/>">Log Me Out</a>
	</h4> --%>
</form>
</body>



</html>