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
<title>Add Song</title>
</head>
<body>
	<div class="container mt-5 w-50">
		<div>
			<a href="/dashboard">Dashboard</a>
		</div>
		 <div>
	    	<div class="border rounded border-primary p-3">
				<form:form action="/songs/new" method="POST" modelAttribute="song">
					<div class="mb-3">
						<form:label class="form-label" path="title">Title:</form:label>
						<form:errors path="title" class="text-danger"/>
						<form:input class="form-control" type="text" path="title" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="artist">Artist:</form:label>
						<form:errors path="artist" class="text-danger"/>
						<form:input class="form-control" type="text" path="artist" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="rating">Rating (1-10):</form:label>
						<form:errors path="rating" class="text-danger"/>
						<form:input class="form-control" type="number" path="rating" id="" />
					</div>
					<input class="button btn-success p-2" type="submit" value="Add Song" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>