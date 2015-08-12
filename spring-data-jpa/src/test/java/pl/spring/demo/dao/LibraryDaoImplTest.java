package pl.spring.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonLibraryDaoTest-context.xml")
public class LibraryDaoImplTest {

    @Autowired
    private LibraryDao libraryDao;

    @Test
    public void testShouldFindBooksByNamePrefix() {
        // given
        final String libraryName = "biblio";
        // when
        List<LibraryEntity> libraryEntity = libraryDao.findLibraryByName(libraryName);
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
    	List<LibraryEntity> libraryEntity = libraryDao.findLibraryByName(libraryName);
    	// then
    	assertNotNull(libraryEntity);
    	assertFalse(libraryEntity.isEmpty());
    	assertEquals("Biblioteka Warszawska", libraryEntity.get(0).getName());
    }
}
