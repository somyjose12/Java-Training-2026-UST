package com.studentmanagement.demo.repository;

import com.studentmanagement.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
