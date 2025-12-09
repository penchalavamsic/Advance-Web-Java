package com.jpa.library.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.jpa.library.service.BookService;
import com.jpa.library.entity.Book;

@RestController
@RequestMapping("/api/books")

public class BookController {
	private final BookService bookService;
	//constructor injection
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}
	@GetMapping
	public java.util.List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
		return bookService.updateBook(id, bookDetails);
	}
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return "Book deleted with id: " + id;
	}
	@GetMapping("/author/{author}")
	public java.util.List<Book>getBooksByAuthor(@PathVariable String author) {
		return bookService.getBooksByAuthor(author);
	}
	@GetMapping("/publishedDate/{publishedDate}")
	public java.util.List<Book> getBooksByPublishedDate(@PathVariable java.sql.Date publishedDate) {
		return bookService.getBooksByPublishedDate(publishedDate);
	}
}
