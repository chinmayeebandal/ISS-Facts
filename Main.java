import java.util.HashMap;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		iss_location iss = new iss_location();
		location loc = iss.getISSlocation();
		
		System.out.println("The International Space Station(ISS) is right now at the following coordinates:");
		System.out.println("Latitude: "+loc.getLatitude());
		System.out.println("Longitude: "+loc.getLongitude());
		
		HashMap<String,String> map = iss.personsInSpace();
		for(String names : map.keySet()){
			System.out.println("Astronaut "+ names + " is in the spacecraft " + map.get(names) +".");
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Give the coordinates to check the number of passes the ISSS made over a location:");
		
		System.out.println("Enter latitude: ");
		String lat = br.readLine();
		System.out.println("Enter longitude: ");
		String lon = br.readLine();
		
		System.out.println("The ISS passed the location ("+lat+", "+lon+ ") "+ iss.passTime(lat, lon)+" times.");
		
	}
}
