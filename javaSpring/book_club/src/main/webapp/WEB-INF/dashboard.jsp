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
<title>Read Share</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<h1 style="color: rebeccapurple;">Welcome, <c:out value="${username}"/>!</h1>
		</div>
		<a href="/logout">Logout</a>
		<a href="/books/new">Add a book to my shelf!</a>
		<div class="row">
			<h3>Books from everyone's shelves:</h3>
		</div>
		<table class="table table-hover table-striped mb-5 shadow">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Title</th>
		            <th>Author Name</th>
		            <th>Posted By</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="book" items="${booksList}">
		         	<tr>
		         		<td><c:out value="${book.id}"/></td>
		         		<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
		         		<td><c:out value="${book.author}"/></td>
		         		<td><c:out value="${book.postedBy.userName}"/></td>
		         	</tr>
		         </c:forEach>
		    </tbody>
	    </table>
	</div>
</body>
</html>