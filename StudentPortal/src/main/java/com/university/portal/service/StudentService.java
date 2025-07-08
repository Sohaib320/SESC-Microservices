package com.university.portal.service;

import com.university.portal.model.Student;
import com.university.portal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Register new student
    public Student registerStudent(String name, String surname, String email, String password) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        student.setPassword(password);
        return studentRepository.save(student);
    }

    // Get student by email
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    // Update student profile
    public Student updateStudentProfile(Student student) {
        return studentRepository.save(student);
    }
}


