package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.to.BookTo;

public interface BookService {

	List<BookTo> findAllBooks();

	List<BookTo> findBooksByTitle(String title);

	List<BookTo> findBooksByAuthor(String author);

	BookTo saveBook(BookTo book);

	void updateTitleBook(Long id, String title);

	void deleteBook(long id);
}
