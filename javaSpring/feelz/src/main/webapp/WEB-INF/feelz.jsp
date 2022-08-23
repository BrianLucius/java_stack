<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
<meta charset="UTF-8">
<title>Feelz</title>
</head>
<body>
	<div class="py-5 vh-100 container-fluid bg-light">
		<div class="mb-5 text-center">
			<h1>Feelz</h1>
			<h4>How do <i>you</i> Feelz right now?</h4>
		</div>
		<div class="row d-flex justify-content-center">
			<div class="col-md-4 border bg-white rounded shadow p-3 pb-5">
				<form:form class="text-center" action="/" method="POST" modelAttribute="feelz" id="feelzForm">
				    <div class="mood" id="moodEmoji">
					</div>
					<div id="slider">
						<span class="emoji">&#x1F62D;</span>
						<form:input type="range" min="1" max="10" class="slider w-50" id="myMood" path="mood"></form:input>
						<span class="emoji">&#x1F973;</span>
					</div>
					<div class = "mt-5" id="emotion">
						<form:label class="form-label " path="Emotion"><h5>Enter a single word to describe your present emotion:</h5></form:label>
						<div>
							<form:errors class="alert-danger px-3 py-2 rounded" path="emotion"/>
						</div>
						<div class="mt-2">
							<form:input class="mx-auto form-control form-control-lg col-1 w-50 text-center shadow" id="emotionWord" type="text" path="emotion"/>
						</div>
					</div>
					<div id="ip"></div>
					<div id="location"></div>
					<div id="ubid"></div>
					<input class="mt-5 btn btn-success p-2 shadow" type="submit" value="Submit"/>
				</form:form>
			</div>
		</div>
		<div id="footer" class="mt-5">
			<div class="text-center">
				<button type="button" class="btn btn-link" data-bs-toggle="modal" data-bs-target="#exampleModalLong">
				  <b>About the Project</b>
				</button>
			</div>
			<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered text-left" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLongTitle">About This Project</h5>
			        <button type="button" class="btn btn-lg close" data-bs-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			        <p>The Feelz project is an ideation by Brian Lucius and is a capstone project for my <a href="https://www.codingdojo.com/" target="_blank">Coding Dojo</a> Java full stack studies.</p>
			        <p>The project aims to collect and create analytics around the global sentiment of Internet connected beings as often as they can remember to submit their current sentiment to the project.</p>
			        <p>In addition to recording your current sentiment and your keyword, the project collects several unique identifiers to aid in analytics processing and generation:</p>
			        <ul>
			        	<li>This experiment will capture the latitude and longitude of your device if you voluntarily enable location services on your device/browser. If location services are not enabled, the latitude and longitude of your ISPs nearest Point of Presence is used instead.</li>
			        	<li>The IP address assigned to your device by your Internet Service Provider is captured.</li>
			        	<li>A unique browser identifier is collected based on the work of Hone, Inc. and the source can be found at: <a href="https://github.com/honeinc/ubid" target="_blank">https://github.com/honeinc/ubid</a>.<br>Much gratitude to the team at Hone, Inc.</li>
			        </ul>
			        <p>None of the information collected will be sold or distributed to any other entity and is strictly for use in this capstone project by Brian Lucius.</p>
			        <p>For questions, conversation, or employment consideration please read more about me on <a href="https://www.linkedin.com/in/brianjlucius/" target="_blank">LinkedIn</a>.</p>
			      </div>
	              <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
	</div>
	<script src="/js/script.js"></script>
	<script src="/js/ubid.js"></script>
</body>
</html>