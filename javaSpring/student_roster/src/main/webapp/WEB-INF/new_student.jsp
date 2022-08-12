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
<title>New Student</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row text-center">
			<h1>New Student</h1>
		</div>
		<div>
			<a href="/dorms">Dashboard</a>
		</div>
		<div class="m-5 p-5 shadow rounded">
			<form:form action="/students/new" method="POST" modelAttribute="student">
				<div>
					<form:label path="studentName">Name:</form:label>
					<form:input type="text" path="studentName"></form:input>
					<div>
						<form:errors class="text-danger" path="studentName"/>
					</div>
				</div>
				<div>
					<form:label path="dorm">Select Dorm:</form:label>
					<form:select path="dorm">
						<c:forEach var="dorm" items="${dormsList}">
							<option value="${dorm.id}">${dorm.dormName}</option>
						</c:forEach>
					</form:select>
				</div>		
				<input type="submit" value="Add"/>
			</form:form>
		</div>
	</div>
</body>
</html>