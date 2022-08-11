<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Donation</title>
</head>
<body>
	<h1>Add New Donation</h1>
	<form:form action="/edit/donations/${donation.id}" method="post" modelAttribute="donation">
	<input type="hidden" name="_method" value="put"/>
		<form:hidden path="donor" />
		<p>Donor: <c:out value="${donation.donor.username}"></c:out></p>
		<div>
			<form:label path="donationName">Donation Name:</form:label>
			<form:input type="text" path="donationName"/>
			<form:errors path="donationName"/>
		</div>
		<div>
			<form:label path="quantity">Quantity:</form:label>
			<form:input type="text" path="quantity"/>
			<form:errors path="quantity"/>
		</div>

		<input type="submit" value="Update Donation" />
	</form:form>
	<a href="/">Back to Dashboard</a>
</body>
</html>