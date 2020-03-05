<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>OutReach</title>
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
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #0033A0;"> <a class="navbar-brand"
            href="#">OutReach</a> </nav>
    <div class="container container-width">


        <h2 style="margin-bottom: 20px;">Create an Event</h2>


        <form:form modelAttribute="event" action="createdEvent" method="post" class="needs-validation">
            <div class="form-group">
                <label for="activity">Activity</label>
                <form:select placeholder="Select an activity" path="activity" id="activity" class="form-control"
                    required="true">
                    <form:option value="">Select Activity</form:option>
                    <form:options items="${activityList}"></form:options>
                </form:select>
            </div>
            <div class="form-group">
                <label for="place">Places</label>
                <form:input path="place" placeholder="Enter the venue place" class="form-control" id="place" /><br>

                <form:errors class="alert alert-danger" role="alert" path="place">
                </form:errors>

            </div>
            <div class="form-group">
                <label for="date">Date</label>
                <form:input path="date" type="date" class="form-control" id="date" /><br>
                <form:errors class="alert alert-danger" role="alert" path="date"></form:errors>
            </div>
            <div class="form-group">
                <label for="contactNumber">Contact number</label>
                <form:input path="contactNumber" placeholder="Enter the host's contact number" class="form-control"
                    id="contactNumber"></form:input><br>

                <form:errors class="alert alert-danger" role="alert" path="contactNumber"></form:errors>



            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <form:textarea path="description" placeholder="Brief description about the event" class="form-control"
                    id="description" /><br>

                <form:errors class="alert alert-danger" role="alert" path="description"></form:errors>

            </div>
            <div class="form-group">
                <label for="dosAndDonts">Do's and Dont's</label>
                <form:textarea path="dosAndDonts" class="form-control" placeholder="Do's and Don't for the event"
                    id="dosAndDonts" /><br>

                <form:errors class="alert alert-danger" role="alert" path="dosAndDonts"></form:errors>


            </div>

            <input class="btn btn-success" style="background-color: #00B242;" type="submit" value="create">
        </form:form>
    </div>
</body>

</html>