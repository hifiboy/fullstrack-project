package com.staffscheduling.staffscheduling.Repostiory;



import org.springframework.data.jpa.repository.JpaRepository;

import com.staffscheduling.staffscheduling.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
