package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.bookSearchCriteria.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

public interface BookServiceSearchCriteria {

	List<BookTo> findBooksByCriteria(BookSearchCriteria bookSearchCriteria);
}
