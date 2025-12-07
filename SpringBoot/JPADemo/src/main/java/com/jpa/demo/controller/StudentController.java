package com.jpa.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.demo.entity.Student;
import com.jpa.demo.entity.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	@GetMapping
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
}
