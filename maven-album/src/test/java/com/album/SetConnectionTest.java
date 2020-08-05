package com.album;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.junit.Test;

public class SetConnectionTest {
	
	ConsoleApp app = new ConsoleApp();
	
	@Test
	public void checkNullConnectionTest() throws IOException {
		assertNull(app.getConnection());
	}

	@Test
	public void setConnectionOneTest() throws IOException {
		app.setUrl(1);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionTwoTest() throws IOException {
		app.setUrl(2);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionThreeTest() throws IOException {
		app.setUrl(3);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionFourTest() throws IOException {
		app.setUrl(4);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionFiveTest() throws IOException {
		app.setUrl(5);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionSixTest() throws IOException {
		app.setUrl(6);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionSevenTest() throws IOException {
		app.setUrl(7);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionEightTest() throws IOException {
		app.setUrl(8);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionNineTest() throws IOException {
		app.setUrl(9);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}
	
	@Test
	public void setConnectionTenTest() throws IOException {
		app.setUrl(10);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		assertNotNull(app.getConnection());
	}

}
