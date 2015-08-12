package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

	@Autowired
	private LibraryRepository libraryRepository;

	@Test
	public void testShouldFindBooksByNamePrefix() {
		// given
		final String libraryName = "biblio";
		// when
		List<LibraryEntity> libraryEntity = libraryRepository.findLibraryByName(libraryName);
		// then
		assertNotNull(libraryEntity);
		assertFalse(libraryEntity.isEmpty());
		assertEquals("Biblioteka wrocławska", libraryEntity.get(0).getName());
	}

	@Test
	public void testShouldFindBooksByFullName() {
		// given
		final String libraryName = "BIBLIOTEKA Warszawska";
		// when
		List<LibraryEntity> libraryEntity = libraryRepository.findLibraryByName(libraryName);
		// then
		assertNotNull(libraryEntity);
		assertFalse(libraryEntity.isEmpty());
		assertEquals("Biblioteka Warszawska", libraryEntity.get(0).getName());
	}
}
