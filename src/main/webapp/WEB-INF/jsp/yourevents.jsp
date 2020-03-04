<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Your Event List</h2>
	<c:forEach var="event" items="${events}">
		<c:out value="${event.activity}" /> 
		<c:out value="${event.place}"/>
		<c:out value="${event.date.toString().substring(0,10)}"/>
	<a href="unsubscribe/${event.id}">UnSubscribe</a><br><br>
	</c:forEach>
</body>
</html>