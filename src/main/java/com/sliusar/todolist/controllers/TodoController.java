package com.sliusar.todolist.controllers;

import com.sliusar.todolist.models.Todo;
import com.sliusar.todolist.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/todoItems")
public class TodoController {
    @Qualifier("tsi")
    private final TodoService todoService;

    @GetMapping()
    public List<Todo> getAll(){
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Todo> getById(@PathVariable int id){
        return todoService.getById(id);
    }


    @PutMapping("/update/{id}")
    public void update(@RequestBody Todo todo, @PathVariable int id){
        todoService.update(todo, id);
    }

    @PutMapping("/{scheduleId}/update/{todoId}")
    public void updateTodo(@RequestBody Todo todo, @PathVariable("scheduleId") int scheduleId){
        todoService.updateTodo(todo, scheduleId);
    }

    @PostMapping("/{id}/addTodo")
    public void addTodo(@PathVariable int id, @RequestBody Todo todo) {
        todoService.addTodo(todo, id);
    }

    @DeleteMapping("/{scheduleId}/delete/{todoId}")
    public void deleteTodo(@PathVariable("scheduleId") int scheduleId, @PathVariable("todoId") int todoId) {
        todoService.removeTodo(todoId, scheduleId);
    }
}


