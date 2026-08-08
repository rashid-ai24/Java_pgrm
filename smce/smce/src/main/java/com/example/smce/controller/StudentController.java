package com.example.smce.controller;

import com.example.smce.entity.Student;
import com.example.smce.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "Student Added Successfully";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student) {
        service.updateStudent(student);
        return "Student Updated Successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student Deleted Successfully";
    }
}