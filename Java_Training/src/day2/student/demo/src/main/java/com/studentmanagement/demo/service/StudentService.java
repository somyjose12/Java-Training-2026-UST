package com.studentmanagement.demo.service;

import com.studentmanagement.demo.entity.Student;
import com.studentmanagement.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setName(studentDetails.getName());
        student.setCourse(studentDetails.getCourse());
        student.setMarks(studentDetails.getMarks());
        return repo.save(student);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}

