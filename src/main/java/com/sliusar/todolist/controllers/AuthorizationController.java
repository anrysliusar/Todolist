package com.sliusar.todolist.controllers;

import com.sliusar.todolist.dao.UserDAO;
import com.sliusar.todolist.models.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    private UserDAO userDAO;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        this.userDAO.save(user);
    };

}
