package com.university.portal.service;

import com.university.portal.model.Enrollment;
import com.university.portal.model.Student;
import com.university.portal.model.Course;
import com.university.portal.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    // Enroll student in a course
    public Enrollment enrollStudentInCourse(String email, Long courseId) {
        Student student = studentService.getStudentByEmail(email);
        Course course = courseService.getAllCourses().stream().filter(c -> c.getId().equals(courseId)).findFirst().orElse(null);

        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollment.setActive(true);
            return enrollmentRepository.save(enrollment);
        }

        return null;
    }
}

