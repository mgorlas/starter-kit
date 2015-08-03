package pl.spring.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.common.Sequence;
import pl.spring.demo.exception.BookNotNullIdException;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "BookDaoImplTest-context.xml")
public class BookDaoImplTest {

	@Autowired
	private BookDao bookDao;
	@Autowired
	private Sequence sequence;

	@Test
	public void testShouldFindAllBooks() {
		// when
		List<BookEntity> allBooks = bookDao.findAll();
		// then
		assertNotNull(allBooks);
		assertFalse(allBooks.isEmpty());
	}

	@Test
	public void testShouldFindAllBooksByFragmentTitle() {
		// given
		final String title = "Opiu";
		// when
		List<BookEntity> booksByTitle = bookDao.findBooksByTitle(title);
		// then
		assertNotNull(booksByTitle);
		assertFalse(booksByTitle.isEmpty());
	}

	@Test
	public void testShouldFindAllBooksByTitle() {
		// given
		final String title = "OpIuM W RoSOLE";
		// when
		List<BookEntity> booksByTitle = bookDao.findBooksByTitle(title);
		// then
		assertNotNull(booksByTitle);
		assertFalse(booksByTitle.isEmpty());
	}

	@Test
	public void testShouldFindAllBooksByAuthorFirstNameLastName() {
		// given
		final String author = "Jan Parandowski";
		// when
		List<BookEntity> booksByAuthor = bookDao.findBooksByAuthor(author);
		// then
		assertNotNull(booksByAuthor);
		assertFalse(booksByAuthor.isEmpty());
	}
	@Test
	public void testShouldFindAllBooksByAuthorLastNameFirstName() {
		// given
		final String author = "Parandowski Jan";
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
		final String author = "Parando";
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
		final BookEntity bookToSave = new BookEntity(null, "Kubus puchatek",
				Arrays.asList(new AuthorTo(2l, "Milne", "Alexander")));
		Mockito.when(sequence.nextValue(Mockito.anyCollection())).thenReturn(6L);
		// when
		bookDao.save(bookToSave);
		// then
		Mockito.verify(sequence).nextValue(Mockito.anyCollection());
		assertNotNull(bookToSave.getId().longValue());
		assertEquals(6L, bookToSave.getId().longValue());
	}
}
