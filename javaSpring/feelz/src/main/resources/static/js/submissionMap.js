// https://developers.google.com/maps/documentation/javascript/adding-a-google-map#maps_add_map-javascript
// Initialize and add the map
  var mapWaitCount = 0;
  var mapWaitMax = 5;

function initMap(data) {

  mapWaitCount++;
  const center = { lat: 39.760556, lng: -99.119722 };
  
  if(typeof google != 'undefined') {
	  const map = new google.maps.Map(document.getElementById('map'), {
	   zoom: 1,
	   center: center,
	  });
	  for (let i=0; i < data.length; i++) {
		let pinType = "";
		
		switch(data[i].type) {
			case "locationServices":
				pinType = "https://maps.google.com/mapfiles/ms/icons/blue-dot.png";
				break
			default:
				pinType = "https://mt.googleapis.com/vt/icon/name=icons/spotlight/spotlight-poi.png&scale=.85";
		}
		marker = new google.maps.Marker({
		    position: {"lat": data[i].lat, "lng": data[i].lng},
		    map: map,
		    icon: {url: pinType}
		  });
	  }
	} else if(mapWaitCount < mapWaitMax) {
        console.log('Waiting attempt #' + mapWaitCount); // just log
        setTimeout(function() { initMap(data); }, 1000);
    }
    // if failed after maximum attempt, not mandatory
    else if(mapWaitCount >= mapWaitMax) {
        console.log('Failed to load google api');
    }
}

async function renderSubmissionMap() {
	fetch ("http://localhost:8080/api/location")
//	fetch ('https://feelz.cc/api/location')
		.then(function(response) {
			return response.json();
		})
		.then(function(data) {
			window.initMap = initMap(data);
		});
};
//renderSubmissionMap();

//window.initMap = initMap;
