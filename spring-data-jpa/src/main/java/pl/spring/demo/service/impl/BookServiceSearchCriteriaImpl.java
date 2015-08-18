package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.bookSearchCriteria.BookSearchCriteria;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookServiceSearchCriteria;

@Service
@Transactional(readOnly = true)
public class BookServiceSearchCriteriaImpl implements BookServiceSearchCriteria {

    @Autowired
    private BookRepository bookRepository;
    
	@Override
	public List<BookEntity> findBooksByCriteria(BookSearchCriteria bookSearchCriteria) {
		return null;
	}
}
