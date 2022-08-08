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
<title>Review form</title>
</head>
<body>
	<h1>Review Form</h1>
	<form action="/process" method="POST">
	<div>
		<label>Product</label>
		<input type="text" name="product"/>
	</div>
	<div>
		<label>Comments</label>
		<textarea name="comment"></textarea>
	</div>
	<div>
		<label>Rating</label>
		<input type="number" name="rating"/>
	</div>
	<input type="submit" value="Submit" />
	</form>
</body>
</html>