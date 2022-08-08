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
	<form action="/processReservation" method="POST">
	<div>
		<label for="">Name:</label>
		<input type="text" name="name" id="" />
	</div>
	<div>
		<label for="">Number of people:</label>
		<input type="number" name="numOfPeople" id="" />
	</div>
	<div>
		<label for="">Reservation Date:</label>
		<input type="date" name="reservationDate" id="" />
	</div>
	<div>
		<label for="">Reservation Time:</label>
		<input type="time" name="reservationTime" id="" />
	</div>
		<input type="submit" value="Reserve!" />
	</form>
</body>
</html>