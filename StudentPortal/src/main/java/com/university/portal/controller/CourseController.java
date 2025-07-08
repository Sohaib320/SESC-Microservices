package com.university.portal.controller;

import com.university.portal.model.Course;
import com.university.portal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public Iterable<Course> viewAllCourses() {
        return courseService.getAllCourses();
    }
}
