<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<h1>JSTL Demo</h1>
	<h1>Displaying Variables</h1>
	<p><c:out value="${jspName}"/></p>
	<p>${jspAge}</p>
	<!-- There is a risk of injection attacks by not using c:out -->
	<!-- If using an integer skipping c:out could be the exception. Strings vars are high risk to injection -->
	<%-- <p>${alertJs}</p> --%>
	<p><c:out value="${alertJs}"/></p>
	
	<h1>If-statement</h1>
	<c:if test = "${jspIsHungry}">
		<p> ${jspName} is hungry </p>
	</c:if>
	
	<h1>If-else statement</h1>
	<c:choose>
		<c:when test="${jspAge<21}">
			<p>${jspName} is under age</p>
		</c:when>
		<c:otherwise>
			<p>${jspName} is over 21</p>
		</c:otherwise>
	</c:choose>
	
	<h1>For each</h1>
	<ul>
		<c:forEach var = "user" items="${jspUsers}">
			<li><c:out value="${user}"/></li>
		</c:forEach>
	</ul>
	
	<h1>Styling Test</h1>
	<p class="styletest">Testing Styling</p>
	<p style="color:blue">Testing blue</p>
	
</body>
</html>