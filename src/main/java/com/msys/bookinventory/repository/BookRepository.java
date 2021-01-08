package com.msys.bookinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msys.bookinventory.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	

}
