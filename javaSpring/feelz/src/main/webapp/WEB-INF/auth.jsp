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
<title>Feelz Analytics Login</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<h1 class="title">Feelz Analytics Portal</h1>
		</div>
		<div class="row">
			<div class="col border rounded shadow p-3 m-5">
				<div>
					<h2>Log In</h2>
				</div>
				<form:form action="/analytics_portal/login" method="post" modelAttribute="newLogin">
					<div class="mb-3">
<%-- 						<form:errors class="text-danger" path="email"/>
						<form:errors class="text-danger" path="password"/> --%>
						<p><form:errors class="alert alert-danger p-1" path="loginError"/></p>
					</div>
					<div class="mb-3">
						<div>
							<form:label path="email">Email:</form:label>
						</div>
						<div>
							<form:input type="text" path="email"/>
						</div>
					</div>
					<div class="mb-3">
						<div>
							<form:label path="password">Password:</form:label>
						</div>	
						<div>
							<form:input type="password" path="password"/>
						</div>
					</div>
					<input type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>