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
<title>Reading Books</title>
</head>
<body>
	<div class="container mt-5">
		<h1><c:out value="${book.title}"/></h1>
		<h3>Description: <c:out value="${book.description}"/></h3>
		<h3>Language: <c:out value="${book.language}"/></h3>
		<h3>Number of Pages: <c:out value="${book.numberOfPages}"/></h3>
		<a href="/books">Go Back to Index</a>
	</div>
</body>
</html>