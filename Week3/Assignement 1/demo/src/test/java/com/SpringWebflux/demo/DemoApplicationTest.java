package com.SpringWebflux.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@WebFluxTest(StudentController.class)
class DemoApplicationTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private Services service;

    @Test
    public void addStudentTest(){
        Mono<DataTransferObject> DatatoMono=Mono.just(new DataTransferObject("102","manoj",99,983362566));
        when(service.saveStudent(DatatoMono)).thenReturn(DatatoMono);

        webTestClient.post().uri("/Students")
                .body(Mono.just(DatatoMono),DataTransferObject.class)
                .exchange()
                .expectStatus().isOk();

    }


    @Test
    public void getStudentsTest(){
        Flux<DataTransferObject> StudentDtoFlux=Flux.just(new DataTransferObject("102","manoj",99,983362566),
                new DataTransferObject("103","tushar",95,936842285));
        when(service.getStudents()).thenReturn(StudentDtoFlux);

        Flux<DataTransferObject> responseBody = webTestClient.get().uri("/Students")
                .exchange()
                .expectStatus().isOk()
                .returnResult(DataTransferObject.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNext(new DataTransferObject("102","manoj",99,983362566))
                .expectNext(new DataTransferObject("103","tushar",95,936842285))
                .verifyComplete();

    }


    @Test
    public void getStudentTest(){
        Mono<DataTransferObject> DatatoMono=Mono.just(new DataTransferObject("102","random",99,1234567890));
        when(service.getStudent(any())).thenReturn(DatatoMono);

        Flux<DataTransferObject> responseBody = webTestClient.get().uri("/Students/102")
                .exchange()
                .expectStatus().isOk()
                .returnResult(DataTransferObject.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNextMatches(s->s.getName().equals("random"))
                .verifyComplete();
    }


    @Test
    public void updateStudentTest(){
        Mono<DataTransferObject> DatatoMono=Mono.just(new DataTransferObject("102","manoj",99,983362566));
        when(service.updateStudent(DatatoMono,"102")).thenReturn(DatatoMono);

        webTestClient.put().uri("/Students/update/102")
                .body(Mono.just(DatatoMono),DataTransferObject.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void deleteStudentTest(){
        given(service.deleteStudent(any())).willReturn(Mono.empty());
        webTestClient.delete().uri("/Students/delete/102")
                .exchange()
                .expectStatus().isOk();
    }

}