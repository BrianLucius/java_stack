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
<title>Ninja Gold Game</title>
</head>
<body class="background min-vh-100">
	<div class="container p-5 mx-auto">
		<div id="score" class="row mt-5 mb-5">
		<h3>Your Gold: <img src="https://cdn4.vectorstock.com/i/thumb-large/90/53/coin-gold-pixelated-icon-vector-11699053.jpg" height="50px" alt="gold coin" /> <c:out value="${gold}"/></h3>
		</div>
		<div id="playField" class="row mb-5">
			<div class="col pt-5 pb-5 border rounded text-center farmBackground">
				<h3 class="mb-5">Farm</h3>
				<h5 class="mb-5">(earns 10-20 gold)</h5>
				<form action="/play" method="POST">
					<input type="hidden" value="farm" name="playType">
					<input type="submit" value="Find Gold!" class="btn btn-success">
				</form>
			</div>
			<div class="col pt-5 pb-5 p-3 border rounded text-center caveBackground">
				<h3 class="mb-5">Cave</h3>
				<h5 class="mb-5">(earns 5-10 gold)</h5>
				<form action="/play" method="POST">
					<input type="hidden" value="cave"name="playType">
					<input type="submit" value="Find Gold!" class="btn btn-success">
				</form>
			</div>
			<div class="col pt-5 pb-5 p-3 border rounded text-center houseBackground">
				<h3 class="mb-5">House</h3>
				<h5 class="mb-5">(earns 2-5 gold)</h5>
				<form action="/play" method="POST">
					<input type="hidden" value="house" name="playType">
					<input type="submit" value="Find Gold!" class="btn btn-success">
				</form>
			</div>
			<div class="col pt-5 pb-5 p-3 border rounded text-center questBackground">
				<h3 class="mb-5">Quest</h3>
				<h5 class="mb-5">(earns/costs 0-50 gold)</h5>
				<form action="/play" method="POST">
					<input type="hidden" value="quest" name="playType">
					<input type="submit" value="Find Gold!" class="btn btn-success">
				</form>
			</div>
			<div class="col pt-5 pb-5 p-3 border rounded text-center bg-primary">
				<h3 class="mb-5">Spa</h3>
				<h5 class="mb-5">(costs 5-20 gold)</h5>
				<form action="/play" method="POST">
					<input type="hidden" value="spa" name="playType">
					<input type="submit" value="Spend Gold!" class="btn btn-success">
				</form>
			</div>
		</div>
		<div id="activites" class="row">
			<h3 class="mb-2">Activities:</h3>
			<textarea readonly name="activities" id="activities" style="height: 175px;"><c:forEach items="${activities}" var= "activity">${activity}
</c:forEach>
			</textarea>
		</div>
	</div>
</body>
</html>