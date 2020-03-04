<%@page import="com.dao.UserDao"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Event List</h2>
	
	<table border="1">
	<tr><th>Activity</th>
		<th>Location</th>
		<th>Date</th>
		<th></th>
	
	<c:forEach var="event" items="${events}">
<tr>
		<td><c:out value="${event.activity}" /></td>
		<td><c:out value="${event.place}" /></td>
		<td><fmt:formatDate value="${event.date}" pattern="dd-MM-yyyy EEE"/></td>
		<td><c:if test="${!event.volunteers.contains(user)}">
			<a href="subscribe/${event.id}">Subscribe</a>
		</c:if>
		
		<c:if test="${event.volunteers.contains(user)}">
			<a href="unsubscribe/${event.id}">UnSubscribe</a>
		</c:if>
		
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>