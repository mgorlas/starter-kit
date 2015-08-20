package pl.spring.demo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.to.BookTo;
import pl.spring.demo.to.LibraryTo;

public class LibraryMapper {

    public static LibraryTo map(LibraryEntity libraryEntity) {
        if (libraryEntity != null) {
            return new LibraryTo(libraryEntity.getId(), libraryEntity.getName(), mapBooks(libraryEntity.getBooks()));
        }
        return null;
    }

    public static LibraryEntity map(LibraryTo libraryTo) {
        if (libraryTo != null) {
            return new LibraryEntity(libraryTo.getId(), libraryTo.getName(), mapBooksEntity(libraryTo.getBooks()));
        }
        return null;
    }

    public static List<LibraryTo> map2To(List<LibraryEntity> bookEntities) {
        return bookEntities.stream().map(LibraryMapper::map).collect(Collectors.toList());
    }

    public static List<LibraryEntity> map2Entity(List<LibraryTo> bookEntities) {
        return bookEntities.stream().map(LibraryMapper::map).collect(Collectors.toList());
    }

    private static Collection<BookTo> mapBooks(Collection<BookEntity> books) {
        if (!books.isEmpty()) {
            return books.stream().map(BookMapper::map).collect(Collectors.toList());
        }
        return null;
    }
    private static Set<BookEntity> mapBooksEntity(Collection<BookTo> books) {
    	if (!books.isEmpty()) {
    		return books.stream().map(BookMapper::map).collect(Collectors.toSet());
    	}
    	return null;
    }
}
