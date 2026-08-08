package com.example.smce.service;

import com.example.smce.entity.Student;
import com.example.smce.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public Student getStudentById(int id) {
        return repository.getStudentById(id);
    }

    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    public void updateStudent(Student student) {
        repository.updateStudent(student);
    }

    public void deleteStudent(int id) {
        repository.deleteStudent(id);
    }
}