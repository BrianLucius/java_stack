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
			<h4>Songs by Artist Containing "<c:out value="${searchArtist}"/>"</h4>
			<form action="/search">
				<input type="text" name="artist" />
				<input type="submit" value="Search Artists" />
			</form>
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="border rounded mb-5">
			<table class="table table-hover table-striped">
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
							    <input type="submit" class="btn btn-sm btn-danger" value="Delete">
							</form></td>
			         	</tr>
			         </c:forEach>
			    </tbody>
		    </table>
		 </div>
	</div>
</body>
</html>