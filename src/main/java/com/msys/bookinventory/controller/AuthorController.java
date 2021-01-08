package com.msys.bookinventory.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.msys.bookinventory.entity.Author;
import com.msys.bookinventory.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	Logger logger = LoggerFactory.getLogger(AuthorController.class);
	
	@Autowired
	AuthorService authorService;
	
	@RequestMapping("/search/{id}")
	public Author getBookById(@PathVariable Long id) {
		Optional<Author> bookOptional = authorService.findById(id);	
		if(!bookOptional.isPresent()) {
			logger.debug("Author id is not found :: "+id);
			System.out.println("Author id is not found :: "+id);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author id is not found : " +id );
		}
	    return bookOptional.get();
	}

}
