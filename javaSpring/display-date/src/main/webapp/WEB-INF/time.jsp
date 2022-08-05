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
<script src="/js/utils.js"></script>
<meta charset="UTF-8">
<title>Time</title>
</head>
<body>
	<div class="container m-5 p-5 border rounded">
		<div class="row text-center">
			<div id="currentTime" class="col-12">
				<p><fmt:formatDate pattern="h" value="${currentDate}"/>:<fmt:formatDate pattern="mm" value="${currentDate}"/> <fmt:formatDate pattern="a" value="${currentDate}"/></p>
			</div>
		</div>
	</div>
</body>
</html>