package pl.spring.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;

import pl.spring.demo.bookSearchCriteria.BookSearchCriteria;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.QBookEntity;
import pl.spring.demo.repository.BookSearchCriteriaRepository;

public class BookRepositoryImpl implements BookSearchCriteriaRepository {

	@PersistenceContext(name = "hsql")
	private EntityManager entityManager;

	@Override
	public List<BookEntity> findBooksByCriteria(BookSearchCriteria bookSearchCriteria) {
		JPAQuery query = new JPAQuery(entityManager);
		QBookEntity bookEntity = QBookEntity.bookEntity;
		BooleanBuilder booleanBookBuilder = new BooleanBuilder();

		if (bookSearchCriteria.getTitle() != null) {
			booleanBookBuilder.and(bookEntity.title.startsWithIgnoreCase(bookSearchCriteria.getTitle()));
		}
		if (bookSearchCriteria.getAuthor() != null) {
			BooleanBuilder booleanAuthorBuilder = new BooleanBuilder();
			booleanAuthorBuilder
					.or(bookEntity.authors.any().firstName.startsWithIgnoreCase(bookSearchCriteria.getAuthor()));
			booleanAuthorBuilder
					.or(bookEntity.authors.any().lastName.startsWithIgnoreCase(bookSearchCriteria.getAuthor()));
			booleanBookBuilder.andAnyOf(booleanAuthorBuilder);
		}
		if (bookSearchCriteria.getLibraryName() != null) {
			booleanBookBuilder.and(bookEntity.library.name.startsWithIgnoreCase(bookSearchCriteria.getLibraryName()));
		}
		return query.from(bookEntity).where(booleanBookBuilder).list(bookEntity);
	}

}
