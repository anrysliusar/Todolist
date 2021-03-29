package com.sliusar.todolist.dao;

import com.sliusar.todolist.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDAO extends JpaRepository<Todo, Integer> {
}
