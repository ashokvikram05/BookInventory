package com.msys.bookinventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msys.bookinventory.entity.Author;
import com.msys.bookinventory.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	public Optional<Author> findById(Long id) {

		return authorRepository.findById(id);
	}

}
