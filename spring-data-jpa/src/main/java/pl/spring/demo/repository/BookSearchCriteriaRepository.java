package pl.spring.demo.repository;

import java.util.List;

import pl.spring.demo.bookSearchCriteria.BookSearchCriteria;
import pl.spring.demo.entity.BookEntity;

public interface BookSearchCriteriaRepository {
	
    public List<BookEntity> findBooksByCriteria(BookSearchCriteria bookSearchCriteria);

}
