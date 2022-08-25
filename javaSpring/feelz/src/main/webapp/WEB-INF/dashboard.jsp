<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="https://d3js.org/d3.v7.min.js"></script>
<script src="/js/bubbleChart.js"></script>
<script src="/js/submissionMap.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<meta charset="UTF-8">
<title>Feelz Analytics | Dashboard</title>
</head>
<body>
	<div class="container mt-5">		
		<nav class="navbar navbar-expand-lg navbar-dark mb-3 rounded" style="background-color: cornflowerblue">
			<div class="container-fluid">
				<a class="navbar-brand">Feelz Analytics</a>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
				          <a class="nav-link" href="/analytics_portal/dashboard">Dashboard</a>
				          <a class="nav-link" href="/analytics_portal/usermanagement">User Management</a>
				          <a class="nav-link" href="https://feelz.cc" target="_blank" >feelz.cc</a>
			        </div>
		        </div>
		        	<a class="nav-link text-light">${user_first_name} ${user_last_name}</a>
		        <div>
				    <a class="nav-link text-light" href="/analytics_portal/logout">Logout</a>
		        </div>
			</div>
		</nav>
		<div>
			<h3>Welcome, let's get started:</h3>
		</div>
		<div class="border rounded shadow p-3">
			<div class="row d-flex justify-content-center">
				<div class="col-md-5 border bg-white rounded shadow p-2 m-2">
					<div class="m-2">
						<h4 id="bubble-chart-title"></h4> 
						<svg id="bubble-chart"></svg>
					</div>
				</div>
				<div class="col-md-6 border bg-white rounded shadow p-2 m-2">
					<div class="m-2">
						<h4 id="map-title">Submissions Map</h4> 
						<div id="map"></div>
						<script id="mapsAPI" async></script>
					</div>
				</div>
		 	</div>
		</div>
	</div>
<script src="/js/config.js"></script>
</body>
</html>