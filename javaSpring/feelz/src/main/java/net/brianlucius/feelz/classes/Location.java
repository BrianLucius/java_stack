package net.brianlucius.feelz.classes;

public class Location {

		private String type;
	    private double latitude;
	    private double longitude;
	    
	    public Location() {
	    };

	    public Location(Double lat, Double lon) {
	    	latitude = lat;
	    	longitude = lon;
	    }
	    
	    public Location(String locType, Double lat, Double lon) {
	    	type = locType;
	    	latitude = lat;
	    	longitude = lon;
	    }
	    
	    public String getType() {
			return type;
		}

		public double getLatitude() {
			return latitude;
		}

		public double getLongitude() {
			return longitude;
		}

	    public void setType(String locType) {
			type = locType;
		}
	    
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

}
