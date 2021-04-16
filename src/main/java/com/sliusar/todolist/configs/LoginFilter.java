package com.sliusar.todolist.configs;

import org.springframework.security.authentication.AuthenticationManager;

import javax.servlet.Filter;

public class LoginFilter implements Filter {
    public LoginFilter(String s, AuthenticationManager authenticationManager, Object p2) {
    }
}
