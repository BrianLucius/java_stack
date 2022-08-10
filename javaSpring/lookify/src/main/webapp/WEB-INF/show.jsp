<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
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
	<div class="container mt-5 w-50">
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
			</div>
		</nav>
		<div class="border rounded border-primary p-3 shadow">
			<h3>Title: <c:out value="${song.title}"/></h3>
			<h3>Artist: <c:out value="${song.artist}"/></h3>
			<h3>Rating: <c:out value="${song.rating}"/></h3>
			<div>
				<form action="/songs/${song.id}" method="POST">
				    <input type="hidden" name="_method" value="DELETE">
				    <input type="submit" class="btn btn-sm btn-outline-danger" value="Delete">
				</form>
			</div>
		</div>
	</div>
</body>
</html>