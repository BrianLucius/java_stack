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
<title>Dashboard</title>
</head>
<body>
	<div class="container mt-5 w-75">		
		<nav class="navbar navbar-expand-lg navbar-dark mb-3 rounded" style="background-color: rebeccapurple">
			<div class="container-fluid">
				<a class="navbar-brand">Project Manager</a>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			        <div class="navbar-nav">
				          <a class="nav-link" href="/projects/new">Create a New Project</a>
			        </div>
		        </div>
		        <div>
				    <a class="navbar-nav nav-link" href="/logout">Logout</a>
		        </div>
			</div>
		</nav>
		<div class="row mb-3">
			<h3>Welcome ${username}!</h3>
		</div>
		<div class="row">
			<h3>All Projects</h3>
		</div>
		<table class="table table-hover table-striped mb-5 shadow">
		    <thead>
		        <tr>
		            <th>Project</th>
		            <th>Team Lead</th>
		            <th>Due Date</th>
		            <th class="text-center" colspan="3">Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="project" items="${allProjectsList}">
		         	<tr>
		         		<td><a href="/projects/${project.id}"><c:out value="${project.projectName}"/></a></td>
		         		<td><c:out value="${project.teamLead.userName}"/></td>
		         		<td><fmt:formatDate pattern="MM/dd/yyyy" value="${project.dueDate}"/></td>
		         		<c:if test="${!project.teamMembers.contains(loggedInUser)}">
			         		<td><form:form action="/projects/join/${project.id}" method="POST" modelAttribute="projects">
									<input type="hidden" name="_method" value="PUT" />
									<input class="btn btn-outline-success p-2" type="submit" value="Join Team" />
								</form:form></td>
		         		</c:if>
		         		<c:if test="${project.teamLead.id == user_id}">
			         		<td><a class="btn btn-outline-success p-2" href="/projects/edit/${project.id}">Edit</a></td>
		         		</c:if>
		         	</tr>
		         </c:forEach>
		    </tbody>
	    </table>
	    <div class="row">
			<h3>Your Projects</h3>
		</div>
		<table class="table table-hover table-striped mb-5 shadow">
		    <thead>
		        <tr>
		            <th>Project</th>
		            <th>Team Lead</th>
		            <th>Due Date</th>
		            <th class="text-center" colspan="3">Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="project" items="${myProjectsList}">
		         	<tr>
		         		<td><a href="/projects/${project.id}"><c:out value="${project.projectName}"/></a></td>
		         		<td><c:out value="${project.teamLead.userName}"/></td>
		         		<td><fmt:formatDate pattern="MM/dd/yyyy" value="${project.dueDate}"/></td>
 		         		<c:if test="${project.teamMembers.contains(loggedInUser) && project.teamLead.id != user_id}">
			         		<td><form:form action="/projects/leave/${project.id}" method="POST" modelAttribute="projects">
									<input type="hidden" name="_method" value="PUT" />
									<input class="btn btn-outline-success p-2" type="submit" value="Leave Team" />
								</form:form></td>
		         		</c:if>
		         		<c:if test="${project.teamLead.id == user_id}">
			         		<td><a class="btn btn-outline-success p-2" href="/projects/edit/${project.id}">Edit</a></td>
		         		</c:if>
		         	</tr>
		         </c:forEach>
		    </tbody>
	    </table>
	</div>
</body>
</html>