package com.Controller;

import com.Model.Student;
import com.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController{
    @Autowired
    public StudentRepository repository1;

    @GetMapping(value="/Student")
    public List<Student> getStudents() {
        return repository1.findAll();
    }

    @GetMapping(value="/Student/{id}")
    Optional<Student>  getStudent(@PathVariable long id){
        return repository1.findById(id);
    }

    @PostMapping(value="/Student")
    public String createStudent(@RequestBody Student student){
        Student save =repository1.save(student);
        return "Student Created "+ student.getName();
    }

    @DeleteMapping(value="/Student/{id}")
    public String deleteStudent(@PathVariable long id){
        repository1.deleteById(id);
        return "Deleted Student"+id ;
    }

    @PutMapping(value="/Student/{id}")
    public Student update(@PathVariable long id, @RequestBody Student student){

        return repository1.findById(id)
                .map(student1 -> {
                    student1.setName(student.getName());
                    student1.setAge(student.getAge());
                    student1.setEmail(student.getEmail());
                    return repository1.save(student1);
                })
                .orElseGet(() -> {
                    student.setId(id);
                    return repository1.save(student);
                });
    }
}

