package com.sliusar.todolist.dao;

import com.sliusar.todolist.models.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDAO extends JpaRepository<AuthToken, Integer> {
}
