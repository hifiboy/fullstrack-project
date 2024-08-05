package com.staffscheduling.staffscheduling.model;


import jakarta.persistence.*;

import jakarta.persistence.Entity;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Double salary;
    private String address;
    private String category;

    
    public Employee() {
    }
    public Employee(Long id, String name, String email, Double salary, String address, String category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.category = category;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }


    
    // Getters and Setters
}
