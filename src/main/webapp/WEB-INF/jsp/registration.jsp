<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<style>
.container-width {
	max-width: 75%;
	padding: 5%;
}
</style>

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #0033A0;">
		<a class="navbar-brand" href="#">OutReach</a>
	</nav>

	<div class="container container-width">

		<h2 style="margin-bottom: 20px;">Sign Up</h2>

		<form:form action="valid" method="POST" modelAttribute="user">



			<div class="form-group">
				<label for="userRole">User Role</label>
				<form:select class="form-control" path="userRole" name="userRole"
					id="userRole">
					<form:options items="${type }"></form:options>
				</form:select>
				<form:errors path="userRole" />
			</div>

			<div class="form-row">

				<div class="form-group col-md-6">
					<label for="firstName">First Name</label>
					<form:input class="form-control" path="firstName" id="firstname"
						name="firstname" />
					<form:errors path="firstName" />
				</div>

				<div class="form-group col-md-6">
					<label for="lastName">Last Name</label>
					<form:input class="form-control" path="lastName" id="lastName"
						name="lastName" />

					<form:errors path="lastName" />

				</div>

			</div>

			<div class="form-row">

				<div class="form-group col-md-6">
					<label for="age">Age</label>
					<form:input class="form-control" path="age" id="age" name="age" />

					<form:errors path="age" />

				</div>

				<div class="form-group col-md-6">
					<label for="gender">Gender</label> <br>
					<div class="form-check form-check-inline">
						<form:radiobutton class="form-check-input" path="gender"
							name="gender" id="gender1" value="Male" />
						<label class="form-check-label" for="gender1">Male</label>
					</div>

					<div class="form-check form-check-inline">
						<form:radiobutton class="form-check-input" path="gender"
							name="gender" id="gender2" value="Female" />
						<label class="form-check-label" for="gender2">Female</label>
					</div>

					<form:errors path="gender" />

				</div>

			</div>

			<div class="form-group">
				<label for="contactNumber">Contact Number</label>

				<form:input class="form-control" path="contactNumber"
					id="contactNumber" name="contactNumber" />


				<form:errors path="contactNumber" />

			</div>

			<div class="form-group">
				<label for="userId">User Id</label>

				<form:input class="form-control" path="userId" id="userId"
					name="userId" />

				<form:errors path="userId" />
			</div>

			<div class="form-group">
				<label for="password">Password</label>

				<form:input class="form-control" type="password" path="password"
					id="password" name="password" />

				<form:errors path="password" />

			</div>

			<input class="btn btn-success" style="background-color: #00B242;"
				type="submit" value="Register" />

		</form:form>
	</div>
</body>
</html>