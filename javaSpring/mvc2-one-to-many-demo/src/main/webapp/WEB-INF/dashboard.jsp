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
<title>Donation Board</title>
</head>
<body>
	<div>
		<h1>Donation Dashboard</h1>
	</div>
	<div>
		<a href="/add/users">Add a new user</a>
	</div>
	<div>
		<a href="/add/donations">Add a new donation</a>
	</div>
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
			<c:forEach var="eachDonation" items="${donationList}">
				<tr>
					<td><a href="/edit/donations/${eachDonation.id}">${eachDonation.id}</a></td>
					<td><c:out value="${eachDonation.donationName}"/></td>
					<td>${eachDonation.quantity}</td>
					<td><a href="/users/${eachDonation.donor.id}"><c:out value="${eachDonation.donor.username}"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>User Dashboard</h1>
		<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Email</th>
				<th>Total Donation</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachUser" items="${userList}">
				<tr>
					<td>${eachUser.id}</td>
					<td><c:out value="${eachUser.username}"/></td>
					<td>${eachUser.email}</td>
					<td><c:out value="${eachUser.donation.size()}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
</body>
</html>