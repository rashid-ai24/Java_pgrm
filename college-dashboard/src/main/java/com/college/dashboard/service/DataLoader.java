package com.college.dashboard.service;

import com.college.dashboard.model.Course;
import com.college.dashboard.model.Enrollment;
import com.college.dashboard.model.Student;
import com.college.dashboard.repository.CourseRepository;
import com.college.dashboard.repository.EnrollmentRepository;
import com.college.dashboard.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final StudentRepository students;
    private final CourseRepository courses;
    private final EnrollmentRepository enrollments;

    public DataLoader(StudentRepository students, CourseRepository courses, EnrollmentRepository enrollments) {
        this.students = students; this.courses = courses; this.enrollments = enrollments;
    }

    @Override
    public void run(String... args) throws Exception {
        Course c1 = courses.save(new Course("CS101", "Intro to Computer Science"));
        Course c2 = courses.save(new Course("MATH201", "Calculus I"));
        Student s1 = students.save(new Student("Alice Johnson", "alice@college.edu"));
        Student s2 = students.save(new Student("Bob Smith", "bob@college.edu"));
        students.save(new Student("Cathy Brown", "cathy@college.edu"));
        enrollments.save(new Enrollment(s1, c1));
        enrollments.save(new Enrollment(s1, c2));
        enrollments.save(new Enrollment(s2, c1));
    }
}
