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
		<nav class="navbar navbar-expand-lg navbar-dark mb-3 rounded" style="background-color: cornflowerblue">
			<div class="container-fluid">
				<a class="navbar-brand">Products and Categories</a>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			        <div class="navbar-nav">
				          <a class="nav-link" href="/products/new">Add Product</a>
				          <a class="nav-link" href="/categories/new">Add Category</a>
			        </div>
		        </div>
			</div>
		</nav>
		<div class="border rounded shadow">
			<table class="table table-hover table-striped mb-0">
			    <thead>
			        <tr>
			            <th>Products</th>
			            <th>Categories</th>
			        </tr>
			    </thead>
			    <tbody>
			    	<tr>
			    		<td>
			    			<ul>
			        		 <c:forEach var="product" items="${productList}">
       							<li><a href="/products/${product.id}"><c:out value="${product.name}"/></a></li>		    		
			         		 </c:forEach>
			    			</ul>
			    		</td>
			    		<td>
			    			<ul>
			        		 <c:forEach var="category" items="${categoryList}">
       							<li><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></li>		    		
			         		 </c:forEach>
			    			</ul>
			    		</td>
			  		</tr>
			    </tbody>
		    </table>
		 </div>
	</div>
</body>
</html>