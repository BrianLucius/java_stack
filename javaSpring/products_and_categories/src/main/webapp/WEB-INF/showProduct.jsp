<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
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
		<div class="border rounded border-primary p-3 shadow">
			<h1 class="text-center">${product.name}</h1>
			<h2>Categories</h2>
			<ul>
	       		 <c:forEach var="category" items="${product.categories}">
				 	<li><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></li>		    		
        		 </c:forEach>
   			</ul>
		</div>		
		<div class="border rounded border-primary p-3 shadow">
			<h2>Add Category:</h2>
			<form:form action="/products/${product.id}" method="POST" modelAttribute="category">
 				<form:select class="mb-3" path="id">
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</form:select>
				<div>
				    <input type="submit" class="btn btn-sm btn-success" value="Add">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>