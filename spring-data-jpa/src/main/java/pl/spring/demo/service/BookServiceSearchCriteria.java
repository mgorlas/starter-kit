package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.bookSearchCriteria.BookSearchCriteria;
import pl.spring.demo.entity.BookEntity;

public interface BookServiceSearchCriteria {

	List<BookEntity> findBooksByCriteria(BookSearchCriteria bookSearchCriteria);
}
