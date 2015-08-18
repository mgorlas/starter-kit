package pl.spring.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.bookSearchCriteria.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonBookServiceTest-context.xml")
public class BookServiceSearchCriteriaTest {


	@Autowired
	private BookServiceSearchCriteria bookServiceSearchCriteria;
	@Autowired
	private BookService bookService;

	@Test
	public void testShouldFindAllBook() {
		// given
		BookSearchCriteria bsc = new BookSearchCriteria();
		// when
		List<BookTo> bookToListAll = bookService.findAllBooks();
		List<BookTo> bookToListAllSearchCriteria = bookServiceSearchCriteria.findBooksByCriteria(bsc);
		// then
		assertEquals(bookToListAll.size(), bookToListAllSearchCriteria.size());
	}

	@Test
	public void testShouldFindOneBookWithFullData() {
		// given
		BookSearchCriteria bsc = new BookSearchCriteria();
		bsc.setAuthor("Jan");
		bsc.setLibraryName("Biblioteka wrocławska");
		bsc.setTitle("Pierwsza książka");
		// when
		List<BookTo> bookSearchCriteria = bookServiceSearchCriteria.findBooksByCriteria(bsc);
		// then
		assertEquals(1, bookSearchCriteria.size());
		assertEquals("Pierwsza książka", bookSearchCriteria.get(0).getTitle());
	}
	@Test
	public void testShouldFindBookWithPrefixData() {
		// given
		BookSearchCriteria bsc = new BookSearchCriteria();
		bsc.setAuthor("Ja");
		bsc.setLibraryName("Biblioteka Wa");
		bsc.setTitle("S");
		// when
		List<BookTo> bookSearchCriteria = bookServiceSearchCriteria.findBooksByCriteria(bsc);
		// then
		assertEquals(2, bookSearchCriteria.size());
		assertEquals("Szósta książka", bookSearchCriteria.get(0).getTitle());
		assertEquals("Siódma książka", bookSearchCriteria.get(1).getTitle());
	}
	@Test
	public void testShouldFindBookWithPrefixDataLibraryName() {
		// given
		BookSearchCriteria bsc = new BookSearchCriteria();
		bsc.setLibraryName("Biblioteka Wa");
		// when
		List<BookTo> bookSearchCriteria = bookServiceSearchCriteria.findBooksByCriteria(bsc);
		// then
		assertNotNull(bookSearchCriteria);
		assertEquals(5, bookSearchCriteria.size());
	}
	@Test
	public void testShouldFindBookWithPrefixDataAuthor() {
		// given
		BookSearchCriteria bsc = new BookSearchCriteria();
		bsc.setAuthor("Ja");
		// when
		List<BookTo> bookSearchCriteria = bookServiceSearchCriteria.findBooksByCriteria(bsc);
		// then
		assertNotNull(bookSearchCriteria);
		assertEquals(5, bookSearchCriteria.size());
	}
	@Test
	public void testShouldFindBookWithPrefixDataBookTitle() {
		// given
		BookSearchCriteria bsc = new BookSearchCriteria();
		bsc.setTitle("Pi");
		// when
		List<BookTo> bookSearchCriteria = bookServiceSearchCriteria.findBooksByCriteria(bsc);
		// then
		assertNotNull(bookSearchCriteria);
		assertEquals(2, bookSearchCriteria.size());
	}
}
