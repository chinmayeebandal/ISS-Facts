/* The code uses the International Space Station API to find the coordinates of where the ISS is located at the
 *  moment and also gives the number of people in space. It also gives the number of passes the ISS made 
 *  over a location whose coordinates are provided by the user.
 */



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.client.fluent.Request;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;


public class iss_location {

	// Gives the latitude and longitude of the International Space Station
	
	public static location getISSlocation(){
		
		String response = "";

	    try{
	        response = Request.Get("http://api.open-notify.org/iss-now.json").execute().returnContent().asString();
	    }catch(IOException ex){
	        ex.printStackTrace();
	    }
	    
	    JsonValue jsonValue = Json.parse(response);
	    JsonObject obj = jsonValue.asObject();
	    JsonObject location = obj.get("iss_position").asObject();
	    
	    String lat = location.get("latitude").asString();
	    String lon = location.get("longitude").asString();
	    
	    return new location(lat,lon);
	    
	}

	
	// Gives the current number of astronauts in space and the spacecrafts they are in
	
	public static HashMap<String,String> personsInSpace(){
		HashMap<String, String> map = new HashMap<String, String>();
		String response = "";

	    try{
	        response = Request.Get("http://api.open-notify.org/astros.json").execute().returnContent().asString();
	    }catch(IOException ex){
	        ex.printStackTrace();
	    }
	    
	    JsonValue value = Json.parse(response);
	    JsonObject obj = value.asObject();
	    JsonArray arr = obj.get("people").asArray();
	    for(JsonValue val: arr){
	        
	        JsonObject jobj = val.asObject();
	        map.put(jobj.get("name").asString(), jobj.get("craft").asString());
	       
	    }
	    return map;
	}
	
	
	// Gives the number of times the ISS passed over a location whose coordinates are provided by the user
	
	public static Integer passTime(String lat, String lon){
		
		String response = "";
		String url = "http://api.open-notify.org/iss-pass.json?lat=" + lat+ "&lon=" + lon;

	    try{
	        response = Request.Get(url).execute().returnContent().asString();
	    }catch(IOException ex){
	        ex.printStackTrace();
	    }
	    
	    JsonValue value = Json.parse(response);
	    JsonObject obj = value.asObject();
	    JsonObject obj1 = obj.get("request").asObject();
	    
	    return obj1.get("passes").asInt();
	}
	
}
