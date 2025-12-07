package com.dao.crud.service;
import com.dao.crud.model.Student;
import com.dao.crud.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
	private final StudentRepository repo;
	public StudentService(StudentRepository repo) {
		this.repo = repo;
	}
	public Student saveStudent(Student student) {
		return repo.save(student);
	}
	public List<Student> getAllStudents() {
		return repo.findAll();
	}
	public Student getStudentById(int id) {
		return repo.findById(id).orElse(null);
	}
	public Student updateStudent(Student student) {
		return repo.save(student);
	}
	public void deleteStudent(int id) {
		repo.deleteById(id);
	}

}
