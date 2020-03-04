<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Outreach</h1>
	<form:form action="upCheck" method="POST" modelAttribute="user">

		<%-- 	UserRole:<form:select path="userRole">
    <form:options items="${type}"></form:options>
    </form:select>
    <form:errors path="userRole" ></form:errors>
		<br><br>
     --%>
    User Id:&nbsp&nbsp&nbsp&nbsp<form:input path="userId" type="text" />
		<form:errors path="userId"></form:errors>
		<br>
		<br>
    
    Password:&nbsp&nbsp&nbsp&nbsp<form:input path="password"
			type="password" />
		<form:errors path="password"></form:errors>
		<br>
		<br>
		<input type="submit" value="Login" />&nbsp&nbsp&nbsp&nbsp
    <a href="signUp">Sign Up</a>

	</form:form>
</body>
</html>