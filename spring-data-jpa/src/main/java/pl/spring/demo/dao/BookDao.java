package pl.spring.demo.dao;

import java.util.List;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;

public interface BookDao {

    List<BookEntity> findAll();

    List<BookEntity> findBookByTitle(String title);

    List<BookEntity> findBooksByAuthor(AuthorTo author);

    BookEntity save(BookEntity book);
}
