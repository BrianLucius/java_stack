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
			<table class="table table-hover table-striped">
			    <thead>
			        <tr>
			            <th>First Name</th>
			            <th>Last Name</th>
			            <th>Email address</th>
			            <th class="text-center" colspan=2>User Actions</th>
			        </tr>
			    </thead>
			    <tbody>
			         <c:forEach var="user" items="${usersList}">
			         	<tr>
			         		<td><c:out value="${user.firstName}"/></td>
			         		<td><c:out value="${user.lastName}"/></td>
			         		<td><c:out value="${user.email}"/></td>
			         		<td><a class="btn btn-outline-success" href="/analytics_portal/usermanagement/edit/${user.id}">Edit User</a></td>
			         		<td><c:if test="${user.id != user_id}">
					         		<form:form action="/analytics_portal/usermanagement/delete/${user.id}" method="POST" modelAttribute="user">
										<input type="hidden" name="_method" value="DELETE" />
										<input class="btn btn-outline-danger" type="submit" value="Delete User" />
									</form:form>
			         			</c:if></td>
			         	</tr>
			         </c:forEach>
			    </tbody>
		    </table>
		    <div>
		    	<a class="btn btn-success" href="/analytics_portal/usermanagement/add">Add User</a>
		 	</div>
	    </div>
  </div>
</body>
</html>