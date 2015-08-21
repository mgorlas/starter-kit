package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.spring.demo.entity.BookEntity;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("select book from BookEntity book where book.title like :title%")
    public List<BookEntity> findBookByTitle(@Param("title") String title);

    @Query("select book from BookEntity book where book.authors like %:author%")
    public List<BookEntity> findBookByAuthor(@Param("author") String author);

    @Query("update BookEntity set title = :title where id=:id")
    public List<BookEntity> updateTitleBook(@Param("id") Long id, @Param("title") String title );
}
