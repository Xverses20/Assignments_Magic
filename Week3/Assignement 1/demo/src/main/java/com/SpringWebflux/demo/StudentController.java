package com.SpringWebflux.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private Services service;

    @GetMapping
    public Flux<DataTransferObject> getStudents(){
        return service.getStudents();
    }
    @GetMapping("/{id}")
    public Mono<DataTransferObject> getStudent(@PathVariable String id){
        return service.getStudent(id);
    }
    @GetMapping("/student-range")
    public Flux<DataTransferObject> getStudentBetweenMarks(@RequestParam("min") int min,@RequestParam("max") int max) {
        return service.getStudentInRange(min, max);
    }
    @PostMapping
    public Mono<DataTransferObject> saveStudent(@RequestBody Mono <DataTransferObject> studentDtoMono){
        return service.saveStudent(studentDtoMono);
    }
    @PutMapping("/update/{id}")
    public Mono<DataTransferObject> saveStudent(@RequestBody Mono <DataTransferObject> studentDtoMono , @PathVariable String id) {
        return service.updateStudent(studentDtoMono, id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }

}