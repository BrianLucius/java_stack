<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
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
<title>Reading Share</title>
</head>
<body>
	<div class="container mt-5 w-50">
		<div>
			<h1>Add a New Book</h1>
		</div>
		<div class="border rounded border-primary p-3">
			<form:form action="/books" method="POST" modelAttribute="book">
			<div class="mb-3">
				<form:label class="form-label" path="title">Title:</form:label>
				<form:errors path="title" class="text-danger"/>
				<form:input class="form-control" type="text" path="title" id="" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="description">Description:</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:textarea class="form-control" path="description" id="" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="language">Language:</form:label>
				<form:errors path="language" class="text-danger"/>
				<form:input class="form-control" type="text" path="language" id="" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="numberOfPages">Number of Pages:</form:label>
				<form:errors path="numberOfPages" class="text-danger"/>
				<form:input class="form-control" type="number" path="numberOfPages" id="" />
			</div>
			<input class="button btn-success p-2" type="submit" value="Add Your Book!" />
			</form:form>
		</div>
	</div>
</body>
</html>