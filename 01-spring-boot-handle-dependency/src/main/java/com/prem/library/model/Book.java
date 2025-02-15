package com.prem.library.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Book {

	/**
	 * The Id.
	 */
	private long id;

	/**
	 * The Title.
	 */
	@NotBlank
	@Size(min = 0, max = 20)
	private String title;

	/**
	 * The Author.
	 */
	@NotBlank
	@Size(min = 0, max = 30)
	private String author;

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets author.
	 *
	 * @param author the author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
}
