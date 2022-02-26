package com.example.springtest4.controller;

import com.example.springtest4.model.Student;
import com.example.springtest4.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static sun.net.InetAddressCachePolicy.get;

@RestController
public class StudentController<getStudent> {
    @Autowired
    public StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/students/{id}")
    Optional<Student>  getStudent(@PathVariable long id){
        return studentRepo.findById(id);
    }

    @PostMapping(value="/students")
    public String createStudent(@RequestBody Student student){
        Student save =studentRepo.save(student);
        return "Student Created "+ student.getName();
    }

    @DeleteMapping(value="/students/{id}")
    public String deleteStudent(@PathVariable long id){
        studentRepo.deleteById(id);
        return "Deleted Student"+id ;
    }

    @PutMapping(value="/students/{id}")
    public Student update(@PathVariable long id, @RequestBody Student student){

        return studentRepo.findById(id)
                .map(student1 -> {
                    student1.setName(student.getName());
                    student1.setAge(student.getAge());
                    student1.setEmail(student.getEmail());
                    return studentRepo.save(student1);
                })
                .orElseGet(() -> {
                    student.setId(id);
                    return studentRepo.save(student);
                });
            }
        }
