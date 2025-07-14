package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {

    private Map<String, String> userDatabase = new HashMap<>();

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password,
                         Model model) {
        if (userDatabase.containsKey(username)) {
            model.addAttribute("message", "User already exists!");
            return "signup";
        }
        userDatabase.put(username, password);
        model.addAttribute("message", "Signup successful! Please login.");
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            model.addAttribute("username", username);
            return "welcome";
        } else {
            model.addAttribute("message", "Invalid credentials!");
            return "login";
        }
    }
}
