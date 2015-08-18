package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.bookSearchCriteria.BookSearchCriteria;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookServiceSearchCriteria;
import pl.spring.demo.to.BookTo;

@Service
@Transactional(readOnly = true)
public class BookServiceSearchCriteriaImpl implements BookServiceSearchCriteria {

    @Autowired
    private BookRepository bookRepository;
    
	@Override
	public List<BookTo> findBooksByCriteria(BookSearchCriteria bookSearchCriteria) {
		return BookMapper.map2To(bookRepository.findBooksByCriteria(bookSearchCriteria));
	}
}
