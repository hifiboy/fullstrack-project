package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Email;
    private Long Salary;
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
        return Email;
    }
    public void setemail(String Email) {
        this.Email = Email;
    }
    public Long getSalary() {
        return Salary;
    }
    public void setSalary(Long Salary) {
        this.Salary = Salary;
    }
    public Employee(Long id, String name, String role, String image) {
        this.id = id;
        this.name = name;
        this.Email = Email;
        this.Salary = Salary;
    }
    public Employee() {
    }

    // Getters and Setters
}
