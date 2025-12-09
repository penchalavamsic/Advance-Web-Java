package com.jpa.library.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String title;
	private String author;
	@Column(unique=true)
	private String isbn;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date publishedDate;
	
}
