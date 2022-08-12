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
<title>Dorms</title>
</head>
<body>
	<div class="container mt-5">
	<div class="row text-center">
		<h1>Dorms</h1>
	</div>
	<div>
		<a href="/dorms/new">Add a New Dorm</a>
	</div>
	<div>
		<a href="/students/new">Add a New Student</a>
	</div>
	<div class="m-5 shadow rounded">
		<table class="table table-hover table-striped ">
			<thead>
				<tr>
					<th>Dorm</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dorm" items="${dormsList}">
					<tr>
						<td><c:out value="${dorm.dormName}"/></td>
						<td><a href="/dorms/${dorm.id}">See Students</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>