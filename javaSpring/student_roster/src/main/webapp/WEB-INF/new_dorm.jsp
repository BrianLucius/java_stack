<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage = "true" %>
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
<title>New Dorm</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row text-center">
			<h1>New Dorm</h1>
		</div>
		<div>
			<a href="/dorms">Dashboard</a>
		</div>
		<div class="m-5 p-5 shadow rounded">
			<form:form action="/dorms/new" method="POST" modelAttribute="dorm">
			<div class="mb-3">
				<form:label path="dormName">Name:</form:label>
				<form:input type="text" path="dormName"></form:input>
				<div>
					<form:errors class="text-danger" path="dormName"/>
				</div>
			</div>
				<input type="submit" value="Add"/>
			</form:form>
		</div>
	</div>
</body>
</html>