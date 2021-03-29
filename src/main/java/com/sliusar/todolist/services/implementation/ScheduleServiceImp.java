package com.sliusar.todolist.services.implementation;

import com.sliusar.todolist.dao.ScheduleDAO;
import com.sliusar.todolist.dao.TodoDAO;
import com.sliusar.todolist.models.Schedule;
import com.sliusar.todolist.models.Todo;
import com.sliusar.todolist.services.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("ssi")
@AllArgsConstructor
public class ScheduleServiceImp implements ScheduleService {
    private final ScheduleDAO scheduleDAO;
    private final TodoServiceImp todoServiceImp;



    @Override
    public List<Schedule> getAll() {
        return scheduleDAO.findAll();
    }

    @Override
    public Optional<Schedule> getById(int id) {
        return scheduleDAO.findById(id);
    }

    @Override
    public void save(Schedule schedule) {
        System.out.println(schedule.getTitle());
        if(schedule.getTitle() != null){
            scheduleDAO.save(schedule);
        }
    }

    @Override
    public void update(Schedule schedule, int id) {
        Schedule chosenSchedule = scheduleDAO.getOne(id);
        schedule.setId(id);
        schedule.setTodoList(chosenSchedule.getTodoList());
        scheduleDAO.save(schedule);
    }

    @Override
    public void deleteById(int id) {
        scheduleDAO.deleteById(id);
    }

}
