
public class location {

	private String latitude;
	private String longitude;
	
	// Constructor
	public location(String latitude, String longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	// Getters and Setters
	
	public String getLatitude(){
		return this.latitude;
	}
	public String getLongitude(){
		return this.longitude;
	}
	public void setLatitude(String latitude){
		this.latitude = latitude;
	}
	public void setLongitude(String longitude){
		this.longitude = longitude;
	}
}
