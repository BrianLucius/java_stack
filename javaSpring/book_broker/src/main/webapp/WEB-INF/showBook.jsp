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
			<h1 style="color: rebeccapurple;">${book.title}</h1>
		</div>
		<a href="/logout">Logout</a>
		<a href="/books">Back to the shelves</a>
		<div class="mb-5 p-5 shadow rounded">
			<h3>${book.postedBy.userName} read ${book.title} by ${book.author}.</h3>
			<h4>Here are ${book.postedBy.userName}'s thoughts:</h4>
			<div class="mb-5 p-5 shadow rounded" style="background-color: #EBD5B3;">
				<p>${book.comments}</p>
			</div>
			<div>
				<h5>Borrowed By: ${book.borrowedBy.userName}</h5>
			</div>
		</div>
		<c:if test="${user_id == book.postedBy.id }">
			<a class="btn btn-success" href="/books/edit/${book.id}">Edit</a>
		</c:if>
	</div>
</body>
</html>