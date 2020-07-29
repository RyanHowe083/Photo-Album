package LTProject;

/**
 * @author ryanhowe
 */

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Album {
	
	//A single URL connection
	private static HttpURLConnection connection;
	
	

	public static void main(String[] args) throws JSONException {
		BufferedReader reader;
		StringBuffer responseContent = new StringBuffer();
		String line;
		JSONObject json = new JSONObject();
		
		
		
		
		
		try {
			//Set the URL for the json placeholder
			URL url = new URL("https://jsonplaceholder.typicode.com/photos");
			connection = (HttpURLConnection) url.openConnection();
			
			//Get request
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int status = connection.getResponseCode();
			
			if(status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
					
					
				}
				reader.close();
				
			}else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
					String[] temp = line.split(":");
					
					
//					System.out.println(temp.length);
				}
				reader.close();

			}
			
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}

	}
}
