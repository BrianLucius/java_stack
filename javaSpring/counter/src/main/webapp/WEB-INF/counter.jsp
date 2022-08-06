<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Current visit count</title>
</head>
<body>
	<div class="container mt-5">
		<div class="col">
			<div class="row">
				<h1>You have visited <a href="http://localhost:8080" target="_blank" rel="noopener noreferrer"> http://localhost:8080</a> <c:out value="${visitCounter}"/> times.</h1>
			</div>
			<div class="row">
				<h2><a href="http://localhost:8080" target="_blank" rel="noopener noreferrer">Test another visit?</a></h2>
			</div>
			<div class="row col-2 mt-5">
				<button class="button btn-primary" onclick="window.location.href='http://localhost:8080/reset';">Reset Counter</button>
			</div>
		</div>
	</div>
</body>
</html>