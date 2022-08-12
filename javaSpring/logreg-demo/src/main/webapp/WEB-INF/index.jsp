<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Login & Registration</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 style="color: rebeccapurple;">Welcome!</h1>
		</div>
		<div class="row">
			<h3>Join our growing community.</h3>
		</div>
		<div class="row">
			<div class="col border rounded shadow p-3 m-5">
				<div>
					<h2>Register</h2>
				</div>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<div class="mb-3">
						<form:label path="userName">User name:</form:label>
						<div>
							<form:errors class="text-danger" path="userName"/>
						</div>
						<form:input type="text" path="userName"/>
					</div>
					<div class="mb-3">
						<form:label path="email">Email:</form:label>
						<div>
							<form:errors class="text-danger" path="email"/>
						</div>
						<form:input type="text" path="email"/>
					</div>
					<div class="mb-3">
						<form:label path="password">Password:</form:label>
						<div>
							<form:errors class="text-danger" path="password"/>
						</div>
						<form:input type="password" path="password"/>
					</div>
					<div class="mb-3">
						<form:label path="confirm">Confirm Password:</form:label>
						<div>
							<form:errors class="text-danger" path="confirm"/>
						</div>
						<form:input type="password" path="confirm"/>
					</div>
					<input type="submit" value="Submit" />
				</form:form>
			</div>
			<div class="col border rounded shadow p-3 m-5">
				<div>
					<h2>Log In</h2>
				</div>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<div class="mb-3">
 						<form:errors class="text-danger" path="email"/>
						<form:errors class="text-danger" path="password"/> 
<%-- 						<form:errors class="text-danger" path="loginError"/> --%>
					</div>
					<div class="mb-3">
						<form:label path="email">Email:</form:label>
						<form:input type="text" path="email"/>
					</div>
					<div class="mb-3">
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
					</div>
					<input type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>