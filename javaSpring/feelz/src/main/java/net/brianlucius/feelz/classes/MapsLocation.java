package net.brianlucius.feelz.classes;

public class MapsLocation {

		private String type;
	    private double lat;
	    private double lng;
	    
	    public MapsLocation() {
	    };

	    public MapsLocation(Double latitude, Double longitude) {
	        lat = latitude;
	        lng = longitude;
	    }
	    
	    public MapsLocation(String locType, Double latitude, Double longitude) {
	    	type = locType;
	        lat = latitude;
	        lng = longitude;
	    }

	    public String getType() {
			return type;
		}
	    
		public double getLat() {
			return lat;
		}

		public double getLng() {
			return lng;
		}
	    
		public void setType(String locType) {
			this.type = locType;
		}
		
		public void setLat(Double latitude) {
			this.lat = latitude;
		}

		public void setLng(Double longitude) {
			this.lng = longitude;
		}

}
