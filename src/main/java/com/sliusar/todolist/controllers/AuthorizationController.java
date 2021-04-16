package com.sliusar.todolist.controllers;

import com.sliusar.todolist.dao.UserDAO;
import com.sliusar.todolist.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.security.util.Password;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userDAO.save(user);
    }
}
