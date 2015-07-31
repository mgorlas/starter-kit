package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@Component
public class BookMapper {

	public BookTo convertBookEntityOnBookTo(BookEntity bookEntity) {
		String authors = null;
		if (bookEntity.getAuthors() != null) {
			authors = convertListAuthorsOnStringAuthor(bookEntity.getAuthors());
		}
		return new BookTo(bookEntity.getId(), bookEntity.getTitle(), authors);
	}

	public BookEntity convertBookToOnBookEntity(BookTo bookTo) {
		List<AuthorTo> authors = null;
		if (bookTo.getAuthors() != null) {
			authors = convertStringAuthorOnListAuthors(bookTo.getAuthors());
		}
		return new BookEntity(bookTo.getId(), bookTo.getTitle(), authors);
	}

	public List<BookEntity> convertListBookToOnListBookEntity(List<BookTo> bookToList) {
		List<BookEntity> bookList = new ArrayList<BookEntity>();
		for (BookTo bookTo : bookToList) {
			bookList.add(convertBookToOnBookEntity(bookTo));
		}
		return bookList;
	}

	public List<BookTo> convertListBookEntityOnListBookTo(List<BookEntity> bookEntityList) {
		List<BookTo> bookList = new ArrayList<BookTo>();
		for (BookEntity bookEntity : bookEntityList) {
			bookList.add(convertBookEntityOnBookTo(bookEntity));
		}
		return bookList;
	}

	public List<AuthorTo> convertStringAuthorOnListAuthors(String author) {
		String[] splitAuthor = author.split(",");
		List<AuthorTo> authors = new ArrayList<>();
		long id = 1L;
		for (int i = 0; i < splitAuthor.length; i++) {
			String[] nextAuthor = splitAuthor[i].split("\\s+");
			authors.add(new AuthorTo(id * (i + 1), nextAuthor.length > 1 ? nextAuthor[0] : null, nextAuthor.length > 1 ? nextAuthor[1] : ""));
		}
		return authors;
	}

	public String convertListAuthorsOnStringAuthor(List<AuthorTo> listAuthors) {
		String authors = "";
		for (AuthorTo authorTo : listAuthors) {
			authors += authorTo.getFirstName() + " " + authorTo.getLastName() + ", ";
		}
		return authors.substring(0, authors.length() - 2);
	}
}
