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
<body class="background min-vh-100">
	<div class="container p-5 w-50 mx-auto">
		<div id="header" class="text-center">
			<h1>Send an Omikuji!</h1>
		</div>
		<div id="submitForm" class="border rounded p-3 bg-light shadow">
			<form action="/submit" method="POST">
				<div id="formNumber" class="mb-4">
					<label for="anyNumber" class="form-label"><h4>Pick any number from 5 to 25:</h4></label>
					<input type="number" list="numberOptions" class="form-control" id="anyNumber" name="anyNumber">
						<datalist id="numberOptions">
						<c:forEach begin="5" end="25" step="1" var="i">
							<option value="${i}">
						</c:forEach>
						</datalist>
				</div>
				<div id="formCity" class="mb-4">
					<h4><label for="city" class="form-label">Enter the name of any city:</label></h4>
					<input type="text" class="form-control" id="city" name="city"/>
				</div>
				<div id="formPersonName" class="mb-4">
					<h4><label for="personName" class="form-label">Enter the name of any real person:</label></h4>
					<input type="text" class="form-control" id="personName" name="personName"/>
				</div>
				<div id="formActivity" class="mb-4">
					<h4><label for="activity" class="form-label">Enter a professional endeavor or hobby:</label></h4>
					<input type="text" class="form-control" id="activity" name="activity"/>
				</div>
				<div id="formLivingThing" class="mb-4">
					<h4><label for="livingThing" class="form-label">Enter any type of living thing:</label></h4>
					<input type="text" class="form-control" id="livingThing" name="livingThing"/>
				</div>
				<div id="formNice" class="mb-4">
					<h4><label for="nice" class="form-label">Say something nice to someone:</label></h4>
					<textarea class="form-control" id="nice" name="nice" style="height: 150px;"></textarea>
				</div>
				<div id="formFooter">
					<div class="row text-center">
						<div class="col-5">
							<h4>Send and show a friend.</h4>
						</div>
						<div class="col-1">
							<input class="btn btn-outline-primary" type="submit" value="Send" />
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>