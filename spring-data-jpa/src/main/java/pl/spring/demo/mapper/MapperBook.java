package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@Component
public class MapperBook {

	public BookTo convertBookEntityToBookTo(BookEntity bookEntity) {
		String authors = null;
		if (bookEntity.getAuthors() != null) {
			authors = convertAuthorListToStringAuthor(bookEntity.getAuthors());
		}
		return new BookTo(bookEntity.getId(), bookEntity.getTitle(), authors);
	}

	public BookEntity convertBookToToBookEntity(BookTo bookTo) {
		List<AuthorTo> authors = new ArrayList<>();
		if (bookTo.getAuthors() != null) {
			authors = convertStringAuthorToAuthorToList(bookTo.getAuthors());
		}
		return new BookEntity(bookTo.getId(), bookTo.getTitle(), authors);
	}

	public List<BookEntity> convertBookToListToBookEntityList(List<BookTo> bookToList) {
		List<BookEntity> bookList = new ArrayList<BookEntity>();
		for (BookTo bookTo : bookToList) {
			bookList.add(convertBookToToBookEntity(bookTo));
		}
		return bookList;
	}

	public List<BookTo> convertBookEntityListToBookToList(List<BookEntity> bookEntityList) {
		List<BookTo> bookList = new ArrayList<BookTo>();
		for (BookEntity bookEntity : bookEntityList) {
			bookList.add(convertBookEntityToBookTo(bookEntity));
		}
		return bookList;
	}

	public List<AuthorTo> convertStringAuthorToAuthorToList(String author) {
		String[] splitAuthor = author.split(",");
		List<AuthorTo> authors = new ArrayList<>();
		long id = 1L;
		for (int i = 0; i < splitAuthor.length; i++) {
			String[] nextAuthor = splitAuthor[i].split("\\s+");
			authors.add(new AuthorTo(id * (i + 1), nextAuthor[0], nextAuthor[1]));
		}
		return authors;
	}

	public AuthorTo convertStringAuthorToAuthorTo(String author) {
		String[] authorTo = author.split("\\s+");
		return new AuthorTo(1L, authorTo[0], authorTo[1]);
	}

	public String convertAuthorListToStringAuthor(List<AuthorTo> listAuthors) {
		String authors = "";
		for (AuthorTo authorTo : listAuthors) {
			authors += authorTo.getFirstName() + " " + authorTo.getLastName() + ", ";
		}
		return authors.substring(0, authors.length() - 2);
	}

}
