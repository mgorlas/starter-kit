package pl.spring.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.spring.demo.service.AuthorService;
import pl.spring.demo.to.AuthorTo;

@RestController
@RequestMapping(value="/authors")
public class AuthorRestService {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public AuthorTo saveAuthor(@RequestBody AuthorTo author) {
        return authorService.saveAuthor(author);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable("id") long id) {
    	authorService.deleteAuthor(id);
    }
}
