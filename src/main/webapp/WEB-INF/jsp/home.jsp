<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
body {
	padding-top: 3rem;
	padding-bottom: 3rem;
	color: #0033A0;
}

.carousel {
	margin-bottom: 4rem;
}

.carousel-caption {
	bottom: 3rem;
	z-index: 10;
}

.carousel-item {
	height: 32rem;
}

.carousel-item>img {
	position: absolute;
	top: 0;
	left: 0;
	min-width: 100%;
	height: 32rem;
}

.marketing .col-lg-4 {
	margin-bottom: 1.5rem;
	text-align: center;
}

.marketing h2 {
	font-weight: 400;
}

.marketing .col-lg-4 p {
	margin-right: .75rem;
	margin-left: .75rem;
}

.featurette-divider {
	margin: 5rem 0;
}

.featurette-heading {
	font-weight: 300;
	line-height: 1;
	letter-spacing: -.05rem;
}

@media ( min-width : 40em) {
	/* Bump up size of carousel content */
	.carousel-caption p {
		margin-bottom: 1.25rem;
		font-size: 1.25rem;
		line-height: 1.4;
	}
	.featurette-heading {
		font-size: 50px;
	}
}

@media ( min-width : 62em) {
	.featurette-heading {
		margin-top: 7rem;
	}
}

.btn-primary, .btn-primary:hover, .btn-primary:active, .btn-primary:visited,
	.btn-primary:focus {
	background-color: #00B242 !important;
	border-color: #00B242 !important;
}

.btn-secondary, .btn-secondary:hover, .btn-secondary:active,
	.btn-secondary:visited, .btn-secondary:focus {
	background-color: #0033A0 !important;
	border-color: #0033A0 !important;
}

#hideMe {
    -moz-animation: cssAnimation 0s ease-in 5s forwards;
    /* Firefox */
    -webkit-animation: cssAnimation 0s ease-in 5s forwards;
    /* Safari and Chrome */
    -o-animation: cssAnimation 0s ease-in 5s forwards;
    /* Opera */
    animation: cssAnimation 0s ease-in 5s forwards;
    -webkit-animation-fill-mode: forwards;
    animation-fill-mode: forwards;
}
@keyframes cssAnimation {
    to {
        width:0;
        height:0;
        overflow:hidden;
    }
}
@-webkit-keyframes cssAnimation {
    to {
        width:0;
        height:0;
        visibility:hidden;
    }
}
/* ul#tabs li.nav-item {
background: #3C75C3 url('/Outreach-App/src/person.png') no-repeat;
background-position: 7px center;
} */
</style>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
</head>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
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
		<c:if test='${!userRole.equalsIgnoreCase("Admin")}'>
				<ul class="navbar-nav mr-auto">
				 <li class="nav-item"><a class="nav-link" href="#">Notifications</a>
			</li>
			</ul> </c:if>&nbsp&nbsp
			<button class="btn btn-outline-light" type="submit">Logout</button>
		</form>
	</div>
	</nav> </header>
	<br>
	<br>
	<c:if test="${eventAddCheck}">

		<div id='hideMe'>
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong>Event added Successfully</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>
	
	
	
	<c:if test="${donation}">

		<div id='hideMe'>
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong>Donation amount added Successfully</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<c:if test="${suggestEventAddCheck}">

		<div id='hideMe'>
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<strong>Thank you for your suggestion. Your suggestion will
					be viewed and examined by the Admin.</strong>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>
	<div class="container horizontal-scrollable d-flex flex-row">
		<c:forEach var="event" items="${events}">

			<div class="card" style="margin: 1%">
				<div class="card-header d-flex justify-content-between"
					style="font-size: 20px; font-weight: bold;">
					<a href="viewEventDetails?eventId=${event.id}&userId=${user.id}">
						<c:out value="${event.activityType.name}" />
					</a>
				</div>
				<div class="card-body">
					<div class="d-flex flex-column">
						<div>
							<span style="font-weight: bold;"> Venue:<c:out
									value="${event.place}" />
							</span>
						</div>
						<div>
							<span style="font-weight: bold;">Date: <fmt:formatDate
									value="${event.date}" pattern="dd MMM yyyy EEE" /></span>
						</div>
						<div>
							<span style="font-weight: bold;">No of Volunteers: </span>
							<c:out value="${event.volunteers.size()}" />
						</div>
					</div>
				</div>
			</div>

		</c:forEach>

	</div>

	<c:choose>
	
		<c:when test='${userRole.equalsIgnoreCase("Admin")}'>
		
		
			<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3"
				style="margin-left: 110px;">
				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden"
					style="background-color: #0033A0;">
					<div class="my-3 p-3">
						<h2 class="display-5">Create Event</h2>
						<p class="lead">Used for Creation of an Event.</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-primary" href="createEvent"
							style="background-color: 00B242; margin-top: 130px">Create
							Event</a>
					</div>
				</div>
				
				
				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden"
					style="background-color: #00B242;">
					<div class="my-3 p-3">
						<h2 class="display-5">View Events</h2>
						<p class="lead">View Created/Upcoming Events.</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-secondary" href="viewEvents"
							style="background-color: 00B242; margin-top: 130px">View
							Event</a>
					</div>
				</div>
				
				
			</div>
			
			
			
			<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3"
				style="margin-left: 110px;">
				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden"
					style="background-color: #00B242;">
					<div class="my-3 p-3">
						<h2 class="display-5">View Suggestions</h2>
						<p class="lead">View Suggested Events</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-secondary" href="viewSuggestedEvents"
							style="background-color: 00B242; margin-top: 130px">Suggested
							Events</a>
					</div>
				</div>
				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden"
					style="background-color: #00B242;">
					<div class="my-3 p-3">
						<h2 class="display-5">Generate Report</h2>
						<p class="lead">View the Report</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-secondary" href="adminReport"
							style="background-color: 00B242; margin-top: 130px">Generate Report
							</a>
					</div>
				</div>
			</div>
			
			
			
			
			
			
			
			
			
		</c:when>
		
		
		
		
		
		
		
		
		<c:when test='${!userRole.equalsIgnoreCase("Admin")}'>
			<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3"
				style="margin-left: 110px;">
				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden"
					style="background-color: #0033A0;">
					<div class="my-3 p-3">
						<h2 class="display-5">Upcoming Events</h2>
						<p class="lead">View list of Upcoming Events!</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-primary" href="viewEvents"
							style="background-color: 00B242; margin-top: 130px">View
							Events</a>
					</div>
				</div>
				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden"
					style="background-color: #00B242;">
					<div class="my-3 p-3">
						<h2 class="display-5">Invited Events</h2>
						<p class="lead">Click to see your Invited Events!</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-secondary" href="invitedEvents"
							style="background-color: 00B242; margin-top: 130px">Invited
							Events</a>
					</div>
				</div>
			</div>


			<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3"
				style="margin-left: 110px;">

				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden"
					style="background-color: #00B242;">
					<div class="my-3 p-3">
						<h2 class="display-5">Suggest an Event</h2>
						<p class="lead">Click to suggest a New Event</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-secondary" href="suggestEvent"
							style="background-color: 00B242; margin-top: 130px">Suggest
							Event</a>
					</div>
				</div>

			</div>

		</c:when>
	</c:choose>

	<nav class="navbar fixed-bottom navbar-expand-md navbar-dark"
		style="background-color: #0033A0;"> <footer> <a
		href="#" style="float: right; margin-left: 750px; color: #00B242;">Back
		to top</a> &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Privacy</a>
	&middot; &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Terms</a>
	</footer> </nav>

</body>
</html>