package com.jpa.library.service;
import java.util.List;
import com.jpa.library.entity.Book;


public interface BookService {
	Book createBook(Book book);
	List<Book> getAllBooks();
	Book getBookById(Long id);
	Book updateBook(Long id, Book bookDetails);
	void deleteBook(Long id);
	List<Book> getBooksByAuthor(String author);
	List<Book> getBooksByPublishedDate(java.sql.Date publishedDate);

}
