package com.staffscheduling.staffscheduling.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.staffscheduling.staffscheduling.model.EmployeeSchedule;
import com.staffscheduling.staffscheduling.Repostiory.EmployeeScheduleRepository;

import java.util.List;

@Service
public class EmployeeScheduleService {

    @Autowired
    private EmployeeScheduleRepository employeeScheduleRepository;

    public List<EmployeeSchedule> getSchedulesByDay(String day) {
        return employeeScheduleRepository.findByDay(day);
    }

    public List<EmployeeSchedule> getAllSchedules() {
        return employeeScheduleRepository.findAll();
    }

    public EmployeeSchedule createSchedule(EmployeeSchedule schedule) {
        return employeeScheduleRepository.save(schedule);
    }

    public EmployeeSchedule updateSchedule(Long id, EmployeeSchedule schedule) {
        if (!employeeScheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("Schedule not found");
        }
        schedule.setId(id);
        return employeeScheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        if (!employeeScheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("Schedule not found");
        }
        employeeScheduleRepository.deleteById(id);
    }
}
