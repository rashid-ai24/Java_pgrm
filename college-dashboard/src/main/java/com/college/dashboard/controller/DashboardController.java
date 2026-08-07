package com.college.dashboard.controller;

import com.college.dashboard.repository.CourseRepository;
import com.college.dashboard.repository.EnrollmentRepository;
import com.college.dashboard.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final StudentRepository students;
    private final CourseRepository courses;
    private final EnrollmentRepository enrollments;

    public DashboardController(StudentRepository students, CourseRepository courses, EnrollmentRepository enrollments) {
        this.students = students; this.courses = courses; this.enrollments = enrollments;
    }

    @GetMapping("/")
    public String dashboard(Model model){
        model.addAttribute("studentCount", students.count());
        model.addAttribute("courseCount", courses.count());
        model.addAttribute("enrollmentCount", enrollments.count());
        model.addAttribute("popularCourses", courses.findAll());
        return "dashboard";
    }

    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute("students", students.findAll());
        return "students";
    }

    @GetMapping("/courses")
    public String courses(Model model){
        model.addAttribute("courses", courses.findAll());
        return "courses";
    }
}
