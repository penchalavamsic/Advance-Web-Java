package com.dao.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.dao.crud.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
