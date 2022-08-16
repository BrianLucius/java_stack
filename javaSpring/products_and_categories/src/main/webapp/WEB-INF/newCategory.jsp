<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
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
<title>New Category</title>
</head>
<body>
	<div class="container mt-5 w-75">
		<nav class="navbar navbar-expand-lg navbar-dark mb-3 rounded" style="background-color: cornflowerblue">
			<div class="container-fluid">
				<a class="navbar-brand">Products and Categories</a>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			        <div class="navbar-nav">
				          <a class="nav-link" href="/">Dashboard</a>
				          <!-- <a class="nav-link" href="/logout">Logout</a> -->
			        </div>
		        </div>
			</div>
		</nav>
		 <div>
	    	<div class="border rounded border-primary p-3 shadow">
				<form:form action="/categories/new" method="POST" modelAttribute="category">
					<div class="mb-3">
						<form:label class="form-label" path="name">Name:</form:label>
						<form:errors path="name" class="text-danger"/>
						<form:input class="form-control" type="text" path="name"/>
					</div>
					<input class="btn btn-outline-success p-2" type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>