package com.example.employeescheduling.model;


import jakarta.persistence.*;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long staffId;
    private String staffName;
    private String scheduleDetails;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStaffId() {
        return staffId;
    }
    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getScheduleDetails() {
        return scheduleDetails;
    }
    public void setScheduleDetails(String scheduleDetails) {
        this.scheduleDetails = scheduleDetails;
    }
    public Schedule() {
    }
    public Schedule(Long id, Long staffId, String staffName, String scheduleDetails) {
        this.id = id;
        this.staffId = staffId;
        this.staffName = staffName;
        this.scheduleDetails = scheduleDetails;
    }

    
}
