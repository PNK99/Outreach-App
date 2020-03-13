<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	
	
	
	
	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3"
				style="margin-left: 110px;">
				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden"
					style="background-color: #0033A0;">
					<div class="my-3 p-3">
						<h2 class="display-5">Report by Month</h2>
						<p class="lead">view list of volunteers in current month</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-primary" href="month"
							style="background-color: 00B242; margin-top: 130px">View
							report</a>
					</div>
				</div>
				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden"
					style="background-color: #00B242;">
					<div class="my-3 p-3">
						<h2 class="display-5">Report by Location</h2>
						<p class="lead">view list of events by location</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-secondary" href="location"
							style="background-color: 00B242; margin-top: 130px">view report
							</a>
					</div>
				</div>
			</div>


			<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3"
				style="margin-left: 110px;">

				<div
					class="mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden"
					style="background-color: #00B242;">
					<div class="my-3 p-3">
						<h2 class="display-5">Report by Activity</h2>
						<p class="lead">view list of activities with participation</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
						<a class="btn btn-secondary" href="activity"
							style="background-color: 00B242; margin-top: 130px">
							view report</a>
					</div>
				</div>

			</div>
	
	
	
	
	
	
	
	
	
	
	
<nav class="navbar fixed-bottom navbar-expand-md navbar-dark"
		style="background-color: #0033A0;"> <footer> <a
		href="#" style="float: right; margin-left: 750px; color: #00B242;">Back
		to top</a> &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Privacy</a>
	&middot; &nbsp&nbsp&nbsp <a href="#" style="color: #00B242;">Terms</a>
	</footer> </nav>
</body>
</html>