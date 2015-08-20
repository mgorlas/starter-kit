package pl.spring.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "AUTHOR")
public class AuthorEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 200)
	private String firstName;
	@Column(nullable = true, length = 200)
	private String lastName;

	// for hibernate
	protected AuthorEntity() {
	}

	public AuthorEntity(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
