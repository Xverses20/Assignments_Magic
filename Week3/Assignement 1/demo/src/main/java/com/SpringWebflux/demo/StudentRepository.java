package com.SpringWebflux.demo;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student,String> {

    Flux<DataTransferObject> findByMarksBetween(Range<Integer> MarksRange);
}