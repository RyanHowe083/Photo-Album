package com.album;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class ConsoleApp {

	// A single URL connection
	private HttpURLConnection connection;
	private URL url;
	private BufferedReader reader;
	private StringBuffer responseContent;

	public ConsoleApp() {
		responseContent = new StringBuffer();
	}

	/**
	 * This method
	 * 
	 * @param albumNum
	 * @return urlTemp the temporary URL to return
	 * @throws MalformedURLException
	 */
	public void setUrl(int albumNum) {

		try {
			if(albumNum >=1 && albumNum <= 10) {
				url = new URL("https://jsonplaceholder.typicode.com/photos?albumId=" + albumNum);
				
			}else {
				throw new OutOfBoundsException("Incorrect input, enter a number between 1-10");
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(OutOfBoundsException e) {
//			e.printStackTrace();
			
		}

	}

	public URL getUrl() {
		return url;
	}
	
	public void configConnection() throws ProtocolException {
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		
	}

	public void createBuffer() {

		String line;
		StringBuffer rc = new StringBuffer();
		// Get request
		try {
			

			// User a reader to append the information to the responseConent
			int status = connection.getResponseCode();
			if (status > 299) {
				setReader(new BufferedReader(new InputStreamReader(connection.getErrorStream())));

			} else {
				setReader(new BufferedReader(new InputStreamReader(connection.getInputStream())));

			}
			while ((line = getReader().readLine()) != null) {

				rc.append(line);

			}
			reader.close();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setResponseContent(rc);
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(HttpURLConnection connection) {
		this.connection = connection;
	}

	/**
	 * @return the reader
	 */
	public BufferedReader getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	/**
	 * @param responseContent the responseContent to set
	 */
	public void setResponseContent(StringBuffer responseContent) {
		this.responseContent = responseContent;
	}

	/**
	 * This method parses the tokens and creates Albums for the list to be returned
	 * 
	 * @param responseContent
	 * @return
	 * @throws JsonParseException
	 * @throws IOException
	 */
	public ArrayList<Album> createAlbumList() throws JsonParseException, IOException {
		// Now use a parser to get the information from the responseContent and after
		// the info from one album is parsed add the object to a list
		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(responseContent.toString());
		Album album = new Album();
		ArrayList<Album> list = new ArrayList();
		while (!parser.isClosed()) {
			JsonToken jsonToken = parser.nextToken();

			// Add each token information to the album object one by one.
			// The final toke is always thumbnailURL
			if (JsonToken.FIELD_NAME.equals(jsonToken)) {
				String fieldName = parser.getCurrentName();

				parser.nextToken();
				if ("albumId".equals(fieldName)) {
					album.setAlbumId(parser.getValueAsInt());
				} else if ("id".equals(fieldName)) {
					album.setId(parser.getValueAsInt());

				} else if ("title".equals(fieldName)) {
					album.setTitle(parser.getValueAsString());
				} else if ("url".equals(fieldName)) {
					album.setUrl(parser.getValueAsString());
				} else if ("thumbnailUrl".equals(fieldName)) {
					album.setThumbnailUrl(parser.getValueAsString());

					// Last string to parse so add the album object to the list and reset
					list.add(album);
					album = new Album();

				}
			}
		}
		return list;

	}

	/**
	 * This method gets the user specified album to display and then loops through
	 * the list to do so
	 * 
	 * @param list
	 */
	public void display(ArrayList<Album> list) {
		System.out.println("> photo-album " + list.get(0).getAlbumId());
		System.out.println();
		for (Album album : list) {
			System.out.println("[" + album.getId() + "]" + album.getTitle());
			System.out.println();
		}

	}

	public URLConnection getConnection() {
		// TODO Auto-generated method stub
		return connection;
	}

	public StringBuffer getResponseContent() {
		// TODO Auto-generated method stub
		return responseContent;
	}

}
