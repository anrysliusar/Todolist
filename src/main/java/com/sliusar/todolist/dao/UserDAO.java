package com.sliusar.todolist.dao;


import com.sliusar.todolist.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
}
