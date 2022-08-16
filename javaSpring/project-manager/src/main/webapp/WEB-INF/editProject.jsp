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
<title>Edit My Project</title>
</head>
<body>
	<div class="container mt-5 w-75">
		<nav class="navbar navbar-expand-lg navbar-dark mb-3 rounded" style="background-color: rebeccapurple">
			<div class="container-fluid">
				<a class="navbar-brand">Project Manager</a>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			        <div class="navbar-nav">
				          <a class="nav-link" href="/dashboard">Dashboard</a>
				          <!-- <a class="nav-link" href="/logout">Logout</a> -->
			        </div>
		        </div>
			</div>
		</nav>
		 <div>
	    	<div class="border rounded border-primary p-3 shadow">
				<form:form action="/projects/edit/${project.id}" method="POST" modelAttribute="project">
				<input type="hidden" name="_method" value="PUT"/>
					<div class="mb-3">
						<form:label class="form-label" path="projectName">Project Title:</form:label>
						<form:errors path="projectName" class="text-danger"/>
						<form:input class="form-control" type="text" path="projectName"/>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="description">Project Description:</form:label>
						<form:errors path="description" class="text-danger"/>
						<form:textarea class="form-control" path="description" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="dueDate">Due Date:</form:label>
						<form:errors path="dueDate" class="text-danger"/>
						<form:input class="form-control" type="date" path="dueDate"/>
					</div>
					<input class="btn btn-outline-success p-2" type="button" onclick="location.href='/dashboard';" value="Cancel" />
					<input class="btn btn-outline-success p-2" type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>