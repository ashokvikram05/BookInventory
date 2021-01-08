package com.msys.bookinventory.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.msys.bookinventory.entity.Book;
import com.msys.bookinventory.service.BookService;

@EnableWebMvc
@RestController
@RequestMapping("/book")
public class BookController {
	
Logger logger = LoggerFactory.getLogger(BookController.class);
	
@Autowired
BookService bookService;
	

@RequestMapping("")
public List<Book> getAllBook() {
    return bookService.findAll();
}

@RequestMapping("/search/{id}")
public Book getBookById(@PathVariable Long id) {
	Optional<Book> bookOptional = bookService.findById(id);	
	if(!bookOptional.isPresent()) {
		logger.debug("Book id is not found :: "+id);
		System.out.println("Book id is not found :: "+id);
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book id is not found : " +id );
	}
    return bookOptional.get();
}

@RequestMapping(method = RequestMethod.POST, value = "/add")
public void addBook(@RequestBody Book book) {
    bookService.insert(book);
}

@RequestMapping(method = RequestMethod.PUT,value ="/edit/{id}")
public void updateBook(@RequestBody Book book) {
    bookService.updateBook(book);
}

@RequestMapping(method = RequestMethod.DELETE,value ="/delete/{id}")
public void deleteBook(@RequestBody Book book) {
    bookService.deleteBook(book);
}
	
}
