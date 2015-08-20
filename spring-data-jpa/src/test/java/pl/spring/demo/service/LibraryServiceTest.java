package pl.spring.demo.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.to.BookTo;
import pl.spring.demo.to.LibraryTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class LibraryServiceTest {

	@Autowired
	private LibraryService libraryService;
	@Autowired
	private BookService bookService;

	@Test
	public void testShouldRemoveAllBookInLibrary() {
		// given
		final Long idLibrary = 3L;
		// when
		List<LibraryTo> libraryBeforeRemoved = libraryService.findAll();
		List<BookTo> bookBeforeRemoved = bookService.findAllBooks();
	
		libraryService.deleteLibrary(idLibrary);
		List<LibraryTo> libraryAfterRemoved = libraryService.findAll();
		List<BookTo> bookAfterRemoved = bookService.findAllBooks();
		// then
		assertTrue(libraryAfterRemoved.size() < libraryBeforeRemoved.size());
		assertTrue(bookAfterRemoved.size() < bookBeforeRemoved.size());
	}

}
