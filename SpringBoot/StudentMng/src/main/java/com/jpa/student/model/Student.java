package com.jpa.student.model;
import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@Table(name="student")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String email;
	private String course;
	private String match;
	@JsonFormat(pattern="yyyy-MM-dd")
	private String enrollDate;
}