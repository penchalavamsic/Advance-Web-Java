package com.jpa.student.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.student.model.Student;
import com.jpa.student.repository.StudentRepo;


@Service
public class ServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).orElse(null);
	}

	@Override
	public Student updateStudent(Long id, Student studentDetails) {
		Student student = studentRepo.findById(id).orElse(null);
		if (student != null) {
			student.setName(studentDetails.getName());
			student.setCourse(studentDetails.getCourse());
			student.setMatch(studentDetails.getMatch());
			return studentRepo.save(student);
		}
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}

	@Override
	public List<Student> getStudentsByCourse(String course) {
		return studentRepo.findByCourse(course);
	}

	@Override
	public List<Student> getStudentsByMatch(String match) {
		return studentRepo.findByMatch(match);
	}

}
