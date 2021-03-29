package com.sliusar.todolist.dao;

import com.sliusar.todolist.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDAO extends JpaRepository<Schedule, Integer> {
}
