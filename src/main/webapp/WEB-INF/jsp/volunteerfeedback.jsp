<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Creation Of Events</title>
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
        
        #hideMe {
    -moz-animation: cssAnimation 0s ease-in 5s forwards;
    /* Firefox */
    -webkit-animation: cssAnimation 0s ease-in 3s forwards;
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
		
	
			<button class="btn btn-outline-light" type="submit">Logout</button>
		</form>
	</div>
	</nav> </header>
	<br><br><br><br>
	<center><h2 class="card pmd-card text-black">Feedback Portal</h2></center>
	<br>
	<form:form action="feedbackSave" method="post" modelAttribute="feedback">
		
		
		<div class="card pmd-card bg-dark text-white" style="width:50% !important; margin-left:25% !important">
    	
		<div class="card-body" >
		
		
		<table>
			<tr>
			       

				<td><form:label path="co_ordinator">Were the co-ordinators helpful?</form:label></td>
				<td><form:radiobutton path="co_ordinator" value="yes" />Yes 
				<form:radiobutton path="co_ordinator" value="no" />No</td>
			</tr>

			
			<tr>


				<td><form:label path="fun"> Was the event fun? </form:label></td>
				<td><form:radiobutton path="fun" value="yes" />Yes 
				<form:radiobutton path="fun" value="no" />No</td>

			</tr>
			
		
			
            <tr>


				<td><form:label path="enjoy"> Did you enjoy the event? </form:label></td>
				<td><form:radiobutton path="enjoy" value="yes" />Yes 
				<form:radiobutton path="enjoy" value="no" />No</td>

			</tr>
			
			
			
			<tr>


				<td><form:label path="infrastructure"> Did the event have all the infrastructure needed? </form:label></td>
				<td><form:radiobutton path="infrastructure" value="yes" />Yes 
				<form:radiobutton path="infrastructure" value="no" />No</td>

			</tr>
			
			
			
			<tr>


				<td><form:label path="recommend"> Would you recommend this event for others? </form:label></td>
				<td><form:radiobutton path="recommend" value="yes" />Yes 
				<form:radiobutton path="recommend" value="no" />No</td>

			</tr>
            
            
				

		</table>
		</div> </div>
		<br>
		<input class="btn btn-primary" type="submit" value="Submit" style="margin-left:45% !important;color:white !important; background-color:#0033A0 !important">
		
		<input type="hidden" name="eventId" value="${eventId}"/>
		<input type="hidden" name="userId" value="${userId}"/>
		
	</form:form>
	
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