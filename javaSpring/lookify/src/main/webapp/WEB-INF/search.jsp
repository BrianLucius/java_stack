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
<title>Search</title>
</head>
<body>
	<div class="container mt-5 w-75">
		<nav class="navbar navbar-expand-lg navbar-dark mb-3" style="background-color: rebeccapurple">
			<div class="container-fluid">
				<a class="navbar-brand">Lookify!</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			        <div class="navbar-nav">
				          <a class="nav-link" href="/dashboard">Dashboard</a>
			        </div>
		        </div>
			    <span class="navbar-text p-2">Songs by Artist Containing "<c:out value="${searchArtist}"/>"</span>
			    <form class="d-flex" role="search" action="/search">
			      <input class="form-control me-2" type="search" placeholder="Search Artists..." aria-label="Search" name="artist">
			      <button class="btn btn-sm btn-success" type="submit">Search</button>
			    </form>
			</div>
		</nav>
		<div class="border rounded mb-5">
			<table class="table table-hover table-striped mb-0">
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Rating</th>
			            <th>Actions</th>
			        </tr>
			    </thead>
			    <tbody>
			         <c:forEach var="song" items="${songList}">
			         	<tr>
			         		<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			         		<td><c:out value="${song.rating}"/></td>
			         		<td><form action="/song/${song.id}" method="POST">
							    <input type="hidden" name="_method" value="DELETE">
							    <input type="submit" class="btn btn-sm btn-outline-danger" value="Delete">
							</form></td>
			         	</tr>
			         </c:forEach>
			    </tbody>
		    </table>
		 </div>
	</div>
</body>
</html>