package LTProject;

/**
 * @author ryanhowe
 */

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;

/**
 * This class creates a console application which displays photo ids and titles
 * in an album.
 */
public class Album {

	private static HttpURLConnection connection;

	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/photos");

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
