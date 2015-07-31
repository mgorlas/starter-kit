package pl.spring.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookDaoImplTest {

	@Autowired
	private BookDao bookDao;

	@Test
	public void testShouldFindAllBooks() {
		// when
		List<BookEntity> allBooks = bookDao.findAll();
		// then
		assertNotNull(allBooks);
		assertFalse(allBooks.isEmpty());
		assertEquals(6, allBooks.size());
	}

	@Test
	public void testShouldFindAllBooksByFragmentTitle() {
		// given
		final String title = "Opiu";
		// when
		List<BookEntity> booksByTitle = bookDao.findBookByTitle(title);
		// then
		assertNotNull(booksByTitle);
		assertFalse(booksByTitle.isEmpty());
	}

	@Test
	public void testShouldFindAllBooksByTitle() {
		// given
		final String title = "Opium W Rosole";
		// when
		List<BookEntity> booksByTitle = bookDao.findBookByTitle(title);
		// then
		assertNotNull(booksByTitle);
		assertFalse(booksByTitle.isEmpty());
	}

	@Test
	public void testShouldFindAllBooksByAuthor() {
		// given
		final String author = "Jan Parandowski";
		// when
		List<BookEntity> booksByAuthor = bookDao.findBooksByAuthor(author);
		// then
		assertNotNull(booksByAuthor);
		assertFalse(booksByAuthor.isEmpty());
	}
	
	@Test
	public void testShouldFindAllBooksByFragmentAuthorsFirstName() {
		// given
		final String author = "Ja";
		// when
		List<BookEntity> booksByAuthor = bookDao.findBooksByAuthor(author);
		// then
		assertNotNull(booksByAuthor);
		assertFalse(booksByAuthor.isEmpty());
	}
	@Test
	public void testShouldFindAllBooksByFragmentAuthorsLastName() {
		// given
		final String author = "Parandowsk";
		// when
		List<BookEntity> booksByAuthor = bookDao.findBooksByAuthor(author);
		// then
		assertNotNull(booksByAuthor);
		assertFalse(booksByAuthor.isEmpty());
	}

	@Test(expected = BookNotNullIdException.class)
	public void testShouldThrowBookNotNullIdException() {
		// given
		final BookEntity bookToSave = new BookEntity();
		bookToSave.setId(22L);
		// when
		bookDao.save(bookToSave);
		// then
		fail("test should throw BookNotNullIdException");
	}

	@Test
	public void testShouldBookWithId() {
		// given
		final BookEntity bookToSave = new BookEntity();
		
		//when
		Mockito.when(bookDao.save(bookToSave)).thenReturn(new BookEntity(11L, null, null));
		// then
		assertEquals(11L, bookToSave.getId().longValue());
	}
}
