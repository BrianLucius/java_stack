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
<title>${dormsList.dormName}</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row text-center">
			<h1>${dormsList.dormName} Students</h1>
		</div>
		<div>
			<a href="/dorms">Dashboard</a>
		</div>
		<div class="m-5 p-5 shadow rounded">
			<form:form action="/students/update/${dormsList.id}" method="POST" modelAttribute="student">
			<input type="hidden" name="_method" value="PUT" />
				<div>
					<form:hidden path="dorm"/>
					<form:hidden path="studentName"/>
					<form:label path="id">Students:</form:label>
					<form:select path="id">
						<c:forEach var="student" items="${studentsList}">
							<option value="${student.id}">${student.studentName} (${student.dorm.dormName})</option>
						</c:forEach>
					</form:select>
				</div>		
				<input type="submit" value="Add"/>
			</form:form>
		</div>
		<div class="m-5 p-5 shadow rounded">
			<table>
				<thead>
					<tr>
						<th>Student</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${dormsList.students}">
						<tr>
							<td><c:out value="${student.studentName}"/></td>
							<td><form:form action="/students/${dormsList.id}/${student.id}" method="POST">
								<input type="hidden" name="_method" value="PUT" />
								<input type="submit" value="Remove"/>
								</form:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>