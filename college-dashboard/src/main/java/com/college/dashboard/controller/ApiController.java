package com.college.dashboard.controller;

import com.college.dashboard.model.Course;
import com.college.dashboard.model.Enrollment;
import com.college.dashboard.model.Student;
import com.college.dashboard.repository.CourseRepository;
import com.college.dashboard.repository.EnrollmentRepository;
import com.college.dashboard.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final StudentRepository students;
    private final CourseRepository courses;
    private final EnrollmentRepository enrollments;

    public ApiController(StudentRepository students, CourseRepository courses, EnrollmentRepository enrollments) {
        this.students = students;
        this.courses = courses;
        this.enrollments = enrollments;
    }

    @GetMapping("/dashboard")
    public DashboardDto dashboard() {
        return new DashboardDto(students.count(), courses.count(), enrollments.count());
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return students.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return students.save(student);
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courses.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courses.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courses.save(course);
    }

    @GetMapping("/enrollments")
    public List<EnrollmentResponse> getEnrollments() {
        return enrollments.findAll().stream()
                .map(EnrollmentResponse::from)
                .collect(Collectors.toList());
    }

    @PostMapping("/enrollments")
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentResponse createEnrollment(@RequestBody EnrollmentRequest request) {
        Student student = students.findById(request.studentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courses.findById(request.courseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        Enrollment saved = enrollments.save(new Enrollment(student, course));
        return EnrollmentResponse.from(saved);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    public record DashboardDto(long studentCount, long courseCount, long enrollmentCount) {}
    public record EnrollmentRequest(Long studentId, Long courseId) {}
    public record EnrollmentResponse(Long id, Long studentId, String studentName, Long courseId, String courseCode) {
        public static EnrollmentResponse from(Enrollment enrollment) {
            return new EnrollmentResponse(
                    enrollment.getId(),
                    enrollment.getStudent().getId(),
                    enrollment.getStudent().getName(),
                    enrollment.getCourse().getId(),
                    enrollment.getCourse().getCode()
            );
        }
    }

    private static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
