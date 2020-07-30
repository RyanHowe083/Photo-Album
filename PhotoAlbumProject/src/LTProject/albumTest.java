/**
 * 
 */
package LTProject;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ryanhowe
 *
 */
public class albumTest {

	/**
	 * Test method for {@link LTProject.Album#getAlbumId()}.
	 */
	@Test
	public void testGetAlbumId() {
		Album a = new Album(1,2,null,null, null);
		assertEquals(1, a.getAlbumId());
	}

	/**
	 * Test method for {@link LTProject.Album#setAlbumId(int)}.
	 */
	@Test
	public void testSetAlbumId() {
		Album a = new Album(1,2,null,null, null);
		a.setAlbumId(20);
		assertEquals(20, a.getAlbumId());
	}

	/**
	 * Test method for {@link LTProject.Album#getId()}.
	 */
	@Test
	public void testGetId() {
		Album a = new Album(1,2,null,null, null);
		assertEquals(2, a.getId());
	}

	/**
	 * Test method for {@link LTProject.Album#setId(int)}.
	 */
	@Test
	public void testSetId() {
		Album a = new Album(1,2,null,null, null);
		a.setId(4);
		assertEquals(4, a.getId());
	}

	/**
	 * Test method for {@link LTProject.Album#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		Album a = new Album(1,2,"Iowa Scenery",null, null);
		assertEquals("Iowa Scenery", a.getTitle());
	}

	/**
	 * Test method for {@link LTProject.Album#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		Album a = new Album();
		a.setTitle("testing title");
		assertEquals("testing title", a.getTitle());
	}

	/**
	 * Test method for {@link LTProject.Album#getUrl()}.
	 */
	@Test
	public void testGetUrl() {
		Album a = new Album(1,2,"Iowa Scenery","www.com", null);
		assertEquals("www.com", a.getUrl());
	}

	/**
	 * Test method for {@link LTProject.Album#setUrl(java.lang.String)}.
	 */
	@Test
	public void testSetUrl() {
		Album a = new Album();
		a.setUrl("testing url");
		assertEquals("testing url", a.getUrl());
	}

	/**
	 * Test method for {@link LTProject.Album#getThumbnailUrl()}.
	 */
	@Test
	public void testGetThumbnailUrl() {
		Album a = new Album(1,2,"Iowa Scenery","www.com", "Another Url");
		assertEquals("Another Url", a.getThumbnailUrl());
	}

	/**
	 * Test method for {@link LTProject.Album#setThumbnailUrl(java.lang.String)}.
	 */
	@Test
	public void testSetThumbnailUrl() {
		Album a = new Album();
		a.setThumbnailUrl("testing thumb");
		assertEquals("testing thumb", a.getThumbnailUrl());
	}

}
