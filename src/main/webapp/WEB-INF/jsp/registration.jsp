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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

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

	<header>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top"
			style="background-color: #0033A0;">
			<a class="navbar-brand" style="color: #00B242" href="/">Outreach</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">${userRole}
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">${sessionScope.user.firstName}</a>
					</li>

				</ul>
				<form class="form-inline mt-2 mt-md-0" action="logout" method="get">
					<!-- style="margin-right:200px" -->
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search">
					<button class="btn btn-outline-light" type="submit">Logout</button>
				</form>
			</div>
		</nav>
	</header>
	<br>
	<br>
	<div class="container container-width">

		<h2 style="margin-bottom: 20px;">Sign Up</h2>

		<form:form action="valid" method="POST" modelAttribute="user">



			<div class="form-group">
				<label for="userRole">User Role</label>
				<form:select class="form-control" path="userRole" name="userRole"
					id="userRole">
					<form:options items="${type }"></form:options>
				</form:select>
				<form:errors path="userRole" class="alert alert-danger" role="alert" />
			</div>

			<div class="form-row">

				<div class="form-group col-md-6">
					<label for="firstName">First Name</label>
					<form:input class="form-control" path="firstName" id="firstname"
						name="firstname" required="required" />
					<form:errors path="firstName" class="alert alert-danger"
						role="alert" />
				</div>

				<div class="form-group col-md-6">
					<label for="lastName">Last Name</label>
					<form:input class="form-control" path="lastName" id="lastName"
						name="lastName" required="required" />

					<form:errors path="lastName" class="alert alert-danger"
						role="alert" />

				</div>

			</div>

			<div class="form-row">

				<div class="form-group col-md-6">
					<label for="age">Age</label>
					<form:input class="form-control" path="age" id="age" name="age"
						required="required" />

					<form:errors path="age" class="alert alert-danger" role="alert" />

				</div>

				<div class="form-group col-md-6">
					<label for="gender">Gender</label> <br>
					<div class="form-check form-check-inline">
						<form:radiobutton class="form-check-input" path="gender"
							name="gender" id="gender1" value="Male" required="required" />
						<label class="form-check-label" for="gender1">Male</label>
					</div>

					<div class="form-check form-check-inline">
						<form:radiobutton class="form-check-input" path="gender"
							name="gender" id="gender2" value="Female" />
						<label class="form-check-label" for="gender2">Female</label>
					</div>

					<form:errors path="gender" class="alert alert-danger" role="alert" />

				</div>

			</div>

			<div class="form-group">
				<label for="contactNumber">Contact Number</label>

				<form:input class="form-control" path="contactNumber"
					id="contactNumber" name="contactNumber" required="required" />


				<form:errors path="contactNumber" class="alert alert-danger"
					role="alert" />

			</div>

			<div class="form-group">
				<label for="userId">User Id</label>

				<form:input class="form-control" path="userId" id="userId"
					name="userId" required="required" />

				<form:errors path="userId" class="alert alert-danger" role="alert" />
			</div>

			<div class="form-group">
				<label for="password">Password</label>

				<form:input class="form-control" type="password" path="password"
					id="password" name="password" required="required" />

				<form:errors path="password" class="alert alert-danger" role="alert" />

			</div>

			<input class="btn btn-success" style="background-color: #00B242;"
				type="submit" value="Register" />

		</form:form>
	</div>
	<nav class="navbar fixed-bottom navbar-expand-md navbar-dark"
		style="background-color: #0033A0;">
		<footer>
			<a href="#" style="float: right; margin-left: 750px; color: #00B242;">Back
				to top</a> &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Privacy</a>
			&middot; &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Terms</a>
		</footer>
	</nav>
</body>
</html>