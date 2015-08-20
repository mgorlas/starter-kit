package pl.spring.demo.to;

import java.util.Collection;
import java.util.HashSet;

public class LibraryTo {
	
	private Long id;
	private String name;
	private Collection<BookTo> books = new HashSet<>();

	public LibraryTo() {
	}

	public LibraryTo(Long id, String name, Collection<BookTo> books) {
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setTitle(String name) {
		this.name = name;
	}
	
	public Collection<BookTo> getBooks(){
		return books;
	}
	public void getBooks(Collection<BookTo> books){
		this.books = books;
	}
}