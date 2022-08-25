package net.brianlucius.feelz.classes;

public class MapsLocation {

	    private double lat;
	    private double lng;
	    
	    public MapsLocation() {
	    };

	    public MapsLocation(Double latitude, Double longitude) {
	        lat = latitude;
	        lng = longitude;
	    }
	    
	    public MapsLocation(String locType, Double latitude, Double longitude) {
	        lat = latitude;
	        lng = longitude;
	    }

		public double getLat() {
			return lat;
		}

		public double getLng() {
			return lng;
		}
	    
		public void setLat(Double latitude) {
			this.lat = latitude;
		}

		public void setLng(Double longitude) {
			this.lng = longitude;
		}

}
