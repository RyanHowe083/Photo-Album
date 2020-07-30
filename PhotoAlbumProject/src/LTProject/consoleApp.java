package LTProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class consoleApp {
	
	//A single URL connection
		private static HttpURLConnection connection;
		
		

		public static void main(String[] args) throws JSONException, JsonParseException, IOException {
			BufferedReader reader;
			StringBuffer responseContent = new StringBuffer();
			String line;
			JsonFactory factory = new JsonFactory();
			
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
					}
					reader.close();

				}
				
				
				
				
				
				
			} catch (MalformedURLException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
			}
			JsonParser parser = factory.createParser(responseContent.toString());
			Album album = new Album();
			ArrayList<Album> list = new ArrayList<Album>();
			while(!parser.isClosed()){
			    JsonToken jsonToken = parser.nextToken();

			    if(JsonToken.FIELD_NAME.equals(jsonToken)){
			        String fieldName = parser.getCurrentName();
//			        System.out.println(fieldName);

			        jsonToken = parser.nextToken();

			        if("albumId".equals(fieldName)){
			        	
			        	album.setAlbumId(parser.getValueAsInt());
//			        	System.out.println(album.getAlbumId());
			        } else if ("id".equals(fieldName)){
			        	album.setId(parser.getValueAsInt());
			        	
			        }else if("title".equals(fieldName)) {
			        	album.setTitle(parser.getValueAsString());
			        }else if("url".equals(fieldName)) {
			        	album.setUrl(parser.getValueAsString());
			        }else if("thumbnailUrl".equals(fieldName)) {
			        	album.setThumbnailUrl(parser.getValueAsString());
			        	
			        	//Once we hit this cell we can add the album to a list
			        	list.add(album);
			        	album = new Album();
			        	
			        }
			    }
			}
			int count = 1;
			for(int i = 0; i < list.size();i++) {
				if(count == list.get(i).getAlbumId()-1) {
					System.out.println("> photo-album " + count);
					System.out.println();
					count++;
				}else {
					System.out.println("[" + list.get(i).getId() + "]" + list.get(i).getTitle());
					System.out.println();
				}
			}

		}

}
