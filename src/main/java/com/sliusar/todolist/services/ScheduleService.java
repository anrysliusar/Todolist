package com.sliusar.todolist.services;

import com.sliusar.todolist.models.Schedule;
import com.sliusar.todolist.models.Todo;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    List<Schedule> getAll();
    Optional<Schedule> getById(int id);
    void save(Schedule schedule);
    void update(Schedule schedule, int id);
    void deleteById(int id);



}
