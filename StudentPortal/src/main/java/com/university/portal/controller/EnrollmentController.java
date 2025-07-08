package com.university.portal.controller;

import com.university.portal.model.Enrollment;
import com.university.portal.service.EnrollmentService;
import com.university.portal.service.StudentService;
import com.university.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    // Enroll student in a course
    @PostMapping("/enroll")
    public Enrollment enrollStudent(@RequestBody Enrollment enrollment) {
        // Check if the student exists
        if (studentService.getStudentByEmail(enrollment.getStudent().getEmail()) == null) {
            studentService.registerStudent(enrollment.getStudent().getName(),
                    enrollment.getStudent().getSurname(),
                    enrollment.getStudent().getEmail(),
                    enrollment.getStudent().getPassword());
        }

        // Enroll the student in the course
        return enrollmentService.enrollStudentInCourse(enrollment.getStudent().getEmail(), enrollment.getCourse().getId());
    }

}
