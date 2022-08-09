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
<title>Edit My Task</title>
</head>
<body>
	<div class="container mt-5 w-50">
		<div>
			<h1 class="mb-2">Edit Expense</h1>
			<a href="/expenses">Go Back</a>
		</div>
		 <div>
	    	<div class="border rounded border-primary p-3">
				<form:form action="/expenses/${expense.id}" method="POST" modelAttribute="expense">
				<input type="hidden" name="_method" value="PUT">
					<div class="mb-3">
						<form:label class="form-label" path="expenseName">Expense Name:</form:label>
						<form:errors path="expenseName" class="text-danger"/>
						<form:input class="form-control" type="text" path="expenseName" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="vendor">Vendor:</form:label>
						<form:errors path="vendor" class="text-danger"/>
						<form:input class="form-control" type="text" path="vendor" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="amount">Amount:</form:label>
						<form:errors path="amount" class="text-danger"/>
						<form:input class="form-control" type="number" step="0.01" path="amount" id="" />
					</div>
					<div class="mb-3">
						<form:label class="form-label" path="description">Description:</form:label>
						<form:errors path="description" class="text-danger"/>
						<form:textarea class="form-control" path="description" id="" />
					</div>
					<input class="button btn-primary p-2" type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>