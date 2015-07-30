package pl.spring.demo.service.impl;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.mapper.MapperBook;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private MapperBook mapperBook;
    
    @Override
    public List<BookTo> findAllBooks() {
        return mapperBook.convertBookEntityListToBookToList(bookDao.findAll());
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
        return mapperBook.convertBookEntityListToBookToList(bookDao.findBookByTitle(title));
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
    	AuthorTo authorTo = mapperBook.convertStringAuthorToAuthorTo(author);
        return mapperBook.convertBookEntityListToBookToList(bookDao.findBooksByAuthor(authorTo));
    }

    @Override
    public BookTo saveBook(BookTo book) {
    	BookEntity bookEntity = bookDao.save(mapperBook.convertBookToToBookEntity(book));
        return mapperBook.convertBookEntityToBookTo(bookEntity);
    }
    
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    public void setMapperBook(MapperBook mapperBook) {
        this.mapperBook = mapperBook;
    }
}
