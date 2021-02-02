<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="sf" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
<form >
<table style="background-color: cyan; margin: auto;">

<tr><td>
<h4><a href=home>Home</a>  |   <a href='<sf:url value="/doctor/dropdown"></sf:url>'>Doctor Specialization</a>   |   <a href='<sf:url value="/patient/logout"></sf:url>'>Logout</a>
</h4>
</td></tr>

</table>

</form>
</pre></body>
</html> 



