package com.SpringWebflux.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class Services {
    @Autowired
    private StudentRepository repository;

    public Flux<DataTransferObject> getStudents(){
        return repository.findAll().map(Application::entitytoData);
    }
    public Mono<DataTransferObject> getStudent(String id){
        return repository.findById(id).map(Application::entitytoData);
    }
    public Flux <DataTransferObject> getStudentInRange(int min ,int max){
        return repository.findByMarksBetween(Range.closed(min,max));
    }
    public Mono<DataTransferObject> saveStudent (Mono<DataTransferObject> studentDtoMono){
        return studentDtoMono.map(Application::datatoToEntity)
                .flatMap(repository::insert)
                .map(Application::entitytoData);
    }
    public Mono<DataTransferObject> updateStudent(Mono <DataTransferObject> studentDtoMono , String id){
        return repository.findById(id)
                .flatMap(s-> studentDtoMono.map(Application::datatoToEntity))
                .doOnNext(e-> e.setId(id))
                .flatMap(repository::save)
                .map(Application::entitytoData);
    }
    public Mono<Void> deleteStudent (String id){
        return repository.deleteById(id);
    }

}