package com.example.hello.controllers;

import com.example.hello.models.Employee;
import com.example.hello.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    HelloWorldService hws;
    @GetMapping("/h")
    public List<Employee> hello() {
        return hws.helloWorld();
    }
    @PutMapping("/")
    public String putMethod() {
        return hws.putMethod();
    }
    @PostMapping("/")
    public String postMethod() {
        return hws.postMethod();
    }
    @DeleteMapping("/")
    public String deleteMethod() {
        return hws.deleteMethod();
    }
    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee emp) {
        return hws.addEmployee(emp);
    }
}
