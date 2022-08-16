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
<title>Add a Project Task</title>
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
			<h2>Project Tasks</h2>
			<h3 class="mb-5">Project Name: <c:out value="${project.projectName}"/></h3>
			<h4 class="mb-5">Project Lead: <c:out value="${project.teamLead.userName}"/></h4>
			<div>
				<form:form action="/projects/${project.id}/tasks" method="POST" modelAttribute="newTask">
					<form:label class="form-label" path="task">Add a Task:</form:label>
					<form:errors path="task" class="text-danger"/>
					<form:textarea class="form-control" path="task" />
				    <input class="btn btn-sm btn-outline-success mt-3 mb-4" type="submit" value="Submit"/>
				</form:form>
			</div>
			<c:forEach var="task" items="${listTasks}">
				<b>Added by ${task.userName} at <fmt:formatDate pattern="hh:mma MMM dd, yyyy" value="${task.createdAt}"/></b>
				<p class="mb-2">${task.task}</p>
			</c:forEach>
		</div>
	</div>
</body>
</html>