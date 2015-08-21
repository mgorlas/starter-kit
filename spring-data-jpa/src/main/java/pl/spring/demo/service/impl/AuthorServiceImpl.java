package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.mapper.AuthorMapper;
import pl.spring.demo.repository.AuthorRepository;
import pl.spring.demo.service.AuthorService;
import pl.spring.demo.to.AuthorTo;

@Service
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<AuthorTo> findAllAuthors() {
		return AuthorMapper.map2To(authorRepository.findAll());
	}

	@Override
	public List<AuthorTo> findAuthorByName(String name) {
		return AuthorMapper.map2To(authorRepository.findAuthorByName(name));
	}

	@Override
	@Transactional(readOnly = false)
	public AuthorTo saveAuthor(AuthorTo author) {
		AuthorEntity entity = AuthorMapper.map(author);
		entity = authorRepository.save(entity);
		return AuthorMapper.map(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAuthor(long id) {
		authorRepository.delete(id);
	}
}
