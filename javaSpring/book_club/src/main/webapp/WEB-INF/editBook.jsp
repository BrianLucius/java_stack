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
<title>Book Share!</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<h1 style="color: rebeccapurple;">Change your Entry!</h1>
		</div>
		<a href="/logout">Logout</a>
		<a href="/books">Back to the shelves</a>
		<div class="mb-5 p-5 shadow">
			<form:form action="/books/edit/${book.id}" method="POST" modelAttribute="book">
					<input type="hidden" name="_method" value="PUT" />
					<div class="mb-3">
						<form:label class="form-label" path="title">Title:</form:label>
						<div>
							<form:errors path="title" class="text-danger"/>
						</div>
						<form:input class="form-control" type="text" path="title" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="author">Author:</form:label>
						<div>
							<form:errors path="author" class="text-danger"/>
						</div>
						<form:input class="form-control" type="text" path="author" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="comments">My Thoughts:</form:label>
						<div>
							<form:errors path="comments" class="text-danger"/>
						</div>
						<form:textarea class="form-control" path="comments" id="" />
					</div>
					<input class="btn btn-outline-success p-2" type="submit" value="Submit" />
				</form:form>
		</div>
	</div>
</body>
</html>