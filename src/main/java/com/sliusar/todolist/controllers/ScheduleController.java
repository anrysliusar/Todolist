package com.sliusar.todolist.controllers;

import com.sliusar.todolist.models.Schedule;
import com.sliusar.todolist.models.Todo;
import com.sliusar.todolist.services.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/schedules")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ScheduleController {
    @Qualifier("ssi")
    private final ScheduleService scheduleService;

    @GetMapping()
    public List<Schedule> getAll(){
        return scheduleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Schedule> getById(@PathVariable int id){
        return scheduleService.getById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Schedule schedule){
        scheduleService.save(schedule);
    }

    @PutMapping("/{id}/update")
    public void update(@RequestBody Schedule schedule, @PathVariable int id){
        scheduleService.update(schedule, id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable int id) {
        scheduleService.deleteById(id);
    }

}
