package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookTo;

public class BookMapper {

    public static BookTo map(BookEntity bookEntity) {
        if (bookEntity != null) {
            return new BookTo(bookEntity.getId(), bookEntity.getTitle(), mapAuthors((bookEntity.getAuthors())));
        }
        return null;
    }

    public static BookEntity map(BookTo bookTo) {
        if (bookTo != null) {
            return new BookEntity(bookTo.getId(), bookTo.getTitle(), mapAuthors(bookTo.getAuthors()));
        }
        return null;
    }

    public static List<BookTo> map2To(List<BookEntity> bookEntities) {
        return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
    }

    public static List<BookEntity> map2Entity(List<BookTo> bookEntities) {
        return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
    }
    
    private static String mapAuthors(Collection<AuthorEntity> authors) {
        if (!authors.isEmpty()) {
            return authors.stream().map(authorEntity -> authorEntity.getFirstName() + " " + authorEntity.getLastName()).collect(Collectors.joining
                    (", "));
        }
        return null;
    }
    private static Collection<AuthorEntity> mapAuthors(String authors) {
    	if (!authors.isEmpty()) {
    		String[] splitAuthor = authors.split(",");
    		Collection<AuthorEntity> authorsEntities = new ArrayList<>();
    		for (int i = 0; i < splitAuthor.length; i++) {
    			String[] nextAuthor = splitAuthor[i].split("\\s+");
    			if(nextAuthor.length > 2) {
    			authorsEntities.add(new AuthorEntity(null, nextAuthor[0] + " " + nextAuthor[1], nextAuthor[2]));
    			}
    			else {
    				authorsEntities.add(new AuthorEntity(null, nextAuthor.length > 0 ? nextAuthor[0] : null, nextAuthor.length > 1 ? nextAuthor[1] : null));
    			}
    		}
    		return authorsEntities;
    	}
    	return null;
    }
}
