package com.lombok.test.controller;
import com.lombok.test.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	@GetMapping("/student")
	public Student student() {
		Student student = new Student();
		student.setId(1);
		student.setName("John Doe");
		return student;
	}
}
