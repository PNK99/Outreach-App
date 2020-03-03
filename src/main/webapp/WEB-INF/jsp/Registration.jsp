<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>


	<form:form action="go" method="POST" modelAttribute="volunteer">
	
	
UserRole:<form:select path="userRole">
    <form:options items="${type }"></form:options>


</form:select>
		<form:errors path="userRole" ></form:errors>
		<br><br>
	
	


First Name:<form:input path="firstName" id="firstname" />
		<form:errors path="firstName" ></form:errors>
		<br><br>
		
		
Last Name:<form:input path="lastName" />
		<form:errors path="lastName"></form:errors>
		<br>
		<br>
Age:<form:input path="age" />
		<form:errors path="age"></form:errors>
		<br>
		<br>
Gender:<form:radiobutton path="gender" value="Male" />Male
       <form:radiobutton path="gender" value="Female" />Female<form:errors
			path="gender"></form:errors>
		<br>
		<br>
Contact Number:<form:input path="contactNumber" />
		<form:errors path="contactNumber"></form:errors>
		<br>
		<br>
Volunteer Id:<form:input path="volunteerId" />
		<form:errors path="volunteerId"></form:errors>
		<br>
		<br>
Password:<form:input path="password" />
		<form:errors path="password"></form:errors>
		<br>
		<br>
		
		<input type="submit" value="submit" />
	</form:form>
</body>
</html>