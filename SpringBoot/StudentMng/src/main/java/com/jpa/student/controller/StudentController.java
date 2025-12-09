package com.jpa.student.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.jpa.student.service.StudentService;
import com.jpa.student.model.Student;
@RestController
@RequestMapping("/api/students")

public class StudentController {
	private final StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	@GetMapping
	public java.util.List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		return studentService.updateStudent(id, studentDetails);
	}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
	@GetMapping("/course/{course}")
	public java.util.List<Student> getStudentsByCourse(@PathVariable String course) {
		return studentService.getStudentsByCourse(course);
	}
	@GetMapping("/match/{match}")
	public java.util.List<Student> getStudentsByMatch(@PathVariable String match) {
		return studentService.getStudentsByMatch(match);
	}

}
