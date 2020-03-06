<%@page import="com.dao.UserDao"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #0033A0;">
        <a class="navbar-brand" href="#">OutReach</a>

    </nav>

    <div class="container container-width">
        <div class="card" style="margin:1%">
            <h2 class="card-header">
                <c:out value="${event.activity}" />
            </h2>

            <div class="card-body" style="padding: 5%;">
                Description :
                <c:out value="${event.description}" /><br />
                Date :
                <fmt:formatDate value="${event.date}" pattern="dd MMM yyyy EEE" /><br />
                Place :
                <c:out value="${event.place}" /><br />
                Do's and Don't :
                <c:out value="${event.dosAndDonts}" /><br />

                Point of contact :
                <c:out value="${event.contactNumber}" /><br />

                No of volunteers registered :
                <c:out value="${event.volunteers.size()}" /><br /><br>

                <c:if test='${!userRole.equalsIgnoreCase("Admin")}'>

                    <c:if test="${!event.volunteers.contains(userI)}">
                        <span> <a class="btn btn-success"
                                href="subscribe?eventId=${event.id}&userId=${user.id}">Subscribe</a></span>
                    </c:if>

                    <c:if test="${event.volunteers.contains(userI)}">
                        <div class="d-flex justify-content-between">

                            <a class="btn btn-danger" href="unsubscribe?eventId=${event.id}&userId=${user.id}">Un
                                Subscribe</a>
                            <a class="btn btn-dark" href="inviteVolunteerList?eventId=${event.id}&userId=${user.id}">
                                Invite others</a>
                        </div>
                    </c:if>
                </c:if>
            </div>
        </div>
    </div>


</body>

</html>