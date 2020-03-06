<%@page import="com.dao.UserDao"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
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
		href="index" style="color: #00B242">Outreach</a>
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
	<div class="container container-width">

		<div class="collapse multi-collapse" id="multiCollapseExample1" style="margin-bottom: 15px;">
			<form:form action="viewEvents" method="get" modelAttribute="eventModel">
				<div class="form-row d-flex justify-content-between">

					<span class="form-group row">

						<label class="col-sm-2 col-form-label" for="activity">Activity
						</label>
						<div class="col-sm-10">
							<form:select class="form-control mb-2" style="margin-left: 20px;"
								placeholder="Select an activity" path="activity" name="activity" id="activity">
								<form:option value="">Select Activity</form:option>
								<form:options items="${activityList}"></form:options>

							</form:select>
						</div>
					</span>


					<span class="form-group row">
						<label class="col-sm-2 col-form-label" for="place">Place</label>
						<div class="col-sm-7">
							<form:input class="form-control mb-2" path="place" name="place" />
						</div>
					</span>
					<span>
						<input class="btn btn-secondary btn-sm" type="submit" value="Filter"></span>
				</div>
			</form:form>
		</div>


		<div class="d-flex justify-content-between">
			<span>
				<h2 style="margin-bottom: 20px;">Event List</h2>
			</span>
			<span>
				<span>
					<a class="btn btn-primary btn-sm" data-toggle="collapse" href="#multiCollapseExample1" role="button"
						aria-expanded="false" aria-controls="multiCollapseExample1">Filter</a>
				</span>
				<c:if test='${!userRole.equalsIgnoreCase("Admin")}'>

					<span>
						<a class="btn btn-primary btn-sm" href="/yourEvents?userId=${user.id}">Your events</a>
					</span>
				</c:if>
				<c:if test='${userRole.equalsIgnoreCase("Admin")}'>
					<span>
						<a class="btn btn-primary btn-sm" href="/createEvent">Create Event</a>
					</span>
				</c:if>
			</span>
		</div>
		<c:if test="${events.size()==0}">
			<h4>No Events Available</h4>
		</c:if>

		<c:forEach var="event" items="${events}">

			<div class="card" style="margin:1%">
				<div class="card-header d-flex justify-content-between" style="font-size: 20px;font-weight: bold;">
					<a href="viewEventDetails?eventId=${event.id}&userId=${user.id}">
						<c:out value="${event.activity}" />
					</a>
					<c:if test='${!userRole.equalsIgnoreCase("Admin")}'>
						<c:if test="${!event.volunteers.contains(userI)}">
							<a class="btn btn-success"
								href="subscribe?eventId=${event.id}&userId=${user.id}">Subscribe</a>
						</c:if>

						<c:if test="${event.volunteers.contains(userI)}">
							<a class="btn btn-danger" href="unsubscribe?eventId=${event.id}&userId=${user.id}">Un
								Subscribe</a>
						</c:if>
					</c:if>
				</div>
				<div class="card-body">
					<div style="display: flex; justify-content: space-between;">
						<span><span style="font-weight: bold;">
								Venue:
							</span>
							<c:out value="${event.place}" />
						</span>
						<span>
							<span style="font-weight: bold;">Date: </span>
							<fmt:formatDate value="${event.date}" pattern="dd MMM yyyy EEE" />
						</span>
						<span><span style="font-weight: bold;">No of Volunteers: </span>
							<c:out value="${event.volunteers.size()}" /></span>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>

		<nav class="navbar fixed-bottom navbar-expand-md navbar-dark"
			style="background-color: #0033A0;">
			<footer>
				<a href="#"
					style="float: right; margin-left: 750px; color: #00B242;">Back
					to top</a> &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Privacy</a>
				&middot; &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Terms</a>
			</footer>
		</nav>
</body>

</html>