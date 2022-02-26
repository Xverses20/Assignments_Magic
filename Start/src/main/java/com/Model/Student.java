package com.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
public class Student {
    @Id
    private long id;

    private String name;
    private int age;
    private String email;

    public Student(){}

    public Student(long id,String name,int age,String email){
        this.id=id;
        this.name=name;
        this.age=age;
        this.email=email;
    }

    public  long getId() { return id; }
    public void setId(long id) {
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
}
