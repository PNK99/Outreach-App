
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Home Page</title>
<style>

/* div#header{
	
 	width:100%;
 	height:131px;
 	
}

div#header img{
	
  	width:470px;
   	height:131px;
   	
}
 */
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
</style>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<%
	
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<body>


	<!-- 	<div id="header">

		<img
			src="https://cognizantonline-my.sharepoint.com/:i:/r/personal/839834_cognizant_com/Documents/thumbnail_image003.jpg?csf=1&e=Roe7MM"
			alt="logo" />

	</div> -->

	<header>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top"
			style="background-color: #0033A0;">

			<a class="navbar-brand" href="index" style="color: #00B242">Outreach</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="/">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="signUp">Sign
							Up</a></li>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>

				</ul>
				<form class="form-inline mt-2 mt-md-0">
					<input class="form-control mr-sm-2" type="text"
						placeholder="Search">
					<button class="btn btn-outline-light" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</header>

	<main role="main">
		<div class="container marketing">
			<br>
			<br>
			<!-- Three columns of text below the carousel -->
			<div class="row">
				<div class="col-lg-4">

					<h2>Outreach emerges as India's largest corporate employee
						volunteering program</h2>
					<p>This day last year, the Honorable Prime Minister of India,
						Shri Narendra Modi, launched the Self4Society app and urged
						employees across companies to volunteer for social causes. His
						rallying cry, "Main nahin hum" ("From I to We") set off a national
						movement of employee-led volunteerism to drive societal change.</p>
					<p>
						<a class="btn btn-secondary"
							href="https://www.linkedin.com/pulse/cognizant-outreach-emerges-indias-largest-corporate-ramamoorthy/"
							role="button" style="color: #00B242; background-color: #0033A0;">View
							details &raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4">
					<h2>Employee volunteering program Outreach Impacts 450,000
						Lives</h2>
					<p>Cognizant's employee volunteering program 'Outreach' has
						completed 10 years and impacted 4,50,000 lives through its work in
						the areas of education, community welfare and environment. During
						this period, over 100,000 Cognizant employees clocked in two
						million hours of volunteering across 20 countries, making Outreach
						one of the largest corporate volunteering efforts.</p>
					<p>
						<a class="btn btn-secondary"
							href="https://news.cognizant.com/Outreach-Dec4-2017"
							role="button" style="color: #00B242; background-color: #0033A0;">View
							details &raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4">

					<h2>Cognizant Outreach is Among the World's Largest Corporate
						Volunteer Efforts</h2>
					<p>Since its inception, IT services firm Cognizant Technology
						Solutions Corp has been giving back to the communities where it
						operates,” writes the National Volunteer and Philanthropy Centre
						(NVPC), Singapore, as part of a series of stories on the business
						case for doing good under its Company of Good program</p>
					<p>
						<a class="btn btn-secondary"
							href="https://news.cognizant.com/outreach-businesstimes-nov21-2016"
							role="button" style="color: #00B242; background-color: #0033A0;">View
							details &raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->

			</div>
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
	</main>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>