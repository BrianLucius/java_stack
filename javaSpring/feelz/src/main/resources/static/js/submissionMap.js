// https://developers.google.com/maps/documentation/javascript/adding-a-google-map#maps_add_map-javascript
// Initialize and add the map
function initMap(data) {

  const center = { lat: 39.760556, lng: -99.119722 };

  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 1,
    center: center,
  });
  for (let i=0; i < data.length; i++) {
	console.log("Adding: ", data[i]);
	marker = new google.maps.Marker({
	    position: data[i],
	    map: map,
	  });
  }
}

async function renderSubmissionMap() {
	fetch ('http://localhost:8080/api/location')
//	fetch ('https://feelz.cc/api/trending')
		.then(function(response) {
			return response.json();
		})
		.then(function(data) {
			window.initMap = initMap(data);
		});
};
renderSubmissionMap();

//window.initMap = initMap;
