package com.msys.bookinventory.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.msys.bookinventory.entity.Book;
import com.msys.bookinventory.repository.BookRepository;

@RunWith(MockitoJUnitRunner.class)
class BookServiceTest {

	@InjectMocks
	BookService bookService;

	@Mock
	BookRepository bookRepository;

	@Test
	public void findByIdTest() {
		Book book = new Book();
		book.setBookId(1L);
		book.setIsbn("Bk101");
		book.setTitle("Spring Boot");
		Optional<Book> bookOptional = Optional.of(book);
		
		System.out.println("bookRepository :: "+bookRepository);
		
		when(bookRepository.findById(1L)).thenReturn(bookOptional);

		Optional<Book> book2Optional = bookService.findById(1L);

		if (book2Optional.isPresent()) {
			Book book2 = book2Optional.get();
			assertEquals("Bk101", book2.getIsbn());
			assertEquals("Spring Boot", book2.getTitle());
		}

	}

}
