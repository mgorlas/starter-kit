package pl.spring.demo.entity;

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
    	mappedBy = "library",
    	cascade = CascadeType.ALL,
    	fetch = FetchType.EAGER
    )
    private Collection<BookEntity> books;
}
