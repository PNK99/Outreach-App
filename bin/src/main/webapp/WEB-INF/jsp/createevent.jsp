<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="event" action="createdEvent" method="post">

Activity<form:select items="${activityList}" path="activity"></form:select>
Place<form:input path="place"/><br><br>
Date<form:input type="date" path="date"/><br><br> 
Contact number<form:input path="contactNumber"/><br><br>
Description<form:textarea path="description"/>
Do's and Dont's<form:textarea path="DosAndDonts"/><br><br>
Donation amount<form:input path="donationAmount"/><br><br>

<input type="submit" value="create">
</form:form>
</body>
</html>