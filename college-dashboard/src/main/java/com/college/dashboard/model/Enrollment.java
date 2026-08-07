package com.college.dashboard.model;

import jakarta.persistence.*;

@Entity
public class Enrollment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    public Enrollment() {}
    public Enrollment(Student student, Course course) { this.student = student; this.course = course; }

    public Long getId() { return id; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
}
