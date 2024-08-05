package com.example.employeescheduling.controller;


import com.example.employeescheduling.model.User;
import com.example.employeescheduling.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AuthService authService;

    @PostMapping("/add")
    public User addAdmin(@RequestBody User user) {
        return authService.addAdmin(user);
    }
}
