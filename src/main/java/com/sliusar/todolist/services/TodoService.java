package com.sliusar.todolist.services;

import com.sliusar.todolist.models.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getAll();
    Optional<Todo> getById(int id);
    void save(Todo todo);
    void update(Todo todo, int todoId);
    void deleteById(int id);
    void updateTodo(Todo todo, int scheduleId);

    void addTodo(Todo todo, int scheduleId);
    void removeTodo(int todoId, int scheduleId);

}
