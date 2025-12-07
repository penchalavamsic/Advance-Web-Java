package com.jpa.demo.entity.repository;
import com.jpa.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository  extends JpaRepository<Student, Long> {

}
