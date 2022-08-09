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
<title>Reading Share</title>
</head>
<body>
	<div class="container mt-5 w-50">
		<div>
			<h1>Add a New Book</h1>
		</div>
		<div class="border rounded border-primary p-3">
			<form action="/books/add" method="POST">
			<div class="mb-3">
				<label class="form-label">Title:</label>
				<input class="form-control" type="text" name="title" id="" />
			</div>
			<div class="mb-3">
				<label class="form-label">Description:</label>
				<input class="form-control" type="text" name="description" id="" />
			</div>
			<div class="mb-3">
				<label class="form-label">Language:</label>
				<input class="form-control" type="text" name="language" id="" />
			</div>
			<div class="mb-3">
				<label class="form-label">Number of Pages:</label>
				<input class="form-control" type="number" name="numberOfPages" id="" />
			</div>
			<input class="button btn-success p-2" type="submit" value="Add Your Book!" />
			</form>
		</div>
	</div>
</body>
</html>