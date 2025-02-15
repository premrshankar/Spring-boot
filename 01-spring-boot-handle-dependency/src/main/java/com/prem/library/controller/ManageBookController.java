package com.prem.library.controller;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prem.library.exception.NoBookFoundException;
import com.prem.library.model.Book;
import com.prem.library.repository.ManageBookRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/book")
public class ManageBookController {

	/**
	 * The Repository.
	 */
	private final ManageBookRepository repository;

	/**
	 * Instantiates a new Book controller.
	 *
	 * @param repository the repository
	 */
	public ManageBookController(ManageBookRepository repository) {
		this.repository = repository;
	}

	/**
	 * Find by id book.
	 *
	 * @param id the id
	 * @return the book
	 */
	@GetMapping("/{id}")
	public Book findById(@PathVariable long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NoBookFoundException());
	}

	/**
	 * Find books collection.
	 *
	 * @return the collection
	 */
	@GetMapping("/")
	public Collection<Book> findBooks() {
		return repository.getBooks();
	}

	/**
	 * Update book book.
	 *
	 * @param id   the id
	 * @param book the book
	 * @return the book
	 */
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Book updateBook(@PathVariable("id") final String id, @RequestBody final Book book) {
		return book;
	}

	/**
	 * Patch book book.
	 *
	 * @param id   the id
	 * @param book the book
	 * @return the book
	 */
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Book patchBook(@PathVariable("id") final String id, @RequestBody final Book book) {
		return book;
	}

	/**
	 * Post book book.
	 *
	 * @param book the book
	 * @return the book
	 */
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Book postBook(@NotNull @Valid @RequestBody final Book book) {
		return book;
	}

	/**
	 * Head book book.
	 *
	 * @return the book
	 */
	@RequestMapping(method = RequestMethod.HEAD, value = "/")
	@ResponseStatus(HttpStatus.OK)
	public Book headBook() {
		return new Book();
	}

	/**
	 * Delete book long.
	 *
	 * @param id the id
	 * @return the long
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public long deleteBook(@PathVariable final long id) {
		return id;
	}
}
