package com.jpa.library.service;
import org.springframework.stereotype.Service;
import com.jpa.library.entity.Book;
import com.jpa.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public java.util.List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public Book updateBook(Long id, Book bookDetails) {
		Book book = bookRepository.findById(id).orElse(null);
		if (book != null) {
			book.setTitle(bookDetails.getTitle());
			book.setAuthor(bookDetails.getAuthor());
			book.setPublishedDate(bookDetails.getPublishedDate());
			return bookRepository.save(book);
		}
		return null;
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public java.util.List<Book> getBooksByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	@Override
	public java.util.List<Book> getBooksByPublishedDate(java.sql.Date publishedDate) {
		return bookRepository.findByPublishedDate(publishedDate);
	}
	
}
