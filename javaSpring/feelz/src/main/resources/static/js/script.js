var slider = document.getElementById("myMood");
var output = document.querySelector(".mood");
var moods = ["1F62D", "1F622", "2639;&#xFE0F", "1F615", "1F610", "1F642", "1F60A", "1F604", "1F60B", "1F973"];
output.innerHTML = "<span class='moodEmoji'>&#x"+moods[slider.value-1]+";</span>";

slider.oninput = function() {
  output.classList.add('pre-animation');
  setTimeout(function(){
    output.innerHTML = "<span class='moodEmoji'>&#x"+moods[slider.value-1]+";</span>";
	output.classList.remove('pre-animation')
	}, 125);
}

var emotionInput = document.getElementById("emotionWord");
var validate = new RegExp("^([A-Za-z]+)$");
emotion.oninput = function() {
	if(!validate.test(emotionInput.value) || emotionInput.value.length>15) {
		emotionInput.value = emotionInput.value.substring(0, emotionInput.value.length-1);	
	}
}

document.addEventListener('DOMContentLoaded', function() {
    // Unique Browser ID courtesy of: https://github.com/honeinc/ubid
	var ubid = require('ubid');
	ubid.get( function( error, signatureData ) {
	if ( error ) {
	    console.error( error );
	    return;
	}
	document.getElementById("ubid").innerHTML = '<input type="hidden" name="uniqueBrowserId" value='+signatureData.canvas.signature+'>';  
	} );
	
	// GeoIP Lookup to get ISP IP and lat/lon
	$.getJSON('https://json.geoiplookup.io/?callback=?', function(data) {
	    document.getElementById("ip").innerHTML = '<input type="hidden" name="browserIp" value='+JSON.stringify(data.ip, null, 2)+'>';
	    document.getElementById("location").innerHTML = '<input type="hidden" name="browserLocation" value='+JSON.stringify({type: "geoip", latitude: data.latitude, longitude: data.longitude})+'>';   
	});
	
	if ('geolocation' in navigator) {
		  console.log("geolocation is available");
		  navigator.geolocation.getCurrentPosition((position) => {
			  console.log("Lat: "+position.coords.latitude+"Lon: "+position.coords.longitude);
			  document.getElementById("location").innerHTML = '<input type="hidden" name="browserLocation" value='+JSON.stringify({type: "locationServices", latitude: position.coords.latitude, longitude: position.coords.longitude})+'>';
			});
		} else {
		  console.log("geolocation IS NOT available");
		}
	
}, false);
    
