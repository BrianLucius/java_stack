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
<title>Feelz Analytics | User Management</title>
</head>
<body>
	<div class="container mt-5">		
		<nav class="navbar navbar-expand-lg navbar-dark mb-3 rounded">
			<div class="container-fluid">
				<a class="navbar-brand">Feelz Analytics</a>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
				          <a class="nav-link" href="/analytics_portal/dashboard">Dashboard</a>
				          <a class="nav-link" href="/analytics_portal/usermanagement">User Management</a>
				          <a class="nav-link" href="https://feelz.cc" target="_blank" >feelz.cc</a>
			        </div>
		        </div>
		        	<a class="nav-link text-light">${user_first_name} ${user_last_name}</a>
		        <div>
				    <a class="nav-link text-light" href="/analytics_portal/logout">Logout</a>
		        </div>
			</div>
		</nav>
		<div>
			<h3>User Management</h3>
		</div>
		<div class="border rounded shadow p-3">
			<form:form action="/analytics_portal/usermanagement/edit/${user.id}" method="POST" modelAttribute="user">
				<input type="hidden" name="_method" value="PUT" />
				<div class="mb-3">
					<form:label class="form-label" path="firstName">First Name:</form:label>
					<div>
						<form:errors path="firstName" class="text-danger"/>
					</div>
					<form:input class="form-control" type="text" path="firstName"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="lastName">Last Name:</form:label>
					<div>
						<form:errors path="lastName" class="text-danger"/>
					</div>
					<form:input class="form-control" type="text" path="lastName"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="email">Email:</form:label>
					<div>
						<form:errors path="email" class="text-danger"/>
					</div>
					<form:input class="form-control" type="text" path="email"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="password">Password:</form:label>
					<div>
						<form:errors path="password" class="text-danger"/>
					</div>
					<form:input class="form-control" type="password" path="password"/>
				</div>
				<div class="mb-3">
					<form:label class="form-label" path="confirm">Confirm Password:</form:label>
					<div>
						<form:errors path="confirm" class="text-danger"/>
					</div>
					<form:input class="form-control" type="password" path="confirm"/>
				</div>
				<div>
					<input class="btn btn-success" type="submit" value="Update User" />
					<a class="btn btn-primary" href="/analytics_portal/usermanagement">Cancel</a>
				</div>
				</form:form>
		</div>	
	</div>
</body>
</html>