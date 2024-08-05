package com.staffscheduling.staffscheduling.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.staffscheduling.staffscheduling.model.EmployeeSchedule;
import com.staffscheduling.staffscheduling.Service.EmployeeScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class EmployeeScheduleController {

    @Autowired
    private EmployeeScheduleService employeeScheduleService;

    @GetMapping
    public ResponseEntity<List<EmployeeSchedule>> getAllSchedules() {
        List<EmployeeSchedule> schedules = employeeScheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{day}")
    public ResponseEntity<List<EmployeeSchedule>> getSchedulesByDay(@PathVariable String day) {
        List<EmployeeSchedule> schedules = employeeScheduleService.getSchedulesByDay(day);
        return ResponseEntity.ok(schedules);
    }

    @PostMapping
    public ResponseEntity<EmployeeSchedule> createSchedule(@RequestBody EmployeeSchedule schedule) {
        EmployeeSchedule createdSchedule = employeeScheduleService.createSchedule(schedule);
        return ResponseEntity.ok(createdSchedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeSchedule> updateSchedule(@PathVariable Long id, @RequestBody EmployeeSchedule schedule) {
        EmployeeSchedule updatedSchedule = employeeScheduleService.updateSchedule(id, schedule);
        return ResponseEntity.ok(updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        employeeScheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
