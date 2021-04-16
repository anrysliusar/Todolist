package com.sliusar.todolist.dao;

import com.sliusar.todolist.models.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenDAO extends JpaRepository<AuthToken, Integer> {
    AuthToken findByToken(String token);
}
