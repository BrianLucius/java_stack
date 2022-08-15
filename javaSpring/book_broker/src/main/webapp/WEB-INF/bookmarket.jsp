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
<title>Book Lender Dashboard</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<h3 style="color: rebeccapurple;">Hello, <c:out value="${username}"/>. Welcome to...</h3>
			<h1>The Book Broker</h1>
		</div>
		<a href="/logout">Logout</a>
		<a href="/books">Back to Dashboard</a>
		<div class="row">
			<h3>Available Books to Borrow</h3>
		</div>
		<table class="table table-hover table-striped mb-5 shadow">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Title</th>
		            <th>Author Name</th>
		            <th>Owner</th>
		            <th class="text-center" colspan="3">Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="book" items="${booksList}">
		         	<tr>
		         		<td><c:out value="${book.id}"/></td>
		         		<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
		         		<td><c:out value="${book.author}"/></td>
		         		<td><c:out value="${book.postedBy.userName}"/></td>
		         		<c:if test="${book.borrowedBy.id == null}">
			         		<td><form:form action="/books/borrow/${book.id}" method="POST" modelAttribute="book">
									<input type="hidden" name="_method" value="PUT" />
									<input class="btn btn-outline-success p-2" type="submit" value="Borrow" />
								</form:form></td>
		         		</c:if>
		         		<c:if test="${book.postedBy.id == user_id}">
			         		<td><a href="/books/edit/${book.id}">Edit</a></td>
			         		<td><form:form action="/books/edit/${book.id}" method="POST" modelAttribute="book">
									<input type="hidden" name="_method" value="DELETE" />
									<input class="btn btn-outline-danger p-2" type="submit" value="Delete" />
								</form:form></td>
		         		</c:if>
		         	</tr>
		         </c:forEach>
		    </tbody>
	    </table>
	    <div class="row">
			<h3>Books I'm Borrowing</h3>
		</div>
		<table class="table table-hover table-striped mb-5 shadow">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Title</th>
		            <th>Author Name</th>
		            <th>Owner</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="book" items="${borrowedList}">
		         	<tr>
		         		<td><c:out value="${book.id}"/></td>
		         		<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
		         		<td><c:out value="${book.author}"/></td>
		         		<td><c:out value="${book.postedBy.userName}"/></td>
		         		<td><form:form action="/books/return/${book.id}" method="POST" modelAttribute="book">
								<input type="hidden" name="_method" value="PUT" />
								<input class="btn btn-outline-success p-2" type="submit" value="Return" />
							</form:form></td>
		         	</tr>
		         </c:forEach>
		    </tbody>
	    </table>
	</div>
</body>
</html>