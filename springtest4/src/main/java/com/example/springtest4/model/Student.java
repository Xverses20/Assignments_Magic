package com.example.springtest4.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")

public class Student {

    private long id;
    private String name;
    private double age;
    private String email;

    public Student() {
    }

    public Student(long id, String name, double age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
