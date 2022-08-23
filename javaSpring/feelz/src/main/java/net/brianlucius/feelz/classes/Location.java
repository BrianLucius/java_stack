package net.brianlucius.feelz.classes;

public class Location {

		private String type;
	    private double latitude;
	    private double longitude;
	    
	    public Location() {
	    };

	    public Location(String locType, Double lat, Double lon) {
	    	type = locType;
	        latitude = lat;
	        longitude = lon;
	    }
	    
	    public String getLocType() {
			return type;
		}

		public double getLatitude() {
			return latitude;
		}

		public double getLongitude() {
			return longitude;
		}

	    public void setLocType(String locType) {
			type = locType;
		}
	    
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

}
