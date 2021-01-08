package com.msys.bookinventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msys.bookinventory.entity.Author;
import com.msys.bookinventory.entity.Book;
import com.msys.bookinventory.service.BookService;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	
Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService bookService;

	
	@RequestMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		
		logger.debug("Book id is not found :: "+id);
		System.out.println("Book id is not found :: "+id);
		
		Book b =new Book();
		b.setBookId(id);
		b.setTitle("My java book");
		b.setPageCount(100L);
		
		Author auth = new Author();
		auth.setAuthorId(5L);
		auth.setFirstName("Raam");
		auth.setLastName("Kumar");
		
		List<Author> al= new ArrayList<>();
		al.add(auth);
		
		b.setAuthors(al);
		
	   // bookService.insert(b);

		return b;
	}
	
}
