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
<title>Save Travels</title>
</head>
<body>
	<div class="container mt-5 w-50">
		<div>
			<h1 class="mb-2">All Expenses</h1>
		</div>
		<div class="border rounded mb-5">
			<table class="table table-hover table-striped">
			    <thead>
			        <tr>
			            <th>Expense</th>
			            <th>Vendor</th>
			            <th>Amount</th>
			        </tr>
			    </thead>
			    <tbody>
			         <c:forEach var="expense" items="${expensesList}">
			         	<tr>
			         		<td><c:out value="${expense.expenseName}"/></td>
			         		<td><c:out value="${expense.vendor}"/></td>
			         		<td><fmt:formatNumber type="currency" value="${expense.amount}"/></td>
			         	</tr>
			         </c:forEach>
			    </tbody>
		    </table>
		 </div>
		 <div>
		    <h2 class="mb-2">Add an expense:</h2>
	    	<div class="border rounded border-primary p-3">
				<form:form action="/expenses" method="POST" modelAttribute="expense">
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