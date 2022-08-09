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
			<h1>All Books</h1>
		</div>
		<div class="border rounded">
			<table class="table table-hover table-striped">
			    <thead>
			        <tr>
			            <th>ID</th>
			            <th>Title</th>
			            <th>Language</th>
			            <th>Number of Pages</th>
			        </tr>
			    </thead>
			    <tbody>
			         <c:forEach var="book" items="${booksList}">
			         	<tr>
			         		<td><c:out value="${book.id}"/></td>
			         		<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
			         		<td><c:out value="${book.language}"/></td>
			         		<td><c:out value="${book.numberOfPages}"/></td>
			         	</tr>
			         </c:forEach>
			    </tbody>
		    </table>
		</div>
	</div>
</body>
</html>