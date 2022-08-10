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
	<div class="container mt-5 w-50">
		<div>
			<h5>Top Ten Songs</h5>
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="border rounded mb-5">
			<ul style="list-style: none;">
				<c:forEach var="song" items="${songList}">
		         	<li><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - <c:out value="${song.artist}"/><li>
		         </c:forEach>
			</ul>
		 </div>
	</div>
</body>
</html>