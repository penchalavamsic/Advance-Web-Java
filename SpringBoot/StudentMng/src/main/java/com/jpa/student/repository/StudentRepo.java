package com.jpa.student.repository;
import java.util.List;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpa.student.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByCourse(String course);
    List<Student> findByMatch(String match);
}