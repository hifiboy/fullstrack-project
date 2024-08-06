package com.example.demo.controller;



import com.example.demo.model.ScheduleCalendar;
import com.example.demo.service.scheduleCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedule-calendars")
public class ScheduleCalendarController {

    @Autowired
    private scheduleCalendarService scheduleCalendarService;

    @GetMapping
    public List<ScheduleCalendar> getAllScheduleCalendars() {
        return scheduleCalendarService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleCalendar> getScheduleCalendarById(@PathVariable Long id) {
        Optional<ScheduleCalendar> scheduleCalendar = scheduleCalendarService.findById(id);
        return scheduleCalendar.map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ScheduleCalendar createScheduleCalendar(@RequestBody ScheduleCalendar scheduleCalendar) {
        return scheduleCalendarService.save(scheduleCalendar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleCalendar> updateScheduleCalendar(@PathVariable Long id, @RequestBody ScheduleCalendar scheduleCalendarDetails) {
        Optional<ScheduleCalendar> scheduleCalendar = scheduleCalendarService.findById(id);
        if (scheduleCalendar.isPresent()) {
            ScheduleCalendar existingScheduleCalendar = scheduleCalendar.get();
            existingScheduleCalendar.setDay(scheduleCalendarDetails.getDay());
            existingScheduleCalendar.setShift(scheduleCalendarDetails.getShift());
            existingScheduleCalendar.setStartTime(scheduleCalendarDetails.getStartTime());
            existingScheduleCalendar.setEndTime(scheduleCalendarDetails.getEndTime());
            existingScheduleCalendar.setDescription(scheduleCalendarDetails.getDescription());
            existingScheduleCalendar.setEmployee(scheduleCalendarDetails.getEmployee());
            ScheduleCalendar updatedScheduleCalendar = scheduleCalendarService.save(existingScheduleCalendar);
            return ResponseEntity.ok(updatedScheduleCalendar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheduleCalendar(@PathVariable Long id) {
        if (scheduleCalendarService.findById(id).isPresent()) {
            scheduleCalendarService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
