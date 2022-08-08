<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Welcome To My Page</title>
</head>
<body>
<h1>Reservation Details</h1>
<h4>Name: <c:out value="${name}"/></h4>
<h4>Number of People: <c:out value="${numOfPeople}"/></h4>
<h4>Reservation Date: <fmt:formatDate type="date" pattern="MMMM dd, yyyy" value="${reservationDate}"/></h4>
<h4>Reservation Time: <fmt:formatDate type="time" pattern="h:mm a" value="${reservationTime}"/></h4>
</body>
</html>