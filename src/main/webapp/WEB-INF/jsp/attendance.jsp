<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Events</title>
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
	<header> <nav
		class="navbar navbar-expand-md navbar-dark fixed-top"
		style="background-color: #0033A0;"> <a class="navbar-brand"
		style="color: #00B242" href="/home">Outreach</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="home">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="#">${userRole}
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">${sessionScope.user.firstName}</a>
			</li>

		</ul>
		<form class="form-inline mt-2 mt-md-0" action="logout" method="get">
			<!-- style="margin-right:200px" -->
			<input class="form-control mr-sm-2" type="text" placeholder="Search">
			<button class="btn btn-outline-light" type="submit">Logout</button>
		</form>
	</div>
	</nav> </header>
	<br>
	<br>
	<div class="container container-width">
		<div class="collapse multi-collapse" id="multiCollapseExample1"
			style="margin-bottom: 15px;">
			<form:form action="volunteerAttendance" method="get"
				modelAttribute="userModel">
				<input type="hidden" name="eventId" value="${event.id}" />
				<div class="form-row d-flex justify-content-between">

					<span class="form-group row"> <label
						class="col-sm-2 col-form-label" for="activity">Name </label>
						<div class="col-sm-7">
							<form:input class="form-control mb-2" path="firstName"
								name="firstName" />
						</div>
					</span> <span class="form-group row"> <label
						class="col-sm-2 col-form-label" for="place">ID</label>
						<div class="col-sm-7">
							<form:input class="form-control mb-2" path="userId" name="userId" />
						</div>
					</span> <span> <input class="btn btn-secondary btn-sm"
						type="submit" value="Search"></span>
				</div>
			</form:form>
		</div>

		<div class="d-flex justify-content-between">
			<span>
				<h2 style="margin-bottom: 20px;">Subscribed Volunteers</h2>
			</span> <span> <a class="btn btn-primary btn-sm"
				data-toggle="collapse" href="#multiCollapseExample1" role="button"
				aria-expanded="false" aria-controls="multiCollapseExample1">Search</a>
			</span>
		</div>



		<form:form action="attendedVolunteers" method="post">
			<input type="hidden" name="eventId" value="${event.id}" />
			<ul class="list-group" style="margin-bottom: 15px;">
				<c:forEach var="u" items="${users}">
					<li class="list-group-item">
						<div>
							<c:if test="${event.voluteerPresent.contains(u)}">
								<input type="checkbox" name="present" value="${u.id}" checked>
							</c:if>
							<c:if test="${!event.voluteerPresent.contains(u)}">
								<input type="checkbox" name="present" value="${u.id}">
							</c:if>
							<c:out value="${u.firstName}" />
							<c:out value="${u.lastName}" />
							-
							<c:out value="${u.userId}" />
						</div>
					</li>

				</c:forEach>
			</ul>
			<input type="submit" class="btn btn-primary"
				value="Submit Attendence">

		</form:form>
	</div>


	<nav class="navbar fixed-bottom navbar-expand-md navbar-dark"
		style="background-color: #0033A0;"> <footer> <a
		href="#" style="float: right; margin-left: 750px; color: #00B242;">Back
		to top</a> &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Privacy</a>
	&middot; &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Terms</a>
	</footer> </nav>
</body>
</html>