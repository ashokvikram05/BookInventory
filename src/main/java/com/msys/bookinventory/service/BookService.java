package com.msys.bookinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msys.bookinventory.entity.Book;
import com.msys.bookinventory.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
    public void insert(Book book) {
    	bookRepository.save(book);
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void updateBook(Book book) {
    	bookRepository.save(book);
    }

    public void deleteBook(Book book) {
    	bookRepository.delete(book);
    }

}
