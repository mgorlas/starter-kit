package pl.spring.demo.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;

public class BookDaoImpl implements BookDao {

	private final Set<BookEntity> ALL_BOOKS = new HashSet<>();

	private Sequence sequence;

	public BookDaoImpl() {
		addTestBooks();
	}

	@Override
	public List<BookEntity> findAll() {
		return new ArrayList<>(ALL_BOOKS);
	}

	@Override
	public List<BookEntity> findBookByTitle(String title) {
		List<BookEntity> foundBooks = new ArrayList<>();
		for (BookEntity bookEntity : ALL_BOOKS) {
			if ((bookEntity.getTitle().toLowerCase()).startsWith(title.toLowerCase())) {
				foundBooks.add(bookEntity);
			}
		}
		return foundBooks;
	}

	@Override
	public List<BookEntity> findBooksByAuthor(String author) {
		List<BookEntity> foundBooks = new ArrayList<>();

		String[] authorData = author.split("\\s+");

		switch (authorData.length) {
		case 1:
			for (BookEntity bookEntity : ALL_BOOKS) {
				for (AuthorTo authorTo : bookEntity.getAuthors()) {
					if ((authorTo.getFirstName().toLowerCase()).startsWith(authorData[0].toLowerCase())
							|| (authorTo.getLastName().toLowerCase()).startsWith(authorData[0].toLowerCase())) {
						foundBooks.add(bookEntity);
					}
				}
			}
			break;
		case 2:
			for (BookEntity bookEntity : ALL_BOOKS) {
				for (AuthorTo authorTo : bookEntity.getAuthors()) {
					if (((authorTo.getFirstName()).equalsIgnoreCase(authorData[0]) && (authorTo.getLastName()).equalsIgnoreCase(authorData[1])) 
							|| ((authorTo.getFirstName()).equalsIgnoreCase(authorData[1]) && (authorTo.getLastName()).equalsIgnoreCase(authorData[0]))){
						foundBooks.add(bookEntity);
					}
				}
			}
			break;
		}
		return foundBooks;
	}

	@Override
	@NullableId
	public BookEntity save(BookEntity book) {
		ALL_BOOKS.add(book);
		return book;
	}

	public Sequence getSequence() {
		return this.sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	private void addTestBooks() {
		ALL_BOOKS.add(new BookEntity(1L, "Romeo i Julia", Arrays.asList(new AuthorTo(1L, "Wiliam", "Szekspir"))));
		ALL_BOOKS.add(new BookEntity(2L, "Opium w rosole", Arrays.asList(new AuthorTo(2L, "Hanna", "Ożogowska"))));
		ALL_BOOKS.add(new BookEntity(3L, "Przygody Odyseusza", Arrays.asList(new AuthorTo(3L, "Jan", "Parandowski"))));
		ALL_BOOKS.add(new BookEntity(4L, "Awantura w Niekłaju", Arrays.asList(new AuthorTo(4L, "Edmund", "Niziurski"))));
		ALL_BOOKS.add(new BookEntity(5L, "Pan Samochodzik i Fantomas",Arrays.asList(new AuthorTo(5L, "Zbigniew", "Nienacki"))));
		ALL_BOOKS.add(new BookEntity(6L, "Zemsta", Arrays.asList(new AuthorTo(6L, "Aleksander", "Fredro"))));
	}
}
