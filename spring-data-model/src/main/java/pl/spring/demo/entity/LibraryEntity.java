package pl.spring.demo.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String name;

	@OneToMany(
		mappedBy = "library_id",
		cascade = CascadeType.ALL,
		fetch = FetchType.EAGER)
	private Collection<BookEntity> books;

	protected LibraryEntity() {
	}

	public LibraryEntity(Long id, String name) {
		this.id = id;
		this.name = name;
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
	
	public Collection<BookEntity> getBooks(){
		return books;
	}
	public void getBooks(Collection<BookEntity> books){
		this.books = books;;
	}
}