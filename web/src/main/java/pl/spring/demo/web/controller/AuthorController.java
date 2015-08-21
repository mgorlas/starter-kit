package pl.spring.demo.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.spring.demo.service.AuthorService;
import pl.spring.demo.to.AuthorTo;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String bookList(Map<String, Object> params) {
        final List<AuthorTo> allAuthors = authorService.findAllAuthors();
        params.put("authors", allAuthors);
        return "authorList";
    }
}
