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
<title>Show Expense</title>
</head>
<body>
	<div class="container mt-5 w-50">
		<div class="border rounded border-warning p-3 ">
			<h1>Expense Details</h1>
			<a href="/expenses">Go Back</a>
			<h3>Expense Name: <c:out value="${expense.expenseName}"/></h3>
			<h3>Expense Description: <c:out value="${expense.description}"/></h3>
			<h3>Vendor: <c:out value="${expense.vendor}"/></h3>
			<h3>Amount Spent: <fmt:formatNumber type="currency" value="${expense.amount}"/></h3>
		</div>
	</div>
</body>
</html>