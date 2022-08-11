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
		<h1>Add New Ninja</h1>
		<div class="mb-5 p-5 shadow">
			<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
 					<div class="mb-3">
						<form:label class="form-label" path="dojo">Dojo:</form:label>
						<form:select path="dojo">
							<c:forEach var="dojo" items="${dojoList}">
				         		<option value="${dojo.id}">${dojo.name}</option>
				       	  	</c:forEach>
						</form:select>
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="firstName">First Name:</form:label>
						<div>
							<form:errors path="firstName" class="text-danger"/>
						</div>
						<form:input class="form-control" type="text" path="firstName" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="lastName">Last Name:</form:label>
						<div>
							<form:errors path="lastName" class="text-danger"/>
						</div>
						<form:input class="form-control" type="text" path="lastName" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="age">Age:</form:label>
						<div>
							<form:errors path="age" class="text-danger"/>
						</div>
						<form:input class="form-control" type="number" path="age" id="" />
					</div>
					<input class="btn btn-outline-success p-2" type="submit" value="Create" />
				</form:form>
		</div>
		<a href="/dojos">Back to List</a>
	</div>
</body>
</html>