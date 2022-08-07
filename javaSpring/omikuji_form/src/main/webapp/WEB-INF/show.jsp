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
<title>Omikugi</title>
</head>
<body class="background vh-100">
	<div class="container p-5 w-50 mx-auto">
		<div id="header" class="text-center">
			<h1>Here's Your Omikuji!</h1>
		</div>
		<div id="omikuji" class="border rounded p-3 bg-primary text-light mb-3 shadow">
			<h3>In <c:out value="${anyNumber}"/> years you will live in <c:out value="${city}"/> with <c:out value="${personName}"/> as your room mate, <c:out value="${activity}"/> for a living. The next time you see a <c:out value="${livingThing}"/>, you will have good luck. Also, <c:out value="${nice}"/></h3>
		</div>
		<div id="formFooter">
			<div class="row text-center">
				<h3><a href="/omikuji">Back to Beginning</a></h3>
			</div>
		</div>
	</div>
</body>
</html>