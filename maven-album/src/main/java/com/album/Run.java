package com.album;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// Attempt to read the URL and display the specified information to the user
		ConsoleApp app = new ConsoleApp();
		try {
			// Get the Id from the user and set up the url connection
			System.out.println("Which album would you like displayed? (Album ID 1-100 are valid)");
			Scanner sc = new Scanner(System.in);

			int albumNum = sc.nextInt();
			sc.close();
			app.setUrl(albumNum);
			app.setConnection((HttpURLConnection) app.getUrl().openConnection());
			app.configConnection();
			app.createBuffer();
			// Parse the list and display the content to the user
			app.display(app.createAlbumList());

		} catch (MalformedURLException e) {// Bad url was used
			e.printStackTrace();

		} catch (IOException e) {// Some sort of bad input or output occured
			System.out.println("The input used was not the right format. Please use a number between 1-100");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("The Id you entered does not exist, please restart");
		}

	}

}
