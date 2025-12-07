package com.dao.crud.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.dao.crud.service.StudentService;
import com.dao.crud.model.Student;
import java.util.List;
@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentService service;
	public StudentController(StudentService service) {
		this.service = service;
	}
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	@GetMapping("/student")
	public List<Student> getALlStudents(){
		return service.getAllStudents();
	}
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
		return "Student deleted with id: " + id;
	}
}
