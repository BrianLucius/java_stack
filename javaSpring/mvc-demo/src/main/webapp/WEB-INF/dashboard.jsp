<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
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
<title>Dashboard</title>
</head>
<body>
	<div class="container mt-5 w-50">
		<div>
			<a href="/donations/add">Add Donation</a>
		</div>
		<div>
			<h1>All Donations</h1>
		</div>
		<div class="border rounded">
			<table class="table table-hover table-striped">
			    <thead>
			        <tr>
			            <th>Donation</th>
			            <th>Quantity</th>
			            <th>Donor</th>
			        </tr>
			    </thead>
			    <tbody>
			         <c:forEach var="donation" items="${donationList}">
			         	<tr>
			         		<td><a href="/donations/${donation.id}"><c:out value="${donation.donationName}"/></a></td>
			         		<td><c:out value="${donation.quantity}"/></td>
			         		<td><c:out value="${donation.donor}"/></td>
			         	</tr>
			         </c:forEach>
			    </tbody>
		    </table>
		    <div>
		    <h4><a href="/books/new">Add your favorite book!</a></h4>
		    </div>
		</div>
	</div>
</body>
</html>