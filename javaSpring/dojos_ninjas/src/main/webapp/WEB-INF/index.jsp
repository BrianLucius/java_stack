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
<title>Dojos and Ninjas!</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4">
				<div class="m-5 p-5 shadow">
					<form:form action="/dojos/new" method="POST" modelAttribute="dojo">
							<div class="mb-3">
								<form:label class="form-label" path="name">Add a New Dojo:</form:label>
								<div>
									<form:errors path="name" class="text-danger"/>
								</div>
								<form:input class="form-control" type="name" path="name" id="" />
							</div>
							<input class="btn btn-outline-success p-2" type="submit" value="Create" />
						</form:form>
				</div>
			</div>
 			<div class="col-8">
 				<div class="m-5 p-5 justify-content-center align-items-center ">
					<a class="btn btn-success" href="/ninjas/new">Add a New Ninja</a>
 				</div>
			</div>
		</div>
		<div class="m-5 shadow">
			<table class="table table-hover table-striped mb-0">
			    <thead>
			        <tr>
			            <th>Dojo Name</th>
			        </tr>
			    </thead>
			    <tbody>
			         <c:forEach var="dojo" items="${dojoList}">
			         	<tr>
			         		<td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
			         	</tr>
			         </c:forEach>
			    </tbody>
		    </table>
		</div>
	</div>
</body>
</html>