package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@Component
public class BookMapper {

	public BookTo convertBookEntityToBookTo(BookEntity bookEntity) {
		String authors = null;
		if (bookEntity.getAuthors() != null) {
			authors = convertListAuthorsToStringAuthor(bookEntity.getAuthors());
		}
		return new BookTo(bookEntity.getId(), bookEntity.getTitle(), authors);
	}

	public BookEntity convertBookToToBookEntity(BookTo bookTo) {
		List<AuthorTo> authors = null;
		if (bookTo.getAuthors() != null) {
			authors = convertStringAuthorToListAuthors(bookTo.getAuthors());
		}
		return new BookEntity(bookTo.getId(), bookTo.getTitle(), authors);
	}

	public List<BookEntity> convertListBookToToListBookEntity(List<BookTo> bookToList) {
		List<BookEntity> bookList = new ArrayList<BookEntity>();
		for (BookTo bookTo : bookToList) {
			bookList.add(convertBookToToBookEntity(bookTo));
		}
		return bookList;
	}

	public List<BookTo> convertListBookEntityToListBookTo(List<BookEntity> bookEntityList) {
		List<BookTo> bookList = new ArrayList<BookTo>();
		for (BookEntity bookEntity : bookEntityList) {
			bookList.add(convertBookEntityToBookTo(bookEntity));
		}
		return bookList;
	}

	public List<AuthorTo> convertStringAuthorToListAuthors(String author) {
		String[] splitAuthor = author.split(",");
		List<AuthorTo> authors = new ArrayList<>();
		long id = 1L;
		for (int i = 0; i < splitAuthor.length; i++) {
			String[] nextAuthor = splitAuthor[i].split("\\s+");
			authors.add(new AuthorTo(id * (i + 1), nextAuthor[0], nextAuthor.length > 1 ? nextAuthor[1] : ""));
		}
		return authors;
	}

	public String convertListAuthorsToStringAuthor(List<AuthorTo> listAuthors) {
		String authors = "";
		for (AuthorTo authorTo : listAuthors) {
			authors += authorTo.getFirstName() + " " + authorTo.getLastName() + ", ";
		}
		return authors.substring(0, authors.length() - 2);
	}
}
