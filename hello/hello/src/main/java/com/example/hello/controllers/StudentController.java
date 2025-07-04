package com.example.hello.controllers;

import com.example.hello.models.Student;
import com.example.hello.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/")
    public String putStudent() {
        return studentService.putMethod();
    }

    @DeleteMapping("/")
    public String deleteStudent() {
        return studentService.deleteMethod();
    }
}
