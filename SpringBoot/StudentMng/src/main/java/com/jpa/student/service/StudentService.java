package com.jpa.student.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.jpa.student.model.Student;

public interface StudentService {
	Student createStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(Long id);
	Student updateStudent(Long id, Student studentDetails);
	void deleteStudent(Long id);
	List<Student> getStudentsByCourse(String course);
	List<Student> getStudentsByMatch(String match);
}
