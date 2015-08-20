package pl.spring.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String name;

	@OneToMany(
		mappedBy = "library",
		cascade = CascadeType.REMOVE,
		fetch = FetchType.LAZY)
	private Set<BookEntity> books = new HashSet<>();

	protected LibraryEntity() {
	}

	public LibraryEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public LibraryEntity(Long id, String name, Set<BookEntity> books) {
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
	
	public Set<BookEntity> getBooks(){
		return books;
	}
	public void getBooks(Set<BookEntity> books){
		this.books = books;;
	}
}