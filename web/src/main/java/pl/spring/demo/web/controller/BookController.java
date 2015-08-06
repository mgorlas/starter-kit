package pl.spring.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String bookList(Map<String, Object> params) {
		final List<BookTo> allBooks = bookService.findAllBooks();
		params.put("books", allBooks);
		return "bookList";
	}

	@RequestMapping(value = "/book-removed", method = RequestMethod.GET)
	public String deleteBook(@RequestParam("buttonDelete") Long bookId, RedirectAttributes redirectAttributes) {
		BookTo bookTo = bookService.findBookById(bookId);
		redirectAttributes.addFlashAttribute("removedBookTitle", bookTo.getTitle());
		bookService.deleteBook(bookTo.getId());
		return "redirect:/successful-removed-book";
	}
	@RequestMapping(value = "/successful-removed-book", method = RequestMethod.GET)
	public String returnTitleRemovedBook() {
		return "removedBook";
	}
}
