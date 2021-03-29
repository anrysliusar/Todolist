package com.sliusar.todolist.services.implementation;

import com.sliusar.todolist.dao.ScheduleDAO;
import com.sliusar.todolist.dao.TodoDAO;
import com.sliusar.todolist.models.Schedule;
import com.sliusar.todolist.models.Todo;
import com.sliusar.todolist.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("tsi")
@AllArgsConstructor
public class TodoServiceImp implements TodoService {
    private final TodoDAO todoDAO;
    private final ScheduleDAO scheduleDAO;


    @Override
    public List<Todo> getAll() {
        return todoDAO.findAll();
    }

    @Override
    public Optional<Todo> getById(int id) {
        return todoDAO.findById(id);
    }

    @Override
    public void save(Todo todo) {
        if(todo != null){
            todoDAO.save(todo);
        }
    }

    @Override
    public void update(Todo todo, int todoId) {
        if (todoDAO.existsById(todoId)){
            todo.setId(todoId);
            todoDAO.save(todo);
        }
    }

    @Override
    public void deleteById(int id) {
        todoDAO.deleteById(id);
    }

    @Override
    public void updateTodo(Todo todo, int scheduleId) {
        Schedule scheduleForUpdatingTodo = scheduleDAO.getOne(scheduleId);
        List<Todo> todoList = scheduleForUpdatingTodo.getTodoList();
        int chosenTodoIndex = 0;
        for (Todo todoItem : todoList) {
            if(todoItem.getId() == todo.getId()){
                chosenTodoIndex = todoList.indexOf(todoItem);
            }
        }
        todo.setSchedule(scheduleForUpdatingTodo);
        scheduleForUpdatingTodo.getTodoList().set(chosenTodoIndex, todo);
        scheduleDAO.save(scheduleForUpdatingTodo);
    }

    @Override
    public void addTodo(Todo todo, int scheduleId) {
        Schedule scheduleForAddingTodo = scheduleDAO.getOne(scheduleId);
        if (scheduleForAddingTodo.getTodoList() != null){
            scheduleForAddingTodo.getTodoList().add(todo);
        }else {
            List<Todo> todoList = new ArrayList<>();
            todoList.add(todo);
            scheduleForAddingTodo.setTodoList(todoList);
        }
        scheduleDAO.save(scheduleForAddingTodo);
    }

    @Override
    public void removeTodo(int todoId, int scheduleId) {
        Schedule scheduleForDeletingTodo = scheduleDAO.getOne(scheduleId);
        scheduleForDeletingTodo.getTodoList().removeIf(todo -> todo.getId() == todoId);
        todoDAO.deleteById(todoId);
        scheduleDAO.save(scheduleForDeletingTodo);
    }
}
