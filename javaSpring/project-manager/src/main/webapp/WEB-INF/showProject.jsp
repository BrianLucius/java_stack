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
<title>Details</title>
</head>
<body>
	<div class="container mt-5 w-75">
				<nav class="navbar navbar-expand-lg navbar-dark mb-3 rounded" style="background-color: rebeccapurple">
			<div class="container-fluid">
				<a class="navbar-brand">Project Manager</a>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			        <div class="navbar-nav">
				          <a class="nav-link" href="/dashboard">Dashboard</a>
			        </div>
		        </div>
			</div>
		</nav>
		<div class="border rounded border-primary p-3 shadow">
			<h3 class="mb-5">Project Name: <c:out value="${project.projectName}"/></h3>
			<h3 class="mb-5">Description: <c:out value="${project.description}"/></h3>
			<h3 class="mb-5">Due Date: <fmt:formatDate pattern="MM/dd/yyyy" value="${project.dueDate}"/></h3>
			<div>
				<c:if test="${project.teamLead.id == user_id}">				
					<form action="/projects/${project.id}" method="POST">
					    <input type="hidden" name="_method" value="DELETE">
					    <input type="submit" class="btn btn-sm btn-outline-danger" value="Delete">
					</form>
				</c:if>
			</div>
		</div>
		<a href="/projects/${project.id}/tasks">See Tasks!</a>
	</div>
</body>
</html>