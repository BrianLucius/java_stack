<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
</head>
<body>
	<div>
		<h1>User Details</h1>
	</div>
	<h3>Username: <c:out value="${user.username }"></c:out></h3>
	<h3>Email: <c:out value="${user.email }"></c:out></h3>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Donation</th>
				<th>Quantity</th>
				<th>Donor</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachDonation" items="${user.donation}">
				<tr>
					<td><a href="/edit/donations/${eachDonation.id}">${eachDonation.id}</a></a></td>
					<td><c:out value="${eachDonation.donationName}"/></td>
					<td>${eachDonation.quantity}</td>
					<td><c:out value="${eachDonation.donor.username}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">Back to Dashboard</a>
</body>
</html>