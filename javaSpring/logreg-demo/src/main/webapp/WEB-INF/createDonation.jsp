<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add a donation</h1>
	<form:form method = "post" action="/donations/add" modelAttribute="donation">
		<div>
			<form:label path="donationName"> Donation</form:label>
			<form:input type="text" path="donationName" />
			<form:errors path="donationName"/>
		</div>
		<div>
			<form:label path="quantity">Quantity</form:label>
			<form:input type="text" path="quantity" />
			<form:errors path="donationName"/>
		</div>
		<form:hidden path="user" value="${userId}"></form:hidden>
		<button type="submit">Add</button>
	</form:form>
</body>
</html>