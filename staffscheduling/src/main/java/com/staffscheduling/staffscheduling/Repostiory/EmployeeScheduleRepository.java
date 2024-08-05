package com.staffscheduling.staffscheduling.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.staffscheduling.staffscheduling.model.EmployeeSchedule;

import java.util.List;

public interface EmployeeScheduleRepository extends JpaRepository<EmployeeSchedule, Long> {
    List<EmployeeSchedule> findByDay(String day);
}
