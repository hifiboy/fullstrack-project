package com.example.demo.service;



import com.example.demo.model.ScheduleCalendar;
import com.example.demo.repository.ScheduleCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class scheduleCalendarService {

    @Autowired
    private ScheduleCalendarRepository scheduleCalendarRepository;

    public List<ScheduleCalendar> findAll() {
        return scheduleCalendarRepository.findAll();
    }

    public Optional<ScheduleCalendar> findById(Long id) {
        return scheduleCalendarRepository.findById(id);
    }

    public ScheduleCalendar save(ScheduleCalendar scheduleCalendar) {
        return scheduleCalendarRepository.save(scheduleCalendar);
    }

    public void deleteById(Long id) {
        scheduleCalendarRepository.deleteById(id);
    }
}
