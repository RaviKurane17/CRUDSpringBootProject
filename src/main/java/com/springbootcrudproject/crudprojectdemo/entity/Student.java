package com.springbootcrudproject.crudprojectdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students") // Best practice: explicitly define database table name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments ID in DB (1, 2, 3...)
    private Integer id; // Use Integer instead of primitive int (allows null before saving)

    private String name;
    private int age;
    private String email;
    private String course;
    private boolean isDelete;

    // 1. No-args constructor (Required by JPA and Jackson)
    public Student() {
    }

    // 2. All-args constructor
    public Student(Integer id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean isDelete(boolean b) {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}