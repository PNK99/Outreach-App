<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Event List</h2>
	<c:forEach var="event" items="${events}">
		<c:out value="${event.activity}" /> 
		<c:out value="${event.place}"/>
		<c:out value="${event.date.toString().substring(0,10)}"/>
		<a href="join/${event.id}">Join</a>
	</c:forEach>
</body>
</html>