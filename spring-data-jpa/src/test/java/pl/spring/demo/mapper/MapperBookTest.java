package pl.spring.demo.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;


public class MapperBookTest {

	private MapperBook mapperBook;
	
    @Before
    public void setUpt() {
    	mapperBook = new MapperBook();
    }

	@Test
	public void testShouldConvertBookToToBookEntity() {
		// given
		BookTo bookTo = new BookTo(1L, "title", "authorFirstName authorLastName");
		// when
		BookEntity bookEntity = mapperBook.convertBookToToBookEntity(bookTo);
		// then
		assertNotNull(bookEntity);
		assertNotNull(bookTo);
		assertEquals("title", bookEntity.getTitle());
		assertEquals("authorFirstName", bookEntity.getAuthors().get(0).getFirstName());
		assertEquals("authorLastName", bookEntity.getAuthors().get(0).getLastName());
	}

	@Test
	public void testShouldConvertBookEntityToBookTo() {
		// given
		BookEntity bookEntity = new BookEntity(1L, "title", Arrays.asList(new AuthorTo(1L, "authorFirstName", "authorLastName")));
		// when
		BookTo bookTo = mapperBook.convertBookEntityToBookTo(bookEntity);
		// then
		assertNotNull(bookEntity);
		assertNotNull(bookTo);
		assertEquals("title", bookTo.getTitle());
		assertEquals("authorFirstName authorLastName", bookTo.getAuthors());
	}
	@Test
	public void testShouldConvertBookToListToBookEntityList() {
		// given
		List<BookEntity> bookEntityList = Arrays.asList(
				new BookEntity(1L, "title1", Arrays.asList(new AuthorTo(1L, "authorFirstName1", "authorLastName1"))),
				new BookEntity(2L, "title2", Arrays.asList(new AuthorTo(1L, "authorFirstName2", "authorLastName2"))),
				new BookEntity(3L, "title3", Arrays.asList(new AuthorTo(1L, "authorFirstName3", "authorLastName3"))));
		// when
		List<BookTo> bookToList = mapperBook.convertBookEntityListToBookToList(bookEntityList);
		// then
		assertNotNull(bookEntityList);
		assertNotNull(bookToList);
		assertEquals(3, bookToList.size());
	}
	@Test
	public void testShouldConvertBookEntityListToBookToList() {
		// given
		List<BookTo> bookToList = Arrays.asList(
				new BookTo(1L, "title1", "authorFirstName1 authorLastName1"),
				new BookTo(2L, "title2", "authorFirstName2 authorLastName2"),
				new BookTo(3L, "title3", "authorFirstName3 authorLastName3"));
		// when
		List<BookEntity> bookEntityList = mapperBook.convertBookToListToBookEntityList(bookToList);
		// then
		assertNotNull(bookEntityList);
		assertNotNull(bookToList);
		assertEquals(3, bookEntityList.size());
	}
	@Test
	public void testShouldConvertBookToAuthorToBookEntityAuthor() {
		// given
		String bookToAuthors = "authorFirstName1 authorLastName1, authorFirstName2 authorLastName2, authorFirstName3 authorLastName3";
		// when
		List<AuthorTo> bookEntityAuthors = mapperBook.convertStringAuthorToAuthorToList(bookToAuthors);
		// then
		assertNotNull(bookToAuthors);
		assertNotNull(bookEntityAuthors);
		assertEquals(3, bookEntityAuthors.size());
	}
	@Test
	public void testShouldConvertBookEntityAuthorToBookToAuthor() {
		// given
		List<AuthorTo> bookEntityAuthors = Arrays.asList(
				new AuthorTo(1L, "authorFirstName1", "authorLastName1"),
				new AuthorTo(2L, "authorFirstName2", "authorLastName2"),
				new AuthorTo(3L, "authorFirstName3", "authorLastName3"));
		// when
		
		String bookToAuthors = "authorFirstName1 authorLastName1, authorFirstName2 authorLastName2, authorFirstName3 authorLastName3";
		// then
		assertNotNull(bookToAuthors);
		assertNotNull(bookEntityAuthors);
		assertEquals(3, bookToAuthors.split(",").length);
		assertEquals(6, bookToAuthors.split("\\s+").length);
	}
}
