package LTProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * 
 * @author ryanhowe
 *
 */
public class consoleApp {

	// A single URL connection
	private static HttpURLConnection connection;

	public static void main(String[] args) {
		// Few variables for getting the info from the url
		BufferedReader reader;
		StringBuffer responseContent = new StringBuffer();
		String line;

		// Attempt to read the URL and display the specified information to the user
		try {
			// Set the URL for the JSON placeholder
			URL url = new URL("https://jsonplaceholder.typicode.com/photos");
			connection = (HttpURLConnection) url.openConnection();

			// Get request
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			// User a reader to append the information to the responseConent
			int status = connection.getResponseCode();
			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

				while ((line = reader.readLine()) != null) {
					responseContent.append(line);

				}
				reader.close();

			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();

			}

			// Parse the list and display the content to the user
			display(createAlbumList(responseContent));

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method parses the tokens and creates Albums for the list to be returned
	 * 
	 * @param responseContent
	 * @return
	 * @throws JsonParseException
	 * @throws IOException
	 */
	private static ArrayList<Album> createAlbumList(StringBuffer responseContent)
			throws JsonParseException, IOException {
		// Now use a parser to get the information from the responseContent and after
		// the info from one album is parsed add the object to a list
		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(responseContent.toString());
		Album album = new Album();
		ArrayList<Album> list = new ArrayList<Album>();
		while (!parser.isClosed()) {
			JsonToken jsonToken = parser.nextToken();

			// Add each token information to the album object one by one.
			// The final toke is always thumbnailURL
			if (JsonToken.FIELD_NAME.equals(jsonToken)) {
				String fieldName = parser.getCurrentName();

				jsonToken = parser.nextToken();

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
	private static void display(ArrayList<Album> list) {
		System.out.println("Which album would you like displayed?");
		try (Scanner sc = new Scanner(System.in)) {
			int albumNum = sc.nextInt();
			System.out.println("> photo-album " + albumNum);
			System.out.println();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getAlbumId() == albumNum) {
					System.out.println("[" + list.get(i).getId() + "]" + list.get(i).getTitle());
					System.out.println();

				}

			}
		}

	}

}
