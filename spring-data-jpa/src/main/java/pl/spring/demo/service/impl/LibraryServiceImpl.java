package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.mapper.LibraryMapper;
import pl.spring.demo.repository.LibraryRepository;
import pl.spring.demo.service.LibraryService;
import pl.spring.demo.to.LibraryTo;

@Service
@Transactional(readOnly = true)
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    @Transactional(readOnly = false)
    public void deleteLibrary(Long id) {
        libraryRepository.delete(id);
    }

	@Override
	public List<LibraryTo> findAll() {
		return LibraryMapper.map2To(libraryRepository.findAll());
	}
}
