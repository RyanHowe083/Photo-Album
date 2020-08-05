package com.album;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlbumTest {

	Album a = new Album(1,2,null,null,null);
	
	/**
	 * Test method for {@link LTProject.Album#getAlbumId()}.
	 */
	@Test
	public void testGetAlbumId() {
		assertEquals(1, a.getAlbumId());
	}

	/**
	 * Test method for {@link LTProject.Album#setAlbumId(int)}.
	 */
	@Test
	public void testSetAlbumId() {
		a.setAlbumId(20);
		assertNotEquals(2, a.getAlbumId());
		assertEquals(20, a.getAlbumId());
	}

	/**
	 * Test method for {@link LTProject.Album#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(2, a.getId());
		
	}

	/**
	 * Test method for {@link LTProject.Album#setId(int)}.
	 */
	@Test
	public void testSetId() {
		a.setId(4);
		assertNotEquals(2,a.getId());
		assertEquals(4, a.getId());
	}

	/**
	 * Test method for {@link LTProject.Album#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		assertEquals(null, a.getTitle());
	}

	/**
	 * Test method for {@link LTProject.Album#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		a.setTitle("testing title");
		assertNotEquals(null,a.getTitle());
		assertEquals("testing title", a.getTitle());
	}

	/**
	 * Test method for {@link LTProject.Album#getUrl()}.
	 */
	@Test
	public void testGetUrl() {
		assertEquals(null, a.getUrl());
	}

	/**
	 * Test method for {@link LTProject.Album#setUrl(java.lang.String)}.
	 */
	@Test
	public void testSetUrl() {
		a.setUrl("testing url");
		assertNotEquals(null, a.getUrl());
		assertEquals("testing url", a.getUrl());
	}

	/**
	 * Test method for {@link LTProject.Album#getThumbnailUrl()}.
	 */
	@Test
	public void testGetThumbnailUrl() {
		assertEquals(null, a.getThumbnailUrl());
	}

	/**
	 * Test method for {@link LTProject.Album#setThumbnailUrl(java.lang.String)}.
	 */
	@Test
	public void testSetThumbnailUrl() {
		a.setThumbnailUrl("testing thumb");
		assertNotEquals(null, a.getThumbnailUrl());
		assertEquals("testing thumb", a.getThumbnailUrl());
	}

}
