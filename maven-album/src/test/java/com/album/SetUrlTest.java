package com.album;

import static org.junit.Assert.assertEquals;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import org.junit.Test;

public class SetUrlTest {

	ConsoleApp app = new ConsoleApp();
	HttpURLConnection conn;

	@Test
	public void setUrlTestOne() throws MalformedURLException {
		app.setUrl(1);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 1, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestTwo() throws MalformedURLException {
		app.setUrl(2);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 2, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestThree() throws MalformedURLException {
		app.setUrl(3);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 3, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestFour() throws MalformedURLException {
		app.setUrl(4);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 4, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestFive() throws MalformedURLException {
		app.setUrl(5);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 5, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestSix() throws MalformedURLException {
		app.setUrl(6);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 6, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestSeven() throws MalformedURLException {
		app.setUrl(7);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 7, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestEight() throws MalformedURLException {
		app.setUrl(8);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 8, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestNine() throws MalformedURLException {
		app.setUrl(9);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 9, app.getUrl().toString());

	}
	
	@Test
	public void setUrlTestTen() throws MalformedURLException {
		app.setUrl(10);
		assertEquals("https://jsonplaceholder.typicode.com/photos?albumId=" + 10, app.getUrl().toString());

	}
	
	@Test
	public void setUrlBadTest() throws MalformedURLException {
		app.setUrl(11);
		
	}

	

}
