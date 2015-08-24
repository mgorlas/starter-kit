package pl.spring.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.spring.demo.service.AuthorService;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;

@RestController
@RequestMapping(value="/authors")
public class AuthorRestService {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/autors-by-name", method = RequestMethod.GET)
	public List<AuthorTo> findAuthorsByName(@RequestParam(value = "namePrefix", required = false) String namePrefix) {
		if (StringUtils.isEmpty(namePrefix)) {
			return authorService.findAllAuthors();
		}
		return authorService.findAuthorByName(namePrefix);
	}
    
    
    @RequestMapping(value = "/authors-list", method = RequestMethod.GET)
    public List<AuthorTo> findAllAuthors() {
    	return authorService.findAllAuthors();
    }
    
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public AuthorTo saveAuthor(@RequestBody AuthorTo author) {
        return authorService.saveAuthor(author);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable("id") long id) {
    	authorService.deleteAuthor(id);
    }
}
