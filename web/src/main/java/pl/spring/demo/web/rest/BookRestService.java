package pl.spring.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@RestController
@RequestMapping(value = "/books")
public class BookRestService {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
	public List<BookTo> findBooksByTitle(@RequestParam(value = "titlePrefix", required = false) String titlePrefix) {
		if (StringUtils.isEmpty(titlePrefix)) {
			return bookService.findAllBooks();
		}
		return bookService.findBooksByTitle(titlePrefix);
	}
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<BookTo> findAllBooks() {
		return bookService.findAllBooks();
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public BookTo saveBook(@RequestBody BookTo bookTo) {
		return bookService.saveBook(bookTo);
	}

	@RequestMapping(value = "/book-update-title", method = RequestMethod.POST)
	public void updateTitleBook(@RequestBody BookTo book) {
		bookService.updateTitleBook(book);
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") long id) {
		bookService.deleteBook(id);
	}
}
