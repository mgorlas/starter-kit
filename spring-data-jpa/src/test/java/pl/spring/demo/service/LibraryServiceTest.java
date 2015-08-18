package pl.spring.demo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class LibraryServiceTest {


	@Autowired
	private LibraryService libraryService;

	@Test
	public void testShouldRemoveAllBookInLibrary() {
		// given
		final Long idLibrary = 3L;
		// when
		List<LibraryEntity> libraryBeforeRemoved = libraryService.findAll();
		libraryService.deleteLibrary(idLibrary);
		List<LibraryEntity> libraryAfterRemoved = libraryService.findAll();
		// then
		assertEquals(libraryAfterRemoved.size(), libraryBeforeRemoved.size() - 1);
	}

}
