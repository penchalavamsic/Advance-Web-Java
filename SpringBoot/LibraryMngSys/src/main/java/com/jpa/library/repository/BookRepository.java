package com.jpa.library.repository;
import org.springframework.stereotype.Repository;

import com.jpa.library.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
	//fetch books by author
	List<Book> findByAuthor(String author);
	//fetch books by published date
	List<Book> findByPublishedDate(Date publishedDate);

}
