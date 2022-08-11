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
<title>Dojos and Ninjas!</title>
</head>
<body>
	<div class="container mt-5 w-50">
		<h1 class="mb-5">${dojoList.name} Location Ninjas</h1>
		<table class="table table-hover table-striped mb-5 shadow">
		    <thead>
		        <tr>
		            <th>First Name</th>
		            <th>Last Name</th>
		            <th>Age</th>
		        </tr>
		    </thead>
		    <tbody>
 			         <c:forEach var="ninja" items="${dojoList.ninjas}">
			         	<tr>
			         		<td><c:out value="${ninja.firstName}"/></td>
			         		<td><c:out value="${ninja.lastName}"/></td>
			         		<td><c:out value="${ninja.age}"/></td>
			         	</tr>
			         </c:forEach>
		    </tbody>
	    </table>
        <c:if test="${empty dojoList.ninjas}">
        	<h3 class="text-center m-3">There are not any Ninjas for this Dojo yet</h3>
        </c:if>
	    <a href="/dojos">Back to List</a>
	</div>
</body>
</html>