package com.album;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

import org.junit.Test;

public class ConsoleAppTest {
	
	ConsoleApp app = new ConsoleApp();

	@Test
	public void configConnectionTest() throws IOException {
		app.setUrl(1);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		app.configConnection();
		assertEquals(5000, app.getConnection().getConnectTimeout());
		assertEquals(5000, app.getConnection().getReadTimeout());
		
	}
	
	@Test
	public void createBufferTest() throws IOException {
		app.setUrl(1);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		app.configConnection();
		app.createBuffer();
		
		assertNotNull(app.getResponseContent());
		
	}
	
	@Test
	public void createAlbumListTest() throws IOException {
		app.setUrl(1);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		app.configConnection();
		app.createBuffer();
		
		assertNotNull(app.createAlbumList());
		
	}
	
	@Test
	public void createAlbumListSizeTest() throws IOException {
		app.setUrl(1);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		app.configConnection();
		app.createBuffer();
		
		assertEquals(50, app.createAlbumList().size());
		
	}
	
	@Test
	public void createAlbumListIdeTest() throws IOException {
		app.setUrl(1);
		app.setConnection((HttpURLConnection) app.getUrl().openConnection());
		app.configConnection();
		app.createBuffer();
		
		assertEquals(1, app.createAlbumList().get(0).getAlbumId());
		
	}

}
