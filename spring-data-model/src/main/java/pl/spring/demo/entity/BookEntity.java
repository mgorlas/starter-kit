package pl.spring.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String title;

	@ManyToMany(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "book_author", 
			joinColumns = {@JoinColumn(name = "book_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = {@JoinColumn(name = "author_id", nullable = false, updatable = false) })
	private Collection <AuthorEntity> authors = new ArrayList<>();

	// for hibernate
	protected BookEntity() {
	}

	public BookEntity(Long id, String title, Collection<AuthorEntity> authors) {
		this.id = id;
		this.title = title;
		this.authors = authors;
	}
	public BookEntity(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<AuthorEntity> authors) {
		this.authors = authors;
	}
}
