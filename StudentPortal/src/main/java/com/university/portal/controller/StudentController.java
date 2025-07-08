package com.university.portal.controller;


import com.university.portal.model.Student;
import com.university.portal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Student registerStudent(@RequestParam String name, @RequestParam String surname, @RequestParam String email, @RequestParam String password) {
        return studentService.registerStudent(name, surname, email, password);
    }

    @GetMapping("/login")
    public Student loginStudent(@RequestParam String email) {
        return studentService.getStudentByEmail(email);
    }

    // View student profile
    @GetMapping("/profile")
    public Student getProfile(@RequestParam String email) {
        return studentService.getStudentByEmail(email);
    }

    // Update student profile
    @PutMapping("/profile")
    public Student updateProfile(@RequestBody Student student) {
        return studentService.updateStudentProfile(student);
    }
}

