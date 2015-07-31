package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<BookTo> findAllBooks() {
		return bookMapper.convertListBookEntityOnListBookTo(bookDao.findAll());
	}

	@Override
	public List<BookTo> findBooksByTitle(String title) {
		return bookMapper.convertListBookEntityOnListBookTo(bookDao.findBooksByTitle(title));
	}

	@Override
	public List<BookTo> findBooksByAuthor(String author) {
		return bookMapper.convertListBookEntityOnListBookTo(bookDao.findBooksByAuthor(author));
	}

	@Override
	public BookTo saveBook(BookTo book) {
		return bookMapper.convertBookEntityOnBookTo(bookDao.save(bookMapper.convertBookToOnBookEntity(book)));
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
