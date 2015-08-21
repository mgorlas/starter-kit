package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("select author from AuthorEntity author where author.firstName like :name% or author.lastName like :name%")
    public List<AuthorEntity> findAuthorByName(@Param("name") String name);

}
